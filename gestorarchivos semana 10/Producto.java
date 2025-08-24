package gestorarchivos;

public class Producto {
    private String codigo;
    private String nombre;
    private int cantidad;
    private double precio;

    public Producto(String codigo, String nombre, int cantidad, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public int getCantidad() { return cantidad; }
    public double getPrecio() { return precio; }

    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public void setPrecio(double precio) { this.precio = precio; }

    // Para guardar en archivo
    @Override
    public String toString() {
        return codigo + "," + nombre + "," + cantidad + "," + precio;
    }

    // Reconstruir desde línea de archivo
    public static Producto fromString(String linea) {
        String[] partes = linea.split(",");
        return new Producto(partes[0], partes[1],
                Integer.parseInt(partes[2]),
                Double.parseDouble(partes[3]));
    }
}

