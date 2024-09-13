package modelo;

import java.util.ArrayList;
import java.util.List;


public class Biblioteca {
    private List<Libro> libros;
    private List<Usuario> usuarios;

    public Biblioteca() {
        libros = new ArrayList<>();

        usuarios = new ArrayList<>();
    }

    public boolean agregarLibro(Libro libro) {
        libros.add(libro);
        return false;
    }

    public void
    agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);

    }

    public Libro buscarLibroPorTitulo(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return
        null;
    }

    public Usuario buscarUsuarioPorNombre(String nombre) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equalsIgnoreCase(nombre)) {
                return usuario;

            }
        }
        return null;
    }

    public boolean agregarLibro(Libro libroDevolver, Usuario usuarioDevolver) {
        return false;
    }
}