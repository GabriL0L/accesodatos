import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;

/**
 * Created by Gabriel on 29/10/2015.
 */
public class Main {
    public static void main(String[] args) {
        XMLReader procesadorXML = null;
        try {
            procesadorXML = XMLReaderFactory.createXMLReader();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        GestionContenido gestor = new GestionContenido();
        procesadorXML.setContentHandler(gestor);

        InputSource fileXML = new InputSource("Contactos.xml");
        try {
            procesadorXML.parse(fileXML);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

    }
}
