package com.academy.project.restcontroller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academy.project.model.Corso;
import com.academy.project.service.CorsoService;

@RestController
@RequestMapping("/api/corsoservice")
@CrossOrigin(origins = "*")
public class CorsoRestController {

	//servizio
	
	@Autowired
	private CorsoService cs;
	
	@GetMapping("/corsi")
	public List<Corso> getCorsi(){
		return cs.findAll();
	}
	
	@GetMapping("/corsipiufrequentati")
	public List<String> getCorsiPiuFrequentati(){
		return cs.findCorsiPiuFrequentati();
	}
	
	@GetMapping("/datainizioultimocorso")
	public Date getDataInizioUltimoCorso() {
		return cs.findDataInizioUltimoCorso();
	}
	
	@GetMapping("/duratamediacorsi")
	public Double getDurataMediaCorsi() {
		return cs.durataMediaCorsi();
	}
	
	@GetMapping("/corsiconpostidisp")
	public List<Corso> getCorsiConPostiDisp(){
		return cs.findCorsiConPostiDisponibili();
	}
	
	@GetMapping("/numerocommenti")
	public Long getNumeroCommenti() {
		return cs.trovaNumeroCommenti();
	}
}

