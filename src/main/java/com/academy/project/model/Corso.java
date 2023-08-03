package com.academy.project.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Corso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codCorso;

    private String nomeCorso;

    @Temporal(TemporalType.DATE)
    private Date dataInizioCorso;

    @Temporal(TemporalType.DATE)
    private Date dataFineCorso;

    private double costoCorso;

    private String commentiCorso;

    private String aulaCorso;

    
    @ManyToOne
    @JoinColumn(name = "docente_id")
    private Docente docente;

    
	public Long getCodCorso() {
		return codCorso;
	}

	public void setCodCorso(Long codCorso) {
		this.codCorso = codCorso;
	}

	public String getNomeCorso() {
		return nomeCorso;
	}

	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}

	public Date getDataInizioCorso() {
		return dataInizioCorso;
	}

	public void setDataInizioCorso(Date dataInizioCorso) {
		this.dataInizioCorso = dataInizioCorso;
	}

	public Date getDataFineCorso() {
		return dataFineCorso;
	}

	public void setDataFineCorso(Date dataFineCorso) {
		this.dataFineCorso = dataFineCorso;
	}

	public double getCostoCorso() {
		return costoCorso;
	}

	public void setCostoCorso(double costoCorso) {
		this.costoCorso = costoCorso;
	}

	public String getCommentiCorso() {
		return commentiCorso;
	}

	public void setCommentiCorso(String commentiCorso) {
		this.commentiCorso = commentiCorso;
	}

	public String getAulaCorso() {
		return aulaCorso;
	}

	public void setAulaCorso(String aulaCorso) {
		this.aulaCorso = aulaCorso;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	@Override
	public String toString() {
		return "Corso [codCorso=" + codCorso + ", nomeCorso=" + nomeCorso + ", dataInizioCorso=" + dataInizioCorso
				+ ", dataFineCorso=" + dataFineCorso + ", costoCorso=" + costoCorso + ", commentiCorso=" + commentiCorso
				+ ", aulaCorso=" + aulaCorso + ", docente=" + docente + "]";
	}

	
    
	
}
