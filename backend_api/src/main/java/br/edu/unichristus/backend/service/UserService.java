package br.edu.unichristus.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unichristus.backend.data.User;
import br.edu.unichristus.backend.repository.UserRepository;



@Service
public class UserService {
	
	
	
		// instanciou o user repositori sem precisar intanciar de maneira convencional
		@Autowired
		private UserRepository repository;
	
	// regra a mais
	public User save(User user) {
		if(user.getName().length()> 150) {
			System.out.println("Limote de caracteres excedido");
			return null;
		}
		// recebe e exibe o resultado
		var userSaved = repository.save(user);
		
		return userSaved;		
	}
	public List<User> listAll(){
		return repository.findAll();
	}
	

}
