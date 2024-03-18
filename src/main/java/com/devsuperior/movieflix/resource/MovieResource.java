package com.devsuperior.movieflix.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.MovieGenreDTO;
import com.devsuperior.movieflix.dto.MovieMinIdDTO;
import com.devsuperior.movieflix.dto.ReviewMovieDTO;
import com.devsuperior.movieflix.service.MovieService;
import com.devsuperior.movieflix.service.ReviewService;

@RestController
@RequestMapping(value = "/movies")
public class MovieResource {
	
	@Autowired
	private MovieService service;
	
	@Autowired
	private ReviewService reviewService;
	
	@GetMapping()
	public ResponseEntity<Page<MovieGenreDTO>> findAllName(
			@RequestParam(value = "genreId", defaultValue = "0") Long genreId, Pageable pageable) {
		Page<MovieGenreDTO> dtoList = service.findAllMoviesPaged(genreId, pageable);
		
		return ResponseEntity.ok().body(dtoList);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<MovieMinIdDTO> findById(@PathVariable Long id) {
		MovieMinIdDTO dto = service.findAllMoviesById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@GetMapping(value = "/{id}/reviews")
	public ResponseEntity<List<ReviewMovieDTO>> findMoviesReviewsById(@PathVariable Long id) {
		List<ReviewMovieDTO> dtoList = reviewService.findMoviesReviewsById(id);
		
		return ResponseEntity.ok().body(dtoList);
	}
}
