package br.edu.unichristus.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import br.edu.unichristus.backend.data.dto.UserDTO;
import br.edu.unichristus.backend.data.dto.UserLowDTO;
import br.edu.unichristus.backend.data.model.User;
import br.edu.unichristus.backend.dozer.DozerConverter;
import br.edu.unichristus.backend.exception.CommonsException;
import br.edu.unichristus.backend.repository.UserRepository;


import java.util.List;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;

	public UserLowDTO save(UserDTO userDTO) {
		var userModel = DozerConverter.parseObject(userDTO, User.class);
		
		if(userModel.getName().length() > 150) {
			//System.out.println("Limite de caracteres excedido!");
			throw new CommonsException(
					HttpStatus.BAD_REQUEST,
					"unchristus.backend.service.badrequest.exception",
					"Limite de Carateres excedido"
					);
		}
		var userFind = repository.findByLogin(userModel.getLogin());
		if(!userFind.isEmpty()) {
			throw new CommonsException(
					HttpStatus.CONFLICT,
					"unichristus.backend.service.user.conflict.exception",
					"O Login informado já existe!"
					);
		}
		
		var userSaved = repository.save(userModel);
		
		var userLowDTO = DozerConverter.parseObject(userSaved, UserLowDTO.class);
		
		return userLowDTO;
	}	
	
	
	public List<UserLowDTO> listAll(){
		var listUserLow = repository.findAll();
		var listConverd = DozerConverter.parseListObjects(listUserLow, UserLowDTO.class);
		
		return listConverd;
	}
	
	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}
	
	public User findById(long id) {
		var user = repository.findById(id);
		if(user.isEmpty()) {
			//System.out.println("usuario não encontrado");
			throw new CommonsException(
					HttpStatus.NOT_FOUND,
					"unchristus.backend.service.user.notfound.exception",
					"O usuario com o id informado não foi encontrado"
					);
		}
		return user.get();
		
	}
	
}
