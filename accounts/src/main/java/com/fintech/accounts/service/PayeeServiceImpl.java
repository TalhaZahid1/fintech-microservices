package com.fintech.accounts.service;

import com.fintech.accounts.entity.Payee;
import com.fintech.accounts.repository.PayeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayeeServiceImpl implements PayeeService{

    @Autowired
    private PayeeRepository payeeRepository;

    @Override
    public boolean addPayee(Payee payeeModelToEntity) {
        Payee payee = payeeRepository.findByAccountNumber(payeeModelToEntity.getAccountNumber());
        if(payee == null) {
            payeeRepository.save(payeeModelToEntity);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deletePayee(String payeeId) {
         payeeRepository.deleteById(payeeId);
         return true;
    }
}
