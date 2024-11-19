import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Main extends JFrame {

    // Contenedor de la lista de prioridad
    private PriorityQueue<PriorityItem> priorityQueue;

    // Componentes gráficos
    private DefaultListModel<String> listModel;
    private JList<String> list;
    private JTextField inputField;
    private JTextField priorityField;
    private JButton addButton;
    private JButton removeButton;
    private JButton searchButton;
    private JTextField searchField;

    public Main() {
        // Título de la ventana
        super("Lista de Prioridad con Búsqueda, Prioridad Ajustable y Eliminación por Prioridad");

        // Inicializar la cola de prioridad
        priorityQueue = new PriorityQueue<>(Comparator.comparingInt(PriorityItem::getPriority));

        // Configuración de la interfaz gráfica
        setLayout(new BorderLayout());
        setSize(450, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configuración del panel de lista
        listModel = new DefaultListModel<>();
        list = new JList<>(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(list);
        add(scrollPane, BorderLayout.CENTER);

        // Panel de botones y campos de texto
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        inputField = new JTextField(10);
        priorityField = new JTextField(5);
        inputPanel.add(new JLabel("Elemento:"));
        inputPanel.add(inputField);
        inputPanel.add(new JLabel("Prioridad:"));
        inputPanel.add(priorityField);

        addButton = new JButton("Agregar");
        removeButton = new JButton("Eliminar (por Prioridad)");
        searchButton = new JButton("Buscar");
        searchField = new JTextField(10);

        // Estilo de los botones
        addButton.setBackground(new Color(73, 157, 73));
        addButton.setForeground(Color.WHITE);
        removeButton.setBackground(new Color(255, 69, 0));
        removeButton.setForeground(Color.WHITE);
        searchButton.setBackground(new Color(100, 149, 237));
        searchButton.setForeground(Color.WHITE);

        inputPanel.add(addButton);
        inputPanel.add(removeButton);
        inputPanel.add(new JLabel("Buscar:"));
        inputPanel.add(searchField);
        inputPanel.add(searchButton);

        add(inputPanel, BorderLayout.SOUTH);

        // Acciones de los botones
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                String priorityText = priorityField.getText();
                if (!input.isEmpty() && !priorityText.isEmpty()) {
                    try {
                        int priority = Integer.parseInt(priorityText);
                        priorityQueue.offer(new PriorityItem(input, priority));
                        updateList();
                        inputField.setText("");
                        priorityField.setText("");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido para la prioridad.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Por favor ingrese un valor y prioridad.");
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!priorityQueue.isEmpty()) {
                    // Eliminar el elemento con la más alta prioridad (menor valor)
                    priorityQueue.poll();
                    updateList();
                } else {
                    JOptionPane.showMessageDialog(null, "La lista está vacía.");
                }
            }
        });

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String searchTerm = searchField.getText();
                boolean found = false;
                for (PriorityItem item : priorityQueue) {
                    if (item.getName().equalsIgnoreCase(searchTerm)) {
                        JOptionPane.showMessageDialog(null, "Elemento encontrado: " + item.getName() + " con prioridad " + item.getPriority());
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    JOptionPane.showMessageDialog(null, "Elemento no encontrado.");
                }
            }
        });

        setVisible(true);
    }

    // Actualizar la lista visualmente
    private void updateList() {
        listModel.clear();
        for (PriorityItem item : priorityQueue) {
            listModel.addElement(item.getName() + " (Prioridad: " + item.getPriority() + ")");
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}

// Clase para almacenar los elementos con su prioridad
class PriorityItem {
    private String name;
    private int priority;

    public PriorityItem(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }
}

