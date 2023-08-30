package com.academy.project.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.academy.project.model.Corso;

public interface CorsoRepository extends JpaRepository<Corso, Long> {
	@Query(value = "SELECT c FROM Corso c JOIN c.corsisti corsista GROUP BY c.codCorso ORDER BY COUNT(corsista) DESC")
	Corso findCorsoPiuFrequentato();

	@Query(value = "SELECT c.nomeCorso " + "FROM Corso c " + "JOIN c.corsisti cc " + "GROUP BY c.nomeCorso "
			+ "ORDER BY COUNT(*) DESC")
	List<String> findCorsiPiuFrequentati();

	@Query(value = "SELECT DISTINCT c.data_inizio_corso " + "FROM corso c "
			+ "WHERE c.data_inizio_corso = (SELECT MAX(data_inizio_corso) " + "FROM corso)", nativeQuery = true)
	Date findDataInizioUltimoCorso();

	@Query(value = "SELECT AVG(DATEDIFF(data_fine_corso, data_inizio_corso)) " + "FROM corso", nativeQuery = true)
	Double durataMediaCorsi();

	@Query(value = "SELECT * " + "FROM corso " + "WHERE numero_studenti > 0", nativeQuery = true)
	List<Corso> findCorsiConPostiDisponibili();
	
	@Query(value = "SELECT COUNT(*) FROM corso WHERE commenti_corso IS NOT NULL", nativeQuery = true)
	Long trovaNumeroCommenti();
}
