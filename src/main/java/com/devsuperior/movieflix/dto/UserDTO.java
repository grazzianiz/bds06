package com.devsuperior.movieflix.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.devsuperior.movieflix.entity.User;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	@NotBlank(message = "Campo obrigatório")
	private String name;

	@Email(message = "Favor entrar um email válido")
	private String email;
	
	Set<RoleDTO> roles = new HashSet<>();
	
	public UserDTO() {
	}

	public UserDTO(Long _id, String _name, String _email) {
		id = _id;
		name = _name;
		email = _email;
	}
	
	public UserDTO(User _entity) {
		id = _entity.getId();
		name = _entity.getName();
		email = _entity.getEmail();
		_entity.getRoles().forEach(role -> roles.add(new RoleDTO(role)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long _id) {
		id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String _name) {
		name = _name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String _email) {
		email = _email;
	}

	public Set<RoleDTO> getRoles() {
		return roles;
	}
}
