package com.fintech.accounts.repository;

import com.fintech.accounts.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
    Account findByUserId(String userId);
    Account findByNumber(String accountNumber);
}
