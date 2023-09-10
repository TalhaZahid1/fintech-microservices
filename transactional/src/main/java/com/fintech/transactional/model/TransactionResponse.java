package com.fintech.transactional.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TransactionResponse {

    private Boolean success;
    private String transactionNumber;
    private String transactionTime;
}
