package com.example.services;

import com.example.entitys.Payment;
import com.example.entitys.UserAccount;
import com.example.repository.PaymentRepository;

import java.util.List;

/**
 * Created by Osvaldo on 8/2/2016.
 */
public class PaymentService {
    PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> getPayment() {
        return paymentRepository.findAll();
    }

    public boolean savePayment(Payment payment) {
        return paymentRepository.save(payment) == null ? false : true;
    }
//
//    public Payment getPayment(UserAccount userAccount) {
//        return paymentRepository.findByUser(userAccount);
//    }

}
