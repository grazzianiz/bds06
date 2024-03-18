package com.devsuperior.movieflix.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.devsuperior.movieflix.entity.Movie;

public class MovieDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String title;
	private String subTitle;
	private Integer year;
	private String imgUrl;
	private String synopsis;
	private Long genreId;
	private List<ReviewDTO> reviews = new ArrayList<>();
	
	public MovieDTO() {
		
	}
	
	public MovieDTO(Long _id, String _title, String _subTitle, Integer _year, String _imgUrl, String _synopsis, Long _genreId) {
		id = _id;
		title = _title;
		subTitle = _subTitle;
		year = _year;
		imgUrl = _imgUrl;
		synopsis = _synopsis;
		genreId = _genreId;
	}
	
	public MovieDTO(Movie _entity) {
		id = _entity.getId();
		title = _entity.getTitle();
		subTitle = _entity.getSubTitle();
		year = _entity.getYear();
		imgUrl = _entity.getImgUrl();
		synopsis = _entity.getSynopsis();
		genreId = _entity.getGenre().getId();
		_entity.getReviews().forEach(review -> reviews.add(new ReviewDTO(review)));
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
	
	public String getSynopsis() {
		return synopsis;
	}
	
	public void setSynopsis(String _synopsis) {
		synopsis = _synopsis;
	}
	
	public Long getGenreId() {
		return genreId;
	}
	
	public void setGenreId(Long _genreId) {
		genreId = _genreId;
	}
	
	public List<ReviewDTO> getReviews() {
		return reviews;
	}
}