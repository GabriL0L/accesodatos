import java.util.ArrayList;

/**
 * Created by Usuario on 27/10/2015.
 */
public class ListaPersonas {
    private ArrayList<Contacto> listaContacto = new ArrayList<Contacto>();

    public ListaPersonas(){}

    public void add(Contacto c){
        listaContacto.add(c);
    }

}
