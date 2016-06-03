package com.atlantis.atlantis;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atlantis.Entities.Reservation;
import com.atlantis.Metier.InterMetierReservation;

@Controller
public class ControllerReservation {
	
	@Autowired
	private InterMetierReservation metierReservation ;
	
	@RequestMapping(value = "/reservation")
	public String accueilReservation(){
		return "reservation";
	}
	
	@RequestMapping(value = "/afficherToutesReservations")
	public String afficherToutesReservations(Model model) {
		model.addAttribute("listeReservation",
				metierReservation.consulterToutesLesReservations());
		return "reservation";
	}
	
	@RequestMapping(value="/detailReservation/{idReservation}")
	public String afficherDetailReservations(Model model,@PathVariable Long idReservation) {
		//à terminer !!!
		return "reservation";
	}
	
	@RequestMapping(value = "/afficherReservationParIdReservation")
	public String afficherReservationParIdReservation(Model model,
			Long idReservation) {
		List<Reservation> listeReservations = new ArrayList<Reservation>();
		listeReservations.add(metierReservation.consulterUneReservationParIdReservation(idReservation));
		model.addAttribute("listeReservation", listeReservations);
		return "reservation";
	}
	
	@RequestMapping(value = "/afficherReservationParIdClient")
	public String afficherReservationParIdClient(Model model, Long idClient) {
		model.addAttribute("listeReservation", metierReservation.consulterListeReservationParIdClient(idClient));
		return "reservation";
	}
	
	@RequestMapping(value = "/afficherReservationParIdEmploye")
	public String afficherReservationParIdEmploye(Model model, Long idEmploye) {
		model.addAttribute("listeReservation", metierReservation.consulterListeReservationParIdEmploye(idEmploye));
		return "reservation";
	}
	
	@RequestMapping(value = "/afficherReservationParIdChambre")
	public String afficherReservationParIdChambre(Model model, Long idChambre) {
		model.addAttribute("listeReservation", metierReservation.consulterListeReservationParIdChambre(idChambre));
		return "reservation";
	}

	@RequestMapping(value = "/ajouterReservation")
	public String ajouterUneReservation(/*Model model, */Long idEmploye,
			Long idClient, Date dateDebut, Date dateFin, String etatReservation) {
		metierReservation.creerUneReservation(idEmploye, idClient, dateDebut,
				dateFin, etatReservation);
		/*Long i = 0L ;
		for (Reservation r :metierReservation.consulterToutesLesReservations()) {
			if (r.getIdReservation()>i){
				i = r.getIdReservation();
			}
		}
		model.addAttribute("listeReservation", metierReservation
				.consulterUneReservationParIdReservation(i));*/
		return "redirect:/reservationenregistre";
	}
	
	@RequestMapping(value = "/reservationenregistre")
	public String redirectReservation(){
		return "reservationenregistre";
	}
	
	@RequestMapping(value = "/rechercherDisponibilite")
	public String ajouterUneReservation(Model model, Date dateDebut, Date dateFin) {
		model.addAttribute("listeChambres", metierReservation.consulterDisponibiliteDesChambresPlageDates(dateDebut, dateFin));
		return "reservation";
	}
	@RequestMapping(value = "/ajouterUneChambreAReservation")
	public String ajouterUneReservation(Long idReservation, Long IdChambre) {
		metierReservation.ajouterChambreAUneReservation(idReservation, IdChambre);
		return "reservation";
	}
	


}
