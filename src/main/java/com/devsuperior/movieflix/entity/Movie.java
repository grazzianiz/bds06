package com.devsuperior.movieflix.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tb_movie")
public class Movie implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String subTitle;
	private Integer year;
	private String imgUrl;
	private String synopsis;
	
	@ManyToOne
	@JoinColumn(name = "genre_id")
	private Genre genre;
	
	@OneToMany(mappedBy = "movie")
	private List<Review> reviews = new ArrayList<>();

	
	public Movie() {
		
	}
	
	public Movie(Long _id, String _title, String _subTitle, Integer _year, String _imUrl, String _synopsis) {
		id = _id;
		title = _title;
		subTitle = _subTitle;
		year = _year;
		imgUrl = _imUrl;
		synopsis = _synopsis;
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
	
	public Genre getGenre() {
		return genre;
	}
	
	public void setGenre(Genre _genre) {
		genre = _genre;
	}
	
	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
}