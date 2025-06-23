/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejemplosmundoreal_poo;

/**
 *
 * @author lasso
 */
public class EjemplosMundoReal_POO {
public static void main(String[] args) {
        Moto miMoto = new Moto("negra", "Yamaha", "MT-03");
        miMoto.acelerar(30);
        miMoto.frenar(15);
        System.out.println("La velocidad final de mi moto es: " + miMoto.getVelocidad() + " km/h");
    }
  
}
