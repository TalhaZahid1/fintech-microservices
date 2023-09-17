package com.fintech.transactional.feignclient;

import com.fintech.transactional.model.CreditAccountModel;
import com.fintech.transactional.model.DebitAccountModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value="getAccountInfo", url="http://localhost:8080")
public interface AccountServiceClient {

    @RequestMapping(value = "/account/debit", method = RequestMethod.POST)
    String debitAccount(DebitAccountModel accountModel);

    @RequestMapping(value = "/account/credit", method = RequestMethod.POST)
    String creditAccount(CreditAccountModel creditAccountModel);
}
