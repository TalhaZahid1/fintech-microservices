package com.fintech.accounts.repository;

import com.fintech.accounts.entity.Payee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PayeeRepository extends JpaRepository<Payee, String> {

    Payee findByAccountNumber(String accountNumber);
    List<Payee> findAllByUserId(String userId);
}
