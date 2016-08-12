package com.example.repository;

import com.example.entitys.Payment;
import com.example.entitys.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

/**
 * Created by Osvaldo on 8/2/2016.
 */
public interface PaymentRepository extends JpaRepository<Payment,Long>{
//    Payment findByUser(  UserAccount user);

}
