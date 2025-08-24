package gestorarchivos;

public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();

        // Agregar productos
        inventario.agregarProducto(new Producto("001", "Laptop", 5, 1200.50));
        inventario.agregarProducto(new Producto("002", "Mouse", 10, 15.99));

        // Mostrar inventario
        inventario.mostrarInventario();

        // Actualizar un producto
        inventario.actualizarProducto("001", 3, 1100.00);

        // Eliminar un producto
        inventario.eliminarProducto("002");

        // Mostrar inventario actualizado
        inventario.mostrarInventario();
    }
}
