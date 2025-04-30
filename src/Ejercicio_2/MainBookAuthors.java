package Ejercicio_2;

import Ejercicio_1.primero.Employee;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainBookAuthors {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < args.length; i++)
            sb.append("Argumento " + i + ": " + args[i] + "\n");
        System.out.println("Argumentos: \n" + sb);


        String operacion = args[0];
        String fichero = args[1];

        Gson gson = new Gson();

        if(operacion.equals("init")){
            Author[] authors = new Author[2];
            authors[0] = new Author("Tan Ah Teck", "AhTeck@somewhere.com", 'm');
            authors[1] = new Author("Paul Tan", "Paul@nowhere.com", 'm');

            BookAuthors javaDummy = new BookAuthors("Java for Dummy", authors, 19.99, 99);

            try(FileWriter fw = new FileWriter(fichero)){
                gson.toJson(javaDummy,fw);
                System.out.println("Libro guardado");
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        if(operacion.equals("show")){
            try (FileReader reader = new FileReader(fichero)) {
                BookAuthors javaDummy = gson.fromJson(reader, BookAuthors.class);
                if(javaDummy != null){
                    System.out.println("Libro cargado: " + javaDummy.toString());
                }else
                    System.out.println("Libro nulo");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error al leer el fichero");
            }
        }
        if(!operacion.equals("init") && !operacion.equals("show")){
            System.out.println("Usa 'init' o 'show'");
        }
    }
}
/** Lo que ocurre es que el objeto que contiene sus atributos, sera puesto como atributo de la clase
 *  que lo contiene. Por lo tanto ocurre lo mismo que al imprimirlo en el main.
 */
