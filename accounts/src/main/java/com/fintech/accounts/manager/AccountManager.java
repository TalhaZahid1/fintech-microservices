package com.fintech.accounts.manager;

import com.fintech.accounts.entity.Account;
import com.fintech.accounts.model.AccountModel;
import com.fintech.accounts.model.CreditAccountModel;
import com.fintech.accounts.model.DebitAccountModel;
import com.fintech.accounts.service.AccountService;

public record AccountManager(AccountService accountService) {

    public AccountModel getUserAccountDetail(String userId) {
        return convertEntityToModel(accountService.getUserAccountDetail(userId));
    }

    private AccountModel convertEntityToModel(Account account) {
        return AccountModel.builder()
                .number(account.getNumber())
                .title(account.getTitle())
                .type(account.getType())
                .balance(account.getBalance().toString())
                .build();
    }

    public String debitAccount(DebitAccountModel debitAccountModel) {
        accountService.debitUserAccount(debitAccountModel.getUserId(), debitAccountModel.getAmountDebited());
        accountService.creditPayeeAccount(debitAccountModel.getPayeeId(), debitAccountModel.getAmountDebited());
        return "OK";
    }

    public String creditAccount(CreditAccountModel creditAccountModel) {
        //ONELINK SERVICE TO DEBIT SENDER ACCOUNT CODE WILL GO HERE
        accountService.creditUserAccount(creditAccountModel.getUserId(), creditAccountModel.getAmountDebited());
        return "OK";
    }

    public Double getAccountBalance(String userId) {
        return accountService.getAccountBalance(userId);
    }
}
