package com.devsuperior.movieflix.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.movieflix.dto.MovieGenreDTO;
import com.devsuperior.movieflix.dto.MovieMinIdDTO;
import com.devsuperior.movieflix.entity.Genre;
import com.devsuperior.movieflix.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	@Query("SELECT new com.devsuperior.movieflix.dto.MovieGenreDTO(movie.id, movie.title, movie.subTitle, movie.year, movie.imgUrl) "
			+ "FROM Movie movie "
			+ "WHERE (:genre IS NULL OR movie.genre = :genre) "
			+ "ORDER BY movie.title")
	Page<MovieGenreDTO> findAllMoviesByGenre(Genre genre, Pageable pageable);
	
	@Query("SELECT new com.devsuperior.movieflix.dto.MovieMinIdDTO(movie.id, movie.title, movie.subTitle, movie.year, movie.imgUrl, movie.synopsis, movie.genre) "
			+ "FROM Movie movie "
			+ "WHERE (movie.id = :id) "
			+ "ORDER BY movie.title")
	List<MovieMinIdDTO> findAllMoviesById(Long id);
}