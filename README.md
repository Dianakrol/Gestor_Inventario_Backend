# nde-poo-backend-taller-1
README:md

# Biblioteca Virtual

Este proyecto es una simple biblioteca virtual implementada en Java. Permite gestionar préstamos de libros a usuarios.

## Tecnologías utilizadas
* Java
* IntelliJ IDEA

## Cómo ejecutar el proyecto
1. Clona este repositorio: `git clone https://github.com/tu-usuario/biblioteca-virtual.git`
2. Abre el proyecto en IntelliJ IDEA.
3. Ejecuta la clase Main.

## Contribuciones
Las contribuciones son bienvenidas. Por favor, abre un issue para discutir cualquier cambio que quieras hacer.

Licencia
Este proyecto está bajo la licencia MIT.


### Descripción
Encapsulación en la clase Libro
Este módulo se enfoca en la implementación de la encapsulación en una clase `Libro` para una biblioteca virtual. La encapsulación permite proteger los datos internos del objeto y controlar el acceso a ellos a través de métodos públicos (getters y setters).

Polimorfismo y Sobrecarga de Métodos en el Préstamo de Libros
Este módulo se enfoca en la implementación del polimorfismo a través de la sobrecarga del método prestar() en la clase Bibliotecario. Esta sobrecarga permite registrar el usuario que solicita un libro y validar si el usuario ha alcanzado el límite de préstamos permitidos.

### Este proyecto es un sistema de gestión de biblioteca básico desarrollado en Java. Actualmente, permite realizar las siguientes operaciones:

Agregar libros: Incorporar nuevos libros a la biblioteca.
Agregar usuarios: Registrar nuevos usuarios del sistema.
Buscar libros: Buscar libros por título.
Buscar usuarios: Buscar usuarios por nombre.
Prestar libros: Prestar libros a usuarios registrados.
Devolver libros: Devolver libros prestados a la biblioteca.

## Funcionamiento
El sistema funciona de la siguiente manera:

Inicio de la aplicación: Al ejecutar la aplicación, se crea una instancia de la clase Biblioteca que representa la biblioteca completa.
Menú principal: Se presenta un menú al usuario con las opciones disponibles (agregar libro, buscar libro, etc.).
Selección de opción: El usuario selecciona la opción deseada y se ejecuta la lógica correspondiente.
Procesamiento de la solicitud: El sistema realiza las operaciones solicitadas, como buscar un libro en una lista interna, agregar un nuevo usuario a un conjunto, o marcar un libro como prestado.
Mostrar resultados: Se muestran los resultados de la operación al usuario, como una lista de libros encontrados o un mensaje de confirmación.

## Limitaciones actuales
Falta de persistencia: La información de libros, usuarios y préstamos se almacena en memoria y se pierde al cerrar la aplicación.
Escalabilidad limitada: El sistema no está diseñado para manejar grandes cantidades de datos o usuarios concurrentes.
Funcionalidades reducidas: La falta de una base de datos restringe la implementación de funcionalidades más avanzadas como historial de préstamos, recomendaciones personalizadas, etc.

## Próximos pasos
Implementar una base de datos: Utilizar una base de datos relacional (como MySQL, PostgreSQL o SQLite) para almacenar de forma persistente los datos de la biblioteca. Esto permitirá mejorar la escalabilidad, seguridad y funcionalidad del sistema, al permitir realizar consultas más complejas, generar informes y ofrecer nuevas características como historial de préstamos y recomendaciones personalizadas.