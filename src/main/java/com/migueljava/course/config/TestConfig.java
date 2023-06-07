package com.migueljava.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.migueljava.course.entities.User;
import com.migueljava.course.repositories.UserRepository;

@Configuration // toda classe de configuração precisa ter o @configuration.
@Profile("test") // "test" é o perfil de teste que crei na apllication-test.properties, o nome
					// precisa estar igual. É nessa annotation onde escolhemos o perfil que vamos usar.
public class TestConfig implements CommandLineRunner{
	
	//Injeção de dependencia
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
	}
}
