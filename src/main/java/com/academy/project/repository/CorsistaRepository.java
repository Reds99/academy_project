package com.academy.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.academy.project.model.Corsista;

public interface CorsistaRepository extends JpaRepository<Corsista, Long>{
	@Query("SELECT c FROM Corsista c JOIN c.corsi corso WHERE corso.codCorso = :codCorso")
    List<Corsista> findByCodcorso(@Param("codCorso") Long codCorso);
}
