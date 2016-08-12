package com.example;

import com.example.entitys.Payment;
import com.example.entitys.UserAccount;
import com.example.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@SpringBootApplication
public class SpringBoot2Application implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(SpringBoot2Application.class);
    @Autowired
    UserRepository userRepository;
    public static void main(String[] args) {
        SpringApplication.run(SpringBoot2Application.class, args);
    }


    @Override
    @Transactional
    public void run(String... strings) throws Exception {
        UserAccount userAccountOsvi = new UserAccount("osvi","123");
        UserAccount userAccountPapi = new UserAccount("papi","123");
        UserAccount userAccountLuis = new UserAccount("luis","123");
        userAccountLuis.setPaymentList(new ArrayList<Payment>(){{
            add(new Payment(userAccountLuis,Calendar.getInstance().getTime(),11,true,"Mercadona","foto"));
            add(new Payment(userAccountLuis,22,"Mercadona"));
            add(new Payment(userAccountLuis,33,"Hiperdino"));
        }});
        userAccountOsvi.setPaymentList(new ArrayList<Payment>(){{
            add(new Payment(userAccountOsvi,Calendar.getInstance().getTime(),11,true,"Mercadona","foto"));
            add(new Payment(userAccountOsvi,22,"Mercadona"));
            add(new Payment(userAccountOsvi,33,"Hiperdino"));
        }});
    userRepository.save(userAccountLuis);
    userRepository.save(userAccountOsvi);
//        userRepository.save(new HashSet<UserAccount>() {{
//            add(userAccountLuis);
//            add(userAccountOsvi);
//            add(userAccountPapi);
//        }});
        UserAccount osvi = userRepository.findByName("luis");
        List<UserAccount> userAccountLis = userRepository.findAll();
        for (UserAccount userAccount : userAccountLis) {
            for (Payment payment : userAccount.getPaymentList()) {
                System.out.println(payment.getMarcket());

            }
        }

    }
}
