package Ejercicio_1.primero;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainAuthor {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < args.length; i++)
            sb.append("Argumento " + i + ": " + args[i] + "\n");
        System.out.println("Argumentos: \n" + sb);


        String operacion = args[0];
        String fichero = args[1];

        Gson gson = new Gson();

        if(operacion.equals("init")){
            Author autor = new Author("Juan Carlos", "Carlos@gmail.com", 'm');
            try(FileWriter fw = new FileWriter(fichero)){
                gson.toJson(autor,fw);
                System.out.println("Autor guardado");
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        if(operacion.equals("show")){
            try (FileReader reader = new FileReader(fichero)) {
                Author autor = gson.fromJson(reader, Author.class);
                if(autor != null){
                    System.out.println("Autor cargado: " + autor.toString());
                }else
                    System.out.println("Autor nulo");
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
