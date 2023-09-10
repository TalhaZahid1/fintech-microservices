package com.fintech.transactional.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    private String id;
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @Column(name = "contact_number")
    private String contactNumber;

    public User(String userId, String firstName, String lastName, String email, String password, String contactNumber) {
        this.id = UUID.randomUUID().toString();
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.contactNumber = contactNumber;
    }

}
