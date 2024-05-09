package com.fintech.notifications.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "fintech-messages",
            groupId = "test-consumer-group")
    public void consume(String message)
    {
        // TODO send email or text
        System.out.println("message = " + message);
    }
}