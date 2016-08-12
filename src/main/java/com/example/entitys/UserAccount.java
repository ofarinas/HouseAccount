package com.example.entitys;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Osvaldo on 7/28/2016.
 */
@Entity(name = "user_account")
public class UserAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String password;
    @OneToMany(mappedBy = "userAccount", cascade = CascadeType.ALL)
    private List<Payment>paymentList;

    public UserAccount() {
    }

    public UserAccount(String name, String password) {
        this.name = name;
        this.password = password;
    }


    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
