import java.util.ArrayList;

/**
 * Created by Gabriel on 21/10/2015.
 */
public class ListaContactos {
    private ArrayList<Contacto> lista = new ArrayList<Contacto>();

    public ListaContactos(){}

    public void add(Contacto c){
        lista.add(c);
    }
    public ArrayList<Contacto> getListaContactos(){
        return lista;
    }
}
