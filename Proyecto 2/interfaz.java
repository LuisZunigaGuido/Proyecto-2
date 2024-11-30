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
    private JPanel panelArbol = new JPanel();
    private JButton botonAgregarNodo;
    private JButton botonEliminar;
    private JButton botonBuscar;
    private JButton botonBuscarArbol;
    private JButton botonIngresarArbol;
    private JButton botonEliminarArbol;
    private JTextField ingresarArbol;
    private JTextField ingresar;
    private Arbol arbol = new Arbol();
    private ListaDePrioridad lista = new ListaDePrioridad(); 
    
    //interfaz grafica
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
        JMenuItem ingresarNodoArbol = new JMenuItem("Ingresar Nodo");
        JMenuItem eliminarNodoArbol = new JMenuItem("Eliminar Nodo");
        JMenuItem buscarNodoArbol = new JMenuItem("Buscar Nodo");

        menuArchivo.addSeparator();
        menuArchivo.add(salirItem);
        menuBar.add(menuArchivo);
        menuBar.add(menuArbol);
        setJMenuBar(menuBar);

        // Acción del botón de salir
        salirItem.addActionListener(e -> System.exit(0));

        // Panel de los botones
        panelGeneral.setLayout(null);
        panelGeneral.setBackground(new Color(245, 245, 245));
        panelArbol.setLayout(new BoxLayout(panelArbol, BoxLayout.Y_AXIS));
        panelArbol.setPreferredSize(new Dimension(500, 500));
        panelArbol.setBackground(new Color(250, 250, 230));
        panelArbol.setBorder(new LineBorder(new Color(0, 0, 0)));


        // Panel para contener la lista
        panelLista.setLayout(new BoxLayout(panelLista, BoxLayout.Y_AXIS));
        panelLista.setPreferredSize(new Dimension(500, 500));
        panelLista.setBackground(new Color(250, 250, 240));
        panelLista.setBorder(new LineBorder(new Color(0, 0, 0)));

        // Botones y campos de texto
        botonAgregarNodo = new JButton("Agregar dato");
        botonEliminar = new JButton("Eliminar dato");
        botonBuscar = new JButton("Buscar dato");
        ingresar = new JTextField(10);
        botonBuscarArbol = new JButton("buscar Nodo");
        botonIngresarArbol = new JButton("ingresar nodo");
        botonEliminarArbol = new JButton("eliminar Nodo");
        ingresarArbol = new JTextField(10);
        
        // Programa de los botones
        // Agregar nodo
        botonAgregarNodo.addActionListener(e -> {
            String texto = ingresar.getText();
            try {
                String[] partes = texto.split(",");
                int numero1 = Integer.parseInt(partes[0].trim());
                int numero2 = Integer.parseInt(partes[1].trim());
                if (partes.length != 2) {
                    JOptionPane.showMessageDialog(null, "Error al ingresar datos, favor de ingresar datos en el formato: numero entero,numero entero :)");
                } else {
                    lista.insertarDatos(numero1, numero2);
                    ordenarListaPrioridad();
                    ingresar.setText("");
                    actualizarPanelLista();
                    JOptionPane.showMessageDialog(null, "Datos ingresados exitosamente :)");
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
                    JOptionPane.showMessageDialog(null, "El dato fue encontrado exitosamente, el dato es " + numeroBuscar+ ":)");
                } else {
                    JOptionPane.showMessageDialog(null, "El dato no pertenece a la lista, favor ingresar otro dato :)");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Error, favor de ingresar un entero válido para realizar la búsqueda :)");
            }
        });
        // Opciones del menú Árbol
        //programa de los botones del arbol
        botonIngresarArbol.addActionListener(e -> {
            String valorString = ingresarArbol.getText();
            try {
                int numero1 = Integer.parseInt(valorString);
                arbol.ingresarNodo(numero1);
                ingresarArbol.setText("");
                actualizarPanelArbol();
                JOptionPane.showMessageDialog(this, "Nodo ingresado correctamente. :)");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un número entero válido. :)");
            }
        });

        botonEliminarArbol.addActionListener(e -> {
            String valorString = ingresarArbol.getText();
            try {
                int valor = Integer.parseInt(valorString);
                arbol.eliminarNodo(arbol.getNodoRaiz(), valor);
                actualizarPanelArbol();
                ingresarArbol.setText("");
                JOptionPane.showMessageDialog(this, "Nodo eliminado correctamente. :)");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un número entero válido. :)");
            }
        });

        botonBuscarArbol.addActionListener(e -> {
            String valorString = ingresarArbol.getText();
            try {
                int valor = Integer.parseInt(valorString);
                boolean existe = arbol.existenciaNodo(arbol.getNodoRaiz(), valor);
                if (existe) {
                    JOptionPane.showMessageDialog(this, "El nodo con valor " + valor + " existe en el árbol. :)");
                    ingresarArbol.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "El nodo con valor " + valor + " no existe en el árbol. :)");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un número entero válido. :)");
            }
        });

        // Posicionamiento de los botones y campo de texto
        botonAgregarNodo.setBounds(130, 120, 300, 60);
        botonBuscar.setBounds(130, 190, 300, 60);
        botonEliminar.setBounds(130, 260, 300, 60);
        ingresar.setBounds(130, 50, 300, 60);
        botonIngresarArbol.setBounds(130, 520, 300,60);
        botonEliminarArbol.setBounds(130,660,300,60);
        botonBuscarArbol.setBounds(130,590,300,60);
        ingresarArbol.setBounds(130,450,300,60);
        
        

        // Color y detalles de los botones
        botonAgregarNodo.setBackground(new Color(144, 238, 144));
        botonAgregarNodo.setBorder(new LineBorder(new Color(0, 0, 0)));
        botonBuscar.setBackground(new Color(135, 206, 235));
        botonBuscar.setBorder(new LineBorder(new Color(0, 0, 0)));
        botonEliminar.setBackground(new Color(255, 99, 71));
        botonEliminar.setBorder(new LineBorder(new Color(0, 0, 0)));
        ingresar.setBackground(new Color(255, 255, 255));
        ingresar.setBorder(new LineBorder(new Color(0, 0, 0)));
        botonIngresarArbol.setBackground(new Color(144,238,140));
        botonIngresarArbol.setBorder(new LineBorder(new Color (0,0,0)));
        botonBuscarArbol.setBackground(new Color(135,206,230));
        botonBuscarArbol.setBorder(new LineBorder(new Color (0,0,0)));
        botonEliminarArbol.setBackground(new Color(255,99,60));
        botonEliminarArbol.setBorder(new LineBorder(new Color (0,0,0)));

        // Añadir componentes al panelGeneral
        panelGeneral.add(botonAgregarNodo);
        panelGeneral.add(botonBuscar);
        panelGeneral.add(botonEliminar);
        panelGeneral.add(ingresar);
        panelGeneral.add(botonIngresarArbol);
        panelGeneral.add(botonBuscarArbol);
        panelGeneral.add(botonEliminarArbol);
        panelGeneral.add(ingresarArbol);

        // Añadir componentes a la ventana
        add(panelLista, BorderLayout.WEST); // Panel superior
        add(panelArbol,BorderLayout.EAST);
        add(panelGeneral, BorderLayout.CENTER); // Panel central
    }
    
    /* metodo actualizarPanelLista
        *   Actualiza la lista para ordenarla con cada insersion y eliminacio
        * parametros de entrada
        *   ninguno
        * parametros de salida
        *   ninguno
        * respuesta esperada
        *       se espera que el metodo sea capaz de actualizar correctamente la lista de prioridad 
       */
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
    
    /* metodo OrdenarListaPrioridad
        *   el metodo ordena la lista
        * parametros de entrada
        *   ninguno
        * parametros de salida
        *   ninguno
        * respuesta esperada
        *       se espera que el metodo sea capaz de ordenar la lista 
       */
    public void ordenarListaPrioridad() {
        ListaDePrioridad listaOrdenada = new ListaDePrioridad();  

        while (lista.getNodoRaiz() != null) {
            Nodo nodoMin = lista.encontrarMenorPrioridad(); 
            listaOrdenada.insertarDatos(nodoMin.getDato(), nodoMin.getPrioridad()); 
            lista.eliminarDato(nodoMin.getDato()); 
        }

        lista.setNodoRaiz(listaOrdenada.getNodoRaiz());
    }
    
    /* metodo dibujarArbol
        *   dibuja los nodos y las conexiones 
        * parametros de entrada
        *   recibe como parametro un objeto graphics, dos enteros para ubicar cada nodo y un entero para la diferencia estetica de cada nodo,
        *   ademas recibe un arbol para dibujarlo.
        * parametros de salida
        *   ninguno
        * respuesta esperada
        *       se espera que el metodo sea capaz de dibujar el arbol con cada insercion y eliminacion
       */
    private void dibujaArbol(Graphics grafico, int x, int y, int offset, NodoArbol nodo) {
        if (nodo == null) return;
    
        // Dibujar el nodo
        grafico.setColor(Color.WHITE);
        grafico.fillOval(x - 15, y - 15, 30, 30);
        grafico.setColor(Color.BLACK);
        grafico.drawString(String.valueOf(nodo.valor), x - 10, y + 5);
    
        // Dibujar las conexiones
        if (nodo.getNodoIzquierda() != null) {
            grafico.setColor(Color.BLACK);
            grafico.drawLine(x, y, x - offset, y + 50);
            dibujaArbol(grafico, x - offset, y + 50, offset / 2, nodo.getNodoIzquierda());
        }
    
        if (nodo.getNodoDerecha() != null) {
            grafico.setColor(Color.BLACK);
            grafico.drawLine(x, y, x + offset, y + 50);
            dibujaArbol(grafico, x + offset, y + 50, offset / 2, nodo.getNodoDerecha());
        }
    }

    /* metodo actualizarPanelArbol
        *   actualiza el panel arbol despues de cada dibujo
        * parametros de entrada
        *   toma como parametros un numero entero para ingresar un nodo
        * parametros de salida
        *   ninguno
        * respuesta esperada
        *       se espera que el metodo sea capaz de actualizar el panel arbol despues de cada modificacion
       */
    private void actualizarPanelArbol() {
        panelArbol.removeAll(); 
    
         if (arbol.getNodoRaiz() == null) {
            JLabel vacio = new JLabel("El árbol está vacío.");
            panelArbol.add(vacio);
        } else {
            // Crear un nuevo panel de dibujo para mostrar el árbol
            JPanel panelDibujoArbol = new JPanel() {
                @Override
                protected void paintComponent(Graphics grafico) {
                    super.paintComponent(grafico);
                    int anchoPanel = getWidth();
                    int altoPanel = getHeight();
                    int xInicial = anchoPanel / 2;
                    int yInicial = 50;
                    int offset = anchoPanel / 4;
                    dibujaArbol(grafico, 250, 50, 100, arbol.getNodoRaiz());
                    panelArbol.repaint();
                }
            };
            panelDibujoArbol.setPreferredSize(new Dimension(500, 500)); // Ajusta el tamaño del panel
            panelArbol.add(panelDibujoArbol); 
            panelArbol.revalidate(); 
            panelArbol.repaint(); 
        }
    }

    //metodo main
    public static void main(String[] args) {
            Interfaz interfaz = new Interfaz();
            interfaz.setVisible(true);
    }
}