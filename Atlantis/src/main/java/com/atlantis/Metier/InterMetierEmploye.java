package com.atlantis.Metier;

import java.util.List;

import com.atlantis.Entities.Employe;

/*Auteur: Henriette Sabrina
 * nom: Atlantis
 *date: 03/05/2016
 *Class:InterMetierEmploye
 * */

public interface InterMetierEmploye {
	
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
