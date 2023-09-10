package com.fintech.authentication.repository;

import com.fintech.authentication.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

    User findByEmail(String email);
    User findByContactNumber(String contactNumber);
    User findByUserId(String userId);
}
