package com.fintech.accounts.controller;


import com.fintech.accounts.manager.UserManager;
import com.fintech.accounts.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/signUp")
public class SignUpController {

    @Autowired
    private UserManager userManager;

    @PostMapping("/user")
    public String signUp(@RequestBody UserModel userModel){
        return userManager.save(userModel);
    }
}
