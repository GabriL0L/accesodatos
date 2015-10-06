import java.io.*;

/**
 * Created by Gabriel on 06/10/2015.
 */
public class ej007 {
    public static void main(String[] args) {
        String clave = "lol";

        try {
            BufferedReader bro = new BufferedReader (new FileReader("texto.txt"));
            BufferedWriter bwe = new BufferedWriter (new FileWriter("encriptado.txt"));
            BufferedReader bre = new BufferedReader (new FileReader("encriptado.txt"));
            BufferedWriter bwd = new BufferedWriter (new FileWriter("desencriptado.txt"));
            int i,j=0,cont = 0;

            while((i = bro.read()) != -1){
                bwe.write((char) i);
                bwe.write(clave.charAt(j));
                if(j == clave.length() - 1)
                    j = 0;
                else
                    j++;
            }

            bwe.close();
            bro.close();

            while((i = bre.read()) != -1){
                if(cont%2 == 0)
                    bwd.write((char) i);

                cont++;
            }

            bre.close();
            bwd.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
