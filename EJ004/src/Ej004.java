import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

/**
 * Created by Gabriel on 29/09/2015.
 */
public class Ej004 {
    public static void main(String[] args) {
        File f = new File(".");
        Scanner teclado = new Scanner(System.in);
        String nombre,extension;
        FilenameFilter filtro;
        int i = 0;

        System.out.println("Introduzca el nombre de un archivo: ");
        nombre = teclado.next();
        System.out.println("Introduzca su extensión: ");
        extension = teclado.next();
        filtro = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if(name.equals(nombre+"."+extension)){
                    return true;
                }else
                    return false;
            }
        };

        File[] archivos = f.listFiles(filtro);
        for(i=0;i<archivos.length;i++){
            System.out.println(archivos[i].getName());
        }

    }
}
