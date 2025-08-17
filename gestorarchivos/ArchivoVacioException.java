package gestorarchivos;

/**
 * Excepción personalizada que se lanza cuando
 * un archivo está vacío.
 * @author Jonathan
 */
public class ArchivoVacioException extends Exception {
    public ArchivoVacioException(String mensaje) {
        super(mensaje);
    }
}
