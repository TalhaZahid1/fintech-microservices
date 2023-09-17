package com.fintech.accounts.model;

import lombok.*;

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
    private AccountModel accountModel;
}
