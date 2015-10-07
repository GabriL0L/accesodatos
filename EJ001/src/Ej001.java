import java.io.File;
import java.util.Scanner;

/**
 * Created by Usuario on 29/09/2015.
 */
public class Ej001 {
    public static void main(String[] args) {
        String nombre;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca el nombre de un archivo: ");
        nombre = teclado.next();

        File archivo = new File(nombre);
        System.out.println("Estos son los datos del archivo");
        System.out.println("Nombre: " + archivo.getName());
        System.out.println("Es ejecutable: " + archivo.canExecute());
        System.out.println("Está oculto: " + archivo.isHidden());
        System.out.println("Ruta relativa: " + archivo.getPath());
        System.out.println("Ruta absoluta: " + archivo.getAbsolutePath());
        System.out.println("Tamaño: " + archivo.length());
    }
}
