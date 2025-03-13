package com.dlopez.taller3.controller;

import com.dlopez.taller3.model.Persona;
import com.dlopez.taller3.service.PersonaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    //Crear una persona.
    @Operation(summary = "Este POST crea una nueva persona.", description = "Los parametros requeridos son 'nombre', 'apellido', el id se crea automaticamente.")
    @PostMapping
    public Persona createPerson(@RequestBody Persona persona) {
        return personaService.crearPersona(persona);
    }

    //Obtener todas las personas.
    @Operation(summary = "Este GET muestra todas las personas.", description = "No requiere agregar parametros.")
    @GetMapping
    public List<Persona> getAllPeople() {
        return personaService.obtenerTodasLasPersonas();
    }

    //Obtener una persona por Id.
    @Operation(summary = "Este GET muestra una persona por Id.", description = "Solo debemos agregar el id de la persona a buscar.")
    @GetMapping("/{id}")
    public ResponseEntity<Persona> getPersonById(@PathVariable Long id) {
        Optional<Persona> persona = personaService.obtenerPersonaById(id);
        return persona.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Actualizar una persona.
    @Operation(summary = "Este PUT actualiza una persona mediante su Id.", description = "Se pueden modificar todos los datos menos el id de la persona.")
    @PutMapping("/{id}")
    public ResponseEntity<Persona> updatePerson(@PathVariable Long id, @RequestBody Persona personaDetails) {
        return ResponseEntity.ok(personaService.actualizarPersona(id,personaDetails));
    }

    //Eliminar una persona.
    @Operation(summary = "Este DELETE elimina una persona mediante su Id.", description = "Solo se necesita agregar el id de la persona a eliminar.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        personaService.eliminarPersona(id);
        return ResponseEntity.noContent().build();
    }
}
