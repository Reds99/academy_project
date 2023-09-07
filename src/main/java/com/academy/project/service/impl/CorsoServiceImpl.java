package com.academy.project.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academy.project.model.Corso;
import com.academy.project.repository.CorsoRepository;
import com.academy.project.service.CorsoService;

@Service
public class CorsoServiceImpl implements CorsoService{

	@Autowired
	CorsoRepository cr;
	
	@Override
	public void saveCorso(Corso corso) {
		cr.save(corso);
	}

	@Override
	public List<Corso> findAll() {
		return cr.findAll();
	}

	@Override
	public Optional<Corso> findById(long id) {
		return cr.findById(id);
	}

	@Override
	public List<String> findCorsiPiuFrequentati() {
		return cr.findCorsiPiuFrequentati();
	}

	@Override
	public Date findDataInizioUltimoCorso() {
		return cr.findDataInizioUltimoCorso();
	}

	@Override
	public Double durataMediaCorsi() {
		return cr.durataMediaCorsi();
	}

	@Override
	public List<Corso> findCorsiConPostiDisponibili() {
		return cr.findCorsiConPostiDisponibili();
	}

	@Override
	public void deleteCorso(Corso corso) {
		corso.getCorsisti().clear();
		cr.delete(corso);
	}

	@Override
	public Long trovaNumeroCommenti() {
		return cr.trovaNumeroCommenti();
	}

	@Override
	public List<Corso> findCorsoByCodDocente(Long codDocente) {
		return cr.findCorsiByCodDocente(codDocente);
	}
}
