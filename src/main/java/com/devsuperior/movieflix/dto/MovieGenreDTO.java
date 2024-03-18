package com.devsuperior.movieflix.dto;

import java.io.Serializable;

import com.devsuperior.movieflix.entity.Movie;

public class MovieGenreDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String title;
	private String subTitle;
	private Integer year;
	private String imgUrl;
	
	public MovieGenreDTO() {
		
	}
	
	public MovieGenreDTO(Long _id, String _title, String _subTitle, Integer _year, String _imgUrl) {
		id = _id;
		title = _title;
		subTitle = _subTitle;
		year = _year;
		imgUrl = _imgUrl;
	}
	
	public MovieGenreDTO(Movie _entity) {
		id = _entity.getId();
		title = _entity.getTitle();
		subTitle = _entity.getSubTitle();
		year = _entity.getYear();
		imgUrl = _entity.getImgUrl();
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long _id) {
		id = _id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String _title) {
		title = _title;
	}
	
	public String getSubTitle() {
		return subTitle;
	}
	
	public void setSubTitle(String _subTitle) {
		subTitle = _subTitle;
	}
	
	public Integer getYear() {
		return year;
	}
	
	public void setYear(Integer _year) {
		year = _year;
	}
	
	public String getImgUrl() {
		return imgUrl;
	}
	
	public void setImgUrl(String _imgUrl) {
		imgUrl = _imgUrl;
	}
}