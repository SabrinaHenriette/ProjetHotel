package com.atlantis.Dao;

import java.util.Date;
import java.util.List;

import com.atlantis.Entities.Chambre;
import com.atlantis.Entities.Reservation;

/*
 * Auteur : Sylvain VROLAND
 * Date : 03/05/2016
 * interface : InterDAOReservation ;
 * package : com.atlantis.Dao ;
 * Version : 1.0 ;
 * ref-uml : / ;
 * sprint : 1 ;
 * ref-userStories : unknown ;
 * Implémentation liée : ImplDAOReservation ;
 * Class concernée : Reservation
 * */

public interface InterDAOReservation {

	// Liste des méthodes liées à la class Reservation :
	Reservation creerUneReservation(Long idEmploye, Long idClient, Date dateDebut,
			Date dateFin, String etatReservation);

	void ajouterChambreAUneReservation(Long idReservation, Long IdChambre);

	void modifierUneReservation(Reservation reservation);

	void supprimerUneReservation(Long idReservation);

	Reservation consulterUneReservationParIdReservation(Long idReservation);

	List<Chambre> consulterListeChambresOccupeesSurPlageDates(Date dateDebutD,
			Date dateFinD);

	List<Reservation> consulterListeReservationParIdClient(Long idCLient);

	List<Reservation> consulterListeReservationParIdEmploye(Long idEmploye);

	List<Reservation> consulterListeReservationParIdChambre(Long idChambre);

	List<Reservation> consulterToutesLesReservations();
	
	List<Chambre> ConsulterToutesLesChambres();

}
