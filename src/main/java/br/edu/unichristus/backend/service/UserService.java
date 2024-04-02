package br.edu.unichristus.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unichristus.backend.data.User;
import br.edu.unichristus.backend.repository.UserRepository;
import ch.qos.logback.core.net.SyslogOutputStream;
import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

import java.util.List;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;

	public User save(User user) {
		if(user.getName().length() > 150) {
			System.out.println("Limite de caracteres excedido!");
			return null;
		}
		
		var userSaved = repository.save(user);
		
		return userSaved;
	}
	
	public User update(User user) {
		if(user.getName().length() > 150) {
			System.out.println("usuario editado!");
			return null;
		}
		
		var userSaved = repository.save(user);
		
		return userSaved;
	}
	
	public List<User> listAll(){
		return repository.findAll();
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public User findById(long id) {
		var user = repository.findById(id);
		if(user.isEmpty()) {
			System.out.println("usuario não encontrado");
			return null;
		}
		return user.get();
		
	}
	
}
