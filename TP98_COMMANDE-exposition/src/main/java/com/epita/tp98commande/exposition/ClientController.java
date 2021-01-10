package com.epita.tp98commande.exposition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epita.tp98commande.appli.ClientService;
import com.epita.tp98commande.domaine.Client;

@RestController
@RequestMapping("api/client")
public class ClientController {
	
	@Autowired
	ClientService clientService;
	
	@PostMapping("/creer")
	public String creerClient(@RequestBody Client client) {
		long id=clientService.creer(client);
		if (id>0) {
			return "client créé " + id;
		}else {
			return "client non créé - vérifiez votre saisie";
		}
		
	}

}
