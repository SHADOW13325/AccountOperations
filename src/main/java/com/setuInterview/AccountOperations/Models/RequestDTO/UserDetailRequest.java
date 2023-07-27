package com.setuInterview.AccountOperations.Models.RequestDTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * @author saumitra chauhan
 * @since 26-07-2023 20:07
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDetailRequest {

    @NotBlank(message = "username can't be empty")
    @Size(min = 3, message = "username length must be greater than or equal to 3")
    private String name;

    @NotBlank(message = "mobile number can't be empty")
    @Size(min = 10, max = 10, message = "mobile number must be of 10 digits")
    private String mobile;

    @Min(value = 1, message = "Choose account type between 1 to 3")
    @Max(value = 3, message = "Choose account type between 1 to 3")
    private int accountType;

    public UserDetailRequest(String name, String mobile, int accountType) {
        this.name = name;
        this.mobile = mobile;
        this.accountType = accountType;
    }

    public UserDetailRequest() {
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

    public int getAccountType() {
        return accountType;
    }

    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }


}
