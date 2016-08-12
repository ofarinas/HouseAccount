package com.example.repository;

import com.example.entitys.UserAccount;

import java.util.List;

/**
 * Created by Osvaldo on 7/30/2016.
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserAccount, Long> {
    public UserAccount findByName(String name);
//    public List<UserAccount> findByPaymentList();
}
