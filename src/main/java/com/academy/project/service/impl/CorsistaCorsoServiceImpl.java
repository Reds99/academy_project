package com.academy.project.service.impl;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academy.project.exception.CorsistaIscrittoException;
import com.academy.project.model.Corsista;
import com.academy.project.model.Corso;
import com.academy.project.repository.CorsistaRepository;
import com.academy.project.repository.CorsoRepository;
import com.academy.project.service.CorsistaCorsoService;

@Service
public class CorsistaCorsoServiceImpl implements CorsistaCorsoService {

	@Autowired
	CorsoRepository corsoRepository;

	@Autowired
	CorsistaRepository corsistaRepository;

	@Override
	public void aggiungiCorsistaAlCorso(long codCorsista, long codCorso) {
		Optional<Corso> optionalCorso = corsoRepository.findById(codCorso);
		Optional<Corsista> optionalCorsista = corsistaRepository.findById(codCorsista);
		Corso corso = optionalCorso.orElseThrow(() -> new NoSuchElementException("Il Corso non è presente"));
		Corsista corsista = optionalCorsista
				.orElseThrow(() -> new NoSuchElementException("Il Corsista non è presente"));
		
		if (corsista.getCorsi().contains(corso)) {
	        throw new CorsistaIscrittoException("Il corsista è già iscritto a questo corso.");
	    }
		
		corso.setNumeroStudenti(corso.getNumeroStudenti() - 1);
		corsista.setPrecedentiFormativi(true);
		
		corsista.getCorsi().add(corso);
		corso.getCorsisti().add(corsista);

		corsistaRepository.save(corsista);
		corsoRepository.save(corso);
	}

}
