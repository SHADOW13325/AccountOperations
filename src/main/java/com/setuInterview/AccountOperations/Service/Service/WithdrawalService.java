package com.setuInterview.AccountOperations.Service.Service;

import com.setuInterview.AccountOperations.Models.RequestDTO.TransactionDetailRequest;
import com.setuInterview.AccountOperations.Models.ResponseDTO.TransactionResponse;

/**
 * @author saumitra chauhan
 * @since 26-07-2023 18:36
 */

public interface WithdrawalService {

    public abstract TransactionResponse withdrawAmount(TransactionDetailRequest transactionDetailRequest);

}
