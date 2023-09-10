package com.fintech.transactional.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    private static final String TOPIC = "transaction";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public boolean sendMessae(String message){
        // Sending the message
        kafkaTemplate.send(TOPIC, message);
        return true;
    }

}
