package gestorarchivos;


/**
 * Clase principal que prueba todas las funcionalidades.
 * 
 * - Guarda contenido en un archivo.
 * - Lee y muestra el contenido.
 * - Valida si el archivo está vacío usando try-catch.
 * 
 * @author Jonathan
 */
public class Main {
    public static void main(String[] args) {
        // Instancias
         System.out.println("Hola, soy la clase principal!");
        GestorDeArchivo gestor = new GestorDeArchivo();
        ValidadorArchivo validador = new ValidadorArchivo();

        String nombreArchivo = "miArchivo.txt";
        String contenido = "Hola, este es un archivo de prueba.\nCreado por Jonathan.";

        // Guardar contenido en archivo
        gestor.guardar(nombreArchivo, contenido);

        // Leer contenido del archivo
        String textoLeido = gestor.leer(nombreArchivo);
        System.out.println("📖 Contenido del archivo:\n" + textoLeido);

        // Verificar si el archivo está vacío
        try {
            validador.verificarNoVacio(nombreArchivo);
            System.out.println("✅ El archivo tiene contenido.");
        } catch (ArchivoVacioException e) {
            System.err.println("❌ Excepción detectada: " + e.getMessage());
        }
    }
}
