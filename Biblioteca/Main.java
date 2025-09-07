package biblioteca;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        // Registrar usuarios
        biblioteca.registrarUsuario(new Usuario("U1", "Ana"));
        biblioteca.registrarUsuario(new Usuario("U2", "Luis"));

        // Añadir libros
        biblioteca.anadirLibro(new Libro("ISBN-001", "Clean Code", "Robert C. Martin", "Software"));
        biblioteca.anadirLibro(new Libro("ISBN-002", "Effective Java", "Joshua Bloch", "Java"));

        // Prestar libros
        biblioteca.prestarLibro("U1", "ISBN-001");
        biblioteca.prestarLibro("U2", "ISBN-002");

        // Listar prestados de Ana
        System.out.println("Libros prestados por Ana:");
        biblioteca.listarPrestados("U1").forEach(System.out::println);

        // Devolver libro
        biblioteca.devolverLibro("U1", "ISBN-001");

        // Búsquedas
        System.out.println("Buscar por autor 'Bloch': " + biblioteca.buscarPorAutor("Bloch"));
        System.out.println("Buscar por categoría 'Software': " + biblioteca.buscarPorCategoria("Software"));
    }
}


