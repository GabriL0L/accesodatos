import java.io.*;

/**
 * Created by Gabriel on 06/10/2015.
 */
public class ej006 {
    public static void main(String[] args) {
        try {
            File fi = new File("origen.txt");
            BufferedReader bro = new BufferedReader(new FileReader("origen.txt"));
            BufferedWriter wr1 = new BufferedWriter(new FileWriter("salida1.txt"));
            BufferedWriter wr2 = new BufferedWriter(new FileWriter("salida2.txt"));
            BufferedWriter wr3 = new BufferedWriter(new FileWriter("salida3.txt"));
            int i,cont = 0;//desp = 0;
            //char[] caracteres = new char[(int) fi.length()];

            while((i = bro.read()) != -1){
                if(cont < 5){
                    wr1.write((char) i);
                    cont ++;
                }else if(cont < 10){
                    wr2.write((char) i);
                    cont ++;
                }else if(cont < 15){
                    wr3.write((char) i);
                    if(cont == 14){
                        cont = 0;
                    }else {
                        cont++;
                    }
                }
            }

            bro.close();
            wr1.close();
            wr2.close();
            wr3.close();

            cont = 0;

            BufferedReader br1 = new BufferedReader(new FileReader("salida1.txt"));
            BufferedReader br2 = new BufferedReader(new FileReader("salida2.txt"));
            BufferedReader br3 = new BufferedReader(new FileReader("salida3.txt"));
            BufferedWriter wrs = new BufferedWriter(new FileWriter("origenS.txt"));


            for(i = 0; i < fi.length(); i++){
                if(cont < 5){
                    wrs.write((char) br1.read());
                    cont ++;
                }else if(cont < 10){
                    wrs.write((char) br2.read());
                    cont ++;
                }else if(cont < 15){
                    wrs.write((char) br3.read());
                    if(cont == 14){
                        cont = 0;
                    }else {
                        cont++;
                    }
                }
            }

            while((i = br1.read()) != -1){
                wrs.write((char) i);
            }

            br1.close();
            br2.close();
            br3.close();
            wrs.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
