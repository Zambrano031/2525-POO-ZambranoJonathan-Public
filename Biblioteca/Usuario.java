package biblioteca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Representa un usuario de la biblioteca digital.
 */
public class Usuario {
    private String id;
    private String nombre;
    private List<String> isbnsPrestados;

    public Usuario(String id, String nombre) {
        if(id == null || id.isBlank() || nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("ID y nombre no pueden ser nulos o vacíos");
        }
        this.id = id;
        this.nombre = nombre;
        this.isbnsPrestados = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public List<String> getIsbnsPrestados() { 
        return Collections.unmodifiableList(isbnsPrestados); 
    }

    public void prestarLibro(String isbn) {
        isbnsPrestados.add(isbn);
    }

    public void devolverLibro(String isbn) {
        isbnsPrestados.remove(isbn);
    }

    @Override
    public String toString() {
        return id + " - " + nombre;
    }
}

