package com.setuInterview.AccountOperations.Models.Enums;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author saumitra chauhan
 * @since 26-07-2023 19:08
 */

public enum AccountType {

    REGULAR("regular savings account", 1, 10, 0, 2000, 5),
    STUDENT("student account", 2,4,1000,0,0),
    ZERO_BALANCE("zero balance account", 3,4,0,0,0);

    private String accountName;
    private int accountType;
    private int withdrawalLimit;
    private int minBalance;
    private int averageBalance;
    private int withdrawalCharge;

    AccountType(String accountName, int accountType, int withdrawalLimit, int minBalance, int averageBalance, int withdrawalCharge) {
        this.accountName = accountName;
        this.accountType = accountType;
        this.withdrawalLimit = withdrawalLimit;
        this.minBalance = minBalance;
        this.averageBalance = averageBalance;
        this.withdrawalCharge=withdrawalCharge;
    }



    public static String getAccountName(int accountType){
        Optional<String> accountName = Arrays.stream(AccountType.values()).
                filter(accountType1 -> accountType1.getAccountType() == accountType).
                map(accountType1 -> accountType1.getAccountName()).findFirst();

        return accountName.orElse(null);

    }

    public static AccountType getAccountEnum(int accountType){
        Optional<AccountType> optional = Arrays.stream(AccountType.values()).
                filter(accountType1 -> accountType1.accountType == accountType).findFirst();
        return optional.orElse(null);
    }

    public String getAccountName() {
        return accountName;
    }

    public int getAccountType() {
        return accountType;
    }

    public int getWithdrawalLimit() {
        return withdrawalLimit;
    }

    public int getMinBalance() {
        return minBalance;
    }

    public int getAverageBalance() {
        return averageBalance;
    }

    public int getWithdrawalCharge() {
        return withdrawalCharge;
    }
}
