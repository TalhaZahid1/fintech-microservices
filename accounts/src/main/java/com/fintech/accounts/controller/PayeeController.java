package com.fintech.accounts.controller;

import com.fintech.accounts.entity.Payee;
import com.fintech.accounts.manager.PayeeManager;
import com.fintech.accounts.model.PayeeModel;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/payee")
public class PayeeController {

    @Autowired
    private PayeeManager payeeManager;

    //add payee
    @PostMapping
    public String addPayee(@RequestBody PayeeModel payeeModel){
        return payeeManager.addPayee(payeeModel);
    }
    //remove payee
    @DeleteMapping
    public String deletePayee(@RequestParam String payeeId){
        return payeeManager.deletePayee(payeeId);
    }
    @GetMapping
    public List<PayeeModel> getAllPayees(@RequestParam String userId){
        return payeeManager.getAllPayees(userId);
    }
}
