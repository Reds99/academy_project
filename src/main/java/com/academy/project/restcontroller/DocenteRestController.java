package com.academy.project.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academy.project.model.Docente;
import com.academy.project.service.DocenteService;

@RestController
@RequestMapping("/api/docenteservice")
@CrossOrigin(origins = "*")
public class DocenteRestController {

	@Autowired
	DocenteService ds;
	
	@GetMapping("/docenteConPiuIscritti")
	public List<Docente> getDocenteConPiuIscritti() {
		return ds.findDocenteConPiuCorsi();
	}
	
}
