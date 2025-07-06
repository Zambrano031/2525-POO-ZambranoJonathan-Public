package principal;

// Clase base: Animal (con encapsulación)
class Animal {
    private String nombre;
    private int edad;

    // Constructor
    public Animal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    // Getters y setters (encapsulación)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Método que será sobrescrito (polimorfismo)
    public void hacerSonido() {
        System.out.println("El animal hace un sonido.");
    }
}

// Clase derivada: Perro (hereda de Animal)
class Perro extends Animal {
    public Perro(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void hacerSonido() {
        System.out.println(getNombre() + " dice: ¡Guau!");
    }
}

// Clase derivada: Gato (hereda de Animal)
class Gato extends Animal {
    public Gato(String nombre, int edad) {
        super(nombre, edad);
    }

    @Override
    public void hacerSonido() {
        System.out.println(getNombre() + " dice: ¡Miau!");
    }
}

// Clase principal con el método main
public class Principal {
    public static void main(String[] args) {
        // Crear instancias
        Animal miAnimal = new Animal("Genérico", 5);
        Perro miPerro = new Perro("Firulais", 3);
        Gato miGato = new Gato("Michi", 2);

        // Demostrar funcionalidad y polimorfismo
        miAnimal.hacerSonido(); // Salida: El animal hace un sonido.
        miPerro.hacerSonido();  // Salida: Firulais dice: ¡Guau!
        miGato.hacerSonido();   // Salida: Michi dice: ¡Miau!
    }
}