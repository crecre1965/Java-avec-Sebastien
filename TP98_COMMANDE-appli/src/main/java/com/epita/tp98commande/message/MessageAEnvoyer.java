package com.epita.tp98commande.message;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.core.MessageCreator;

public class MessageAEnvoyer implements MessageCreator {
private String messageFromAppli;
public MessageAEnvoyer(String messageFromAppli) {
	this.messageFromAppli=messageFromAppli;
}
	public Message createMessage(Session session) throws JMSException {
		TextMessage textMessage=session.createTextMessage(messageFromAppli);
		return textMessage;
	}

}
