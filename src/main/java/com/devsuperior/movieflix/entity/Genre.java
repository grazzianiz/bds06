package com.devsuperior.movieflix.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_genre")
public class Genre implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	public String name;
	
	@OneToMany(mappedBy = "genre")
	private List<Movie> movies = new ArrayList<>();
	
	public Genre() {
		
	}
	
	public Genre(Long _id, String _name) {
		super();
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
	
	public List<Movie> getMovies() {
		return movies;
	}
}