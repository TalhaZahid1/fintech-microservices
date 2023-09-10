package com.fintech.accounts.service;

import com.fintech.accounts.entity.Payee;

import java.util.List;

public interface PayeeService {
    boolean addPayee(Payee payeeModelToEntity);

    boolean deletePayee(String payeeId);
}
