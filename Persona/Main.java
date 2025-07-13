/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persona;

/**
 *
 * @author lasso
 */
public class Main {
    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author lasso
 */
public class main {
    public static void main(String[] args) {
        // Crear persona con constructor por defecto
        Persona persona1 = new Persona();
        persona1.mostrarInformacion();

        // Crear persona con constructor parametrizado
        Persona persona2 = new Persona("Carlos", 25);
        persona2.mostrarInformacion();

        // Crear persona con constructor sobrecargado (solo nombre)
        Persona persona3 = new Persona("Laura");
        persona3.mostrarInformacion();
    }
}

}
