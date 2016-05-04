package com.atlantis.Metier;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.atlantis.Dao.InterDAOClient;
import com.atlantis.Entities.Client;

/*Auteur: Henriette Sabrina
 * nom: Atlantis
 *date: 03/05/2016
 *Class:ImplMetierClient
 * */

@Transactional
public class ImplMetierClient implements InterMetierClient{
	
	@PersistenceContext
	private EntityManager em;

	   private final Logger LOG=Logger.getLogger("ImplMetierClient");
		
	   private InterDAOClient dao;
	   
		public void setDao(InterDAOClient dao) {
			this.dao = dao;
			LOG.info("dao injected");
		}
		
		
	//Ajout

	@Override
	public Client ajoutClient(Client cli) {

		return dao.ajoutClient(cli);
		
	}
	
	
	//Suppression

	@Override
	public void deleteClient(Long id) {

		dao.deleteClient(id);
		
	}
	
	
	//Modification

	@Override
	public void updateClient(Long id) {

		dao.updateClient(id);
		
	}
	
	
	//GetList

	@Override
	public List<Client> getListClient() {

		return dao.getListClient();
	}
	
	
	//GetClient

	@Override
	public Client getClient(Long id) {

		return dao.getClient(id);
	}
	
	
	//GetClient par mot clé

	@Override
	public List<Client> getClientParMC(String mc) {
		
		return dao.getClientParMC(mc);
	}
	
	

}
