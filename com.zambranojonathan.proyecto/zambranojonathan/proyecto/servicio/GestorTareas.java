package com.zambranojonathan.proyecto.servicio;

import com.zambranojonathan.proyecto.modelo.Tarea;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona una lista de tareas.
 * Parte de la lógica del sistema desarrollado por Jonathan Zambrano.
 * 
 * @author Jonathan
 */
public class GestorTareas {
    private List<Tarea> tareas;

    public GestorTareas() {
        tareas = new ArrayList<>();
    }

    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
    }

    public void mostrarTareas() {
        if (tareas.isEmpty()) {
            System.out.println("No hay tareas registradas.");
        } else {
            for (Tarea t : tareas) {
                System.out.println(t);
            }
        }
    }
}
