import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GUIAdministradorLibros {
    private JFrame frame;
    private AdministradorLibros admin;
    
    public GUIAdministradorLibros() {
        frame = new JFrame("Administrador de Libros");
        admin = new AdministradorLibros();
        
        JMenuBar menuBar = new JMenuBar();
        
        JMenu menu = new JMenu("Opciones");
        JMenuItem agregarItem = new JMenuItem("Agregar libro");
        JMenuItem eliminarItem = new JMenuItem("Eliminar libro por ISBN");
        JMenuItem mostrarItem = new JMenuItem("Mostrar todos los libros");
        JMenuItem salir = new JMenuItem("Salir");
        
        menu.add(agregarItem);
        menu.add(eliminarItem);
        menu.add(mostrarItem);
        menu.add(salir);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);
        
        //action listener - agregar libro
        agregarItem.addActionListener((ActionListener) new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUIagregarLibro nuevoNuevoLibro = new GUIagregarLibro(); //llamado a clase GUIagregarLibro
                nuevoNuevoLibro.setVisible(true); //hacer visible el GUIagregarLibro
            }
        });
        
        //action listener - eliminar libro
        eliminarItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUIeliminarPorISBN eliminarNuevo = new GUIeliminarPorISBN(); //llamado a clase GUIagregarLibro
                eliminarNuevo.setVisible(true); //hacer visible el GUIagregarLibro
            }
        });
        
        //action listener - mostrar todos los libros
        mostrarItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               GUImostrarLibros nuevaMuestra = new GUImostrarLibros(); //llamado a clase GUImostrarLibros
                nuevaMuestra.setVisible(true); //hacer visible el GUImostrarLibros
            }
        });

        //action listener - salir
        mostrarItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               System.exit(0);
            }
        });
        
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
  
}