package biblioteca;

import java.util.*;

/**
 * Gestiona libros y usuarios de la biblioteca.
 */
public class Biblioteca {
    private final Map<String, Libro> catalogoPorIsbn;
    private final Map<String, Usuario> usuariosPorId;
    private final Set<String> isbnsPrestados;

    public Biblioteca() {
        catalogoPorIsbn = new HashMap<>();
        usuariosPorId = new HashMap<>();
        isbnsPrestados = new HashSet<>();
    }

    // ---------------- Operaciones de libros ----------------
    public void anadirLibro(Libro libro) {
        catalogoPorIsbn.put(libro.getIsbn(), libro);
    }

    public void quitarLibro(String isbn) {
        if(!isbnsPrestados.contains(isbn)) {
            catalogoPorIsbn.remove(isbn);
        } else {
            System.out.println("No se puede quitar, el libro está prestado.");
        }
    }

    // ---------------- Operaciones de usuarios ----------------
    public void registrarUsuario(Usuario u) {
        usuariosPorId.put(u.getId(), u);
    }

    public void darBajaUsuario(String id) {
        Usuario u = usuariosPorId.get(id);
        if(u != null && u.getIsbnsPrestados().isEmpty()) {
            usuariosPorId.remove(id);
        } else {
            System.out.println("No se puede dar de baja, el usuario tiene libros prestados.");
        }
    }

    // ---------------- Operaciones de préstamos ----------------
    public void prestarLibro(String idUsuario, String isbn) {
        Usuario u = usuariosPorId.get(idUsuario);
        Libro l = catalogoPorIsbn.get(isbn);

        if(u == null || l == null) {
            System.out.println("Usuario o libro no existe.");
            return;
        }
        if(isbnsPrestados.contains(isbn)) {
            System.out.println("Libro ya prestado.");
            return;
        }
        u.prestarLibro(isbn);
        isbnsPrestados.add(isbn);
    }

    public void devolverLibro(String idUsuario, String isbn) {
        Usuario u = usuariosPorId.get(idUsuario);
        if(u != null && u.getIsbnsPrestados().contains(isbn)) {
            u.devolverLibro(isbn);
            isbnsPrestados.remove(isbn);
        }
    }

    // ---------------- Búsquedas ----------------
    public List<Libro> buscarPorTitulo(String texto) {
        return catalogoPorIsbn.values().stream()
            .filter(l -> l.getTitulo().toLowerCase().contains(texto.toLowerCase()))
            .toList();
    }

    public List<Libro> buscarPorAutor(String texto) {
        return catalogoPorIsbn.values().stream()
            .filter(l -> l.getAutor().toLowerCase().contains(texto.toLowerCase()))
            .toList();
    }

    public List<Libro> buscarPorCategoria(String texto) {
        return catalogoPorIsbn.values().stream()
            .filter(l -> l.getCategoria().toLowerCase().contains(texto.toLowerCase()))
            .toList();
    }

    public List<Libro> listarPrestados(String idUsuario) {
        Usuario u = usuariosPorId.get(idUsuario);
        if(u == null) return Collections.emptyList();

        List<Libro> resultado = new ArrayList<>();
        for(String isbn : u.getIsbnsPrestados()) {
            resultado.add(catalogoPorIsbn.get(isbn));
        }
        return resultado;
    }
}

