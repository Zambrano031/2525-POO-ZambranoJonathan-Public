package com.zambranojonathan.proyecto.vista;

/**
 * Clase utilitaria que muestra mensajes y menús en consola.
 * Parte del proyecto de Jonathan Zambrano.
 * 
 * @author Jonathan
 */
public class Consola {
    public static void mostrarMensajeBienvenida() {
        System.out.println("📌 Bienvenido al sistema de tareas de POO - Jonathan Zambrano");
    }

    public static void mostrarMenu() {
        System.out.println("\nMenú Principal:");
        System.out.println("1. Registrar nueva tarea");
        System.out.println("2. Ver tareas registradas");
        System.out.println("3. Salir");
        System.out.print("Selecciona una opción: ");
    }

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}

