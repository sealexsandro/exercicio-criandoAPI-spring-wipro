package com.jarvis.aulaspring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarvis.aulaspring.model.User;
import com.jarvis.aulaspring.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public User findById(Integer id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElse(null);
	}

	public List<User> findAll() {
		return repository.findAll();
	}

	public User update(Integer id, User obj) {
		User newObj = findById(id);
		newObj.setNome(obj.getNome());
		newObj.setSobrenome(obj.getSobrenome());
		newObj.setEmail(obj.getEmail());
		newObj.setSenha(obj.getSenha());
		return repository.save(newObj);
	}

	public User create(User obj) {
		return repository.save(obj);
	}

	public void delete(Integer id) {
		findById(id);
		repository.deleteById(id);
	}

}