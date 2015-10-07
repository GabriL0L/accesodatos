import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Usuario on 29/09/2015.
 */
public class Ej002 {
    public static void main(String[] args) throws IOException {
        File dir= new File("DIRECTORIO");
        File subdir = new File(dir,"SUBDIRECTORIO");
        File fichero1 = new File(dir,"f1.txt");
        File fichero2 = new File(dir,"f2.txt");
        File fichero3 = new File(dir,"f3.txt");
        File subfichero = new File(subdir,"sf.txt");


        int i = 0;

        dir.mkdir();
        subdir.mkdir();
        try {
            fichero1.createNewFile();
            fichero2.createNewFile();
            fichero3.createNewFile();
            subfichero.createNewFile();
        }catch(IOException ioe){
            ioe.printStackTrace();
        }

        fichero2.renameTo(new File(dir, "ficherito.txt"));
        fichero3.delete();

        String[] archivoDir = dir.list();
        String[] archivoSubDir = subdir.list();

        System.out.println("Ruta directorio: " + dir.getAbsolutePath());
        for(i=0;i<archivoDir.length;i++){
            System.out.println(archivoDir[i]);
        }
        System.out.println("Ruta subdirectorio: " + subdir.getAbsolutePath());
        for(i=0;i<archivoSubDir.length;i++){
            System.out.println(archivoSubDir[i]);
        }

    }
}
