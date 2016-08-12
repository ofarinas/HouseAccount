package com.example.entitys;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Osvaldo on 8/2/2016.
 */
@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_account_id")
    private UserAccount userAccount;
    private Date date;
    private int amount;
    private boolean debts;
    private String marcket;

    private String urlPhoto;

    public Payment() {
    }


    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public Payment(UserAccount userAccount, Date date, int amount, boolean debts, String marcket, String urlPhoto) {
        this.userAccount = userAccount;
        this.date = date;
        this.amount = amount;
        this.debts = debts;
        this.marcket = marcket;
        this.urlPhoto = urlPhoto;
    }

    public Payment(UserAccount userAccount, int amount, String marcket) {
        this.userAccount = userAccount;
        this.amount = amount;
        this.marcket = marcket;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    public String getMarcket() {
        return marcket;
    }

    public void setMarcket(String marcket) {
        this.marcket = marcket;
    }

}
