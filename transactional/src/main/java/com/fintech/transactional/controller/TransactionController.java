package com.fintech.transactional.controller;

import com.fintech.transactional.manager.TransactionalManager;
import com.fintech.transactional.model.CreditAccountModel;
import com.fintech.transactional.model.DebitAccountModel;
import com.fintech.transactional.model.TransactionResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/debitAccount")
    public TransactionResponse debitAccount(@RequestBody DebitAccountModel debitAccountModel) {
         return transactionManager.debitAccount(debitAccountModel);
    }

    @PostMapping("/creditAccount")
    public TransactionResponse creditAccount(@RequestBody CreditAccountModel creditAccountModel){
        return transactionManager.creditAccount(creditAccountModel);
    }


}
