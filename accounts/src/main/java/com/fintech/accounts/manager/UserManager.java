package com.fintech.accounts.manager;

import com.fintech.accounts.entity.Account;
import com.fintech.accounts.entity.User;
import com.fintech.accounts.model.AccountModel;
import com.fintech.accounts.model.UserModel;
import com.fintech.accounts.service.AccountService;
import com.fintech.accounts.service.UserService;

public record UserManager(UserService userService, AccountService accountService) {

    public String save(UserModel userModel) {
        User userSaved =  userService.save(constructNewUser(userModel));
        accountService.addAccount(constructNewAccount(userModel.getAccountModel(), userSaved));
        return userSaved!=null ? "Saved!!" : "Not Saved!!";
    }

    private Account constructNewAccount(AccountModel accountModel, User user) {
        return Account.builder()
                .userId(user)
                .number(accountModel.getNumber())
                .title(accountModel.getTitle())
                .type(accountModel.getType())
                .build();
    }

    private User constructNewUser(UserModel userModel) {
        return User.builder()
                .firstName(userModel.getFirstName())
                .lastName(userModel.getLastName())
                .email(userModel.getEmail())
                .password(userModel.getPassword())
                .contactNumber(userModel.getContactNumber())
        .build();
    }
}
