package com.atlantis.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;



/*Auteur: Henriette Sabrina
 * nom: Atlantis
 *date: 02/05/2016
 *Package:com.atlantis.atlantis
 *Class:Chambre
 *version:1.
 *ref-UML:Chambre
 *sprint:1
 *ref-userStories:4.
 *association: ManyToMany avec Reservation
 * 
 * */

@Entity
public class Chambre implements Serializable {
	
	//Attributs
	
	@Id
	private Long idChambre;
	private Integer capacite;
	private Double prix;
	private String description;
	
	@ManyToMany(/*fetch=FetchType.LAZY, */mappedBy="listeChambreReserve")
	private List<Reservation> listeReservationParChambre = new ArrayList<Reservation>();
	
	
	//Getters et Setters
	
	public Long getIdChambre() {
		return idChambre;
	}
	public void setIdChambre(Long idChambre) {
		this.idChambre = idChambre;
	}
	public Integer getCapacite() {
		return capacite;
	}
	public void setCapacite(Integer capacite) {
		this.capacite = capacite;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Reservation> getListeReservationParChambre() {
		return listeReservationParChambre;
	}
	public void setListeReservationParChambre(
			List<Reservation> listeReservationParChambre) {
		this.listeReservationParChambre = listeReservationParChambre;
	}
	
	
	//Constructeurs
	

	public Chambre() {
		super();
	}
	
	
	public Chambre(Long idChambre, Integer capacite, Double prix,
			String description) {
		super();
		this.idChambre = idChambre;
		this.capacite = capacite;
		this.prix = prix;
		this.description = description;
	}
	
	
	

}
