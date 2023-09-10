package com.fintech.accounts.manager;

import com.fintech.accounts.entity.Payee;
import com.fintech.accounts.model.PayeeModel;
import com.fintech.accounts.service.PayeeService;
import com.fintech.accounts.service.UserService;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

public record PayeeManager(PayeeService payeeService, UserService userService) {

    public String addPayee(PayeeModel payeeModel){
        return payeeService.addPayee(payeeModelToEntity(payeeModel)) ? "Payee Added" : "Payee Already Exists!";
    }

    private Payee payeeModelToEntity(PayeeModel payeeModel) {
        return Payee.builder()
                .userId(userService.findByUserId(payeeModel.getUserId()))
                .accountNumber(payeeModel.getAccountNumber())
                .accountTitle(payeeModel.getAccountTitle())
                .bankName(payeeModel.getBankName())
                .nickName(payeeModel.getNickName())
                .build();
    }

    public String deletePayee(String payeeId) {
        return payeeService.deletePayee(payeeId) ? "Deleted Succefully" : "Unable to delete!";
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public List<PayeeModel> getAllPayees(String userId) {
        return payeeEntityToModel(userService.getAllPayeesByUserId(userId));
    }

    private List<PayeeModel> payeeEntityToModel(List<Payee> allPayeesByUserId) {
        List<PayeeModel> payeeModels = new ArrayList<>();
        allPayeesByUserId.forEach(payee -> payeeModels.add(PayeeModel
                        .builder()
                        .accountNumber(payee.getAccountNumber())
                        .accountTitle(payee.getAccountTitle())
                        .bankName(payee.getBankName())
                        .nickName(payee.getNickName())
                        .userId(payee.getUserId().getUserId())
                        .build()));
        return payeeModels;
    }

}
