package com.atlantis.Metier;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.atlantis.Dao.InterDAOPersonne;
import com.atlantis.Entities.Personne;

/*Auteur: Henriette Sabrina
 * nom: Atlantis
 *date: 03/05/2016
 *Class:ImplMetierPersonne
 * */



@Transactional
public class ImplMetierPersonne implements InterMetierPersonne{
	
	@PersistenceContext
	private EntityManager em;

	   private final Logger LOG=Logger.getLogger("ImplMetierPersonne");
		
	   private InterDAOPersonne daoPersonne;
	   
		public void setDao(InterDAOPersonne daoPersonne) {
			this.daoPersonne = daoPersonne;
			LOG.info("dao injected");
		}
		
		
	//Ajout

	@Override
	public Personne ajoutPersonne(Personne p) {

		return daoPersonne.ajoutPersonne(p);
	}
	
	
	//Suppression

	@Override
	public void deletePersonne(Long id) {

		daoPersonne.deletePersonne(id);
		
	}
	
	
	//Modification

	@Override
	public void updatePersonne(Long id) {

		daoPersonne.updatePersonne(id);
		
	}
	
	
	//GetList

	@Override
	public List<Personne> getListPersonne() {
	
		return daoPersonne.getListPersonne();
	}
	
	
	//GetPersonne

	@Override
	public Personne getPersonne(Long id) {

		return daoPersonne.getPersonne(id);

	}
	
	
	//GetPersonne par mot clé

	@Override
	public List<Personne> getPersonneParMC(String mc) {

		return daoPersonne.getPersonneParMC(mc);
	}
	
	

}
