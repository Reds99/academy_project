package com.academy.project.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academy.project.model.Docente;
import com.academy.project.repository.DocenteRepository;
import com.academy.project.service.DocenteService;

@Service
public class DocenteServiceImpl implements DocenteService {

	@Autowired
	DocenteRepository dr;
	
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

}
