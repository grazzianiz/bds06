package com.devsuperior.movieflix.dto;

import javax.validation.constraints.NotBlank;

import com.devsuperior.movieflix.entity.Review;
import com.devsuperior.movieflix.entity.User;

public class ReviewDTO {
	private Long id;
	
	@NotBlank(message = "Campo requerido")
	private String text;
	private Long movieId;
	//private Long userId;
	private User user;
	
	public ReviewDTO() {
		
	}
	
	public ReviewDTO(Long _id, String _text, Long _movieId, User _user) {
		id = _id;
		text = _text;
		movieId = _movieId;
		user = _user;
	}
	
	public ReviewDTO(Review _entity) {
		id = _entity.getId();
		text = _entity.getText();
		movieId = _entity.getMovie().getId();
		user = _entity.getUser();
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
	
	public Long getMovieId() {
		return movieId;
	}
	
	public void setMovieId(Long _movieId) {
		movieId = _movieId;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUserId(User _user) {
		user = _user;
	}
}