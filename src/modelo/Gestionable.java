package modelo;

import modelo.Libro;
import modelo.Usuario;

public interface Gestionable {
    void prestarLibro(Libro libro, Usuario usuario);
    void devolverLibro(Libro libro, Usuario usuario);
}