package com.devsuperior.movieflix.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.GenreNameDTO;
import com.devsuperior.movieflix.service.GenreService;

@RestController
@RequestMapping(value = "/genres")
public class GenreResource {
	
	@Autowired
	private GenreService service;
	
	@GetMapping()
	public ResponseEntity<List<GenreNameDTO>> findAllName() {
		List<GenreNameDTO> dtoList = service.findAllName();
		
		return ResponseEntity.ok().body(dtoList);
	}
}
