package com.academy.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Docente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codDocente;

    private String nomeDocente;

    private String cognomeDocente;

    private String cvDocente;
    

	public Long getCodDocente() {
		return codDocente;
	}

	public void setCodDocente(Long codDocente) {
		this.codDocente = codDocente;
	}

	public String getNomeDocente() {
		return nomeDocente;
	}

	public void setNomeDocente(String nomeDocente) {
		this.nomeDocente = nomeDocente;
	}

	public String getCognomeDocente() {
		return cognomeDocente;
	}

	public void setCognomeDocente(String cognomeDocente) {
		this.cognomeDocente = cognomeDocente;
	}

	public String getCvDocente() {
		return cvDocente;
	}

	public void setCvDocente(String cvDocente) {
		this.cvDocente = cvDocente;
	}

	@Override
	public String toString() {
		return "Docente [codDocente=" + codDocente + ", nomeDocente=" + nomeDocente + ", cognomeDocente="
				+ cognomeDocente + ", cvDocente=" + cvDocente + "]";
	}

    

	

    

}

