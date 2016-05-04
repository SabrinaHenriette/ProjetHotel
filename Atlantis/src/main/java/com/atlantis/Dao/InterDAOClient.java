package com.atlantis.Dao;

import java.util.List;


/*Auteur: Henriette Sabrina
 * nom: Atlantis
 *date: 03/05/2016
 *Class:InterDAOClient
 * */

import com.atlantis.Entities.Client;

public interface InterDAOClient {
	
			//Ajout
			public Client ajoutClient(Client cli);
			
			//Suppression
			public void deleteClient(Long id);
			
			//Modification
			public void updateClient(Long id);
			
			//Avoir la liste
			public List<Client> getListClient();
			
			//Avoir un objet
			public Client getClient(Long id);
			
			//Avoir une liste 
			public List<Client> getClientParMC(String mc);

}
