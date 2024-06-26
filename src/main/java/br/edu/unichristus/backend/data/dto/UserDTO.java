package br.edu.unichristus.backend.data.dto;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
	

	
	private Long id;
	

	private String name;
	private String email;
	private String login;
	private String password;	
	

}
