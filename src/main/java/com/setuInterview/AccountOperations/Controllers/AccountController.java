package com.setuInterview.AccountOperations.Controllers;

import com.setuInterview.AccountOperations.Constants.ServiceURIs;
import com.setuInterview.AccountOperations.Models.RequestDTO.TransactionDetailRequest;
import com.setuInterview.AccountOperations.Models.ResponseDTO.TransactionResponse;
import com.setuInterview.AccountOperations.Models.RequestDTO.UserDetailRequest;
import com.setuInterview.AccountOperations.Models.ResponseDTO.UserResponse;
import com.setuInterview.AccountOperations.Service.Service.AccountCreationService;
import com.setuInterview.AccountOperations.Service.Service.DepositService;
import com.setuInterview.AccountOperations.Service.Service.TransactionHistoryService;
import com.setuInterview.AccountOperations.Service.Service.WithdrawalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author saumitra chauhan
 * @since 26-07-2023 16:57
 */

@RestController
@RequestMapping(value = ServiceURIs.ACCOUNT_API_BASE_PATH, consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountController {

    private final WithdrawalService withdrawalService;

    private final DepositService depositService;

    private final TransactionHistoryService historyService;

    private final AccountCreationService accountCreationService;

    @Autowired
    public AccountController(WithdrawalService withdrawalService, DepositService depositService, TransactionHistoryService historyService, AccountCreationService accountCreationService) {
        this.withdrawalService = withdrawalService;
        this.depositService = depositService;
        this.historyService = historyService;
        this.accountCreationService = accountCreationService;
    }

    @PostMapping(ServiceURIs.CREATION_API_V1)
    public ResponseEntity<UserResponse> accountCreation(@Valid @RequestBody UserDetailRequest userDetailRequest) {

        UserResponse userResponse = accountCreationService.createAccount(userDetailRequest);
        return ResponseEntity.ok(userResponse);

    }

    @PostMapping(ServiceURIs.DEPOSIT_API_V1)
    public ResponseEntity<TransactionResponse> depositMoney(@Valid @RequestBody TransactionDetailRequest transactionDetailRequest){

        TransactionResponse transactionResponse = depositService.depositAmount(transactionDetailRequest);
        return ResponseEntity.ok(transactionResponse);
    }

    @PostMapping(ServiceURIs.WITHDRAWAL_API_V1)
    public ResponseEntity<TransactionResponse> withdrawMoney(@Valid @RequestBody TransactionDetailRequest transactionDetailRequest) {
        TransactionResponse transactionResponse = withdrawalService.withdrawAmount(transactionDetailRequest);
        return ResponseEntity.ok(transactionResponse);
    }

    @GetMapping(ServiceURIs.TRANSACTION_HISTORY_API_V1)
    public ResponseEntity<UserResponse> transactionHistory(@RequestParam("accountNumber") String accountNumber ){
        UserResponse userResponse = historyService.getTransactionHistory(accountNumber);
        return ResponseEntity.ok(userResponse);
    }
}
