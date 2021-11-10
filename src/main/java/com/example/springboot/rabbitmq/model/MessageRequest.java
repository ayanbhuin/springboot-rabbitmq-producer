package com.example.springboot.rabbitmq.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author Ayan Bhuin
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MessageRequest {
    private String id;
    private String message;
    private Date messageDate;
}
