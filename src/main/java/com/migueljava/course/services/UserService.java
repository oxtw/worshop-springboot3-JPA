package com.migueljava.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.migueljava.course.entities.User;
import com.migueljava.course.repositories.UserRepository;
import com.migueljava.course.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {
		return repository.findAll();
	}

	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));//orElseThrow tenta dar o get, se n conseguir ele lança uma exceção.
	}
	//operação básica para inserir um novo objeto do tipo User.
	public User insert (User obj) {
		return repository.save(obj);
	}
	//metodo DELETE para excluir um user do banco de dados por ID.
	public void delete(Long id) {
		repository.deleteById(id);
	}
	//função para atualizar um dado UPDATE
	public User update(Long id, User obj) {
		User entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
}
