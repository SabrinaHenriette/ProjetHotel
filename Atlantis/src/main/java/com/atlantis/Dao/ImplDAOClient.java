package com.atlantis.Dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.atlantis.Entities.Client;

/*Auteur: Henriette Sabrina
 * nom: Atlantis
 *date: 03/05/2016
 *Class:ImplDAOClient
 * */


public class ImplDAOClient implements InterDAOClient{
	
	@PersistenceContext
	private EntityManager em;
	
	
	//Ajout

	@Override
	public Client ajoutClient(Client cli) {
		
		em.persist(cli);
		return cli;
	}
	
	
	//Delete

	@Override
	public void deleteClient(Long id) {

		Client cli = em.find(Client.class, id);
		em.remove(id);
		
	}
	
	
	//Modification

	@Override
	public void updateClient(Long id) {

		Client cli = em.find(Client.class, id);
		em.merge(id);
		
	}
	
	
	//GetList

	@Override
	public List<Client> getListClient() {
		
		Query query = em.createQuery("from Client cli ");
		return query.getResultList();
	}
	
	
	//GetClient

	@Override
	public Client getClient(Long id) {
		
		Client query = (Client) em.createQuery("from Client cli where cli.idClient ="+id).getSingleResult();
		return query;


	}
	
	//GetClien par mot clé

	@Override
	public List<Client> getClientParMC(String mc) {

		Query query = em.createQuery("from Client cli where cli.nomClient like '%"+mc+"'");
		return query.getResultList();
	}
	
	

}
