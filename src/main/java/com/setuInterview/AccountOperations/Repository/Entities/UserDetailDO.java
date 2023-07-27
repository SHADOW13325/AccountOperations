package com.setuInterview.AccountOperations.Repository.Entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

/**
 * @author saumitra chauhan
 * @since 26-07-2023 17:37
 */

@Entity
@Table(name = "user_detail", indexes = {@Index(name = "idx_acc_no", columnList = "account_number", unique = true)})
public class UserDetailDO {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_no")
    private String mobile;

    @Column(name = "account_number", nullable = false)
    private String accountNumber;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    public UserDetailDO(){
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }
}
