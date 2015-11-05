import java.io.Serializable;

/**
 * Created by Usuario on 27/10/2015.
 */
public class Contacto implements Serializable {

    private static final long serialVersionUID = 1L;

    public String Nombre, Telefono, Direccion;
    public int CodPostal;
    public boolean Debo;
    public float Cantidad;

    public Contacto(String nomCont, String tel, String dir, int CodPostal, boolean Debo, float Cantidad){
        Nombre = nomCont;
        Telefono = tel;
        Direccion = dir;
        this.CodPostal = CodPostal;
        this.Debo = Debo;
        this.Cantidad = Cantidad;
    }
    public String toString(){
        float dinero;
        return String.format("Nombre: %s | Telefono: %s | Direccio: %s | CP: %d | ¿Debo dinero?: %s %s",
                Nombre, Telefono, Direccion, CodPostal, Debo ?"Si":"No",  (dinero = Cantidad) == 0?"":"| Cantidad a deber: " + dinero);
    }
}
