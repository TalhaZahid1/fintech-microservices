package com.fintech.transactional.service;

import com.fintech.transactional.entity.Transaction;

public interface TransactionService {

    Transaction creditAccount(Transaction transaction);
}
