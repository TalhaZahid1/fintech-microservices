package com.fintech.accounts.controller;

import com.fintech.accounts.entity.Payee;
import com.fintech.accounts.manager.PayeeManager;
import com.fintech.accounts.model.PayeeModel;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
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

    @GetMapping("/getAllPayees")
    public List<PayeeModel> getAllPayees(@RequestParam String userId){
//        List<PayeeModel> payeeModels = new ArrayList<>();
        return payeeManager.getAllPayees(userId);
//        payeeModels.add(new PayeeModel("123132","talha","TZ","Gulberg","123"));
//        return new ResponseEntity<>(payeeModels, HttpStatus.OK);
    }
}
