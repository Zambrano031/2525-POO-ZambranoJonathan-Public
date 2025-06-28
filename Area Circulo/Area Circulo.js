/*
 * Programa: Calculadora de área de un círculo
 * Funcionalidad: Solicita al usuario el radio de un círculo, valida el dato
 *                y calcula el área utilizando la fórmula A = π * r^2.
 * Autor: JONATHAN
*/
package com.mycompany.areacirculo;
import java.util.Scanner;

public class AreaCirculo {

    public static void main(String[] args) {
        // Crear objeto Scanner para capturar entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Declarar variables usando tipos de datos diversos
        float radio; // tipo float para permitir decimales
        float area;  // resultado del cálculo del área
        boolean entrada_valida = false; // bandera para controlar la validez
        String mensaje_bienvenida = "=== Calculadora de área de un círculo ===";
        int intentos = 0;

        System.out.println(mensaje_bienvenida);

        // Bucle para validar la entrada del usuario
        while (!entrada_valida && intentos < 3) {
            System.out.print("Ingresa el radio del círculo: ");
            if (scanner.hasNextFloat()) {
                radio = scanner.nextFloat();

                if (radio > 0) {
                    // Calcular el área usando la fórmula A = π * r^2
                    area = (float) (Math.PI * Math.pow(radio, 2));
                    System.out.println("El área del círculo es: " + area + " unidades cuadradas.");
                    entrada_valida = true;
                } else {
                    System.out.println("El radio debe ser mayor que cero.");
                }
            } else {
                System.out.println("Entrada inválida. Debes ingresar un número.");
                scanner.next(); // Limpiar entrada incorrecta
            }
            intentos++;
        }

        // Si no se ingresó un valor válido
        if (!entrada_valida) {
            System.out.println("Demasiados intentos fallidos. Programa terminado.");
        }

        scanner.close();
    }
}
