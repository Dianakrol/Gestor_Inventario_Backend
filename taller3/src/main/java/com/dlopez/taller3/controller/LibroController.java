package com.dlopez.taller3.controller;

import com.dlopez.taller3.model.Libro;
import com.dlopez.taller3.service.LibroService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/libro")
public class LibroController {
    @Autowired
    private LibroService libroService;

    //Crear libro
    @Operation(summary = "este post crea un nuevo libro", description = "Los parametros requeridos para crear un libro son 'autor', 'isbn' y 'titulo', el id del libro se genera automaticamente.")
    @PostMapping
    public Libro crearlibro(@RequestBody Libro libro){
        return libroService.crearLibro(libro);
    }

    //Obtener todos los libros
    @Operation(summary = "Este get obtiene todos los libro", description = "Este método no requiere parámetros.")
    @GetMapping
    public List<Libro> obtenerTodosLosLibros(){
        return libroService.obtenerTodosLosLibros();
    }

    //Obtener libro por ID
    @Operation(summary = "Este get obtiene libro por id", description = "Este método solo requiere el id como parámetros.")
    @GetMapping("/{id}")
    public ResponseEntity<Libro> obtenerLibroPorId(@PathVariable Long id){
        Optional<Libro>libro=libroService.obtenerlibroporID(id);
        return libro.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    //Actualizar un libro
    @Operation(summary = "Este put actualiza un libro", description = "Este método actualiza todos los datos menos el id.")
    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizarLibro(@PathVariable Long id, @RequestBody Libro libroDetails){
        return ResponseEntity.ok(libroService.actualizarLibro(id, libroDetails));

    }

    //Eliminar un libro
    @Operation(summary = "Este delete elimina un libro", description = "Este método solo requiere el id como parámetros.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable Long id){
        libroService.eliminarLibro(id);
        return ResponseEntity.noContent().build();

    }


}
