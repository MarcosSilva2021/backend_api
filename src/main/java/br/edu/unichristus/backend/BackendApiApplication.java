package br.edu.unichristus.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
	    info = @Info(
	        title = "Backend da API construida em topicos e desenvolviemto WEB",
	        version = "1.0",
	        description = "Trata-se da Documentação da API construida em Sala de aula",
	        contact = @Contact(
	        	    name = "marcos ads",
	        	    email = "msss@exemplo.com",
	        	     url = "https://unichristus.edu.br")
	      
	        
	    )
	)


@SpringBootApplication
public class BackendApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApiApplication.class, args);
	}

}
