import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;

public class interfaz extends JFrame {
    private JTextField ingresar;
    private JButton botonAgregarDato;
    private JButton botonAgregarPrioridad;
    private JButton botonEliminar;
    private JButton botonBuscar;

    public interfaz() {
        setTitle("Interfaz Gráfica Proyecto 2");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Esta función centra la ventana.

        // Barra de menú
        JMenuBar menuBar = new JMenuBar();
        JMenu menuArchivo = new JMenu("Archivo");
        JMenuItem salirItem = new JMenuItem("Salir");
        menuArchivo.addSeparator();
        menuArchivo.add(salirItem);
        menuBar.add(menuArchivo);
        setJMenuBar(menuBar);

        // Acción del botón de salir
        salirItem.addActionListener(e -> System.exit(0));

        // Panel de formulario
        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(null);

        // Botones y campos de texto
        botonAgregarDato = new JButton("Agregar dato");
        ingresar = new JTextField(10);
        botonAgregarPrioridad = new JButton("Agregar prioridad");//agregue un solo nodo pues tiene dos parametros y borre ambos botones.
        botonEliminar = new JButton("Eliminar dato");
        botonBuscar = new JButton("Buscar dato");
        
        // Posicionamiento de los botones y campos de texto [pendiente]
        botonAgregarDato.setBounds(305,700, 250, 25);    
        botonAgregarPrioridad.setBounds(530, 700, 250, 25);     
        botonEliminar.setBounds(755, 700, 250, 25);  
        botonBuscar.setBounds(980, 700, 250, 25);     
        ingresar.setBounds(650, 650, 250, 25); 
        // Colores más oscuros para los botones
        botonAgregarDato.setBackground(new Color(80, 200, 120)); // Verde oscuro
        botonAgregarPrioridad.setBackground(new Color(80, 200, 120)); // Verde oscuro
        botonEliminar.setBackground(new Color(255, 99, 71)); // Rojo oscuro
        botonBuscar.setBackground(new Color(173,216,230)); // Azul oscuro
        // Añadir los componentes al panel
        //prioridad
        panelFormulario.add(ingresar);
        panelFormulario.add(new JLabel("Prioridad:"));
        panelFormulario.add(botonAgregarPrioridad);
        //eliminar dato
        panelFormulario.add(new JLabel("Eliminar dato:"));
        panelFormulario.add(botonEliminar);
        //buscar dato
        panelFormulario.add(new JLabel("Buscar dato:"));
        panelFormulario.add(botonBuscar);
        //dato
        panelFormulario.add(new JLabel("Dato:"));
        panelFormulario.add(botonAgregarDato);
        
        add(panelFormulario, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        interfaz interfazGrafica = new interfaz();
        interfazGrafica.setVisible(true);
    }
}

