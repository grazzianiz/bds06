package com.devsuperior.movieflix.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.devsuperior.movieflix.dto.ReviewDTO;
import com.devsuperior.movieflix.dto.ReviewMovieDTO;
import com.devsuperior.movieflix.dto.UserDTO;
import com.devsuperior.movieflix.entity.Movie;
import com.devsuperior.movieflix.entity.Review;
import com.devsuperior.movieflix.entity.User;
import com.devsuperior.movieflix.repository.MovieRepository;
import com.devsuperior.movieflix.repository.ReviewRepository;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository repository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserService userService;
	
	@Transactional(readOnly = true)
	public List<ReviewMovieDTO> findMoviesReviewsById(Long movieId) {
		Optional<Movie> obj = movieRepository.findById(movieId);
		Movie entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		List<Review> reviewList = entity.getReviews();
		List<ReviewMovieDTO> reviewMovieList = new ArrayList<>();
		for (Review review : reviewList) {
			reviewMovieList.add(new ReviewMovieDTO(review));
		}
		
		return reviewMovieList;
	}

	@Transactional
	public ReviewDTO insert(ReviewDTO dto) {
		Optional<Movie> optionalMovie = movieRepository.findById(dto.getMovieId());
		Movie movie = optionalMovie.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		UserDTO userDTO = userService.getLoggedUser();
		User user = new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail(), "");
		
		Review entity = new Review();
		entity.setText(dto.getText());
		entity.setUser(user);
		entity.setMovie(movie);
		entity = repository.save(entity);
		return new ReviewDTO(entity);
	}
}
