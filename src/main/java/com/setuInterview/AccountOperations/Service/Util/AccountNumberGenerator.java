package com.setuInterview.AccountOperations.Service.Util;

/**
 * @author saumitra chauhan
 * @since 26-07-2023 22:19
 */

public class AccountNumberGenerator {

    private static long accountNumberCount = 1111_1111_1111l;
    public static synchronized String generateAccountNumber(){

        return String.valueOf(accountNumberCount++);
    }
}
