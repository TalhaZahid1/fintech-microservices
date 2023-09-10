package com.fintech.transactional.feignclient;

import com.fintech.transactional.model.DebitAccountModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value="getAccountInfo", url="http://localhost:8080")
public interface AccountServiceClient {

    @RequestMapping(value = "/account/debitAccount", method = RequestMethod.POST)
    String debitAccount(DebitAccountModel accountModel);
}
