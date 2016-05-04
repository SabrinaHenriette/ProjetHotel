package com.atlantis.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/*Auteur: Henriette Sabrina
 * nom: Atlantis
 *date: 02/05/2016
 *Package:com.atlantis.atlantis
 *Class:Employe
 *version:1.
 *ref-UML:Employe
 *sprint:1
 *ref-userStories:4.
 *association: OneToMany avec Reservation
 * 
 * */

@Entity
@DiscriminatorValue("Employe")
public class Employe extends Personne implements Serializable{
	
	@OneToMany(mappedBy="employe")
	private List<Reservation> listeReservationParEmploye = new ArrayList<Reservation>();
	
	//Constructeurs

	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employe(String nomPersonne, String prenomPersonne, String sexe,
			Date dateNaissance, String adresse, String tel, String mail) {
		super(nomPersonne, prenomPersonne, sexe, dateNaissance, adresse, tel, mail);
		// TODO Auto-generated constructor stub
	}

	public List<Reservation> getListeReservationParEmploye() {
		return listeReservationParEmploye;
	}

	public void setListeReservationParEmploye(
			List<Reservation> listeReservationParEmploye) {
		this.listeReservationParEmploye = listeReservationParEmploye;
	}
	
	

}
