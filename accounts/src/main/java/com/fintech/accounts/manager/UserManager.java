package com.fintech.accounts.manager;

import com.fintech.accounts.entity.User;
import com.fintech.accounts.model.UserModel;
import com.fintech.accounts.service.UserService;

public record UserManager(UserService userService) {

    public String save(UserModel userModel) {
        return userService.save(constructNewUser(userModel));
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
