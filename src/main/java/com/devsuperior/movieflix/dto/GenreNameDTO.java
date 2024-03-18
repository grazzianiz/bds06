package com.devsuperior.movieflix.dto;

import java.io.Serializable;

public class GenreNameDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	
	public GenreNameDTO() {
		
	}
	
	public GenreNameDTO(Long _id, String _name) {
		id = _id;
		name = _name;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long _id) {
		id = _id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String _name) {
		name = _name;
	}
}