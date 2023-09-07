package com.academy.project.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.academy.project.model.Corso;

public interface CorsoService {
	void saveCorso(Corso corso);
	void deleteCorso(Corso corso);
	List<Corso> findAll();
	Optional<Corso> findById(long id);
	List<String> findCorsiPiuFrequentati();
	Date findDataInizioUltimoCorso();
	Double durataMediaCorsi();
	List<Corso> findCorsiConPostiDisponibili();
	Long trovaNumeroCommenti();
	List<Corso> findCorsoByCodDocente(Long codDocente);
}
