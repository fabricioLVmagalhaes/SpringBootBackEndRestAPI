package com.fabriciomagalhaes.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.fabriciomagalhaes.cursomc.domain.Pedido;


public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);

}
