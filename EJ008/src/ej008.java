import java.io.*;

/**
 * Created by Gabriel on 06/10/2015.
 */
public class ej008 {
    public static void main(String[] args) {
        File fichero = new File("ficherito.dat");
        String nombre = "Juan";
        int telefono = 666554422;
        String direccion = "C/ Falsa 123";
        int cod_postal = 11200;
        boolean debo = false;
        float deber = 0;


        try {
            DataInputStream in = new DataInputStream(new FileInputStream(fichero));
            DataOutputStream out = new DataOutputStream(new FileOutputStream(fichero));

            out.writeUTF(nombre);
            out.writeInt(telefono);
            out.writeUTF(direccion);
            out.writeInt(cod_postal);
            out.writeBoolean(debo);
            out.writeFloat(deber);


                System.out.printf("Nombre: %s\nTeléfono: %d\nDirección: %s\nCódigo Postal: %d\n¿Le debo dinero? %s\nDinero a deber: %.1f",
                        in.readUTF(),in.readInt(),in.readUTF(),in.readInt(),in.readBoolean()?"Si":"No",in.readFloat());

            out.close();
            in.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
