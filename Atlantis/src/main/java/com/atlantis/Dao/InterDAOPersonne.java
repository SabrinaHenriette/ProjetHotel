package com.atlantis.Dao;

import java.util.List;

import javax.persistence.Query;

import com.atlantis.Entities.Personne;

/*Auteur: Henriette Sabrina
 * nom: Atlantis
 *date: 03/05/2016
 *Class:InterDAOPersonne
 * */


public interface InterDAOPersonne {
	
	//Ajout
	public Personne ajoutPersonne(Personne p);
	
	//Suppression
	public void deletePersonne(Long id);
	
	//Modification
	public void updatePersonne(Long id);
	
	//Avoir la liste
	public List<Personne> getListPersonne();
	
	//Avoir un objet
	public Personne getPersonne(Long id);
	
	//Avoir une liste 
	public List<Personne> getPersonneParMC(String mc);
	
}
