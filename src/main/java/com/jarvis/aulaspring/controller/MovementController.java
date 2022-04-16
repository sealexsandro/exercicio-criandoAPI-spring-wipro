package com.jarvis.aulaspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.jarvis.aulaspring.model.Movement;
import com.jarvis.aulaspring.service.MovementService;

@Controller
@RequestMapping("/movements")
@CrossOrigin("*")
public class MovementController {

	@Autowired
	MovementService service;

	@GetMapping("/{id}")
	public ResponseEntity<Movement> getById(@PathVariable Integer id) {
		Movement obj = this.service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	public ResponseEntity<List<Movement>> getAll() {
		List<Movement> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	public ResponseEntity<Movement> create(@RequestBody Movement movement) {
		Movement newMovement = service.create(movement);
		return ResponseEntity.status(HttpStatus.CREATED).body(newMovement);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Movement> update(@PathVariable Integer id, @RequestBody Movement obj) {
		Movement newMoviment = service.update(id, obj);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(newMoviment);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
