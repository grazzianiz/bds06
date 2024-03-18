package com.devsuperior.movieflix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.movieflix.entity.User;
import com.devsuperior.movieflix.repository.UserRepository;
import com.devsuperior.movieflix.services.exceptions.UnauthorizedException;

@Service
public class AuthService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly=true)
	public User authenticated() {
		try {
			String userName = SecurityContextHolder.getContext().getAuthentication().getName();
			return userRepository.findByEmail(userName);
		} catch (Exception e) {
			throw new UnauthorizedException("Invalid user");
		}
	}
	
	/*
	public void validateSelfOrAdmin(Long _userId) {
		User user = authenticated();
		
		if (!user.getId().equals(_userId) && !user.hasRole("ROLE_ADMIN")) {
			throw new ForbiddenException("Acess denied");
		}
	}
	*/
}