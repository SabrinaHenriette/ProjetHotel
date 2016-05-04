package com.atlantis.Dao;

import java.util.List;

/*Auteur: Henriette Sabrina
 * nom: Atlantis
 *date: 03/05/2016
 *Class:InterDAOChambre
 * */

import com.atlantis.Entities.Chambre;

public interface InterDAOChambre {
	
		//Ajout
		public Chambre ajoutChambre(Chambre c);
		
		//Suppression
		public void deleteChambre(Long id);
		
		//Modification
		public void updateChambre(Long id);
		
		//Avoir la liste
		public List<Chambre> getListChambre();
		
		//Avoir un objet
		public Chambre getChambre(Long id);
		

		


}
