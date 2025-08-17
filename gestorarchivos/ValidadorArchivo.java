package gestorarchivos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase encargada de validar que un archivo no esté vacío.
 * Usa la excepción personalizada ArchivoVacioException.
 * 
 * @author Jonathan
 */
public class ValidadorArchivo {

    /**
     * Verifica si un archivo tiene contenido.
     * 
     * @param nombreArchivo Nombre del archivo a verificar
     * @throws ArchivoVacioException si el archivo no tiene contenido
     */
    public void verificarNoVacio(String nombreArchivo) throws ArchivoVacioException {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            if (br.readLine() == null) {
                throw new ArchivoVacioException("⚠️ El archivo está vacío: " + nombreArchivo);
            }
        } catch (IOException e) {
            System.err.println("❌ Error al verificar el archivo: " + e.getMessage());
        }
    }
}

