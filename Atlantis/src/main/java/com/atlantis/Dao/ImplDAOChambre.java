package com.atlantis.Dao;

import java.util.List;

/*Auteur: Henriette Sabrina
 * nom: Atlantis
 *date: 03/05/2016
 *Class:ImplDAOChambre
 * */




import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.atlantis.Entities.Chambre;

public class ImplDAOChambre implements InterDAOChambre{
	
	@PersistenceContext
	private EntityManager em;
	
	//Ajout

	@Override
	public Chambre ajoutChambre(Chambre c) {

		em.persist(c);
		return c;
		
	}
	
	//Suppression

	@Override
	public void deleteChambre(Long id) {

		Chambre c = em.find(Chambre.class, id);
		em.remove(c);
		
	}
	
	//Modification

	@Override
	public void updateChambre(Long id) {

		Chambre c = em.find(Chambre.class, id);
		em.merge(id);
		
	}
	
	//GetList

	@Override
	public List<Chambre> getListChambre() {

		Query query = em.createQuery("from Chambre c ");
		return query.getResultList();
		
	}
	
	//GetChambre

	@Override
	public Chambre getChambre(Long id) {
		
		Chambre query = (Chambre) em.createQuery("from Chambre c where c.idChambre ="+id).getSingleResult();
		return query;

	}


	
	

}
