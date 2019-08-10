package com.example.mybeautifulproject;

import java.util.Date;

import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

@Entity
public class Transaction {
    @Id long id;
    private String money;
    private Date createdAt;
    private String purpose;
    private boolean ifCostOrNot;

    public Transaction(String money, String purpose, boolean ifCostOrNot) {
        this.money = money;
        createdAt = new Date();
        this.purpose = purpose;
        this.ifCostOrNot = ifCostOrNot;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }


    public long getId() {
        return id;
    }

    public String getMoney() {
        return money;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getPurpose() {
        return purpose;
    }

    public boolean isIfCostOrNot() {
        return ifCostOrNot;
    }

    public void setIfCostOrNot(boolean ifCostOrNot) {
        this.ifCostOrNot = ifCostOrNot;
    }
}
