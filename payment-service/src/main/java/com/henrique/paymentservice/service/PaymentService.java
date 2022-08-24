package com.henrique.paymentservice.service;

import com.henrique.paymentservice.model.Payment;

public interface PaymentService {

    void sendPayment(Payment payment);
}
