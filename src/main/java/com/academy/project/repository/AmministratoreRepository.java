package com.academy.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.academy.project.model.Amministratore;

@Repository("amministratoreRepository")
public interface AmministratoreRepository extends JpaRepository<Amministratore, Long>{
	@Query(value = "Select * from amministratore where username = ?1", nativeQuery = true)
	Optional<Amministratore> findByUsername(String username);
}
