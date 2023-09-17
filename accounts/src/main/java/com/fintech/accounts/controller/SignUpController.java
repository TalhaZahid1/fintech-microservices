package com.fintech.accounts.controller;


import com.fintech.accounts.manager.UserManager;
import com.fintech.accounts.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/signUp")
public class SignUpController {

    @Autowired
    private UserManager userManager;

    @PostMapping
    public String signUp(@RequestBody UserModel userModel){
        return userManager.save(userModel);
    }
}
