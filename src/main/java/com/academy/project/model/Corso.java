package com.academy.project.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Corso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codCorso;

    private String nomeCorso;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataInizioCorso;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataFineCorso;

    private double costoCorso;

    private String commentiCorso;

    private String aulaCorso;
    
    private int numeroStudenti = 15;
    
    @ManyToOne
    @JoinColumn(name = "cod_docente")
    private Docente docente;
    
    @ManyToMany
    @JoinTable(
        name = "corsisti_corsi",
        joinColumns = @JoinColumn(name = "cod_corso"),
        inverseJoinColumns = @JoinColumn(name = "cod_corsista")
    )
    private List<Corsista> corsisti = new ArrayList<>();


    
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

	public int getNumeroStudenti() {
		return numeroStudenti;
	}

	public void setNumeroStudenti(int numeroStudenti) {
		this.numeroStudenti = numeroStudenti;
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

	public List<Corsista> getCorsisti() {
		return corsisti;
	}

	public void setCorsisti(List<Corsista> corsisti) {
		this.corsisti = corsisti;
	}

	@Override
	public String toString() {
		return "Corso [codCorso=" + codCorso + ", nomeCorso=" + nomeCorso + ", dataInizioCorso=" + dataInizioCorso
				+ ", dataFineCorso=" + dataFineCorso + ", costoCorso=" + costoCorso + ", commentiCorso=" + commentiCorso
				+ ", aulaCorso=" + aulaCorso + ", docente=" + docente + ", corsisti=" + corsisti + "]";
	}

	

	
    
	
}
