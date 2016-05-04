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
 * Date : 03/05/2016
 * interface : ImplDAOReservation ;
 * package : com.atlantis.Dao ;
 * Version : 1.0 ;
 * ref-uml : / ;
 * sprint : 1 ;
 * ref-userStories : unknown ;
 * Imterface implémentée : InterDAOReservation ;
 * Class concernée : Reservation
 * */

public class ImplDAOReservation implements InterDAOReservation {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Reservation creerUneReservation(Long idEmploye, Long idClient,
			Date dateDebut, Date dateFin, String etatReservation) {
		// TODO Auto-generated method stub
		Reservation reservation = new Reservation();
		Employe employe = em.find(Employe.class, idEmploye);
		Client client = em.find(Client.class, idClient);
		reservation.setEmploye(employe);
		reservation.setClient(client);
		reservation.setDateDebut(dateDebut);
		reservation.setDateFin(dateFin);
		reservation.setEtatReservation(etatReservation);
		em.persist(reservation);
		return reservation;

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
	public List<Chambre> consulterListeChambresOccupeesSurPlageDates(
			Date dateDebutD, Date dateFinD) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("Select c from Chambre c, "
				+ " Reservation r, " 
				+ " Assos_Reservation_Chambre arc "
				+ " where r.idReservation = arc.idReservation "
				+ " and arc.idChambre = c.idChambre " 
				+ " and ( " + dateDebutD + " > r.dateDebut and " + dateDebutD + " < r.dateFin) "
				+ " || ( " + dateFinD + " > r.dateDebut and " + dateFinD + " < r.dateFin)");
		return query.getResultList();
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
		Query query = em
				.createQuery("from Reservation r, Assos_Reservation_Chambre arc "
						+ "where r.idReservation = arc.idReservation and arc.idChambre = "
						+ idChambre);
		return query.getResultList();
	}

	@Override
	public List<Reservation> consulterToutesLesReservations() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("from Reservation");
		return query.getResultList();
	}

	@Override
	public List<Chambre> ConsulterToutesLesChambres() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("from Chambre");
		return query.getResultList();
	}

}
