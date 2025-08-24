package gestorarchivos;

import java.io.*;
import java.util.*;

public class Inventario {
    private List<Producto> productos = new ArrayList<>();
    private String archivo = "inventario.txt";

    public Inventario() {
        cargarDesdeArchivo();
    }

    // Agregar producto
    public void agregarProducto(Producto p) {
        productos.add(p);
        guardarEnArchivo();
        System.out.println("✅ Producto añadido y guardado en archivo.");
    }

    // Actualizar producto
    public void actualizarProducto(String codigo, int nuevaCantidad, double nuevoPrecio) {
        for (Producto p : productos) {
            if (p.getCodigo().equals(codigo)) {
                p.setCantidad(nuevaCantidad);
                p.setPrecio(nuevoPrecio);
                guardarEnArchivo();
                System.out.println("✅ Producto actualizado.");
                return;
            }
        }
        System.out.println("⚠️ Producto no encontrado.");
    }

    // Eliminar producto
    public void eliminarProducto(String codigo) {
        productos.removeIf(p -> p.getCodigo().equals(codigo));
        guardarEnArchivo();
        System.out.println("✅ Producto eliminado.");
    }

    // Mostrar inventario
    public void mostrarInventario() {
        if (productos.isEmpty()) {
            System.out.println("⚠️ El inventario está vacío.");
        } else {
            for (Producto p : productos) {
                System.out.println(p);
            }
        }
    }

    // ================= Manejo de Archivos =================

    private void guardarEnArchivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Producto p : productos) {
                bw.write(p.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("❌ Error al guardar inventario: " + e.getMessage());
        }
    }

    private void cargarDesdeArchivo() {
        File file = new File(archivo);
        if (!file.exists()) {
            try {
                file.createNewFile(); // Crear si no existe
                System.out.println("ℹ️ Archivo inventario creado: " + archivo);
            } catch (IOException e) {
                System.err.println("❌ No se pudo crear el archivo: " + e.getMessage());
            }
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    productos.add(Producto.fromString(linea));
                }
            }
            if (productos.isEmpty()) {
                throw new ArchivoVacioException("El archivo está vacío.");
            }
        } catch (ArchivoVacioException ave) {
            System.err.println("⚠️ " + ave.getMessage());
        } catch (FileNotFoundException fnf) {
            System.err.println("❌ Archivo no encontrado.");
        } catch (IOException e) {
            System.err.println("❌ Error al leer el archivo: " + e.getMessage());
        }
    }
}
