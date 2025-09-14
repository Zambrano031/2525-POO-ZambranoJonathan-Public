import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class TablaSwingApp {

    public static void main(String[] args) {
        // Crear ventana principal
        JFrame frame = new JFrame("Gestor de Tabla de Elementos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null); // Centrar ventana

        // Panel principal con BorderLayout
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));

        // Panel superior: etiqueta y campo de texto
        JPanel panelEntrada = new JPanel(new FlowLayout());
        JLabel etiqueta = new JLabel("Ingrese elemento:");
        JTextField campoTexto = new JTextField(20);
        panelEntrada.add(etiqueta);
        panelEntrada.add(campoTexto);

        // Panel central: tabla
        String[] columnas = {"ID", "Elemento"}; // Columnas de la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);
        JTable tabla = new JTable(modeloTabla);
        JScrollPane scrollTabla = new JScrollPane(tabla);

        // Panel inferior: botones
        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton botonAgregar = new JButton("Agregar");
        JButton botonLimpiar = new JButton("Limpiar");
        panelBotones.add(botonAgregar);
        panelBotones.add(botonLimpiar);

        // Añadir paneles al panel principal
        panelPrincipal.add(panelEntrada, BorderLayout.NORTH);
        panelPrincipal.add(scrollTabla, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        // Contador para ID
        final int[] contador = {1};

        // Eventos
        botonAgregar.addActionListener((ActionEvent e) -> {
            String texto = campoTexto.getText().trim();
            if (!texto.isEmpty()) {
                modeloTabla.addRow(new Object[]{contador[0], texto});
                contador[0]++;
                campoTexto.setText(""); // Limpiar campo
            } else {
                JOptionPane.showMessageDialog(frame, "El campo está vacío.", "Error", JOptionPane.WARNING_MESSAGE);
            }
        });

        botonLimpiar.addActionListener((ActionEvent e) -> {
            modeloTabla.setRowCount(0); // Limpiar tabla
            campoTexto.setText(""); // Limpiar campo
            contador[0] = 1; // Reiniciar contador
        });

        // Configurar ventana
        frame.setContentPane(panelPrincipal);
        frame.setVisible(true);
    }
}

