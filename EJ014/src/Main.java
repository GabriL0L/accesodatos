import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Gabriel on 05/11/2015.
 */
public class Main {
    public static void main(String[] args) {
        XStream xstream = new XStream();
        FileWriter salida;
        ListaPersonas contactos;
        Gson conversor=new GsonBuilder().setPrettyPrinting().create();

        try {
            salida = new FileWriter("salida.json");

            xstream.alias("ListaContactos",ListaPersonas.class);
            xstream.alias("DatosContacto",Contacto.class);

            contactos = (ListaPersonas) xstream.fromXML(new FileInputStream("Contactos.xml"));

            salida.write(conversor.toJson(contactos.getListaContacto()));
            salida.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
