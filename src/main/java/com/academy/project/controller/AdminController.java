package com.academy.project.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.academy.project.model.Corsista;
import com.academy.project.model.Corso;
import com.academy.project.model.Docente;
import com.academy.project.service.CorsistaCorsoService;
import com.academy.project.service.CorsistaService;
import com.academy.project.service.CorsoService;
import com.academy.project.service.DocenteService;

@Controller
public class AdminController {

	@Autowired
	CorsistaService corsistaService;

	@Autowired
	CorsoService corsoService;
	
	@Autowired
	CorsistaCorsoService corsistaCorsoService;

	@Autowired
	DocenteService ds;

	@GetMapping("/")
	public ModelAndView showLoginPage(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("loginAdmin");
		return mv;
	}

	@GetMapping("/admin/home")
	public ModelAndView showHomePage(HttpSession session, Authentication auth) {
		List<Corsista> listaCorsisti = corsistaService.findAllCorsistiWithCorsi();
		ModelAndView mv = new ModelAndView();
		session.setAttribute("username", auth.getName());
		mv.addObject("_username", auth.getName());
		mv.setViewName("adminHome");
		mv.addObject("listaCorsisti", listaCorsisti);
		return mv;
	}
	
	@GetMapping("/admin/logout")
	public ModelAndView logout(HttpSession session) {
	ModelAndView mv = new ModelAndView();
	mv.setViewName("loginAdmin");
	session.invalidate();
	return mv;
	}

	@GetMapping("/admin/corsi")
	public ModelAndView showCorsiPage(HttpSession session) {
		List<Corso> listaCorsi = corsoService.findAll();
		ModelAndView mv = new ModelAndView();
		String username= (String)session.getAttribute("username");
		mv.addObject("dataAttuale", new java.util.Date());
		mv.addObject("_username", username);
		mv.setViewName("corsi");
		mv.addObject("listaCorsi", listaCorsi);
		return mv;
	}

	@GetMapping("/admin/insertCorsista")
	public ModelAndView showInsertCorsistaPage(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		String username= (String)session.getAttribute("username");
		mv.addObject("_username", username);
		mv.setViewName("insertCorsista");
		return mv;
	}

	@GetMapping("/admin/insertCorsi")
	public ModelAndView showInsertCorsoPage(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		List<Docente> listaDocenti = ds.findAll();
		String username= (String)session.getAttribute("username");
		mv.addObject("_username", username);
		mv.addObject("listaDocenti", listaDocenti);
		mv.setViewName("insertCorso");
		return mv;
	}

	@PostMapping("/admin/addCorsista")
	public ModelAndView addCorsista(@RequestParam("nome") String nome, @RequestParam("cognome") String cognome,
			@RequestParam("precedentiFormativi") Boolean precedentiFormativi, HttpSession session) {

		Corsista corsista = new Corsista();
		corsista.setNomeCorsista(nome);
		corsista.setCognomeCorsista(cognome);
		corsista.setPrecedentiFormativi(precedentiFormativi);

		corsistaService.saveCorsista(corsista);

		ModelAndView mv = new ModelAndView();
		List<Corsista> listaCorsisti = corsistaService.findAllCorsistiWithCorsi();
		String username= (String)session.getAttribute("username");
		mv.addObject("_username", username);
		mv.setViewName("adminHome");
		mv.addObject("listaCorsisti", listaCorsisti);
		return mv;
	}

	@PostMapping("/admin/addCorso")
	public ModelAndView addCorso(@RequestParam("nomeCorso") String nomeCorso,
			@RequestParam("dataInizio") String dataInizio, @RequestParam("dataFine") String dataFine,
			@RequestParam("commenti") String commenti, @RequestParam("aulaCorso") String aulaCorso,
			@RequestParam("cognomeDocente") String cognomeDocente,
			@RequestParam("costo") double costo, HttpSession session) {

		Corso corso = new Corso();
		
		Docente docente = ds.findDocenteByCognome(cognomeDocente);

		DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		String dataInizioString = LocalDate.parse(dataInizio, inputFormatter).format(outputFormatter);
		String dataFineString = LocalDate.parse(dataFine, inputFormatter).format(outputFormatter);

		Date dataInizioDateFormatted = Date.valueOf(dataInizioString);
		Date dataFineDateFormatted = Date.valueOf(dataFineString);
	    
	    corso.setNomeCorso(nomeCorso);
	    corso.setDataInizioCorso(dataInizioDateFormatted);
	    corso.setDataFineCorso(dataFineDateFormatted);
	    corso.setAulaCorso(aulaCorso);
	    corso.setCommentiCorso(commenti);
	    corso.setCostoCorso(costo);
	    corso.setDocente(docente);

		corsoService.saveCorso(corso);

		ModelAndView mv = new ModelAndView();
		String username= (String)session.getAttribute("username");
		mv.addObject("_username", username);
		List<Corso> listaCorsi = corsoService.findAll();
		mv.setViewName("corsi");
		mv.addObject("listaCorsi", listaCorsi);
		return mv;
	}
	
