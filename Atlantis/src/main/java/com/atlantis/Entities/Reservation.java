package com.atlantis.Entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
 * Auteur : Sylvain VROLAND
 * Date : 02/05/2016
 * class : Reservation
 * package : com.atlantis.Metier ;
 * Version : 01 ;
 * ref-uml : 1 ;
 * sprint : 1 ;
 * ref-userStories : unknown ;
 * association : Employe, Client, List<Chambre> ;
 * */


@Entity
public class Reservation implements Serializable {

	
	// Attibuts
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long idReservation;
	@Temporal(TemporalType.DATE)
	Date dateDebut;
	@Temporal(TemporalType.DATE)
	Date dateFin;
	String etatReservation; //(ex : "Réservation confirmée")
	
	
	// Associations
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name=idPersonne)
	Employe employe;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name=idPersonne)
	Client client;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name=Assos_Reservation_ChambrejoinColumns = @JoinColumn(name = "idReservation"), inverseJoinColumns = @JoinColumn(name = "idChambre"))
	Liste<Chambre> listeChambreReserve = new ArrayList<Chambre>();

	
	// Getters & Setters
	public Long getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(Long idReservation) {
		this.idReservation = idReservation;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getEtatReservation() {
		return etatReservation;
	}

	public void setEtatReservation(String etatReservation) {
		this.etatReservation = etatReservation;
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Liste<Chambre> getListeChambreReserve() {
		return listeChambreReserve;
	}

	public void setListeChambreReserve(Liste<Chambre> listeChambreReserve) {
		this.listeChambreReserve = listeChambreReserve;
	}
	
	
	// Constructeurs
	public Reservation() {
		// TODO Auto-generated constructor stub
	}

	public Reservation(Date dateDebut, Date dateFin, String etatReservation) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.etatReservation = etatReservation;
	}
	
	
	

}
