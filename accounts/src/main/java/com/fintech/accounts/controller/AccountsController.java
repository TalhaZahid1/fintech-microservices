package com.fintech.accounts.controller;


import com.fintech.accounts.manager.AccountManager;
import com.fintech.accounts.model.AccountModel;
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

    //acctdetails
    @GetMapping
    public AccountModel getAccountDetails(@RequestParam String userId) {
        return accountManager.getUserAccountDetail(userId);
    }
    //debitAccount
    @PostMapping("/debitAccount")
    public String debitAccount(@RequestBody DebitAccountModel debitAccountModel){
        return accountManager.debitAccount(debitAccountModel);
    }
}
