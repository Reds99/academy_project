package com.academy.project.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academy.project.model.Corsista;
import com.academy.project.service.CorsistaService;

@RestController
@RequestMapping("/api/corsistaservice")
@CrossOrigin(origins = "*")
public class CorsistaRestController {

	//servizio
	
	@Autowired
	private CorsistaService cs;
	
	@GetMapping("/corsisti")
	public List<Corsista> getCorsisti(){
		return cs.findAllCorsistiWithCorsi();
	}
	
	@GetMapping("/corsistitotali")
	public Long getCorsistiTotali(){
		return cs.countTotalCorsisti();
	}
	
	@GetMapping("/corsistiIscritti")
	public List<Corsista> getCorsistiIscritti() {
		return cs.findCorsistiIscritti();
	}
	
	@PostMapping("/create")
	public void createCorsista(Corsista corsista) {
		cs.saveCorsista(corsista);
	}
	
}
