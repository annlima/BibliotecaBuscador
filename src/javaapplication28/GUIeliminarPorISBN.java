import javax.swing.JFrame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUIeliminarPorISBN extends JFrame
{   
    private JLabel labelISBN;
    private JTextField ISBNTextfield;
    private JButton eliminarButton;

    //GUI Set up
    public GUIeliminarPorISBN() 
    {
        super("Agregar libro");
 
        //get content pane and set its layout
        Container container = getContentPane();
        container.setLayout(new FlowLayout());

        //GUI constructor 
        labelISBN = new JLabel("ISBN: ");
        ISBNTextfield = new JTextField( " ", 15 ); 
        container.add(labelISBN);  
        container.add(ISBNTextfield);

        eliminarButton = new JButton("Eliminar");
        container.add(eliminarButton);

        setSize(300, 100);
          
        setVisible(true); //hacerlo visible

        eliminarButton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) {
                String ISBN;

                ISBN = ISBNTextfield.getText();
                AdministradorLibros eliminarLibro = new AdministradorLibros(); //llamado al administrador
                eliminarLibro.eliminarPorISBN(ISBN);

                int dialogButton = JOptionPane.showConfirmDialog(null, "Libro eliminado. ¿Desea eliminar otro libro?", "New submission", JOptionPane.YES_NO_OPTION);
                
                if (dialogButton == JOptionPane.YES_OPTION)
                {
                    //Vaciar los textfields
                    ISBNTextfield.setText(" ");
                }
                else
                {
                    dispose();
                }

            }

        });
    }

    

}
