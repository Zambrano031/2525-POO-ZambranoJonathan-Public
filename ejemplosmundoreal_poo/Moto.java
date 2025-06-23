/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ejemplosmundoreal_poo;

/**
 *
 * @author lasso
 */
public class Moto {
    private String color;
    private String marca;
    private String modelo;
    private int velocidad;

    public Moto(String color, String marca, String modelo) {
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
        this.velocidad = 0;
    }

    public void acelerar(int incremento) {
        velocidad += incremento;
        System.out.println("La " + marca + " " + modelo + " aceleró a " + velocidad + " km/h");
    }

    public void frenar(int decremento) {
        velocidad = Math.max(0, velocidad - decremento);
        System.out.println("La " + marca + " " + modelo + " frenó a " + velocidad + " km/h");
    }

    public int getVelocidad() {
        return velocidad;
    }
}
