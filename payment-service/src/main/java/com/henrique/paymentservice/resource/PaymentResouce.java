package com.henrique.paymentservice.resource;

import com.henrique.paymentservice.model.Payment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface PaymentResouce {

    @PostMapping
    ResponseEntity<Payment> payment(@RequestBody Payment payment);
}
