package gestorarchivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clase que gestiona la creación y lectura de archivos de texto.
 * @author Jonathan
 */
public class GestorDeArchivo {

    /**
     * Método que guarda un contenido en un archivo de texto.
     * Si el archivo no existe, se crea automáticamente.
     *
     * @param nombreArchivo Nombre del archivo (ejemplo: "archivo.txt")
     * @param contenido     Texto a guardar dentro del archivo
     */
    public void guardar(String nombreArchivo, String contenido) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivo))) {
            bw.write(contenido);
            System.out.println("✅ Archivo guardado correctamente: " + nombreArchivo);
        } catch (IOException e) {
            System.err.println("❌ Error al guardar el archivo: " + e.getMessage());
        }
    }

    /**
     * Método que lee el contenido de un archivo línea por línea.
     *
     * @param nombreArchivo Nombre del archivo a leer
     * @return Contenido del archivo en un String
     */
    public String leer(String nombreArchivo) {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        } catch (IOException e) {
            System.err.println("❌ Error al leer el archivo: " + e.getMessage());
        }
        return contenido.toString();
    }
}

