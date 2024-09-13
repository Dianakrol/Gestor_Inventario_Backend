package modelo;

// Clase modelo.Persona: Representa a una persona en general
public abstract class Persona {

    //Atributo nombre y apellido protegidos de la clase modelo.Persona
    protected String nombre;
    protected String apellido;

    //Metodo declarado como abstracto, lo que significa que no tiene una implementación en la clase base
    public abstract void mostrarDatos();

    //El contructor inicializa los atributos nombre y apellido
    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }
    public String getNombre() {
        return nombre;
    }
}
