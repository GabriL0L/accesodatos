import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

/**
 * Created by Gabriel on 29/09/2015.
 */
public class Ej004 {
    public static void main(String[] args) {
        File f;
        Scanner teclado = new Scanner(System.in);
        String extension;
        String[] listaArchivos;
        FilenameFilter filtro;
        int i = 0;

        System.out.println("Introduzca un directorio: ");
        f = new File(teclado.next());
        System.out.println("Introduzca su extensión: ");
        extension = teclado.next();

        listaArchivos = f.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                if(name.matches(".*\\."+extension)){
                    return true;
                }else
                    return false;
            }
        });
        for(i=0;i<listaArchivos.length;i++){
            System.out.println(listaArchivos[i]);
        }

    }
}
