package com.academy.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.academy.project.model.Corso;

public interface CorsoRepository extends JpaRepository<Corso, Long>{
	@Query(value = "SELECT c FROM Corso c JOIN c.corsisti corsista GROUP BY c.codCorso ORDER BY COUNT(corsista) DESC")
    Corso findCorsoPiuFrequentato();
}
