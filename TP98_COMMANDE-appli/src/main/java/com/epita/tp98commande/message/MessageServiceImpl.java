package com.epita.tp98commande.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	JmsTemplate jmsTemplate;
	public void send(String message) {
		jmsTemplate.send("queue_COMMANDE", new MessageAEnvoyer(message));
	}
}
