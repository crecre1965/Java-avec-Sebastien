package com.epita.tp99commrecep.appli;



import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MonConsumer {

@JmsListener(destination="queue_COMMANDE")
		
	public void consume(String message) {
		
		System.out.println(message);
	
		

	}

}
