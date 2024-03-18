package com.devsuperior.movieflix.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_review")
public class Review implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String text;
	
	@ManyToOne
	@JoinColumn(name = "movie_id")
	private Movie movie;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	public Review() {
		
	}
	
	public Review(Long _id, String _text) {
		id = _id;
		text = _text;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long _id) {
		id = _id;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String _text) {
		text = _text;
	}
	
	public Movie getMovie() {
		return movie;
	}
	
	public void setMovie(Movie _movie) {
		movie = _movie;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User _user) {
		user = _user;
	}
}