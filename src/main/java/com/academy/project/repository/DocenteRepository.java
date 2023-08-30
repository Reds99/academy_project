package com.academy.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.academy.project.model.Docente;

public interface DocenteRepository extends JpaRepository<Docente, Long> {
	@Query(value = "SELECT * FROM docente", nativeQuery = true)
	List<Docente> findAll();

	@Query(value = "SELECT * FROM docente WHERE cognome_docente = :cognomeDocente", nativeQuery = true)
	Docente findDocenteByCognome(@Param("cognomeDocente") String cognomeDocente);

	@Query(value = "SELECT d.* " + "FROM docente d " + "JOIN corso c ON d.cod_docente = c.cod_docente "
			+ "GROUP BY d.cod_docente " + "HAVING COUNT(c.cod_corso) = " + "(SELECT MAX(cnt) "
			+ " FROM (SELECT COUNT(*) as cnt FROM corso GROUP BY cod_docente) as counts)", nativeQuery = true)
	List<Docente> findDocenteConPiuCorsi();
}
