package com.fintech.transactional.manager;

import com.fintech.transactional.feignclient.AccountServiceClient;
import com.fintech.transactional.model.DebitAccountModel;
import com.fintech.transactional.model.TransactionModel;
import com.fintech.transactional.entity.Transaction;
import com.fintech.transactional.model.TransactionResponse;
import com.fintech.transactional.service.KafkaService;
import com.fintech.transactional.service.TransactionService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

public record TransactionalManager(TransactionService transactionService, AccountServiceClient accountServiceClient, KafkaService kafkaService) {

    @Transactional(propagation = Propagation.MANDATORY, rollbackFor = NullPointerException.class)
    public TransactionResponse debitAccount(TransactionModel transactionModel) {
        String response = accountServiceClient.debitAccount(new DebitAccountModel().builder()
                .userId(transactionModel.getUserId())
                .payeeId(transactionModel.getPayeeId())
                .amountDebited(Double.parseDouble(transactionModel.getAmount()))
                .build());
        if(response.equalsIgnoreCase("OK")){
            Transaction transaction = transactionService.creditAccount(constructTransaction(transactionModel));
            //TODO on transaction complete, write/send Kafka template and consume in notifications
            kafkaService.sendMessae("Your account debited with amount " +  transaction.getAmount() + "to beneficiary "+ transaction.getPayeeId());
            return new TransactionResponse(true, transaction.getNumber().toString(), transaction.getTime());
        }
        return new TransactionResponse(false, "", "");
    }

    private Transaction constructTransaction(TransactionModel transactionModel) {
        return Transaction.builder()
                .userId(transactionModel.getUserId())
                .amount(Double.valueOf(transactionModel.getAmount()))
                .payeeId(transactionModel.getPayeeId())
                .number(Integer.parseInt(UUID.randomUUID().toString()))
                .time(new Date().toString())
                .build();
    }
}
