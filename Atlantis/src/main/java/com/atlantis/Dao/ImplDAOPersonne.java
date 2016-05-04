package com.atlantis.Dao;

import java.util.List;

/*Auteur: Henriette Sabrina
 * nom: Atlantis
 *date: 03/05/2016
 *Class:ImplDAOPersonne
 * */

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.atlantis.Entities.Personne;

public class ImplDAOPersonne implements InterDAOPersonne{
	@PersistenceContext
	private EntityManager em;
	
	//Ajout

	@Override
	public Personne ajoutPersonne(Personne p) {
		
		em.persist(p);
		return p;
		
	}
	
	//Suppression

	@Override
	public void deletePersonne(Long id) {
		
		Personne p = em.find(Personne.class, id);
		em.remove(p);

		
	}
	
	//Modification

	@Override
	public void updatePersonne(Long id) {

		Personne p = em.find(Personne.class, id);
		em.merge(p);
		
	}
	
	//GetList

	@Override
	public List<Personne> getListPersonne() {
		
		Query query = em.createQuery("from Personne p ");
		return query.getResultList();
		
	}
	
	//GetPersonne

	@Override
	public Personne getPersonne(Long id) {
		
		Personne query = (Personne) em.createQuery("from Personne p where p.idPersonne ="+id).getSingleResult();
		return query;
	}
	
	//GetPersonne par mot clé

	@Override
	public List<Personne> getPersonneParMC(String mc) {
		
		Query query = em.createQuery("from Personne p where p.nomPersonne like '%"+mc+"'");
		return query.getResultList();
		
	}
	
	

}
