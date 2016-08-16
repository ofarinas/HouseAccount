package com.example.services;

import com.example.dto.PaymentDTO;
import com.example.entitys.Payment;
import com.example.repository.PaymentRepository;

/**
 * Created by Osvaldo on 8/2/2016.
 */
public class PaymentService {
    PaymentRepository paymentRepository;
    PaymentDTO paymentDTO;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
        paymentDTO = new PaymentDTO();
    }

    public String getPayment() {
        return paymentDTO.getJsonPaymentList(paymentRepository.findAll());
    }

    public boolean savePayment(Payment payment) {
        return paymentRepository.save(payment) == null ? false : true;
    }
//
//    public Payment getPayment(UserAccount userAccount) {
//        return paymentRepository.findByUser(userAccount);
//    }

}
