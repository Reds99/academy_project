package com.academy.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.academy.project.model.Corsista;

public interface CorsistaService {
	void saveCorsista(Corsista corsista);
	List<Corsista> findAllCorsistiWithCorsi();
	ArrayList<Corsista> findAllCorsistiWithCorsiArrayList();
	List<Corsista> findAll();
	Optional<Corsista> findById(long id);
	Long countTotalCorsisti();
	List<Corsista> findCorsistiIscritti();
	void deleteCorsista(Corsista corsista);
	void leaveCorso(Long codCorsista, Long codCorso);
}
