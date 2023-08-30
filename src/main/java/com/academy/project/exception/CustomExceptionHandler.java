package com.academy.project.exception;

import java.util.Date;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CorsistaIscrittoException.class)
	public ModelAndView handleCustomException(CorsistaIscrittoException ex) {

		ModelAndView modelAndView = new ModelAndView("error"); // Nome della tua pagina di errore
		Date dataAttuale = new Date();
		modelAndView.addObject("message", ex.getMessage());
		modelAndView.addObject("timestamp", dataAttuale);
		return modelAndView;
	}
}
