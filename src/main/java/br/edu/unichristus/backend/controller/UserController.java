package br.edu.unichristus.backend.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unichristus.backend.data.User;
import br.edu.unichristus.backend.service.UserService;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping
	public User save(@RequestBody User user) {
		return service.save(user);
	}
	
	@PutMapping
	public User update(@RequestBody User user) {
		return service.save(user);
	}
	
	@GetMapping
	public List<User> listAll(){
		return service.listAll();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.delete(id);
	}

}
