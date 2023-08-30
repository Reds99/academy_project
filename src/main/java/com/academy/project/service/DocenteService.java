package com.academy.project.service;

import java.util.List;

import com.academy.project.model.Docente;

public interface DocenteService {
	List<Docente> findAll();
	Docente findDocenteByCognome(String cognomeDocente);
	List<Docente> findDocenteConPiuCorsi();
}
