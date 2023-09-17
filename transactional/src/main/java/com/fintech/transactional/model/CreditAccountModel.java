package com.fintech.transactional.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreditAccountModel {
    private String userId;
    private Double amountCredited;
    private String senderAccountNumber;
    private String senderAccountTitle;
}
