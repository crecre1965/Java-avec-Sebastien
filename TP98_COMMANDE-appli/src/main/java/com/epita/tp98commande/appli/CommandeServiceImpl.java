package com.epita.tp98commande.appli;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epita.tp98commande.domaine.Client;
import com.epita.tp98commande.domaine.Commande;
import com.epita.tp98commande.domaine.MoyenPaiement;
import com.epita.tp98commande.domaine.Produit;
import com.epita.tp98commande.exception.IllegalCheckoutException;
import com.epita.tp98commande.exception.PaymentException;
import com.epita.tp98commande.infra.ClientDao;
import com.epita.tp98commande.infra.CommandeDao;
import com.epita.tp98commande.infra.ProduitDao;
import com.epita.tp98commande.message.MessageService;

@Service
public class CommandeServiceImpl implements CommandeService {

	@Autowired
	CommandeDao commandeDao;

	@Autowired
	ClientDao clientDao;

	@Autowired
	ProduitDao produitDao;
	
	@Autowired
	MessageService messageService;

	public Commande creer(Commande commande) {

		if (commande.getMoyenPaiement()==MoyenPaiement.CH) {
			throw new PaymentException("mode de paiement interdit par net");
		}
		if (commande.getClient().getAge()<18) {
			throw new IllegalCheckoutException("client mineur !!!");
		}
		List<Produit> produits = new ArrayList<Produit>();
		produits=commande.getProduits();
		
		for (Produit produit : produits) {
			produitDao.save(produit);
		}
		commandeDao.save(commande);
		
		messageService.send("Commande enregistrée- id : " + commande.getId() + " / nom client : " + commande.getClient().getLastname());
		return commande;
	}

	
	public List<Commande> findByClient(Client client) {
		return commandeDao.findByClient(client);
	}


}
