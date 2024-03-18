package com.devsuperior.movieflix.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.MovieGenreDTO;
import com.devsuperior.movieflix.dto.MovieMinIdDTO;
import com.devsuperior.movieflix.entity.Genre;
import com.devsuperior.movieflix.entity.Movie;
import com.devsuperior.movieflix.repository.GenreRepository;
import com.devsuperior.movieflix.repository.MovieRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository repository;
	
	@Autowired
	private GenreRepository genreRepository;
	
	@Transactional(readOnly = true)
	public Page<MovieGenreDTO> findAllMoviesPaged(Long genreId, Pageable pageable) {
		Genre genre = (genreId == 0) ? null :  genreRepository.getOne(genreId);

		return repository.findAllMoviesByGenre(genre, pageable);
	}

	@Transactional(readOnly = true)
	public MovieMinIdDTO findAllMoviesById(Long movieId) {
		Optional<Movie> obj = repository.findById(movieId);
		Movie entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		
		return new MovieMinIdDTO(entity);
	}
}