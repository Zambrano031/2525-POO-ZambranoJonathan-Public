 package com.mycompany.debers2;

import java.util.Scanner;

public class Debers2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Crear un Guerrero y un Mago
        Guerrero guerrero = new Guerrero("Aragorn", 10, 3, 5, 100, 5);
        Mago mago = new Mago("Gandalf", 3, 10, 3, 80, 4);

        // Mostrar atributos iniciales
        guerrero.atributos();
        mago.atributos();

        System.out.println("\n--- Batalla inicia ---");

        // Cambiar arma del guerrero
        guerrero.cambiarArma();

        // Turno de ataques
        guerrero.atacar(mago);
        if (mago.estaVivo()) {
            mago.atacar(guerrero);
        }

        System.out.println("\n--- Estado final ---");
        guerrero.atributos();
        mago.atributos();

        sc.close();
    }
}

class Personaje {
    protected String nombre;
    protected int fuerza;
    protected int inteligencia;
    protected int defensa;
    protected int vida;

    public Personaje(String nombre, int fuerza, int inteligencia, int defensa, int vida) {
        this.nombre = nombre;
        this.fuerza = fuerza;
        this.inteligencia = inteligencia;
        this.defensa = defensa;
        this.vida = vida;
    }

    public void atributos() {
        System.out.println("\n" + nombre + ":");
        System.out.println("·Fuerza: " + fuerza);
        System.out.println("·Inteligencia: " + inteligencia);
        System.out.println("·Defensa: " + defensa);
        System.out.println("·Vida: " + vida);
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void morir() {
        vida = 0;
        System.out.println(nombre + " ha muerto");
    }

    public int daño(Personaje enemigo) {
        return fuerza - enemigo.defensa;
    }

    public void atacar(Personaje enemigo) {
        int daño = daño(enemigo);
        if (daño < 0) daño = 0; // evitar daño negativo
        enemigo.vida -= daño;
        System.out.println(nombre + " ha realizado " + daño + " puntos de daño a " + enemigo.nombre);
        if (enemigo.estaVivo()) {
            System.out.println("Vida restante de " + enemigo.nombre + ": " + enemigo.vida);
        } else {
            enemigo.morir();
        }
    }
}

class Guerrero extends Personaje {
    private int espada;

    public Guerrero(String nombre, int fuerza, int inteligencia, int defensa, int vida, int espada) {
        super(nombre, fuerza, inteligencia, defensa, vida);
        this.espada = espada;
    }

    public void cambiarArma() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nElige un arma para " + nombre + ":");
        System.out.println("(1) Acero Valyrio (daño 8)");
        System.out.println("(2) Matadragones (daño 10)");
        int opcion = sc.nextInt();
        if (opcion == 1) {
            espada = 8;
        } else if (opcion == 2) {
            espada = 10;
        } else {
            System.out.println("Opción inválida, se mantiene el arma actual.");
        }
    }

    @Override
    public void atributos() {
        super.atributos();
        System.out.println("·Espada: " + espada);
    }

    @Override
    public int daño(Personaje enemigo) {
        return (fuerza * espada) - enemigo.defensa;
    }
}

class Mago extends Personaje {
    private int libro;

    public Mago(String nombre, int fuerza, int inteligencia, int defensa, int vida, int libro) {
        super(nombre, fuerza, inteligencia, defensa, vida);
        this.libro = libro;
    }

    @Override
    public void atributos() {
        super.atributos();
        System.out.println("·Libro: " + libro);
    }

    @Override
    public int daño(Personaje enemigo) {
        return (inteligencia * libro) - enemigo.defensa;
    }
}