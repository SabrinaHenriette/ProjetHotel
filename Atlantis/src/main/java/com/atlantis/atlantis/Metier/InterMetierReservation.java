package com.atlantis.atlantis.Metier;

import java.util.Date;
import java.util.List;

import com.atlantis.atlantis.Entities.Chambre;
import com.atlantis.atlantis.Entities.Reservation;

/*
 * Auteur : Sylvain VROLAND
 * Date : 03/05/2016
 * interface : InterDAOReservation ;
 * package : com.atlantis.Metier ;
 * Version : 1.0 ;
 * ref-uml : / ;
 * sprint : 1 ;
 * ref-userStories : unknown ;
 * Impl�mentation li�e : ImplMetierReservation ;
 * Class concern�e : Reservation
 * */

public interface InterMetierReservation {

	// Liste des m�thodes li�es � la class Reservation :
	Reservation creerUneReservation(Long idEmploye, Long idClient, Date dateDebut,
			Date dateFin, String etatReservation);

	void ajouterChambreAUneReservation(Long idReservation, Long IdChambre);

	void modifierUneReservation(Reservation reservation);

	void supprimerUneReservation(Long idReservation);

	Reservation consulterUneReservationParIdReservation(Long idReservation);
	
	List<Chambre> consulterListeChambresOccupeesSurPlageDates(Date dateDebutD,
			Date dateFinD);

	List<Chambre> consulterDisponibiliteDesChambresPlageDates(Date dateDebutD,
			Date dateFinD); //Pr�sent uniquement dans le m�tier

	List<Reservation> consulterListeReservationParIdClient(Long idClient);

	List<Reservation> consulterListeReservationParIdEmploye(Long idEmploye);

	List<Reservation> consulterListeReservationParIdChambre(Long idChambre);

	List<Reservation> consulterToutesLesReservations();
	
	List<Chambre> ConsulterToutesLesChambres() ;

}
