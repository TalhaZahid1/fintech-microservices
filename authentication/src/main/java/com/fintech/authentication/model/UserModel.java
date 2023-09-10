package com.fintech.authentication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserModel {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String contactNumber;
    private String role;
}
