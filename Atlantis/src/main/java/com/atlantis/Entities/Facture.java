package com.atlantis.Entities;

/*
 * 
 *Auteur(s): Vinh
 *Nom projet: Atlantis
 *Date: 02/05/2016
 *Package: com.atlantis.Entities
 *Classe: Facture
 *Version: 1
 *Ref-UML: 1
 *Sprint: 1
 *Ref-UserStory: 1
 *Association(s): Devis
 *
 *
 * */

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Facture implements Serializable {

	///////////////////
	/////attributs/////
	///////////////////
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idFacture;
	@Temporal(TemporalType.DATE)
	private Date datePaiement;
	private String typePaiement;
	
	@OneToOne
//	@PrimaryKeyJoinColumn
	private Devis devis;
	
	
	///////////////////////
	/////constructeurs/////
	///////////////////////
	public Facture() {
	}
	public Facture(Date datePaiement, String typePaiement) {
		this.datePaiement = datePaiement;
		this.typePaiement = typePaiement;
	}
	
	
	/////////////////////////
	/////getters&setters/////
	/////////////////////////
	public Long getIdFacture() {
		return idFacture;
	}
	public void setIdFacture(Long idFacture) {
		this.idFacture = idFacture;
	}
	public Date getDatePaiement() {
		return datePaiement;
	}
	public void setDatePaiement(Date datePaiement) {
		this.datePaiement = datePaiement;
	}
	public String getTypePaiement() {
		return typePaiement;
	}
	public void setTypePaiement(String typePaiement) {
		this.typePaiement = typePaiement;
	}
	public Devis getDevisProduit() {
		return devis;
	}
	public void setDevisProduit(Devis devis) {
		this.devis = devis;
	}
	
}
