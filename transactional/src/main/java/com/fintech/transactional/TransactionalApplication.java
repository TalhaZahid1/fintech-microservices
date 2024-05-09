package com.fintech.transactional;

import com.fintech.transactional.fiegnclient.AccountServiceClient;
import com.fintech.transactional.manager.TransactionalManager;
import com.fintech.transactional.service.KafkaService;
import com.fintech.transactional.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
@ImportAutoConfiguration({FeignAutoConfiguration.class})
public class TransactionalApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionalApplication.class, args);
	}

	@Autowired
	private TransactionService transactionService;

	@Autowired
	private KafkaService kafkaService;

	@Autowired
	private AccountServiceClient accountServiceClient;

	@Bean
	public TransactionalManager transactionalManager(){
		return new TransactionalManager(transactionService,kafkaService, accountServiceClient);
	}
}
