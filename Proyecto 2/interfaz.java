import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.border.LineBorder;

public class Interfaz extends JFrame {
    private JButton botonAgregarNodo;
    private JButton botonEliminar;
    private JButton botonBuscar;
    private JTextField ingresar;

    public Interfaz() {
        setTitle("Interfaz Gráfica Proyecto 2");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana

        // Barra de menú
        JMenuBar menuBar = new JMenuBar();
        JMenu menuArchivo = new JMenu("Lista");
        JMenu Arbol = new JMenu("Arbol");
        JMenuItem salirItem = new JMenuItem("Salir");
        menuArchivo.addSeparator();
        menuArchivo.add(salirItem);
        menuBar.add(menuArchivo);
        menuBar.add(Arbol);
        setJMenuBar(menuBar);
        
        
        // Acción del botón de salir
        salirItem.addActionListener(e -> System.exit(0));
        
        // Panel de los botones
        JPanel panelGeneral = new JPanel();
        panelGeneral.setLayout(null);
        panelGeneral.setBackground(new Color(245,245,245)); 
        
        // Panel para contener la lista
        JPanel panelLista = new JPanel();
        panelLista.setLayout(null);
        panelLista.setPreferredSize(new Dimension(600, 600));
        panelLista.setBackground(new Color(250, 250, 240)); 
        panelLista.setBorder(new LineBorder(new Color(160, 82, 45), 2));

        // Botones y campos de texto
        botonAgregarNodo = new JButton("Agregar Nodo");
        botonEliminar = new JButton("Eliminar dato");
        botonBuscar = new JButton("Buscar dato");
        ingresar = new JTextField(10);

        // Posicionamiento de los botones y campo de texto
        botonAgregarNodo.setBounds(390, 100, 250, 30);
        botonBuscar.setBounds(645, 100, 250, 30);
        botonEliminar.setBounds(900, 100, 250, 30);
        ingresar.setBounds(638, 50, 265, 30);
        
        //color de los botones
        botonAgregarNodo.setBackground(new Color(144, 238, 144));
        botonBuscar.setBackground(new Color(135, 206, 235));
        botonEliminar.setBackground(new Color(255, 99, 71));
        ingresar.setBackground(new Color (255, 255, 255));

        // Añadir componentes al panelGeneral
        panelGeneral.add(botonAgregarNodo);
        panelGeneral.add(botonBuscar);
        panelGeneral.add(botonEliminar);
        panelGeneral.add(ingresar);

        // Añadir componentes a la ventana
        add(panelLista, BorderLayout.NORTH); // Panel superior
        add(panelGeneral, BorderLayout.CENTER); // Panel central

        setVisible(true);
    }

    public static void main(String[] args) {
        new Interfaz();
    }
}

