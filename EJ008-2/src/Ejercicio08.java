/**
 * Created by Gabriel on 21/10/2015.
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class Ejercicio08 {

    private static DataInputStream leer;
    private static DataOutputStream escribir;

    public static void main(String[] args) {
        Contacto p1 = new Contacto("Pepe", "123", "rosales", 11300, true, 10.2f);
        Contacto p2 = new Contacto("Juan", "4578", "SanPedro", 11300, false, 0f);

        ObjectInputStream leerOb;
        ObjectOutput escribirOb;

        try {

            // Con Serialización.
            escribirOb = new ObjectOutputStream(new FileOutputStream("binarioSerial.dat"));
            leerOb = new ObjectInputStream(new FileInputStream("binarioSerial.dat"));

            escribirOb.writeObject(p1);
            escribirOb.writeObject(p2);
            escribirOb.close();

            try {
                while (true)
                    System.out.println(leerOb.readObject().toString());
            } catch (EOFException e){

            } catch (ClassNotFoundException e){

            }
            leerOb.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
    }
    public static String leerSinSerializar() throws EOFException, FileNotFoundException, IOException {
        float dinero;
        return String.format("Nombre: %s | Telefono: %s | Direccio: %s | CP: %d | �Debo dinero?: %s %s",
                leer.readUTF(), leer.readUTF(), leer.readUTF(), leer.readInt(), leer.readBoolean()?"Si":"No le debo dinero.", (dinero = leer.readFloat()) == 0?"":"| Cantidad debida: " + dinero);
    }
    public static void agregarSinSerializar(Contacto c) throws IOException{
        escribir.writeUTF(c.nombreCont);
        escribir.writeUTF(c.telefono);
        escribir.writeUTF(c.direccion);
        escribir.writeInt(c.codP);
        escribir.writeBoolean(c.deboMoney);
        escribir.writeFloat(c.cantDeb);
    }
}
