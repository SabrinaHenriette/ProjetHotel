package com.atlantis.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.atlantis.Entities.Client;
import com.atlantis.Entities.Employe;

/*Auteur: Henriette Sabrina
 * nom: Atlantis
 *date: 03/05/2016
 *Class:ImplDAOEmploye
 * */

public class ImplDAOEmploye implements InterDAOEmploye{
	
	@PersistenceContext
	private EntityManager em;
	
	//Ajout

	@Override
	public Employe ajoutEmploye(Employe emp) {

		em.persist(emp);
		return emp;
	}
	
	
	//Suppression

	@Override
	public void deleteEmploye(Long id) {

		Employe emp = em.find(Employe.class, id);
		em.remove(id);
		
	}
	
	
	//Modification

	@Override
	public void updateEmploye(Long id) {

		Employe emp = em.find(Employe.class, id);
		em.merge(id);
		
	}
	
	
	//GetList

	@Override
	public List<Employe> getListEmploye() {
		
		Query query = em.createQuery("from Employe emp ");
		return query.getResultList();
	}
	
	
	//GetEmploye

	@Override
	public Employe getEmploye(Long id) {
		
		Employe query = (Employe) em.createQuery("from Employe emp where emp.idEmploye ="+id).getSingleResult();
		return query;
		
	}
	
	//GetEmploye par mot clé

	@Override
	public List<Employe> getEmployeParMC(String mc) {
		
		Query query = em.createQuery("from Employe emp where emp.nomEmploye like '%"+mc+"'");
		return query.getResultList();
		
	}
	
	

}
