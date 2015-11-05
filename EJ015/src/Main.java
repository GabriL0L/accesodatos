/**
 * Created by Gabriel on 05/11/2015.
 */
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        final String FORMATO_FECHA = "dd/MM/yyyy";
        Gson gson = new GsonBuilder().setPrettyPrinting().setDateFormat(FORMATO_FECHA).create();
        BufferedReader lector;
        BufferedWriter escritor;
        ArrayList<C> contactos;
        Type tipoListaEmpleados = new TypeToken<ArrayList<C>>() {
        }.getType();



        try {
            escritor=new BufferedWriter(new FileWriter("salida.txt"));
            lector = new BufferedReader(new FileReader("json.json"));
            contactos = gson.fromJson(lector, tipoListaEmpleados);


            escritor.write("*************************************************************\n");
            escritor.write("                     Agenda Telefonica\n");
            escritor.write("*************************************************************\n");
            for (C contacto : contactos) {
                escritor.write(contacto.toString());
                escritor.write("*************************************************************\n");
            }
            escritor.write("                  Fin de la Agenda Telefonica\n");
            escritor.write("*************************************************************\n");
            escritor.close();
            lector.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
