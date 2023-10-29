package com.springbootMc1.BEJ_C1_S4_Spring_Boot_MC_1;

import com.springbootMc1.BEJ_C1_S4_Spring_Boot_MC_1.Services.MessageService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BejC1S4SpringBootMc1Application {

	public static void main(String[] args) {
	ApplicationContext context =  SpringApplication.run(BejC1S4SpringBootMc1Application.class, args);
		MessageService messageService = context.getBean(MessageService.class);
		System.out.println(messageService.getMessage());
	}
}
