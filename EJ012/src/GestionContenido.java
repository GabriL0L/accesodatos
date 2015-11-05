import org.xml.sax.SAXException;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Gabriel on 29/10/2015.
 */
public class GestionContenido extends DefaultHandler{

    private String auxiliar = "";
    private BufferedWriter escribir;

    public GestionContenido(){
        super();
    }

    public void startDocument(){
        try {
            escribir = new BufferedWriter(new FileWriter("salida.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void endDocument(){
        try {
            escribir.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startElement(String uri, String nombre, String nombreC, Attributes atts){
        if (!nombre.matches("DatosContacto") && !nombre.matches("listaContacto") && !nombre.matches("ListaContactos"))
            auxiliar += nombre + ": ";
        for (int i = 0; i < atts.getLength(); i++) {
            auxiliar += String.format("(%s: %s) ", atts.getLocalName(i), atts.getValue(i));
        }
    }

    public void endElement(String uri, String localName, String qName){
        if(localName.matches("DatosContacto")){
            try {
                escribir.write(auxiliar);
                escribir.newLine();
                auxiliar = "";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void characters(char[] chars, int inicio, int longitud) throws SAXException {
        String car = new String(chars,inicio,longitud);
        car = car.trim();
        if (car.length() > 0)
            auxiliar += String.format("%s ", car);
    }

}
