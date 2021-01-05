package com.epita.hbtp5.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class AdressePostale {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String codePostal;
	private String nomRue;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getNomRue() {
		return nomRue;
	}
	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}
	
	

}
