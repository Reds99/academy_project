package com.academy.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Amministratore {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codAdmin;

    private String nomeAdmin;

    private String cognomeAdmin;

    
	public Long getCodAdmin() {
		return codAdmin;
	}

	public void setCodAdmin(Long codAdmin) {
		this.codAdmin = codAdmin;
	}

	public String getNomeAdmin() {
		return nomeAdmin;
	}

	public void setNomeAdmin(String nomeAdmin) {
		this.nomeAdmin = nomeAdmin;
	}

	public String getCognomeAdmin() {
		return cognomeAdmin;
	}

	public void setCognomeAdmin(String cognomeAdmin) {
		this.cognomeAdmin = cognomeAdmin;
	}

	@Override
	public String toString() {
		return "Amministratore [codAdmin=" + codAdmin + ", nomeAdmin=" + nomeAdmin + ", cognomeAdmin=" + cognomeAdmin
				+ "]";
	}
    
    

}
