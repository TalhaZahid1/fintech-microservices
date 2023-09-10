package com.fintech.transactional;

import com.fintech.transactional.feignclient.AccountServiceClient;
import com.fintech.transactional.manager.TransactionalManager;
import com.fintech.transactional.service.KafkaService;
import com.fintech.transactional.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TransactionalApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionalApplication.class, args);
	}

	@Autowired
	private AccountServiceClient accountServiceClient;

	@Autowired
	private TransactionService transactionService;

	@Autowired
	private KafkaService kafkaService;

	@Bean
	public TransactionalManager transactionalManager(){
		return new TransactionalManager(transactionService, accountServiceClient, kafkaService);
	}
}
