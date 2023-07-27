package com.setuInterview.AccountOperations.Repository.DAOService.Repositories;

import com.setuInterview.AccountOperations.Repository.Entities.AccountDetailDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author saumitra chauhan
 * @since 27-07-2023 06:27
 */

public interface AccountDetailRepository extends JpaRepository<AccountDetailDO, Integer> {

    public AccountDetailDO findFirstByAccountNumber(String accountNumber);
}
