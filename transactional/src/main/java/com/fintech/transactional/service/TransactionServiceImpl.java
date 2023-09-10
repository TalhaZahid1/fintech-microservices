package com.fintech.transactional.service;

import com.fintech.transactional.entity.Transaction;
import com.fintech.transactional.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Transaction creditAccount(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}
