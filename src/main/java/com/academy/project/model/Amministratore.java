package com.academy.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Amministratore {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codAdmin;
	
	@Column(unique = true)
	private String username;
	
	private String password;
	
	private String role = "ADMIN";

    private String nomeAdmin;

    private String cognomeAdmin;
    
    boolean enabled = true;

	public Long getCodAdmin() {
		return codAdmin;
	}

	public void setCodAdmin(Long codAdmin) {
		this.codAdmin = codAdmin;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "Amministratore [codAdmin=" + codAdmin + ", username=" + username + ", password=" + password + ", role="
				+ role + ", nomeAdmin=" + nomeAdmin + ", cognomeAdmin=" + cognomeAdmin + ", enabled=" + enabled + "]";
	}

	
    
	
    
    

}
