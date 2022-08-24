package com.henrique.jsonconsumer.listener;

import com.henrique.jsonconsumer.model.Payment;
import static java.lang.Thread.sleep;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class JsonListener {

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "create-group", containerFactory = "jsonContainerFactory")
    public void antiFraude(@Payload Payment payment) {
        log.info("Recebi o pagamento {}", payment.toString());
        sleep(2000);
        log.info("Validanod Fraude...");
        sleep(2000);
        log.info("Compra Aprovada...");
        sleep(2000);
    }

    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "pdf-group", containerFactory = "jsonContainerFactory")
    public void pdfGenerator(@Payload Payment payment) {
        log.info("Gerando PDF do ID {}", payment.getId());
        sleep(3000);
    }


    @SneakyThrows
    @KafkaListener(topics = "payment-topic", groupId = "email-group", containerFactory = "jsonContainerFactory")
    public void sendEmail() {
        sleep(3000);
        log.info("Enviando Email de confirmação...");
    }
}
