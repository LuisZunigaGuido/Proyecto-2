import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
public class interfaz extends JFrame {
    private JTextField ingresarDato;
    private JTextField ingresarPrioridad;
    private JTextField eliminarDato;
    private JTextField buscarDato;
    private JButton insertar;
    private JButton eliminar;
    private JButton buscar;
    public interfaz(){
        setTitle("interfaz grafica Proyecto 2");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); //esta funcion centra la ventana.
        
        //para la barra de menus tenemos la lista de prioridad y queremos el arbol pero con opcion a cambios.
        JMenuBar menuBar = new JMenuBar();
        JMenu Archivo = new JMenu("Archivo");
        JMenuItem salirItem = new JMenu("Salir");
        //los añadimos al menu 
        Archivo.add(salirItem);
        setJMenuBar(menuBar);
        //le damos la funcion al boton de salir
        salirItem.addActionListener(e->System.exit(0));
        
        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new BoxLayout(panelFormulario, BoxLayout.Y_AXIS));
    
        //haga los textFields y los Labels y añadalos al formulario.
    }
    public static void main(String[] args){
        interfaz interfazGrafica = new interfaz();
        interfazGrafica.setVisible(true);
    }
}
