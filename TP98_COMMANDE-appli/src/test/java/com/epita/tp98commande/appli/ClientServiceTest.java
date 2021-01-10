package com.epita.tp98commande.appli;



import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.epita.tp98commande.domaine.Adress;
import com.epita.tp98commande.domaine.Client;
import com.epita.tp98commande.infra.ClientDao;

@RunWith(MockitoJUnitRunner.class)
public class ClientServiceTest {
	
	@InjectMocks
	ClientService clientService=new ClientServiceImpl();
	
	@Mock
	ClientDao clientDao;
	
	
	
	@Test
	public void creerClientOk() {
		Client client = new Client();
		Adress adress= new Adress();
		adress.setStreet("12 rue");
		adress.setZipCode("91620");
		client.setId(12);
		client.setAdress(adress);
		client.setAge(22);
		client.setFirstname("lolo");
		client.setLastname("Crecre");
		Mockito.when(clientDao.save(client)).thenReturn(client);
		assertEquals(12, clientService.creer(client));
	}
}
