package com.fintech.transactional.service;

import com.fintech.transactional.entity.User;

public interface UserService {

    String save(User user);

    User findByUserId(String userId);
}
