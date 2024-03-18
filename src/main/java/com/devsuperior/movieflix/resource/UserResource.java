package com.devsuperior.movieflix.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.movieflix.dto.UserDTO;
import com.devsuperior.movieflix.service.UserService;

@RestController
@RequestMapping(value="/users/profile")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<UserDTO> getLoggedUser() {
		UserDTO dto = service.getLoggedUser();
		
		return ResponseEntity.ok().body(dto);
	}
}