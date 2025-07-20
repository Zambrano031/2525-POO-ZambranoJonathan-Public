package com.zambranojonathan.proyecto.modelo;

/**
 * Representa una tarea con nombre y descripción.
 * Parte del proyecto POO desarrollado por Jonathan Zambrano.
 * 
 * @author Jonathan
 */
public class Tarea {
    private String nombre;
    private String descripcion;

    public Tarea(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "Tarea: " + nombre + "\nDescripción: " + descripcion + "\n";
    }
}
