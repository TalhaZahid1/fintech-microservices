package com.fintech.accounts.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PayeeModel {
    private String accountNumber;
    private String accountTitle;
    private String nickName;
    private String bankName;
    private String userId;
}
