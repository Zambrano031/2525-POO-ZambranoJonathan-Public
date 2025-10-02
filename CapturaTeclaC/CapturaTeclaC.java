import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class CapturaTeclaC extends JFrame {

    private JList<String> lista;
    private DefaultListModel<String> modeloLista;
    private final JButton boton;

    public CapturaTeclaC() {
        setTitle("Ejemplo Captura Tecla C con Key Bindings");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Modelo de lista con algunos elementos
        modeloLista = new DefaultListModel<>();
        modeloLista.addElement("Elemento 1");
        modeloLista.addElement("Elemento 2");
        modeloLista.addElement("Elemento 3");

        lista = new JList<>(modeloLista);
        lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        add(new JScrollPane(lista), BorderLayout.CENTER);

        boton = new JButton("Botón de prueba");
        add(boton, BorderLayout.SOUTH);

        // ---------- Key Binding para la tecla "C" ----------
        InputMap inputMap = lista.getInputMap(JComponent.WHEN_FOCUSED);
        ActionMap actionMap = lista.getActionMap();

        // Asociar tecla C (mayúscula/minúscula) con la acción "accionC"
        inputMap.put(KeyStroke.getKeyStroke('C'), "accionC");
        inputMap.put(KeyStroke.getKeyStroke('c'), "accionC");

        // Definir la acción a ejecutar
        actionMap.put("accionC", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = lista.getSelectedIndex();
                if (index != -1) {
                    // Alternar texto del elemento seleccionado
                    String actual = modeloLista.getElementAt(index);
                    if (actual.endsWith("✔")) {
                        modeloLista.set(index, actual.replace(" ✔", ""));
                    } else {
                        modeloLista.set(index, actual + " ✔");
                    }
                    System.out.println("Tecla C presionada sobre: " + actual);
                } else {
                    System.out.println("Tecla C presionada sin selección.");
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CapturaTeclaC().setVisible(true);
        });
    }
}



