package com.atlantis.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/*Auteur: Henriette Sabrina
 * nom: Atlantis
 *date: 02/05/2016
 *Package:com.atlantis.atlantis
 *Class:Client
 *version:1.
 *ref-UML:InterDAOPersonne
 *sprint:1
 *ref-userStories:4.
 *association: list<Reservation>
 * 
 * */

@Entity
@DiscriminatorValue("Client")
public class Client extends Personne implements Serializable{
	
	@OneToMany(mappedBy="client")
	private List<Reservation> listReservationParClient = new ArrayList<Reservation>();
	
	//Constructeurs

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Client(String nomPersonne, String prenomPersonne, String sexe,
			Date dateNaissance, String adresse, String tel, String mail) {
		super(nomPersonne, prenomPersonne, sexe, dateNaissance, adresse, tel, mail);
		// TODO Auto-generated constructor stub
	}

	public List<Reservation> getListReservationParClient() {
		return listReservationParClient;
	}

	public void setListReservationParClient(
			List<Reservation> listReservationParClient) {
		this.listReservationParClient = listReservationParClient;
	}
	

}
