package com.fintech.accounts.repository;

import com.fintech.accounts.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface UserRepository extends CrudRepository<User, String> {

    User findByEmail(String email);
    User findByContactNumber(String contactNumber);
    User findByUserId(String userId);
}
