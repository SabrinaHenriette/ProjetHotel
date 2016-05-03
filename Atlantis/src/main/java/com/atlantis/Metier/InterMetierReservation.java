package com.atlantis.Metier;

import java.util.Date;
import java.util.List;

import com.atlantis.Entities.Chambre;
import com.atlantis.Entities.Reservation;

/*
 * Auteur : Sylvain VROLAND
 * Date : 02/05/2016
 * interface : InterDAOReservation ;
 * package : com.atlantis.Metier ;
 * Version : 1.0 ;
 * ref-uml : / ;
 * sprint : 1 ;
 * ref-userStories : unknown ;
 * Implémentation liée : ImplMetierReservation ;
 * Class concernée : Reservation
 * */

public interface InterMetierReservation {

	// Liste des méthodes liées à la class Reservation :
	void creerUneReservation(Reservation reservation, Long idEmploye,
			Long idClient, Date dateDebut, Date dateFin, String etatReservation);

	void ajouterChambreAUneReservation(Long idReservation, Long IdChambre);

	void modifierUneReservation(Reservation reservation);

	void supprimerUneReservation(Long idReservation);

	Reservation consulterUneReservationParIdReservation(Long idReservation);

	List<Chambre> consulterDisponibiliteDesChambresPlageDates(Date dateDebutD,
			Date dateFinD);

	List<Reservation> consulterListeReservationParIdClient(Long idCLient);

	List<Reservation> consulterListeReservationParIdEmploye(Long idEmploye);

	List<Reservation> consulterListeReservationParIdChambre(Long idChambre);

	List<Reservation> consulterToutesLesReservations();

}
