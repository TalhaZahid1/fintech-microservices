package com.fintech.transactional.manager;

import com.fintech.transactional.fiegnclient.AccountServiceClient;
import com.fintech.transactional.model.CreditAccountModel;
import com.fintech.transactional.model.DebitAccountModel;
import com.fintech.transactional.entity.Transaction;
import com.fintech.transactional.model.TransactionResponse;
import com.fintech.transactional.service.KafkaService;
import com.fintech.transactional.service.TransactionService;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

public class TransactionalManager {

    private TransactionService transactionService;
    private KafkaService kafkaService;
    private AccountServiceClient accountServiceClient;

    public TransactionalManager(TransactionService transactionService, KafkaService kafkaService, AccountServiceClient accountServiceClient) {
        this.transactionService = transactionService;
        this.kafkaService = kafkaService;
        this.accountServiceClient = accountServiceClient;
    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = NullPointerException.class)
    public TransactionResponse debitAccount(DebitAccountModel debitAccountModel) {
        String response = accountServiceClient.debitAccount(debitAccountModel);
        if(response.equalsIgnoreCase("OK")){
            Transaction transaction = transactionService.debitAccount(constructDebitTransaction(debitAccountModel));
            kafkaService.sendMessae("Your account debited with amount " +  transaction.getAmount() + " to beneficiary "+ transaction.getPayeeId());
            return new TransactionResponse(true, transaction.getId().toString(), transaction.getTime());
        }
        return new TransactionResponse(false, "", "");
    }

    private Transaction constructDebitTransaction(DebitAccountModel debitAccountModel) {
        return Transaction.builder()
                .userId(debitAccountModel.getUserId())
                .amount(debitAccountModel.getAmountDebited())
                .payeeId(debitAccountModel.getPayeeId())
//                .number(Integer.parseInt(UUID.randomUUID().toString()))
                .time(new Date().toString())
                .build();
    }

    public TransactionResponse creditAccount(CreditAccountModel creditAccountModel) {
        String response = accountServiceClient.creditAccount(creditAccountModel);
        if(response.equalsIgnoreCase("OK")){
            Transaction transaction = transactionService.creditAccount(constructCreditTransaction(creditAccountModel));
            kafkaService.sendMessae("Your account credited with amount " +  transaction.getAmount() + " from "+ transaction.getSenderAccountTitle());
            return new TransactionResponse(true, transaction.getId().toString(), transaction.getTime());
        }
        return new TransactionResponse(false, "", "");
    }

    private Transaction constructCreditTransaction(CreditAccountModel creditAccountModel) {
        return Transaction.builder()
                .userId(creditAccountModel.getUserId())
                .amount(creditAccountModel.getAmountCredited())
                .senderAccountNumber(creditAccountModel.getSenderAccountNumber())
                .senderAccountTitle(creditAccountModel.getSenderAccountTitle())
                .time(new Date().toString())
                .build();
    }
}
