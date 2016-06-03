package com.atlantis.Metier;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.type.DbTimestampType;
import org.springframework.transaction.annotation.Transactional;

import com.atlantis.Dao.InterDAOReservation;
import com.atlantis.Entities.Chambre;
import com.atlantis.Entities.Reservation;

/*
 * Auteur : Sylvain VROLAND 
 * Date : 03/05/2016
 * interface : ImplDAOReservation ;
 * package : com.atlantis.Metier ;
 * Version : 1.0 ;
 * ref-uml : / ;
 * sprint : 1 ;
 * ref-userStories : unknown ;
 * Imterface implémentée : InterMetierReservation ;
 * Class concernée : Reservation
 * */

@Transactional
public class ImplMetierReservation implements InterMetierReservation {

	private final Logger Log = Logger.getLogger("Debut du test Reservation");

	private InterDAOReservation dao;

	public void setDao(InterDAOReservation dao) {
		this.dao = dao;
		Log.info("dao metier Reservation injectée");
	}

	@Override
	public Reservation creerUneReservation(Long idEmploye, Long idClient,
			Date dateDebut, Date dateFin, String etatReservation) {
		// TODO Auto-generated method stub
		return dao.creerUneReservation(idEmploye, idClient, dateDebut, dateFin,
				etatReservation);

	}

	@Override
	public void ajouterChambreAUneReservation(Long idReservation, Long IdChambre) {
		// TODO Auto-generated method stub
		dao.ajouterChambreAUneReservation(idReservation, IdChambre);

	}

	@Override
	public void modifierUneReservation(Reservation reservation) {
		// TODO Auto-generated method stub
		dao.modifierUneReservation(reservation);

	}

	@Override
	public void supprimerUneReservation(Long idReservation) {
		// TODO Auto-generated method stub
		dao.supprimerUneReservation(idReservation);

	}

	@Override
	public Reservation consulterUneReservationParIdReservation(
			Long idReservation) {
		// TODO Auto-generated method stub
		return dao.consulterUneReservationParIdReservation(idReservation);
	}

	@Override
	public List<Chambre> consulterListeChambresOccupeesSurPlageDates(
			Date dateDebutD, Date dateFinD) {
		// TODO Auto-generated method stub
		return dao.consulterListeChambresOccupeesSurPlageDates(dateDebutD, dateFinD);
	}

	@Override
	public List<Chambre> consulterDisponibiliteDesChambresPlageDates(
			Date dateDebutD, Date dateFinD) {
		// TODO Auto-generated method stub
		/*List<Chambre> listeDeChambresDisponibles = dao.ConsulterToutesLesChambres();
		List<Chambre> listeChambresOccupees = dao.consulterListeChambresOccupeesSurPlageDates(dateDebutD, dateFinD);
		for (Chambre cd: listeDeChambresDisponibles) {
			for (Chambre co : listeChambresOccupees) {
				if (cd.getIdChambre() == co.getIdChambre()){
					listeDeChambresDisponibles.remove(cd);
				}
			}
		}*/
		
		List<Chambre> listeDeChambresDisponibles = new ArrayList<Chambre>();
		Long dDD = dateDebutD.getTime();
		Long dFD = dateFinD.getTime();
		for (Chambre c : dao.ConsulterToutesLesChambres()) {
			boolean b = true;
			for (Reservation r : dao.consulterListeReservationParIdChambre(c
					.getIdChambre())) {
				Long dDT = r.getDateDebut().getTime();
				Long dFN = r.getDateFin().getTime();
				if    ((dDD > dDT && dDD < dFN)  //dateDebutD dans une réservation
					|| (dFD > dDT && dFD < dFN)  //dateFinD dans une réservation
					|| (dDD < dDT && dFD > dFN)) //Réservation inclue entre dateDebutD et dateFinD
				{
					b = false;
				}
			}
			if (b) {
				listeDeChambresDisponibles.add(c);
			}
		}
		return listeDeChambresDisponibles;
	}

	@Override
	public List<Reservation> consulterListeReservationParIdClient(Long idClient) {
		// TODO Auto-generated method stub
		return dao.consulterListeReservationParIdClient(idClient);
	}

	@Override
	public List<Reservation> consulterListeReservationParIdEmploye(
			Long idEmploye) {
		// TODO Auto-generated method stub
		return dao.consulterListeReservationParIdEmploye(idEmploye);
	}

	@Override
	public List<Reservation> consulterListeReservationParIdChambre(
			Long idChambre) {
		// TODO Auto-generated method stub
		return dao.consulterListeReservationParIdChambre(idChambre);
	}

	@Override
	public List<Reservation> consulterToutesLesReservations() {
		// TODO Auto-generated method stub
		return dao.consulterToutesLesReservations();
	}

	@Override
	public List<Chambre> ConsulterToutesLesChambres() {
		// TODO Auto-generated method stub
		return dao.ConsulterToutesLesChambres();
	}

}
