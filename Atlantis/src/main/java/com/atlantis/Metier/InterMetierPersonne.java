package com.atlantis.Metier;

import java.util.List;

/*Auteur: Henriette Sabrina
 * nom: Atlantis
 *date: 03/05/2016
 *Class:InterMetierPersonne
 * */

import com.atlantis.Entities.Personne;

public interface InterMetierPersonne {
	
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
