package com.fintech.transactional.repository;

import com.fintech.transactional.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

    User findByEmail(String email);
    User findByContactNumber(String contactNumber);
    User findByUserId(String userId);
}
