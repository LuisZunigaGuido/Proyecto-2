import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.border.LineBorder;

public class Interfaz extends JFrame {
    private JPanel panelGeneral = new JPanel();
    private JPanel panelLista = new JPanel();
    private JButton botonAgregarNodo;
    private JButton botonEliminar;
    private JButton botonBuscar;
    private JTextField ingresar;
    private ListaDePrioridad lista = new ListaDePrioridad();
    private Arbol arbol = new Arbol();

    public Interfaz() {
        setTitle("Interfaz Gráfica Proyecto 2");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana

        // Barra de menú
        JMenuBar menuBar = new JMenuBar();
        JMenu menuArchivo = new JMenu("Lista");
        JMenu menuArbol = new JMenu("Árbol");
        JMenuItem salirItem = new JMenuItem("Salir");
        JMenuItem ingresarNodoItem = new JMenuItem("Ingresar Nodo");
        JMenuItem eliminarNodoItem = new JMenuItem("Eliminar Nodo");
        JMenuItem buscarNodoItem = new JMenuItem("Buscar Nodo");

        menuArchivo.addSeparator();
        menuArchivo.add(salirItem);
        menuBar.add(menuArchivo);
        menuArbol.add(ingresarNodoItem);
        menuArbol.add(eliminarNodoItem);
        menuArbol.add(buscarNodoItem);
        menuBar.add(menuArbol);
        setJMenuBar(menuBar);

        // Acción del botón de salir
        salirItem.addActionListener(e -> System.exit(0));

        // Panel de los botones
        panelGeneral.setLayout(null);
        panelGeneral.setBackground(new Color(245, 245, 245));

        // Panel para contener la lista
        panelLista.setLayout(new BoxLayout(panelLista, BoxLayout.Y_AXIS));
        panelLista.setPreferredSize(new Dimension(600, 600));
        panelLista.setBackground(new Color(250, 250, 240));
        panelLista.setBorder(new LineBorder(new Color(0, 0, 0)));

        // Botones y campos de texto
        botonAgregarNodo = new JButton("Agregar Nodo");
        botonEliminar = new JButton("Eliminar dato");
        botonBuscar = new JButton("Buscar dato");
        ingresar = new JTextField(10);

        // Programa de los botones
        // Agregar nodo
        botonAgregarNodo.addActionListener(e -> {
            String texto = ingresar.getText();
            try {
                // Separar los valores ingresados por una coma
                //la funcion .split separa el texto para ser analizados por aparte esto en el caso que se ponga un numero y una palabra
                String[] partes = texto.split(",");
                int numero1 = Integer.parseInt(partes[0].trim());
                int numero2 = Integer.parseInt(partes[1].trim());
                // Verificar que se ingresaron exactamente dos valores
                if (partes.length != 2) {
                    JOptionPane.showMessageDialog(null, "Error al ingresar datos, favor de ingresar datos en el formato: numero entero,numero entero :)");
                } else {
                    //cambiamos los datos con la funcion parseInt a numeros para trabajar las entradas
                    lista.insertarDatos(numero1, numero2);
                    ordenarListaPrioridad();
                    ingresar.setText("");
                    actualizarPanelLista();
                    JOptionPane.showMessageDialog(null, "Datos ingresados exitosamente :)");
                    //resetear textfield y actualizar lista
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Error, favor ingresar datos en el formato: numero entero, numero entero :)");
            }
        });

        // Botón eliminar dato
        botonEliminar.addActionListener(e -> {
            String datoEliminar = ingresar.getText();
            try {
                int numeroEliminar = Integer.parseInt(datoEliminar.trim());
                if (lista.buscarDato(numeroEliminar) != null) {
                    lista.eliminarDato(numeroEliminar);
                    ordenarListaPrioridad();
                    JOptionPane.showMessageDialog(null, "El dato fue eliminado exitosamente :)");
                    ingresar.setText("");
                    actualizarPanelLista();
                } else {
                    JOptionPane.showMessageDialog(null, "Error, el dato que desea eliminar no se encuentra en la lista, favor ingrese un dato de la lista :)");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Error al eliminar dato, ingrese un valor entero válido de la lista :)");
            }
        });

        // Botón buscar dato
        botonBuscar.addActionListener(e -> {
            String datoBuscar = ingresar.getText();
            try {
                int numeroBuscar = Integer.parseInt(datoBuscar.trim());
                if (lista.buscarDato(numeroBuscar) != null) {
                    JOptionPane.showMessageDialog(null, "El dato fue encontrado exitosamente, el dato es " + numeroBuscar);
                } else {
                    JOptionPane.showMessageDialog(null, "El dato no pertenece a la lista, favor ingresar otro dato :)");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Error, favor de ingresar un entero válido para realizar la búsqueda :)");
            }
        });

        // Opciones del menú Árbol
        ingresarNodoItem.addActionListener(e -> {
            String valorStr = JOptionPane.showInputDialog(this, "Ingrese un valor entero para el nodo:");
            try {
                int valor = Integer.parseInt(valorStr);
                arbol.ingresarNodo(valor);
                JOptionPane.showMessageDialog(this, "Nodo ingresado correctamente.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un número entero válido.");
            }
        });

        eliminarNodoItem.addActionListener(e -> {
            String valorStr = JOptionPane.showInputDialog(this, "Ingrese el valor del nodo a eliminar:");
            try {
                int valor = Integer.parseInt(valorStr);
                arbol.setNodoRaiz(arbol.eliminarNodo(arbol.getNodoRaiz(), valor));
                JOptionPane.showMessageDialog(this, "Nodo eliminado correctamente.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un número entero válido.");
            }
        });

        buscarNodoItem.addActionListener(e -> {
            String valorStr = JOptionPane.showInputDialog(this, "Ingrese el valor del nodo a buscar:");
            try {
                int valor = Integer.parseInt(valorStr);
                boolean existe = arbol.existenciaNodo(arbol.getNodoRaiz(), valor);
                if (existe) {
                    JOptionPane.showMessageDialog(this, "El nodo con valor " + valor + " existe en el árbol.");
                } else {
                    JOptionPane.showMessageDialog(this, "El nodo con valor " + valor + " no existe en el árbol.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un número entero válido.");
            }
        });

        // Posicionamiento de los botones y campo de texto
        botonAgregarNodo.setBounds(390, 100, 250, 30);
        botonBuscar.setBounds(645, 100, 250, 30);
        botonEliminar.setBounds(900, 100, 250, 30);
        ingresar.setBounds(638, 50, 265, 30);

        //color y detalles de los botones
        botonAgregarNodo.setBackground(new Color(144, 238, 144));
        botonAgregarNodo.setBorder(new LineBorder(new Color (0,0,0)));
        botonBuscar.setBackground(new Color(135, 206, 235));
        botonBuscar.setBorder(new LineBorder(new Color (0,0,0)));
        botonEliminar.setBackground(new Color(255, 99, 71));
        botonEliminar.setBorder(new LineBorder(new Color (0,0,0)));
        ingresar.setBackground(new Color (255, 255, 255));
        ingresar.setBorder(new LineBorder(new Color (0,0,0)));

        // Añadir componentes al panelGeneral
        panelGeneral.add(botonAgregarNodo);
        panelGeneral.add(botonBuscar);
        panelGeneral.add(botonEliminar);
        panelGeneral.add(ingresar);

        // Añadir componentes a la ventana
        add(panelLista, BorderLayout.NORTH); // Panel superior
        add(panelGeneral, BorderLayout.CENTER); // Panel central
    }

    public void actualizarPanelLista() {
        panelLista.removeAll();
        Nodo nodoActual = lista.getNodoRaiz(); // Obtener el primer nodo de la lista
        if (nodoActual == null) {
            JLabel mensaje = new JLabel("La lista está vacía");
            panelLista.add(mensaje);
        } else {
            while (nodoActual != null) {
                JLabel nodoEtiqueta = new JLabel("Dato: " + nodoActual.getDato() + " ,Prioridad: " + nodoActual.getPrioridad());
                panelLista.add(nodoEtiqueta);
                nodoActual = nodoActual.getNodoSiguiente();
            }
        }
        panelLista.revalidate();
        panelLista.repaint();
    }

    public void ordenarListaPrioridad() {
        ListaDePrioridad listaOrdenada = new ListaDePrioridad();  // Una nueva lista vacía

        // Mientras haya nodos en la lista original
        while (lista.getNodoRaiz() != null) {
            Nodo nodoMin = lista.encontrarMenorPrioridad(); // Encuentra el nodo con menor prioridad
            listaOrdenada.insertarDatos(nodoMin.getDato(), nodoMin.getPrioridad()); // Inserta el nodo en la lista ordenada
            lista.eliminarDato(nodoMin.getDato()); // Elimina el nodo de la lista original
        }

        // Ahora, la lista ordenada tiene los nodos en orden de prioridad.
        // Actualiza la referencia de nodoRaiz para que apunte a la lista ordenada
        lista.setNodoRaiz(listaOrdenada.getNodoRaiz());
    }

    public static void main(String[] args) {
        Interfaz interfazGrafica = new Interfaz();
        interfazGrafica.setVisible(true);
    }
}

