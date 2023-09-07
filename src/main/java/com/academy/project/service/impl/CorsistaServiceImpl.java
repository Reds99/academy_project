package com.academy.project.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academy.project.model.Corsista;
import com.academy.project.model.Corso;
import com.academy.project.repository.CorsistaRepository;
import com.academy.project.service.CorsistaService;

@Service
public class CorsistaServiceImpl implements CorsistaService {

	@Autowired
	CorsistaRepository cr;
	
	@Override
	public List<Corsista> findAllCorsistiWithCorsi() {
		return cr.findAllCorsistiWithCorsi();
	}

	@Override
	public void saveCorsista(Corsista corsista) {
		cr.save(corsista);
	}

	@Override
	public List<Corsista> findAll() {
		return cr.findAll();
	}

	@Override
	public Optional<Corsista> findById(long id) {
		return cr.findById(id);
	}

	@Override
	public Long countTotalCorsisti() {
		return cr.countTotalCorsisti();
	}

	@Override
	public List<Corsista> findCorsistiIscritti() {
		return cr.findCorsistiIscritti();
	}

	@Override
	public ArrayList<Corsista> findAllCorsistiWithCorsiArrayList() {
		return cr.findAllCorsistiWithCorsiArrayList();
	}

	@Override
	public void deleteCorsista(Corsista corsista) {
		List<Corso> corsi = corsista.getCorsi();
		for(Corso corso : corsi) {
			corso.getCorsisti().remove(corsista);
			corso.setNumeroStudenti(corso.getNumeroStudenti() + 1);
		}
		corsista.getCorsi().clear();
		cr.delete(corsista);
	}

}
