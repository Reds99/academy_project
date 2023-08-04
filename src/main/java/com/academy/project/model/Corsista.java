package com.academy.project.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Corsista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codCorsista;

    private String nomeCorsista;

    private String cognomeCorsista;

    private boolean precedentiFormativi;

	public Long getCodCorsista() {
		return codCorsista;
	}
	
	@ManyToMany(mappedBy = "corsisti")
    private List<Corso> corsi = new ArrayList<>();

	public void setCodCorsista(Long codCorsista) {
		this.codCorsista = codCorsista;
	}

	public String getNomeCorsista() {
		return nomeCorsista;
	}

	public void setNomeCorsista(String nomeCorsista) {
		this.nomeCorsista = nomeCorsista;
	}

	public String getCognomeCorsista() {
		return cognomeCorsista;
	}

	public void setCognomeCorsista(String cognomeCorsista) {
		this.cognomeCorsista = cognomeCorsista;
	}

	public boolean isPrecedentiFormativi() {
		return precedentiFormativi;
	}

	public void setPrecedentiFormativi(boolean precedentiFormativi) {
		this.precedentiFormativi = precedentiFormativi;
	}

	public List<Corso> getCorsi() {
		return corsi;
	}

	public void setCorsi(List<Corso> corsi) {
		this.corsi = corsi;
	}

	@Override
	public String toString() {
		return "Corsista [codCorsista=" + codCorsista + ", nomeCorsista=" + nomeCorsista + ", cognomeCorsista="
				+ cognomeCorsista + ", precedentiFormativi=" + precedentiFormativi + ", corsi=" + corsi + "]";
	}
    

}

