import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Gabriel on 29/09/2015.
 */
public class Ej003 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String nombre;
        File directorio = new File("directorio");
        File pr1 = new File(directorio,"prueba1.txt");
        File pr2 = new File(directorio,"prueba2.txt");
        File dir2 = new File(directorio,"subdir");
        File pr3 = new File(dir2,"prueba3.txt");
        File pr4 = new File(dir2,"prueba4.txt");
        directorio.mkdir();
        dir2.mkdir();

        try {
            pr1.createNewFile();
            pr2.createNewFile();
            pr3.createNewFile();
            pr4.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Introduzca un directorio: ");
        nombre = teclado.next();
        System.out.println("Los datos de ese directorio son: ");
        File dirABuscar = new File(nombre);

        mostrar(dirABuscar);

    }

    public static void mostrar(File directorio){
        int i=0;
        File[] dir = directorio.listFiles();
        for(i=0;i<dir.length;i++){
            if(dir[i].isFile()){
                System.out.println("Archivo: " + dir[i].getName());
            }else{
                System.out.println("Directorio: " + dir[i].getName());
                mostrar(dir[i]);
            }
        }
    }
}
