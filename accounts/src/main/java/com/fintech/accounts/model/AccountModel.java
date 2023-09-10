package com.fintech.accounts.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AccountModel {

    private String userId;
    private String number;
    private String title;
    private String type;
    private String balance;
}
