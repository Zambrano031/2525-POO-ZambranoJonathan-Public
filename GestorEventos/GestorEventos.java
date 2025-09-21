import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GestorEventos extends JFrame {

    private final JTable tablaEventos;
    private final DefaultTableModel modeloTabla;
    private final JSpinner spinnerFecha;
    private final JSpinner spinnerHora;
    private final JTextField txtDescripcion;

    public GestorEventos() {
        setTitle("Gestor de Eventos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar ventana

        // Panel principal con BorderLayout
        setLayout(new BorderLayout());

        // ===== Panel de entrada =====
        JPanel panelEntrada = new JPanel(new GridLayout(3, 2, 5, 5));

        // Fecha
        JLabel lblFecha = new JLabel("Fecha (dd/MM/yyyy):");
        spinnerFecha = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor editorFecha = new JSpinner.DateEditor(spinnerFecha, "dd/MM/yyyy");
        spinnerFecha.setEditor(editorFecha);

        // Hora
        JLabel lblHora = new JLabel("Hora (HH:mm):");
        spinnerHora = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor editorHora = new JSpinner.DateEditor(spinnerHora, "HH:mm");
        spinnerHora.setEditor(editorHora);

        // Descripción
        JLabel lblDescripcion = new JLabel("Descripción:");
        txtDescripcion = new JTextField();

        panelEntrada.add(lblFecha);
        panelEntrada.add(spinnerFecha);
        panelEntrada.add(lblHora);
        panelEntrada.add(spinnerHora);
        panelEntrada.add(lblDescripcion);
        panelEntrada.add(txtDescripcion);

        add(panelEntrada, BorderLayout.NORTH);

        // ===== Panel de tabla =====
        modeloTabla = new DefaultTableModel(new Object[]{"Fecha", "Hora", "Descripción"}, 0);
        tablaEventos = new JTable(modeloTabla);
        JScrollPane scrollTabla = new JScrollPane(tablaEventos);

        add(scrollTabla, BorderLayout.CENTER);

        // ===== Panel de botones =====
        JPanel panelBotones = new JPanel();

        JButton btnAgregar = new JButton("Agregar");
        JButton btnEliminar = new JButton("Eliminar seleccionado");
        JButton btnSalir = new JButton("Salir");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnEliminar);
        panelBotones.add(btnSalir);

        add(panelBotones, BorderLayout.SOUTH);

        // ===== Eventos de botones =====
        btnAgregar.addActionListener(e -> agregarEvento());
        btnEliminar.addActionListener(e -> eliminarEvento());
        btnSalir.addActionListener(e -> dispose());
    }

    private void agregarEvento() {
        String descripcion = txtDescripcion.getText().trim();

        if (descripcion.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "La descripción no puede estar vacía",
                    "Validación",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        Date fecha = (Date) spinnerFecha.getValue();
        Date hora = (Date) spinnerHora.getValue();

        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");

        String fechaStr = formatoFecha.format(fecha);
        String horaStr = formatoHora.format(hora);

        modeloTabla.addRow(new Object[]{fechaStr, horaStr, descripcion});

        txtDescripcion.setText("");
        txtDescripcion.requestFocus();
    }

    private void eliminarEvento() {
        int filaSeleccionada = tablaEventos.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this,
                    "Selecciona un evento primero",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        int opcion = JOptionPane.showConfirmDialog(this,
                "¿Eliminar el evento seleccionado?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION);

        if (opcion == JOptionPane.YES_OPTION) {
            modeloTabla.removeRow(filaSeleccionada);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GestorEventos ventana = new GestorEventos();
            ventana.setVisible(true);
        });
    }
}
