package com.fintech.accounts.service;

import com.fintech.accounts.entity.Payee;
import com.fintech.accounts.entity.User;
import com.fintech.accounts.model.PayeeModel;

import java.util.List;

public interface UserService {

    String save(User user);

    User findByUserId(String userId);

    List<Payee> getAllPayeesByUserId(String userId);
}
