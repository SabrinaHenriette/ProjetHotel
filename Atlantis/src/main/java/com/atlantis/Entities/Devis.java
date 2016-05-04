package com.atlantis.Entities;

/*
 * 
 *Auteur(s: Vinh
 *Nom projet: Atlantis
 *Date: 02/05/2016
 *Package: com.atlantis.Entities
 *Classe: Devis
 *Version: 1
 *Ref-UML: 1
 *Sprint: 1
 *Ref-UserStory: 1
 *Association(s): List<Produit>, Reservation
 *
 *
 * */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@SuppressWarnings("serial")
@Entity
public class Devis implements Serializable {

	///////////////////
	/////attributs/////
	///////////////////
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idDevis;
	
	@OneToMany
//	@JoinColumn(name="id_Produit")
	private List<Produit> listeProduits = new ArrayList<Produit>();
	@OneToOne
//	@PrimaryKeyJoinColumn
	private Reservation reservation;

	
	///////////////////////
	/////constructeurs/////
	///////////////////////
	public Devis() {
	}
	
	
	/////////////////////////
	/////getters&setters/////
	/////////////////////////
	public Long getIdDevis() {
		return idDevis;
	}
	public void setIdDevis(Long idDevis) {
		this.idDevis = idDevis;
	}
	public List<Produit> getProduits() {
		return listeProduits;
	}
	public void setProduits(List<Produit> listeProduits) {
		this.listeProduits = listeProduits;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
}
