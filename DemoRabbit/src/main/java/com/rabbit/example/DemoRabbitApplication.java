package com.rabbit.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import com.rabbit.example.service.SenderMessageRabbitService;

@SpringBootApplication
@EnableAsync
public class DemoRabbitApplication implements CommandLineRunner{

	@Autowired
	private SenderMessageRabbitService senderMessageRabbitService;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoRabbitApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (int i = 0; i < 10; i++) {
			init();
		}
	}

	
	private void init() {
		senderMessageRabbitService.sendItenMercado(1000);
		
		senderMessageRabbitService.sendItenShop(1000);
		
		senderMessageRabbitService.sendItenShop2(1000);
	}
}
