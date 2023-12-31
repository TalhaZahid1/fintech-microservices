package com.fintech.transactional.service;

import com.fintech.transactional.entity.User;
import com.fintech.transactional.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String save(User user) {
        if(userRepository.findByEmail(user.getEmail()) == null) {
            User userSaved = userRepository.save(user);
            return userSaved.getId()!=null ? "Saved" : "Not Saved. Internal Server Error";
        } else if(userRepository.findByContactNumber(user.getContactNumber()) == null){
            return "Phone Number Already Exist!";
        }
            return "Email Already Exist!";
    }

    @Override
    public User findByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }
}
