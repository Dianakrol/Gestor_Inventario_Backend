package modelo;

public class Libro {
    private String titulo;
    private String autor;
    private String isbn;
    private boolean disponible;

    public Libro(String number, String georgeOrwell) {
    }

    // Getters y setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;

    }
    public boolean isDisponible() {
        return disponible;
    }

    // Método para prestar un libro
    public void prestar() {
        if (isDisponible()) {
            disponible = false;
            System.out.println("modelo.Libro prestado.");
        } else {
            System.out.println("El libro no está disponible.");
        }
    }

    // Método para devolver un libro
    public void devolver() {
        disponible = true;
        System.out.println("modelo.Libro devuelto.");
    }
}