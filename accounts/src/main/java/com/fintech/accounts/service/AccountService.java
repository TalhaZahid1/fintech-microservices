package com.fintech.accounts.service;

import com.fintech.accounts.entity.Account;

public interface AccountService {
    Account getUserAccountDetail(String userId);
    Account debitUserAccount(String userId, Double amount);
    Account creditUserAccount(String userId, Double amount);
    Account creditPayeeAccount(String payeeId, Double amount);
    void addAccount(Account account);
}
