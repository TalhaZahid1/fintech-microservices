package com.fintech.transactional.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransactionModel {
    private String userId;
    private String amount;
    private String payeeId;
}
