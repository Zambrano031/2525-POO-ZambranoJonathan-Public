package com.zambranojonathan.proyecto.dashboard;

import com.zambranojonathan.proyecto.modelo.Tarea;
import com.zambranojonathan.proyecto.servicio.GestorTareas;
import com.zambranojonathan.proyecto.vista.Consola;

import java.util.Scanner;

/**
 * Clase principal para gestionar el menú del sistema de tareas.
 * Permite registrar y mostrar tareas ficticias desde consola.
 * 
 * @author Jonathan
 */
public class Dashboard {
    private GestorTareas gestor;
    private Scanner scanner;

    public Dashboard() {
        this.gestor = new GestorTareas();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Inicia el menú principal del sistema.
     */
    public void iniciar() {
        Consola.mostrarMensajeBienvenida();

        int opcion;
        do {
            Consola.mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpia el buffer

            switch (opcion) {
                case 1:
                    registrarTarea();
                    break;
                case 2:
                    gestor.mostrarTareas();
                    break;
                case 3:
                    Consola.mostrarMensaje("¡Hasta luego!");
                    break;
                default:
                    Consola.mostrarMensaje("Opción inválida.");
            }
        } while (opcion != 3);
    }

    /**
     * Registra una tarea ingresada por el usuario.
     */
    private void registrarTarea() {
        System.out.print("Nombre de la tarea: ");
        String nombre = scanner.nextLine();
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        gestor.agregarTarea(new Tarea(nombre, descripcion));
        Consola.mostrarMensaje("✅ Tarea registrada con éxito.");
    }

    public static void main(String[] args) {
        new Dashboard().iniciar();
    }
}

