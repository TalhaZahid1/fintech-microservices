package com.fintech.accounts.service;

import com.fintech.accounts.entity.Payee;
import com.fintech.accounts.entity.User;
import com.fintech.accounts.model.PayeeModel;
import com.fintech.accounts.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(User user) {
        if(userRepository.findByEmail(user.getEmail()) == null) {
            return userRepository.save(user);
        } else{
            return null;
        }
    }

    @Override
    public User findByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }

    @Override
    public List<Payee> getAllPayeesByUserId(String userId) {
        return userRepository.findByUserId(userId).getPayee();
    }
}
