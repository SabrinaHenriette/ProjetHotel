package com.atlantis.Tests;

import java.util.List;

import com.atlantis.atlantis.Dao.ImplDAOReservation;
import com.atlantis.atlantis.Dao.InterDAOReservation;
import com.atlantis.atlantis.Entities.Reservation;
import com.atlantis.atlantis.Metier.ImplMetierReservation;
import com.atlantis.atlantis.Metier.InterMetierReservation;

public class DriverTestReservation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		InterDAOReservation app = new ImplDAOReservation();
		
		List<Reservation> toutesReservations = app.consulterToutesLesReservations();
		for (Reservation r : toutesReservations) {
			System.out.println(r.getIdReservation());
		}
		
//		List<Reservation> tabrescli = app.consulterListeReservationParIdClient(1L);
//		for (Reservation r : tabrescli) {
//			System.out.println(r.getIdReservation());
//		}
		
		
		/*List<Reservation> tabresch = app.consulterListeReservationParIdChambre(101L);
		for (Reservation r : tabresch) {
			System.out.println(r.getIdReservation());*/
//			System.out.println(r.getClient().getIdPersonne());
//		}

	}

}
