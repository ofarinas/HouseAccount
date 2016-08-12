package com.example.controllers;

import com.example.entitys.Payment;
import com.example.entitys.UserAccount;
import com.example.repository.PaymentRepository;
import com.example.repository.UserRepository;
import com.example.services.PaymentService;
import com.example.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

/**
 * Created by Osvaldo on 8/2/2016.
 */
@RestController(value = "payment")
public class PaymentController {
    private PaymentRepository paymentRepository;
    private UserRepository userRepository;

    @Autowired
    public PaymentController(PaymentRepository paymentRepository, UserRepository userRepository) {
        this.paymentRepository = paymentRepository;
        this.userRepository = userRepository;
//        insert();
    }

    private void insert() {
//        new PaymentService(paymentRepository).savePayment(new Payment(12,"mercadona", new UserService(userRepository).getUser("osvi")));
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Payment> findAllUsers() {
        return new PaymentService(paymentRepository).getPayment();
    }

    //
    @RequestMapping(method = RequestMethod.GET, value = "payment/create")
    public String craete(@RequestParam(value = "date") String date, @RequestParam(value = "amount") String amount, @RequestParam(value = "debts") String debts, @RequestParam(value = "marcket") String marcket, @RequestParam(value = "urlPhoto") String urlPhoto, @RequestParam(value = "name") String name) throws ParseException {
//        return String.valueOf(new PaymentService(paymentRepository).savePayment(new Payment(new SimpleDateFormat().parse(date), Integer.valueOf(amount), Boolean.valueOf(debts), marcket, urlPhoto, getUser(name))));
        return "";
    }

    private UserAccount getUser(String name) {
        return new UserService(userRepository).getUser(name);
    }

}
