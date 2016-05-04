package com.atlantis.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*Auteur: Henriette Sabrina
 * nom: Atlantis
 *date: 02/05/2016
 *Package:com.atlantis.atlantis
 *Class:Personne
 *version:1.
 *ref-UML:Personne
 *sprint:1
 *ref-userStories:4.
 *association: /
 *Heritage: Client et Employe
 * 
 * */

@Entity
@Inheritance
@DiscriminatorColumn(name="typePersonne", discriminatorType=DiscriminatorType.STRING)
public class Personne implements Serializable {
	
	//Attributs
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idPersonne;
	private String nomPersonne;
	private String prenomPersonne;
	private String sexe;
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	private String adresse;
	private String tel;
	private String mail;
	
	//Getters et Setters
	
	public String getNomPersonne() {
		return nomPersonne;
	}
	public void setNomPersonne(String nomPersonne) {
		this.nomPersonne = nomPersonne;
	}
	public String getPrenomPersonne() {
		return prenomPersonne;
	}
	public void setPrenomPersonne(String prenomPersonne) {
		this.prenomPersonne = prenomPersonne;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Long getIdPersonne() {
		return idPersonne;
	}
	public void setIdPersonne(Long idPersonne) {
		this.idPersonne = idPersonne;
	}
	
	
	
	//Constructeur
	
	public Personne() {
		super();
	}
	
	
	public Personne(String nomPersonne, String prenomPersonne, String sexe,
			Date dateNaissance, String adresse, String tel, String mail) {
		super();
		this.nomPersonne = nomPersonne;
		this.prenomPersonne = prenomPersonne;
		this.sexe = sexe;
		this.dateNaissance = dateNaissance;
		this.adresse = adresse;
		this.tel = tel;
		this.mail = mail;
	}
	
	
	
	

}
