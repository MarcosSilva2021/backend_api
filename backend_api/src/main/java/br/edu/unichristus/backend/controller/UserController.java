package br.edu.unichristus.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unichristus.backend.data.User;
import br.edu.unichristus.backend.service.UserService;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping
	public User save(@RequestBody User user ) {
		return service.save(user);
	} 
	
	@GetMapping
	public List<User> listAll(){
		return service.listAll();
	}
}
