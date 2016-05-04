package com.atlantis.Dao;

import java.util.List;

/*Auteur: Henriette Sabrina
 * nom: Atlantis
 *date: 03/05/2016
 *Class:InterDAOEmploye
 * */

import com.atlantis.Entities.Employe;

public interface InterDAOEmploye {
	
	//Ajout
	public Employe ajoutEmploye(Employe emp);
	
	//Suppression
	public void deleteEmploye(Long id);
	
	//Modification
	public void updateEmploye(Long id);
	
	//Avoir la liste
	public List<Employe> getListEmploye();
	
	//Avoir un objet
	public Employe getEmploye(Long id);
	
	//Avoir une liste 
	public List<Employe> getEmployeParMC(String mc);

}