	@GetMapping("/admin/iscrivi/{codCorso}")
	public ModelAndView iscriviCorsista(@PathVariable long codCorso, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		String username= (String)session.getAttribute("username");
		mv.addObject("_username", username);
		Optional<Corso> optionalCorso = corsoService.findById(codCorso);
		Corso corso = optionalCorso.orElseThrow(() -> new NoSuchElementException("Il Corso non è presente"));
		List<Corsista> listaCorsisti = corsistaService.findAll();
		mv.addObject("corso", corso);
		mv.addObject("listaCorsisti", listaCorsisti);
		mv.setViewName("iscrizioneCorso");
		return mv;
	}
	
	@GetMapping("/admin/elimina/{codCorso}")
	public ModelAndView eliminaCorso(@PathVariable long codCorso, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		String username= (String)session.getAttribute("username");
		List<Corsista> listaCorsisti = corsistaService.findAll();
		
		Corso corso = corsoService.findById(codCorso).get();
		corsoService.deleteCorso(corso);
		
		List<Corso> listaCorsi = corsoService.findAll();
		
		mv.addObject("listaCorsisti", listaCorsisti);
		mv.addObject("listaCorsi", listaCorsi);
		mv.addObject("_username", username);
		mv.setViewName("corsi");
		return mv;
	}
	
	@PostMapping("/admin/iscrivi")
	public ModelAndView iscrivi(@RequestParam("cognomeCorsista") long codCorsista,
			@RequestParam("codCorso") long codCorso, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		String username= (String)session.getAttribute("username");
		mv.addObject("_username", username);
		corsistaCorsoService.aggiungiCorsistaAlCorso(codCorsista, codCorso);
		List<Corsista> listaCorsisti = corsistaService.findAllCorsistiWithCorsi();
		mv.addObject("listaCorsisti", listaCorsisti);
		mv.setViewName("adminHome");
		return mv;
	}
	
	@GetMapping("/admin/statistiche")
	public ModelAndView showStatistiche(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		String username= (String)session.getAttribute("username");
		mv.addObject("_username", username);
		
		Long corsistiTotali = corsistaService.countTotalCorsisti();
		List<String> corsiPiuFrequentati = corsoService.findCorsiPiuFrequentati();
		java.util.Date dataInizioUltimoCorso = corsoService.findDataInizioUltimoCorso();
		Double durataMediaCorsi = corsoService.durataMediaCorsi();
		List<Docente> docentiConPiuCorsi = ds.findDocenteConPiuCorsi();
		List<Corso> corsiConPostiDisponibili = corsoService.findCorsiConPostiDisponibili();
		List<Corsista> listaCorsisti = corsistaService.findCorsistiIscritti();
		Long numeroCommenti = corsoService.trovaNumeroCommenti();
		
		mv.addObject("numeroCommenti", numeroCommenti);
		mv.addObject("listaCorsisti", listaCorsisti);
		mv.addObject("corsiConPostiDisponibili", corsiConPostiDisponibili);
		mv.addObject("docentiConPiuCorsi", docentiConPiuCorsi);
		mv.addObject("durataMediaCorsi", durataMediaCorsi);
		mv.addObject("dataInizioUltimoCorso", dataInizioUltimoCorso);
		mv.addObject("corsistiTotali", corsistiTotali);
		mv.addObject("corsiPiuFrequentati", corsiPiuFrequentati);
		mv.setViewName("statistiche");
		return mv;
	}
	
	@GetMapping("/admin/dettagliCorsista/{codCorsista}")
	public ModelAndView dettagliCorsista(@PathVariable long codCorsista, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		String username= (String)session.getAttribute("username");
		Corsista corsista = corsistaService.findById(codCorsista).get();
		
		mv.addObject("corsista", corsista);
		mv.addObject("_username", username);
		mv.setViewName("dettaglioCorsista");
		return mv;
	}
	
	@GetMapping("/admin/espelli/{codCorsista}")
	public ModelAndView espelliCorsista(@PathVariable long codCorsista, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		List<Corsista> listaCorsisti = corsistaService.findAllCorsistiWithCorsi();
		String username = (String) session.getAttribute("username");
		mv.addObject("_username", username);
		mv.addObject("listaCorsisti", listaCorsisti);
		mv.setViewName("adminHome");
		return mv;
	}
}
