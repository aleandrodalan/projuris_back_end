package br.com.projuris.controllers.exceptions;

import java.util.Arrays;
import java.util.List;

import lombok.Getter;

@Getter
public class ApiErrors {
	
	private List<String> errors;
	
	public ApiErrors(List<String> errors) {
		this.errors = errors;
	}
	
	public ApiErrors(String message) {
		this.errors = Arrays.asList(message);
	}
}