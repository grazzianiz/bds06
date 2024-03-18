package com.devsuperior.movieflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.dto.GenreNameDTO;
import com.devsuperior.movieflix.repository.GenreRepository;

@Service
public class GenreService {
	
	@Autowired
	private GenreRepository repository;
	
	@Transactional(readOnly = true)
	public List<GenreNameDTO> findAllName() {
		List<GenreNameDTO> genreDtoList = repository.findAllGenresName();
		
		return genreDtoList;
	}
}