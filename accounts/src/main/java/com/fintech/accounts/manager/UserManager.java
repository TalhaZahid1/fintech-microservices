package com.fintech.accounts.manager;

import com.fintech.accounts.entity.Account;
import com.fintech.accounts.entity.User;
import com.fintech.accounts.model.AccountModel;
import com.fintech.accounts.model.UserModel;
import com.fintech.accounts.service.AccountService;
import com.fintech.accounts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserManager {

    private UserService userService;
    private AccountService accountService;

    @Autowired
    public UserManager(UserService userService, AccountService accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    public String save(UserModel userModel) {
        User userSaved =  userService.save(constructNewUser(userModel));
        accountService.addAccount(constructNewAccount(userModel.getAccountModel(), userSaved));
        return userSaved!=null ? "Saved!!" : "Not Saved!!";
    }

    private Account constructNewAccount(AccountModel accountModel, User user) {
        return Account.builder()
                .userId(user.getUserId())
                .number(accountModel.getNumber())
                .title(accountModel.getTitle())
                .type(accountModel.getType())
                .balance(Double.valueOf(accountModel.getBalance()))
                .build();
    }

    private User constructNewUser(UserModel userModel) {
        return User.builder()
                .userId(userModel.getUserId())
                .firstName(userModel.getFirstName())
                .lastName(userModel.getLastName())
                .email(userModel.getEmail())
                .password(userModel.getPassword())
                .contactNumber(userModel.getContactNumber())
        .build();
    }
}
