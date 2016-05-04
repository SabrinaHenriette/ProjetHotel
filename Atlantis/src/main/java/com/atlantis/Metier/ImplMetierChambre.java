package com.atlantis.Metier;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.atlantis.Dao.InterDAOChambre;
import com.atlantis.Dao.InterDAOPersonne;
import com.atlantis.Entities.Chambre;

/*Auteur: Henriette Sabrina
 * nom: Atlantis
 *date: 03/05/2016
 *Class:ImplMetierChambre
 * */

@Transactional
public class ImplMetierChambre implements InterMetierChambre{
	
	@PersistenceContext
	private EntityManager em;

	   private final Logger LOG=Logger.getLogger("ImplMetierChambre");
		
	   private InterDAOChambre dao;
	   
		public void setDao(InterDAOChambre dao) {
			this.dao = dao;
			LOG.info("dao injected");
		}
		
	//Ajout

	@Override
	public Chambre ajoutChambre(Chambre c) {

		return dao.ajoutChambre(c);
		
	}
	
	//Suppression

	@Override
	public void deleteChambre(Long id) {

		dao.deleteChambre(id);
		
	}
	
	
	//Modification

	@Override
	public void updateChambre(Long id) {

		dao.updateChambre(id);
		
	}
	
	
	//GetList

	@Override
	public List<Chambre> getListChambre() {

		return dao.getListChambre();
	}
	
	//GetChambre

	@Override
	public Chambre getChambre(Long id) {

		return dao.getChambre(id);
	}


	
	

}
