import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Gabriel on 29/10/2015.
 */
public class Main {
    public static void main(String[] args) {
        FileOutputStream os = null;
        Transformer transformer;
        try {
            os = new FileOutputStream(new File("pagina.html"));
            Source estilos = new StreamSource("estilo.xsl");
            Source datos = new StreamSource("Contactos.xml");
            Result result = new StreamResult(os);

            transformer = TransformerFactory.newInstance().newTransformer(estilos);
            transformer.transform(datos,result);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

        try {
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
