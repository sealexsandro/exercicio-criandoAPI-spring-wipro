package com.jarvis.aulaspring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarvis.aulaspring.model.Movement;
import com.jarvis.aulaspring.repository.MovementRepository;

@Service
public class MovementService {

	@Autowired
	MovementRepository repository;

	public Movement findById(Integer id) {
		Optional<Movement> obj = repository.findById(id);
		return obj.orElse(null);
	}

	public List<Movement> findAll() {
		List<Movement> list = repository.findAll();
		
		for (Movement movement : list) {
			System.out.println(movement.getMovementDate());
		}
		return repository.findAll();
	}

	public Movement update(Integer id, Movement obj) {
		Movement newObj = findById(id);
		newObj.setValue(obj.getValue());
		newObj.setNumberCard(obj.getNumberCard());
		newObj.setMovementDate(obj.getMovementDate());
		return repository.save(newObj);
	}

	public Movement create(Movement obj) {
		return repository.save(obj);
	}

	public void delete(Integer id) {
		findById(id);
		repository.deleteById(id);
	}
}
