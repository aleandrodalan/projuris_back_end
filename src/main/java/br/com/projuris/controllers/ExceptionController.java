package br.com.projuris.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import br.com.projuris.controllers.exceptions.ApiErrors;

@RestControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ApiErrors handleValidationErrors(MethodArgumentNotValidException ex) {
		BindingResult bindingResult = ex.getBindingResult();
		List<String> messages = bindingResult.getAllErrors()
									.stream()
									.map(objectError -> objectError.getDefaultMessage())
									.collect(Collectors.toList());
		
		return new ApiErrors(messages);
	}	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler(ResponseStatusException.class)
	public ResponseEntity handleResponseStatusException(ResponseStatusException ex) {
		String messageError = ex.getReason();
		HttpStatus statusCode = ex.getStatus();
		ApiErrors apiErrors = new ApiErrors(messageError);
		
		return new ResponseEntity(apiErrors, statusCode);
	}	
}