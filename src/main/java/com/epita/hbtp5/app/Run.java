package com.epita.hbtp5.app;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;



import com.epita.hbtp5.dao.DaoFactory;
import com.epita.hbtp5.dao.PersonneDao;
import com.epita.hbtp5.entity.AdressePostale;
import com.epita.hbtp5.entity.Entreprise;
import com.epita.hbtp5.entity.HistoriqueRemuneration;
import com.epita.hbtp5.entity.Personne;

public class Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Entreprise entreprise = new Entreprise();
		
		AdressePostale adressePostale=new AdressePostale();
		adressePostale.setNomRue("rue entreprise");
		adressePostale.setCodePostal("91620");
		
		entreprise.setNom("entreprise de Lolo");
		entreprise.setAdressePostale(adressePostale);
		
		Personne personne = new Personne();
		
		HistoriqueRemuneration histo = new HistoriqueRemuneration();
		histo.setMontant(2000);
		histo.setPeriode(new Date());
		Set <HistoriqueRemuneration> historique= new HashSet<HistoriqueRemuneration>();
		historique.add(histo);
		
		AdressePostale adressePostale1=new AdressePostale();
		
		adressePostale1.setCodePostal("75001");
		adressePostale1.setNomRue("rue titi");
		personne.setAdressePostale(adressePostale1);
		personne.setEntreprise(entreprise);
		personne.setNom("toto");
		personne.setHisto(historique);
		
		PersonneDao dao= DaoFactory.createPersonneDao();
		dao.create(personne);
				
				
	}



}
