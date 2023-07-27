package com.setuInterview.AccountOperations.Service.Service.Impl;

import com.setuInterview.AccountOperations.Models.RequestDTO.UserDetailRequest;
import com.setuInterview.AccountOperations.Models.ResponseDTO.UserResponse;
import com.setuInterview.AccountOperations.Repository.DAOService.DAOService;
import com.setuInterview.AccountOperations.Repository.Entities.AccountDetailDO;
import com.setuInterview.AccountOperations.Repository.Entities.UserDetailDO;
import com.setuInterview.AccountOperations.Service.Service.AccountCreationService;
import com.setuInterview.AccountOperations.Service.Util.AccountNumberGenerator;
import com.setuInterview.AccountOperations.Service.Util.Converter;
import com.setuInterview.AccountOperations.Service.Util.CreateResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author saumitra chauhan
 * @since 26-07-2023 21:45
 */
@Service
public class AccountCreationServiceImpl implements AccountCreationService {

    private final DAOService daoService;
    private final Converter converter;
    private final CreateResponses createResponses;

    @Autowired
    public AccountCreationServiceImpl(DAOService daoService, Converter converter, CreateResponses createResponses) {
        this.daoService = daoService;
        this.converter = converter;
        this.createResponses = createResponses;
    }

    @Override
    public UserResponse createAccount(UserDetailRequest userDetailRequest) {

        String accountNumber = AccountNumberGenerator.generateAccountNumber();
        UserDetailDO userDetailDO = converter.convertUserDetailToUserDetailDO(userDetailRequest, accountNumber);
        AccountDetailDO accountDetailDO = new AccountDetailDO(accountNumber, userDetailRequest.getAccountType());
        daoService.save(userDetailDO);
        daoService.saveOrUpdate(accountDetailDO);
        UserResponse userResponse = createResponses.createUserDetailResponse(userDetailDO, accountDetailDO);
        return userResponse;
    }
}
