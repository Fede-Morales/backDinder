package com.dinder.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dinder.model.Persona;
import com.dinder.service.PersonaService;

@RestController
@RequestMapping("/persona")
public class PersonaController {
	
	@Autowired
	private PersonaService  service;
	
	@PostMapping("/guardar")
	private ResponseEntity<Persona> guardar(@RequestBody Persona persona){
		Persona temp = service.create(persona);
		
		try {
			return ResponseEntity.created(new URI("/persona"+temp.getId())).body(temp);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping //("/listarTodasLasPersonas")
	private ResponseEntity<List<Persona>> listarTodasLasPersonas(){
		return ResponseEntity.ok(service.getAllPersonas());
	}
	
	@DeleteMapping
	private ResponseEntity<Void> eliminarPersona(Persona persona){
		service.delete(persona);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping(value = "{id}")
	private ResponseEntity<Optional<Persona>> getPersona (@PathVariable ("id") Long id){
		return ResponseEntity.ok(service.findById(id));
	}
	
}
