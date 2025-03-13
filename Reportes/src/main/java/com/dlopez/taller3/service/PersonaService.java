package com.dlopez.taller3.service;

import com.dlopez.taller3.model.Persona;
import com.dlopez.taller3.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    //Crear una persona.
    public Persona crearPersona(Persona persona) {
        return personaRepository.save(persona);
    }

    //Obtener todas las personas.
    public List<Persona> obtenerTodasLasPersonas() {
        return personaRepository.findAll();
    }

    //Obtener persona por Id.
    public Optional<Persona> obtenerPersonaById(Long id) {
        return personaRepository.findById(id);
    }

    //Actualizar una persona.
    public Persona actualizarPersona(Long id, Persona personaDetails) {
        Persona persona = personaRepository.findById(id).orElseThrow();
        persona.setNombre(personaDetails.getNombre());
        persona.setApellido(personaDetails.getApellido());
        return personaRepository.save(persona);
    }

    //Eliminar una persona.
    public void eliminarPersona(Long id) {
        personaRepository.deleteById(id);
    }
}
