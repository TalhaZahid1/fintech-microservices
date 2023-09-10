package com.fintech.transactional.controller;

import com.fintech.transactional.feignclient.AccountServiceClient;
import com.fintech.transactional.model.TransactionModel;
import com.fintech.transactional.manager.TransactionalManager;
import com.fintech.transactional.model.TransactionResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@AllArgsConstructor
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionalManager transactionManager;

    @PostMapping
    public TransactionResponse debitAccount(@RequestBody TransactionModel transactionModel) {
         return transactionManager.debitAccount(transactionModel);
    }

    //debitaccount


}
