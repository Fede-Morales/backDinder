package com.dinder.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dinder.model.Persona;
import com.dinder.repository.PersonaRepository;

@Service
public class PersonaService {

	@Autowired
	private PersonaRepository repo;
	
	public Persona create(Persona persona) {
		return repo.save(persona);
		
	}
	
	public List<Persona> getAllPersonas(){
		return repo.findAll();
	}
	
	public void delete(Persona persona) {
		repo.delete(persona);
	}
	
	public Optional<Persona> findById(Long id) {
		return repo.findById(id);
	}
	
	
	
}
