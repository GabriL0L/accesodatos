import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Usuario on 27/10/2015.
 */
public class Main {
    public static void main(String[] args) {
        XStream xstream = new XStream();
        ListaPersonas listContacto;
        Iterator it;
        DataOutputStream escribir;
        FileInputStream lectorAntiguo, lectorNuevo;
        boolean salir = false;
        int i, j;

        xstream.alias("ListaContactos",ListaPersonas.class);
        xstream.alias("DatosContacto",Contacto.class);
        try {
            escribir = new DataOutputStream(new FileOutputStream("ej11Salida.dat"));
            listContacto = (ListaPersonas) xstream.fromXML (new FileInputStream("Contactos.xml"));
            it = listContacto.getListaContacto().listIterator();

            while(it.hasNext()){
                Contacto c = (Contacto) it.next();
                escribir.writeUTF(c.nombreCont);
                escribir.writeUTF(c.telefono);
                escribir.writeUTF(c.direccion);
                escribir.writeInt(c.codP);
                escribir.writeBoolean(c.deboMoney);
                escribir.writeFloat(c.cantDeb);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            lectorAntiguo = new FileInputStream("binarioSerial.dat");
            lectorNuevo = new FileInputStream("ej11Salida.dat");

            while(!salir && (i = lectorAntiguo.read()) != -1 && (j = lectorNuevo.read()) != -1){
                if(i != j)
                    salir = true;
            }

            if (salir)
                System.out.println("Los ficheros no son iguales.");
            else
                System.out.println("Los ficheros son iguales.");

            lectorAntiguo.close();
            lectorNuevo.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
