package com.henrique.strproducer.services;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
@Log4j2
@Service
public class StringProducerService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message){
        log.info("Send message Success{}", message);
        kafkaTemplate.send("str-topic", message);
//                .addCallback(
//                success -> {
//                    if(success != null){
//                        log.info("Send message Success{}", message);
//                        log.info("Partition {}, Offset {}", success.getRecordMetadata().partition(), success.getRecordMetadata().offset());
//                    }
//                },
//                error -> log.error("Error to send message")
//        );
    }

}
