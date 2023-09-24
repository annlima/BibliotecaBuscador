import java.util.ArrayList;
import java.util.Arrays;


class AdministradorLibros {
    ArrayList<Libro> biblioteca = new ArrayList<>(); //crea el objeto arraylist - arraylist de objetos tipo libro llamado biblioteca

    //Función agregarLibro
    public void agregarLibro(Libro book) {
        biblioteca.add(book); 
    }

    //Función eliminarLibroPorISBN
    boolean eliminarPorISBN(String todeleteISBN)
    {
        for (Libro book : biblioteca) {
            if (book.ISBN.equals(todeleteISBN)) {
            biblioteca.remove(book);
            return true;
            }
        }
        
        return false;
        
    }

    //MostrarLibros
    String mostrarLibros()
    {
        
        StringBuilder bibliotecaString = new StringBuilder();
        for (Libro book: biblioteca){
            bibliotecaString.append(book).append("\n");
        }
        return bibliotecaString.toString();
        

    }
}
