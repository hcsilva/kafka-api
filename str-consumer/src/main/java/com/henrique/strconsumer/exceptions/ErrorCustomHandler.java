package com.henrique.strconsumer.exceptions;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class ErrorCustomHandler implements KafkaListenerErrorHandler {


    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException e) {
        log.info("exception handler");
        log.info("payload::: {}", message.getPayload());
        log.info("headers::: {}", message.getHeaders());
        log.info("offset::: {}", message.getHeaders().get("kafka_offset"));
        log.info("message exception::: {}", e.getMessage());
        return null;
    }

//    @Override
//    public Object handleError(Message<?> message, ListenerExecutionFailedException exception, Consumer<?, ?> consumer) {
//        return KafkaListenerErrorHandler.super.handleError(message, exception, consumer);
//    }
}
