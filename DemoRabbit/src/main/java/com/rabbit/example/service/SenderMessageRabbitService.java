package com.rabbit.example.service;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.rabbit.example.entity.Item;

@Service
public class SenderMessageRabbitService {

	@Autowired
	private AmqpTemplate rabbitTemplateShoping;
	
	@Value("${shop.exchange}")
	private String exchShop;
	
	@Value("${shop.routing.key}")
	private String rkShop;
	
	
	@Value("${shop2.exchange}")
	private String exchShop2;
	
	@Value("${shop2.routing.key}")
	private String rkShop2;
	
	
	@Value("${item.exchange}")
	private String exchMercado;
	
	@Value("${item.routing.key}")
	private String rkMercado;
	
	@Async("threadExecutor")
	public void sendItenShop(Integer cant) {
		for (int i = 0; i < cant; i++) {
			Item item = new Item();
			item.setName("Mercado Shop");
			item.setNumber(i);
			sendIten(item, exchShop, rkShop); 
			
			}System.out.println("Shop");		
	}
	
	@Async("threadExecutor")
	public void sendItenShop2(Integer cant) {
		 
		for (int i = 0; i < cant; i++) {
			Item item = new Item();
			item.setName("Mercado Sop2");
			item.setNumber(i);
			sendIten(item, exchShop2, rkShop2);
			
			}System.out.println("Shop2");
	}
	
	@Async("threadExecutor")
	public void sendItenMercado(Integer cant) {
		for (int i = 0; i < cant; i++) {
			Item item = new Item();
			item.setName("Mercado Mercado");
			item.setNumber(i);
			sendIten(item, exchMercado, rkMercado);
			
			}System.out.println("Mercado");
		
	}
	
	
	private void sendIten(Item item, String exch, String rk) {
		rabbitTemplateShoping.convertAndSend(exch, rk, item);
	}
}
