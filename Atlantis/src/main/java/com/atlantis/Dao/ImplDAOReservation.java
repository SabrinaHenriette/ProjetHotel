package com.atlantis.Dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.atlantis.Entities.Chambre;
import com.atlantis.Entities.Client;
import com.atlantis.Entities.Employe;
import com.atlantis.Entities.Reservation;

/*
 * Auteur : Sylvain VROLAND
 * Date : 02/05/2016
 * interface : ImplDAOReservation ;
 * package : com.atlantis.Dao ;
 * Version : 1.0 ;
 * ref-uml : / ;
 * sprint : 1 ;
 * ref-userStories : unknown ;
 * Imterface impl�ment�e : InterDAOReservation ;
 * Class concern�e : Reservation
 * */

public class ImplDAOReservation implements InterDAOReservation {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void creerUneReservation(Reservation reservation, Long idEmploye,
			Long idClient, Date dateDebut, Date dateFin, String etatReservation) {
		// TODO Auto-generated method stub
		Employe employe = em.find(Employe.class, idEmploye);
		Client client = em.find(Client.class, idClient);
		reservation.setEmploye(employe);
		reservation.setClient(client);
		reservation.setDateDebut(dateDebut);
		reservation.setDateFin(dateFin);
		reservation.setEtatReservation(etatReservation);
		em.persist(reservation);

	}

	@Override
	public void ajouterChambreAUneReservation(Long idReservation, Long IdChambre) {
		// TODO Auto-generated method stub
		Chambre chambre = em.find(Chambre.class, IdChambre);
		Reservation reservation = em.find(Reservation.class, idReservation);
		reservation.getListeChambreReserve().add(chambre);
		em.merge(chambre);

	}

	@Override
	public void modifierUneReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		em.merge(reservation);

	}

	@Override
	public void supprimerUneReservation(Long idReservation) {
		// TODO Auto-generated method stub
		Reservation reservation = em.find(Reservation.class, idReservation);
		em.remove(reservation);

	}

	@Override
	public Reservation consulterUneReservationParIdReservation(
			Long idReservation) {
		// TODO Auto-generated method stub
		Reservation reservation = em.find(Reservation.class, idReservation);
		return reservation;
	}

	@Override
	public List<Chambre> consulterDisponibiliteDesChambresPlageDates(
			Date dateDebutD, Date dateFinD) {
		// TODO Auto-generated method stub
//		M�thode 1 par inner join :
/*		Query query = em.createQuery(" from Chambre c, "
				+ " inner join Assos_Reservation_Chambre arc "
				+ " and arc.idChambre = c.idChambre"
				+ " inner join Reservation r, "
				+ " on r.idReservation = arc.idReservation "
				+ " where r.dateFin < " + dateDebutD + " and r.dateDebut > " + dateFinD 
				+ " union"
				+ " from Chambre c "
				+ " where c.idChambre not in "
				+ " ( select arc.idChambre from Assos_Reservation_Chambre arc");
		return null;*/
		
//		M�thode 2 qu'avec des Select :
		Query query = em.createQuery("Select c from Chambre c, "
				+ " Reservation r, "
				+ " Assos_Reservation_Chambre arc "
				+ " where r.idReservation = arc.idReservation "
				+ " and arc.idChambre = c.idChambre "
				+ " and r.dateFin < " + dateDebutD + " and r.dateDebut > " + dateFinD 
				+ " union"
				+ " select c from Chambre c "
				+ " where c.idChambre not in "
				+ " ( select arc.idChambre from Assos_Reservation_Chambre arc");
		return null;
	}

	@Override
	public List<Reservation> consulterListeReservationParIdClient(Long idCLient) {
		// TODO Auto-generated method stub
		Client client = em.find(Client.class, idCLient);
		Query query = em.createQuery("from Reservation r where r.client = "
				+ client);
		return query.getResultList();
	}

	@Override
	public List<Reservation> consulterListeReservationParIdEmploye(
			Long idEmploye) {
		// TODO Auto-generated method stub
		Employe employe = em.find(Employe.class, idEmploye);
		Query query = em.createQuery("from Reservation r where r.employe = "
				+ employe);
		return query.getResultList();
	}

	@Override
	public List<Reservation> consulterListeReservationParIdChambre(
			Long idChambre) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("from Reservation r, Assos_Reservation_Chambre arc "
				+ "where r.idReservation = arc.idReservation and arc.idChambre = " + idChambre);
		return query.getResultList();
	}

	@Override
	public List<Reservation> consulterToutesLesReservations() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("from Reservation");
		return query.getResultList();
	}

}
