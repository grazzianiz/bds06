package com.devsuperior.movieflix.resources.exceptions;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OAuthCustomError implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String error;
	
	@JsonProperty("error_description")
	private String errorDescription;
	
	public OAuthCustomError() {
		
	}
	
	public OAuthCustomError(String _error, String _errorDescription) {
		super();
		error = _error;
		errorDescription = _errorDescription;
	}

	public String getError() {
		return error;
	}

	public void setError(String _error) {
		error = _error;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String _errorDescription) {
		errorDescription = _errorDescription;
	}
}