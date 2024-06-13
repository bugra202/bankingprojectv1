package com.oredata.bankingproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BankingprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingprojectApplication.class, args);
	}

}
