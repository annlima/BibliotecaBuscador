import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GUImostrarLibros extends JFrame{
    private JLabel Biblioteca;

    public GUImostrarLibros()
    {
        super("Mostrar libros");
 
        //get content pane and set its layout
        Container container = getContentPane();
        container.setLayout(new FlowLayout());

        //GUI constructor 
        Biblioteca = new JLabel("Nuestra colección de libros");
        container.add(Biblioteca);  

        AdministradorLibros newAdmin = new AdministradorLibros();
        String biblioteca = newAdmin.mostrarLibros();

        if (!biblioteca.isEmpty()) {
            
            String[] columnas = {"Título", "Autor", "ISBN"};
            DefaultTableModel model = new DefaultTableModel(columnas, 0);
            String[] arr = biblioteca.split("\n");
            for (String libro : arr) {
                String[] partes = libro.split(" - ISBN: ");
                if (partes.length == 2) {
                    String[] tituloAutor = partes[0].split(" por ");
                    if (tituloAutor.length == 2) {
                        String titulo = tituloAutor[0];
                        String autor = tituloAutor[1];
                        String ISBN = partes[1];
                        model.addRow(new Object[]{titulo, autor, ISBN});
                    }
                }
            }

            JTable tabla = new JTable(model);
            JScrollPane scrollPane = new JScrollPane(tabla);
            add(scrollPane);
            setVisible(true);
        } 
        
        else 
        {
            JOptionPane.showMessageDialog(null, "No hay libros en la biblioteca.", "Biblioteca", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
