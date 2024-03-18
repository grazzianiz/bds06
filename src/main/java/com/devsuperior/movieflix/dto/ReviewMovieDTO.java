package com.devsuperior.movieflix.dto;

import com.devsuperior.movieflix.entity.Review;

public class ReviewMovieDTO {
	private String text;
	private String userName;
	
	public ReviewMovieDTO() {
		
	}
	
	public ReviewMovieDTO(String _text, String _userName) {
		text = _text;
		userName = _userName;
	}
	
	public ReviewMovieDTO(Review _entity) {
		text = _entity.getText();
		userName = _entity.getUser().getName();
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String _text) {
		text = _text;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserId(String _userName) {
		userName = _userName;
	}
}