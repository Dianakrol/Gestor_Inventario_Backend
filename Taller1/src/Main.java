import modelo.Biblioteca;
import modelo.Libro;
import modelo.Usuario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crear una instancia de la biblioteca
        Biblioteca miBiblioteca = new Biblioteca();

        // Agregar algunos libros y usuarios de ejemplo
        miBiblioteca.agregarLibro(new Libro("1984", "George Orwell"));
        miBiblioteca.agregarUsuario(new Usuario("Ana", "García", 1));
        miBiblioteca.agregarUsuario(new Usuario("Juan", "Pérez", 2));

        // Crear un escáner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Menú principal
        boolean salir = false;
        while (!salir) {
            System.out.println("Bienvenido al sistema de biblioteca");
            System.out.println("1. Buscar libro");
            System.out.println("2. Buscar usuario");
            System.out.println("3. Prestar libro");
            System.out.println("4. Devolver libro");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opción: ");

            int opcion = scanner.nextInt();
            // Casos del menú
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el título del libro: ");
                    String titulo = scanner.next();
                    Libro libroEncontrado = miBiblioteca.buscarLibroPorTitulo(titulo);
                    if (libroEncontrado != null) {
                        System.out.println("Libro encontrado: " + libroEncontrado);
                    } else {
                        System.out.println("Libro no encontrado.");

                    }
                    break;

                case 2:
                    System.out.print("Ingrese el nombre del usuario: ");
                    String nombreUsuario = scanner.next();
                    Usuario usuarioEncontrado = miBiblioteca.buscarUsuarioPorNombre(nombreUsuario);
                    if (usuarioEncontrado != null) {
                        System.out.println("Usuario encontrado: " + usuarioEncontrado);
                    } else {
                        System.out.println("Usuario no encontrado.");

                    }
                    break;

                case 3:
                    System.out.print("Ingrese el título del libro a prestar: ");
                    String tituloLibro = scanner.next();
                    System.out.print("Ingrese el nombre del usuario: ");
                    nombreUsuario = scanner.next();

                    Libro libroPrestar = miBiblioteca.buscarLibroPorTitulo(tituloLibro);
                    Usuario usuarioPrestar = miBiblioteca.buscarUsuarioPorNombre(nombreUsuario);

                    if (libroPrestar != null && usuarioPrestar != null) {
                        if (miBiblioteca.agregarLibro(libroPrestar)) {
                            System.out.println("Libro prestado exitosamente a " + usuarioPrestar.getNombre());
                        } else {
                            System.out.println("No se pudo prestar el libro. El libro puede estar prestado o el usuario puede haber alcanzado su límite de préstamos.");
                        }
                    } else {
                        System.out.println("Libro o usuario no encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese el título del libro a devolver: ");
                    tituloLibro = scanner.next();
                    System.out.print("Ingrese el nombre del usuario que lo devolvió: ");
                    nombreUsuario = scanner.next();

                    Libro libroDevolver = miBiblioteca.buscarLibroPorTitulo(tituloLibro);
                    Usuario usuarioDevolver = miBiblioteca.buscarUsuarioPorNombre(nombreUsuario);

                    if (libroDevolver != null && usuarioDevolver != null) {
                        if (miBiblioteca.agregarLibro(libroDevolver, usuarioDevolver)) {
                            System.out.println("Libro devuelto exitosamente.");
                        } else {
                            System.out.println("No se pudo devolver el libro. Verifica los datos ingresados o si el usuario tiene el libro prestado.");
                        }
                    } else {
                        System.out.println("Libro o usuario no encontrado.");
                    }
                    break;


                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
