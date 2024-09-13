package modelo;

import java.util.ArrayList;
import java.util.List;

public class Usuario extends Persona {
    private int numeroSocio;
    private List<Libro> librosPrestados = new ArrayList<>();

    // Constructor
    public Usuario(String nombre, String apellido, int numeroSocio) {
        super(nombre, apellido);
        this.numeroSocio = numeroSocio;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Usuario: " + nombre + " " + apellido + " (socio #" + numeroSocio + ")");
    }

    private int prestamosRealizados;
    private static final int MAX_PRESTAMOS = 3;

    public boolean puedePrestar() {
        return prestamosRealizados < MAX_PRESTAMOS;
    }

    public void registrarPrestamo(Libro libro) {
        prestamosRealizados++;
        librosPrestados.add(libro);
    }

    public boolean puedePrestarMasLibros() {
        return librosPrestados.size() < MAX_PRESTAMOS;
    }

    // Método para obtener la lista de libros prestados
    public List<Libro> getLibrosPrestados() {
        return librosPrestados;
    }
}