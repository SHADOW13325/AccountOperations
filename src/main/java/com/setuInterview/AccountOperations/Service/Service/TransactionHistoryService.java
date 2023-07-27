package com.setuInterview.AccountOperations.Service.Service;

import com.setuInterview.AccountOperations.Models.ResponseDTO.UserResponse;

/**
 * @author saumitra chauhan
 * @since 26-07-2023 18:38
 */

public interface TransactionHistoryService {

    public abstract UserResponse getTransactionHistory(String accountNumber);
}
