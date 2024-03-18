package com.devsuperior.movieflix.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.devsuperior.movieflix.entity.Genre;


public class GenreDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private List<MovieDTO> movies = new ArrayList<>();
	
	public GenreDTO() {
	}
	
	public GenreDTO(Long _id, String _name) {
		id = _id;
		name = _name;
	}
	
	public GenreDTO(Genre _entity) {
		id = _entity.getId();
		name = _entity.getName();
		_entity.getMovies().forEach(movie -> movies.add(new MovieDTO(movie)));
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