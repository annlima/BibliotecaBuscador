import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//pop up screen para poder registrar un nuevo libro
public class GUIagregarLibro extends JFrame 
{
    
    private JLabel labelTitulo, labelAutor, labelISBN;
    private JTextField tituloTextfield, autorTextfield, ISBNTextfield;
    private JButton guardarButton;

    //GUI Set up
    public GUIagregarLibro() 
    {
        super("Agregar libro");
 
        //get content pane and set its layout
        Container container = getContentPane();
        container.setLayout(new FlowLayout());

        //GUI constructor 
        labelTitulo = new JLabel("Título: ");
        tituloTextfield = new JTextField( " ", 15 ); 
        container.add(labelTitulo);  
        container.add(tituloTextfield);

        labelAutor = new JLabel("Autor: ");
        autorTextfield = new JTextField( " ", 15 ); 
        container.add(labelAutor);  
        container.add(autorTextfield);  

        labelISBN = new JLabel("ISBN: ");
        ISBNTextfield = new JTextField( " ", 15 ); 
        container.add(labelISBN);  
        container.add(ISBNTextfield);

        guardarButton = new JButton("Guardar");
        container.add(guardarButton);

        //Create an instance of inner class ButtonHandler to use our button event handling
        ButtonHandler handler = new ButtonHandler();
        guardarButton.addActionListener( handler ); //register JBUtton to receive events from ButtonHandler

        setSize(250, 300);
        
        setVisible(true); //hacerlo visible
        
    }

    //Inner class for button event handling
    private class ButtonHandler implements ActionListener
    {
        //handle button event
        public void actionPerformed(ActionEvent event)
        {
            Object source = event.getSource();

            if (source == guardarButton) 
            {
                String newTitle = " ";
                String newAuthor = " ";
                String newISBN = " ";

                newTitle = tituloTextfield.getText();
                newAuthor = autorTextfield.getText();
                newISBN = ISBNTextfield.getText();

                Libro b1 = new Libro(newTitle, newAuthor, newISBN); 
                AdministradorLibros nuevoLibro = new AdministradorLibros(); //llamado al administrador
                nuevoLibro.agregarLibro(b1);  //llamado a la clase agregarLibro del administrador
                
                int dialogButton = JOptionPane.showConfirmDialog(null, "Libro agregado exitosamente. ¿Desea agregar otro libro?", "New submission", JOptionPane.YES_NO_OPTION);
                
                if (dialogButton == JOptionPane.YES_OPTION)
                {
                    //Vaciar los textfields
                    tituloTextfield.setText(" ");
                    autorTextfield.setText(" ");
                    ISBNTextfield.setText(" ");
                }
                else
                {
                    dispose();
                }
            }
            
        }
    }
}