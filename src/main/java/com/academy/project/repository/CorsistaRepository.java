package com.academy.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.academy.project.model.Corsista;

public interface CorsistaRepository extends JpaRepository<Corsista, Long> {
	@Query("SELECT c FROM Corsista c JOIN c.corsi corso WHERE corso.codCorso = :codCorso")
	List<Corsista> findByCodcorso(@Param("codCorso") Long codCorso);

	@Query(value = "SELECT DISTINCT c.* FROM corsista c LEFT JOIN corsisti_corsi cc ON c.cod_corsista = cc.cod_corsista", nativeQuery = true)
	List<Corsista> findAllCorsistiWithCorsi();

	@Query(value = "SELECT COUNT(DISTINCT c.cod_corsista) FROM corsista c JOIN corsisti_corsi cc ON c.cod_corsista = cc.cod_corsista", nativeQuery = true)
	Long countTotalCorsisti();

	@Query(value = "SELECT c.* FROM corsista c "
			+ "WHERE EXISTS (SELECT 1 FROM corsisti_corsi cc WHERE c.cod_corsista = cc.cod_corsista)", nativeQuery = true)
	List<Corsista> findCorsistiIscritti();
}
