package com.atlantis.atlantis.WebService;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.atlantis.atlantis.Entities.Reservation;
import com.atlantis.atlantis.Metier.InterMetierReservation;

@RestController
public class ReservationRest {
	
	@Autowired
	private InterMetierReservation metierReservation;
	
	@RequestMapping(value="/AfficherToutesLesResa", method=RequestMethod.GET)
	public List<Reservation> AfficherToutesLesResa(){
		return metierReservation.consulterToutesLesReservations();
	}
	
	@RequestMapping(value="/AjouterUneResa", method=RequestMethod.POST)
	public Object CreerUneReservation(@Valid @RequestBody Long idEmploye, Long idClient, Date dateDebut, Date dateFin, String etatReservation , BindingResult r){
		if (r.hasErrors()){
			Map<String, Object> error = new HashMap<String, Object>();
			error.put("erreur", true);
			for (FieldError f : r.getFieldErrors()) {
				error.put(f.getField(), f.getDefaultMessage());
			}
			return error;
		}
		return metierReservation.creerUneReservation(idEmploye, idClient, dateDebut, dateFin, etatReservation) ;
	}

}
