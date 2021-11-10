package com.example.springboot.rabbitmq.controller;

import com.example.springboot.rabbitmq.config.RabbitMQConfig;
import com.example.springboot.rabbitmq.model.MessageRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

/**
 * @author Ayan Bhuin
 */

@RestController
@Log4j2
public class MessagePublisherController {
    @Autowired
    private RabbitTemplate template;

    @PostMapping("/publish")
    public String publishMessage(@RequestBody MessageRequest message) {
        log.info("Started.");
        message.setId(UUID.randomUUID().toString());
        message.setMessageDate(new Date());
        template.convertAndSend(RabbitMQConfig.EXCHANGE,
                RabbitMQConfig.ROUTING_KEY, message);

        return "User Message Published";
    }
}
