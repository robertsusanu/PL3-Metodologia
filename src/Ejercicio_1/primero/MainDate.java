package Ejercicio_1.primero;

import Ejercicio_1.segundo.Contraseña;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainDate {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < args.length; i++)
            sb.append("Argumento " + i + ": " + args[i] + "\n");
        System.out.println("Argumentos: \n" + sb);


        String operacion = args[0];
        String fichero = args[1];

        Gson gson = new Gson();

        if(operacion.equals("init")){
            Date fecha = new Date(5,8,2000);
            try(FileWriter fw = new FileWriter(fichero)){
                gson.toJson(fecha,fw);
                System.out.println("Fecha guardada");
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        if(operacion.equals("show")){
            try (FileReader reader = new FileReader(fichero)) {
                Date fecha = gson.fromJson(reader, Date.class);
                if(fecha != null){
                    System.out.println("Fecha cargada: " + fecha.toString());
                }else
                    System.out.println("Fecha nula");
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
