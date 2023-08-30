package com.academy.project.security;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.academy.project.model.Amministratore;
import com.academy.project.repository.AmministratoreRepository;

@Component
public class AmministratoreDetailsService implements UserDetailsService {

	private AmministratoreRepository amministratoreRepository;

	private Map<String, Integer> failedAttempts = new HashMap<>();

	public AmministratoreDetailsService(AmministratoreRepository amministratoreRepository) {
		this.amministratoreRepository = amministratoreRepository;
	}

	public void incrementFailedAttempts(String username) {
		failedAttempts.put(username, failedAttempts.getOrDefault(username, 0) + 1);
	}

	public int getFailedAttempts(String username) {
		return failedAttempts.getOrDefault(username, 0);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			Amministratore amministratore = amministratoreRepository.findByUsername(username).get();
			if (amministratore != null) {
				return User.withUsername(amministratore.getUsername()).accountLocked(!amministratore.isEnabled())
						.password(amministratore.getPassword()).roles(amministratore.getRole()).build();
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		throw new UsernameNotFoundException(username);
	}

}
