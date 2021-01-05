package com.epita.hbtp5.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;



@Entity
public class Personne {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	
	@ManyToOne
	@Cascade(value =CascadeType.ALL)
	private Entreprise entreprise;
	
	@ManyToOne
	@Cascade(value =CascadeType.ALL)
	private AdressePostale adressePostale;
	
	@OneToMany
	@Cascade(value =CascadeType.ALL)
	private Set<HistoriqueRemuneration> histo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		if (nom==null) {
			nom= "nom par défaut";
		}
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public AdressePostale getAdressePostale() {
		if (adressePostale== null){
			adressePostale=new AdressePostale();
		}
		return adressePostale;
	}

	public void setAdressePostale(AdressePostale adressePostale) {
		this.adressePostale = adressePostale;
	}

	public Set<HistoriqueRemuneration> getHisto() {
		if (histo==null) {
			histo=new HashSet<HistoriqueRemuneration>();
		}
		return histo;
	}

	public void setHisto(Set<HistoriqueRemuneration> histo) {
		this.histo = histo;
	}
	
	

}
