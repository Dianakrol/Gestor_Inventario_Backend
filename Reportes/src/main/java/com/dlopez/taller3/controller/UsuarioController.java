package com.dlopez.taller3.controller;

import com.dlopez.taller3.model.Usuario;
import com.dlopez.taller3.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    //Crear un usuario.
    @Operation(summary = "Este POST crea un nuevo usuario.", description = "Para crear el usuario solo se pone el id de la persona a la que se le asignara el usuario, ademas de el rol que va a tener esta persona.")
    @PostMapping
    public Usuario createUser(@RequestBody Usuario usuario) {
        return usuarioService.createUser(usuario);
    }

    //Obtener todos los usuarios.
    @Operation(summary = "Este GET muestra todos los usuarios.", description = "No se requieren parametros, este metodo traera el id del usuario, los datos de la persona asociada y el rol de este usuario.")
    @GetMapping
    public List<Usuario> getAllUsers() {
        return usuarioService.getAllUsers();
    }

    //Obtener un usuario por Id.
    @Operation(summary = "Este GET muestra un usuario por Id.", description = "Solo debemos agregar el id del usuario a buscar como parametro y este traera el id del usuario, los datos de la persona asociada y el rol de este usuario.")
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUserById(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.getUserById(id);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    //Actualizar un usuario.
    @Operation(summary = "Este PUT actualiza un usuario mediante su Id.", description = "Este put solo necesita el id del usuario a actualizar, solo permite modificar el rol del usuario.")
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUser(@PathVariable Long id, @RequestBody Usuario usuarioDetails) {
        return ResponseEntity.ok(usuarioService.updateUser(id, usuarioDetails));
    }

    //Eliminar un usuario.
    @Operation(summary = "Este DELETE elimina un usuario mediante su Id.", description = "Solo se necesita agregar el id del usuario a eliminar.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        usuarioService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
