package com.setuInterview.AccountOperations.Repository.DAOService.Repositories;

import com.setuInterview.AccountOperations.Repository.Entities.AccountDetailDO;
import com.setuInterview.AccountOperations.Repository.Entities.UserDetailDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author saumitra chauhan
 * @since 27-07-2023 06:25
 */

public interface UserDetailRepository extends JpaRepository<UserDetailDO, Integer> {

    public UserDetailDO findFirstByAccountNumber(String accountNumber);
}
