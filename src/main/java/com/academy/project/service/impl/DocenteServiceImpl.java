package com.academy.project.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academy.project.model.Corso;
import com.academy.project.model.Docente;
import com.academy.project.repository.CorsoRepository;
import com.academy.project.repository.DocenteRepository;
import com.academy.project.service.DocenteService;

@Service
public class DocenteServiceImpl implements DocenteService {

	@Autowired
	DocenteRepository dr;
	
	@Autowired
	CorsoRepository cr;
	
	@Override
	public List<Docente> findAll() {
		return dr.findAll();
	}

	@Override
	public Docente findDocenteByCognome(String cognomeDocente) {
		return dr.findDocenteByCognome(cognomeDocente);
	}

	@Override
	public List<Docente> findDocenteConPiuCorsi() {
		return dr.findDocenteConPiuCorsi();
	}

	@Override
	public void addDocente(String nome, String cognome, Long anniEsperienza) {
		Docente docente = new Docente();
		docente.setNomeDocente(nome);
		docente.setCognomeDocente(cognome);
		docente.setCvDocente(anniEsperienza.toString());
		dr.save(docente);
	}

	@Override
	public void deleteDocente(Long codDocente, String cognomeDocenteSostitutivo) {
		List<Corso> corsiDocente = cr.findCorsiByCodDocente(codDocente);
		Docente docenteSostitutivo = dr.findDocenteByCognome(cognomeDocenteSostitutivo);
		for(Corso corso: corsiDocente) {
			corso.setDocente(docenteSostitutivo);
			cr.save(corso);
		}
		Docente docente = dr.findById(codDocente).get();
		dr.delete(docente);
	}

	@Override
	public List<Docente> findAllTranneDocente(Long codDocente) {
		return dr.findAllTranneCodDocente(codDocente);
	}

	@Override
	public void deleteDocenteSecco(Long codDocente) {
		Optional<Docente> docente = dr.findById(codDocente);
		dr.delete(docente.get());
	}

}
