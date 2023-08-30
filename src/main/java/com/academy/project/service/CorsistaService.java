package com.academy.project.service;

import java.util.List;
import java.util.Optional;

import com.academy.project.model.Corsista;

public interface CorsistaService {
	void saveCorsista(Corsista corsista);
	List<Corsista> findAllCorsistiWithCorsi();
	List<Corsista> findAll();
	Optional<Corsista> findById(long id);
	Long countTotalCorsisti();
	List<Corsista> findCorsistiIscritti();
}
