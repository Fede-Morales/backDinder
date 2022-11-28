package com.dinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dinder.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
