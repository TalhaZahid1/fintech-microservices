package com.fintech.accounts.controller;


import com.fintech.accounts.manager.AccountManager;
import com.fintech.accounts.model.AccountModel;
import com.fintech.accounts.model.CreditAccountModel;
import com.fintech.accounts.model.DebitAccountModel;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/account")
public class AccountsController {

    @Autowired
    private AccountManager accountManager;

    @GetMapping
    public AccountModel getAccountDetails(@RequestParam String userId) {
        return accountManager.getUserAccountDetail(userId);
    }

    @PostMapping("/debit")
    public String debitAccount(@RequestBody DebitAccountModel debitAccountModel){
        return accountManager.debitAccount(debitAccountModel);
    }

    @GetMapping("/checkBalance")
    public Double checkAccountBalance(@RequestParam String userId){
        return accountManager.getAccountBalance(userId);
    }

    @PostMapping("/credit")
    public String debitAccount(@RequestBody CreditAccountModel creditAccountModel){
        return accountManager.creditAccount(creditAccountModel);
    }
}
