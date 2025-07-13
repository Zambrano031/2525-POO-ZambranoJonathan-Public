/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package persona;

/**
 *
 * @author lasso
 */
public class Persona {

    // Atributos privados (encapsulamiento)
    private String nombre;
    private int edad;

    /**
     * Constructor por defecto.
     * Inicializa los atributos con valores predeterminados.
     */
    public Persona() {
        this.nombre = "Sin nombre";
        this.edad = 0;
    }

    /**
     * Constructor parametrizado.
     * Inicializa los atributos con valores proporcionados por el usuario.
     * @param nombre Nombre de la persona
     * @param edad Edad de la persona
     */
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    /**
     * Otro constructor sobrecargado: solo nombre.
     * Edad se inicializa en 18 por defecto.
     * @param nombre Nombre de la persona
     */
    public Persona(String nombre) {
        this.nombre = nombre;
        this.edad = 18; // valor por defecto
    }

    // Métodos getters para acceder a los atributos
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    // Método para mostrar información
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre + ", Edad: " + edad);
    }
    
}
