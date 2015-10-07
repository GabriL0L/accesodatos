import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Usuario on 06/10/2015.
 */
public class prueba {
    public static void main(String[] args) throws FileNotFoundException {

        try {
            FileWriter fw = new FileWriter("texto.txt");

            fw.append('a');
            fw.write("lol");
            fw.close();
            FileReader fic = new FileReader("texto.txt");

            System.out.print((char) fic.read());
            System.out.print((char) fic.read());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
