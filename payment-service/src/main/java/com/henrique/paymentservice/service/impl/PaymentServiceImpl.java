package com.henrique.paymentservice.service.impl;

import com.henrique.paymentservice.model.Payment;
import com.henrique.paymentservice.service.PaymentService;
import java.io.Serializable;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    KafkaTemplate<String, Serializable> kafkaTemplate;
    @SneakyThrows
    @Override
    public void sendPayment(Payment payment) {
        log.info("recebi o pagamento {}", payment);
        Thread.sleep(1000);
        log.info("Enviando Pagamento...");
        kafkaTemplate.send("payment-topic", payment);
    }
}
