package com.devsuperior.movieflix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.movieflix.dto.ReviewMovieDTO;
import com.devsuperior.movieflix.entity.Movie;
import com.devsuperior.movieflix.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
	
	@Query("SELECT new com.devsuperior.movieflix.dto.ReviewMovieDTO(review.text, review.user.name) "
			+ "FROM Review review "
			+ "WHERE review.movie = :movie")
	List<ReviewMovieDTO> findMoviesReviewsById(Movie movie);
}