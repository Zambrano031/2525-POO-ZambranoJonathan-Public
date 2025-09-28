package todoapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Objects;

public class TodoApp {

    private final DefaultListModel<Task> listModel = new DefaultListModel<>();
    private final JFrame frame = new JFrame("Todo Swing - Lista de Tareas");
    private final JTextField inputField = new JTextField(25);
    private final JButton addButton = new JButton("Añadir Tarea");
    private final JButton toggleButton = new JButton("Marcar como Completada");
    private final JButton deleteButton = new JButton("Eliminar Tarea");
    private final JList<Task> taskList = new JList<>(listModel);

    public TodoApp() {
        initGUI();
        attachHandlers();
    }

    private void initGUI() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(520, 380);
        frame.setLocationRelativeTo(null);

        JPanel topPanel = new JPanel();
        topPanel.setBorder(BorderFactory.createEmptyBorder(12, 12, 6, 12));
        topPanel.add(new JLabel("Nueva tarea:"));
        topPanel.add(inputField);
        topPanel.add(addButton);

        taskList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        taskList.setVisibleRowCount(10);
        taskList.setCellRenderer(new TaskCellRenderer());

        JScrollPane listScroll = new JScrollPane(taskList);
        listScroll.setBorder(BorderFactory.createTitledBorder("Tareas"));

        JPanel bottomPanel = new JPanel();
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(6, 12, 12, 12));
        bottomPanel.add(toggleButton);
        bottomPanel.add(deleteButton);

        frame.setLayout(new BorderLayout());
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(listScroll, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void attachHandlers() {
        addButton.addActionListener(e -> addTaskFromInput());
        inputField.addActionListener(e -> addTaskFromInput());
        toggleButton.addActionListener(e -> toggleSelectedTask());
        deleteButton.addActionListener(e -> removeSelectedTask());

        taskList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    int index = taskList.locationToIndex(e.getPoint());
                    if (index >= 0) {
                        Task t = listModel.get(index);
                        t.setCompleted(!t.isCompleted());
                        listModel.set(index, t);
                    }
                }
            }
        });

        InputMap im = taskList.getInputMap(JComponent.WHEN_FOCUSED);
        ActionMap am = taskList.getActionMap();
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), "deleteTask");
        am.put("deleteTask", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeSelectedTask();
            }
        });

        addButton.setMnemonic(KeyEvent.VK_A);
        toggleButton.setMnemonic(KeyEvent.VK_M);
        deleteButton.setMnemonic(KeyEvent.VK_E);
    }

    private void addTaskFromInput() {
        String text = inputField.getText().trim();
        if (!text.isEmpty()) {
            listModel.addElement(new Task(text));
            inputField.setText("");
            inputField.requestFocusInWindow();
        } else {
            Toolkit.getDefaultToolkit().beep();
        }
    }

    private void toggleSelectedTask() {
        int idx = taskList.getSelectedIndex();
        if (idx >= 0) {
            Task t = listModel.get(idx);
            t.setCompleted(!t.isCompleted());
            listModel.set(idx, t);
        } else {
            JOptionPane.showMessageDialog(frame, "Selecciona una tarea.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void removeSelectedTask() {
        int idx = taskList.getSelectedIndex();
        if (idx >= 0) {
            int option = JOptionPane.showConfirmDialog(frame, "¿Eliminar la tarea seleccionada?", "Confirmar", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                listModel.remove(idx);
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Selecciona una tarea.", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(TodoApp::new);
    }

    private static class Task {
        private String description;
        private boolean completed;

        public Task(String description) {
            this.description = Objects.requireNonNull(description);
            this.completed = false;
        }

        public String getDescription() {
            return description;
        }
        public boolean isCompleted() {
            return completed;
        }
        public void setDescription(String description) {
            this.description = Objects.requireNonNull(description);
        }
        public void setCompleted(boolean completed) {
            this.completed = completed;
        }
        @Override
        public String toString() {
            return description;
        }
    }

    private static class TaskCellRenderer extends JLabel implements ListCellRenderer<Task> {
        public TaskCellRenderer() {
            setOpaque(true);
            setBorder(BorderFactory.createEmptyBorder(4, 6, 4, 6));
        }

        @Override
        public Component getListCellRendererComponent(JList<? extends Task> list, Task value, int index,
                                                      boolean isSelected, boolean cellHasFocus) {
            if (value == null) {
                setText("");
                return this;
            }
            String desc = value.getDescription()
                    .replace("&", "&amp;")
                    .replace("<", "&lt;")
                    .replace(">", "&gt;");
            if (value.isCompleted()) {
                setText("<html><strike>" + desc + "</strike></html>");
            } else {
                setText("<html>" + desc + "</html>");
            }

            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(value.isCompleted() ? Color.GRAY : list.getForeground());
            }
            return this;
        }
    }
}

