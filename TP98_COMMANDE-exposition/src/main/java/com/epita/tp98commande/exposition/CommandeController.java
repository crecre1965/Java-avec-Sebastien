package com.epita.tp98commande.exposition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.epita.tp98commande.appli.CommandeService;
import com.epita.tp98commande.domaine.Commande;

@RestController
@RequestMapping("/api/copmmande")
public class CommandeController {
@Autowired
private CommandeService commandeService;

@PostMapping("/creer")
	public String creerCommande(@RequestBody Commande commande) {
		Commande commandeRealisee=commandeService.creer(commande);
		
		return "commande créee ! id : " +commandeRealisee.getId();
	}

}
