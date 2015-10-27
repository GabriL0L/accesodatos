import com.thoughtworks.xstream.XStream;

import java.io.*;

/**
 * Created by Usuario on 27/10/2015.
 */
public class Main {
    public static void main(String[] args) {
        ListaPersonas listacont = new ListaPersonas();
        File fichero = new File("binarioSerial.dat");
        FileInputStream filein = null;
        ObjectInputStream dataIS = null;
        XStream xstream = new XStream();
        try {
            filein = new FileInputStream(fichero);
            dataIS = new ObjectInputStream(filein);


            while (true) {
                Contacto c = (Contacto) dataIS.readObject();
                listacont.add(c);
            }
        } catch (EOFException e){
        }catch (FileNotFoundException e) {
                e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            dataIS.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        xstream.alias("ListaContactos",ListaPersonas.class);
        xstream.alias("DatosContacto",Contacto.class);
        //xstream.addImplicitCollection(ListaPersonas.class, "lista");
        try {
            xstream.toXML(listacont,new FileOutputStream("Contactos.xml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }


}
