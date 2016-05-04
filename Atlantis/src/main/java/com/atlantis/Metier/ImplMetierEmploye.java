package com.atlantis.Metier;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.atlantis.Dao.InterDAOEmploye;
import com.atlantis.Entities.Employe;

/*Auteur: Henriette Sabrina
 * nom: Atlantis
 *date: 03/05/2016
 *Class:ImplMetierEmmploye
 * */

@Transactional
public class ImplMetierEmploye implements InterMetierEmploye{
	
	
		@PersistenceContext
		private EntityManager em;

		   private final Logger LOG=Logger.getLogger("ImplMetierEmploye");
			
		   private InterDAOEmploye dao;
		   
			public void setDao(InterDAOEmploye dao) {
				this.dao = dao;
				LOG.info("dao injected");
			}
			
			
	//Ajout

	@Override
	public Employe ajoutEmploye(Employe emp) {

		return dao.ajoutEmploye(emp);

	}
	
	
	//Suppression

	@Override
	public void deleteEmploye(Long id) {

		dao.deleteEmploye(id);
		
	}
	
	
	//Modification

	@Override
	public void updateEmploye(Long id) {

		dao.updateEmploye(id);
		
	}
	
	
	//GetList

	@Override
	public List<Employe> getListEmploye() {

		return dao.getListEmploye();
	}
	
	
	//GetEmploye

	@Override
	public Employe getEmploye(Long id) {

		return dao.getEmploye(id);
	}
	
	
	//GetEmploye par mot clé

	@Override
	public List<Employe> getEmployeParMC(String mc) {
		
		return dao.getEmployeParMC(mc);
	}
	
	

}
