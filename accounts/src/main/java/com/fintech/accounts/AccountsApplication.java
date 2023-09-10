package com.fintech.accounts;

import com.fintech.accounts.manager.AccountManager;
import com.fintech.accounts.manager.PayeeManager;
import com.fintech.accounts.manager.UserManager;
import com.fintech.accounts.service.AccountService;
import com.fintech.accounts.service.PayeeService;
import com.fintech.accounts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccountsApplication {

	@Autowired
	private UserService userService;
	@Autowired
	private PayeeService payeeService;
	@Autowired
	private AccountService accountService;

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

	@Bean
	public UserManager userManager(){
		return new UserManager(userService);
	}

	@Bean
	public AccountManager accountManager(){
		return new AccountManager(accountService);
	}

	@Bean
	public PayeeManager payeeManager(){
		return new PayeeManager(payeeService,userService);
	}
}
