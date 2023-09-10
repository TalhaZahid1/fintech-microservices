package com.fintech.accounts.service;

import com.fintech.accounts.entity.Account;
import com.fintech.accounts.repository.AccountRepository;
import com.fintech.accounts.repository.PayeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PayeeRepository payeeRepository;

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Account getUserAccountDetail(String userId) {
        return accountRepository.findByUserId(userId);
    }

    @Override
    public Account debitUserAccount(String userId, Double amount) {
        Account userAcc = accountRepository.findByUserId(userId);
        userAcc.setBalance(userAcc.getBalance()-amount);
        return accountRepository.save(userAcc);
    }

    @Override
    public Account creditUserAccount(String userId, Double amount) {
        Account userAcc = accountRepository.findByUserId(userId);
        userAcc.setBalance(userAcc.getBalance()+amount);
        return accountRepository.save(userAcc);
    }

    @Override
    public Account creditPayeeAccount(String payeeId, Double amount) {
        String payeeAcct = payeeRepository.findById(payeeId).get().getAccountNumber();
        Account payeeAccount = accountRepository.findByNumber(payeeAcct);
        payeeAccount.setBalance(payeeAccount.getBalance()+amount);
        return accountRepository.save(payeeAccount);
    }


}
