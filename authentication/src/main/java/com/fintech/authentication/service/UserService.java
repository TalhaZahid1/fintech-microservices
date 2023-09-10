package com.fintech.authentication.service;

import com.fintech.authentication.entity.User;

public interface UserService {

    String save(User user);

    User findByUserId(String userId);
}
