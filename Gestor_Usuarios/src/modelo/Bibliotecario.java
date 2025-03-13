package modelo;

public abstract class Bibliotecario extends Persona implements Gestionable {
    private String identificacion;

    // Constructor
    public Bibliotecario(String nombre, String apellido, String identificacion) {
        super(nombre, apellido);
        this.identificacion = identificacion;
    }

    @Override
    public void prestarLibro(Libro libro, Usuario usuario) {
        // Lógica para prestar un libro
        if (libro.isDisponible() && usuario.puedePrestar()) {
            libro.prestar();
            usuario.registrarPrestamo(libro);
            System.out.println("El libro '" + libro.getTitulo() + "' ha sido prestado a " + usuario.getNombre());
        } else {
            // ... Manejar casos donde el libro no está disponible o el usuario no puede prestar
        }
    }

    @Override
    public void devolverLibro(Libro libro, Usuario usuario) {
        if (usuario.getLibrosPrestados().contains(libro)) { // Aquí usamos el getter para acceder a la lista
            usuario.getLibrosPrestados().remove(libro);
            libro.devolver();
            System.out.println("El libro '" + libro.getTitulo() + "' ha sido devuelto por " + usuario.getNombre());
        } else {
            System.out.println("El usuario no tiene prestado este libro.");
        }
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Bibliotecario: " + nombre + " " + apellido + ", (ID: " + identificacion + ")");
    }
}