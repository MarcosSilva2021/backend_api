package br.edu.unichristus.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.unichristus.backend.data.User;


public interface UserRepository extends JpaRepository<User, Long> {
	
	

}
