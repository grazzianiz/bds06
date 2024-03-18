package com.devsuperior.movieflix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.devsuperior.movieflix.dto.GenreNameDTO;
import com.devsuperior.movieflix.entity.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
	
	@Query("SELECT new com.devsuperior.movieflix.dto.GenreNameDTO(genre.id, genre.name) "
			+ "FROM Genre genre "
			+ "ORDER BY genre.id")
	List<GenreNameDTO> findAllGenresName();
}