import java.io.*;

/**
 * Created by Gabriel on 06/10/2015.
 */
public class ej005 {
    public static void main(String[] args) {
        File destino = new File("destino.txt");
        File salida;
        String linea;
        boolean escribir = true;



            try {
                destino.createNewFile();
                BufferedReader br = new BufferedReader(new FileReader("origen.txt"));
                BufferedWriter bw;
                if(destino.isDirectory()){
                    salida = new File(destino, "salida.txt");
                    bw = new BufferedWriter(new FileWriter("salida.txt"));
                    while((linea = br.readLine()) != null){
                        bw.write(linea+"\n");
                    }
                    br.close();
                    bw.close();
                }else{
                    if(escribir && destino.exists()){
                        bw = new BufferedWriter(new FileWriter("destino.txt"));
                        while((linea = br.readLine()) != null){
                            bw.write(linea+"\n");
                        }
                        br.close();
                        bw.close();
                    }else if(escribir && !destino.exists()){
                        System.out.println("No se ha hecho nada.");
                    }else if(!escribir && destino.exists()){
                        System.out.println("¡Error!");
                    }else if(!escribir && !destino.exists()){
                        System.out.println("No se ha hecho nada.");
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

    }
}
