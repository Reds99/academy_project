package com.academy.project.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    private int maxAttempts = 5; // Numero massimo di tentativi

    @Autowired
    private AmministratoreDetailsService amministratoreDetailsService;

    @Override
    public void onAuthenticationFailure(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {

        // Incrementa il contatore dei tentativi
        amministratoreDetailsService.incrementFailedAttempts(request.getParameter("username"));

        int remainingAttempts = maxAttempts - amministratoreDetailsService.getFailedAttempts(request.getParameter("username"));

        String errorMessage = null;
        String viewName = null;

        if (remainingAttempts <= 0) {
            // Pagina di errore specifica per tentativi superati
            errorMessage = "Numero di tentativi superati!";
            viewName = "error"; // Sostituisci con il nome della vista della pagina di errore
        } else {
            // Pagina di errore generica
            errorMessage = "Credenziali non valide. Tentativi rimanenti: " + remainingAttempts;
            viewName = "error"; // Sostituisci con il nome della vista della pagina di login
        }
        request.setAttribute("message", errorMessage);
        request.getRequestDispatcher(viewName).forward(request, response);
    }
}