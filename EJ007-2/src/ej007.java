/**
 * Created by Usuario on 07/10/2015.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ej007 {

    public static void main(String[] args) {

        File fichero = new File("./fichero.txt"), encriptado = new File("./Encriptado.txt");
        FileReader lectorF, lectorEn;
        FileWriter wriEn, wriDes;
        String clave;
        int i, cont = 0;

        System.out.print("- Introduzca la clave de encriptación: ");
        clave = Teclado.leerPalabra();
        try {
            wriEn = new FileWriter(encriptado);
            wriDes = new FileWriter("./Desencriptado.txt");
            try {
                lectorF = new FileReader(fichero);
                while ((i = lectorF.read()) != -1){
                    if (cont < clave.length()){
                        wriEn.write(i + clave.charAt(cont));
                        cont++;
                    } else {
                        cont = 0;
                        wriEn.write(i + clave.charAt(cont));
                    }
                }
                cont = 0; i = 0;
                lectorF.close();
                wriEn.close();
                lectorEn = new FileReader(encriptado);
                while ((i = lectorEn.read()) != -1){
                    if (cont < clave.length()){
                        wriDes.write(i - clave.charAt(cont));
                        cont++;
                    } else {
                        cont = 0;
                        wriDes.write(i - clave.charAt(cont));
                    }
                }
                lectorEn.close();
                wriDes.close();
            } catch (FileNotFoundException e) {}
        } catch (IOException e){}
    }
}
