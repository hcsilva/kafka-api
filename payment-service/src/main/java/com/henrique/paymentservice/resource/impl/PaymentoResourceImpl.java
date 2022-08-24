package com.henrique.paymentservice.resource.impl;

import com.henrique.paymentservice.model.Payment;
import com.henrique.paymentservice.resource.PaymentResouce;
import com.henrique.paymentservice.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/payments")
public class PaymentoResourceImpl implements PaymentResouce {

    @Autowired
    PaymentService service;

    @Override
    public ResponseEntity<Payment> payment(Payment payment) {
       service.sendPayment(payment);
       return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
