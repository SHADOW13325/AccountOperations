package com.setuInterview.AccountOperations.Service.Service;

import com.setuInterview.AccountOperations.Models.RequestDTO.UserDetailRequest;
import com.setuInterview.AccountOperations.Models.ResponseDTO.UserResponse;

/**
 * @author saumitra chauhan
 * @since 26-07-2023 21:45
 */

public interface AccountCreationService {

    public abstract UserResponse createAccount(UserDetailRequest userDetailRequest);
}
