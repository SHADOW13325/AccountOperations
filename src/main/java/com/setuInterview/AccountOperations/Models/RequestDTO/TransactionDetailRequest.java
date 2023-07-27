package com.setuInterview.AccountOperations.Models.RequestDTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

/**
 * @author saumitra chauhan
 * @since 26-07-2023 20:23
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionDetailRequest {

    @NotBlank(message = "account number can't be empty")
    private String accountNumber;

    @Min(value = 1, message = "balance can't be less than or equal to zero")
    @Digits(integer = 5, fraction = 0, message = "balance should be in rupees and less than or equal to 99999")
    private long balance;

    public TransactionDetailRequest(String accountNumber, long balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public TransactionDetailRequest() {
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }


}
