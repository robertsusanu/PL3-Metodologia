package Ejercicio_1.segundo;

import Ejercicio_1.primero.Employee;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainContraseña {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < args.length; i++)
            sb.append("Argumento " + i + ": " + args[i] + "\n");
        System.out.println("Argumentos: \n" + sb);


        String operacion = args[0];
        String fichero = args[1];

        Gson gson = new Gson();

        if(operacion.equals("init")){
            Contraseña contraseña = new Contraseña("awe1234");
            try(FileWriter fw = new FileWriter(fichero)){
                gson.toJson(contraseña,fw);
                System.out.println("Contraseña guardada");
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        if(operacion.equals("show")){
            try (FileReader reader = new FileReader(fichero)) {
                Contraseña contraseña = gson.fromJson(reader, Contraseña.class);
                if(contraseña != null){
                    System.out.println("Contraseña cargada: " + contraseña.toString());
                }else
                    System.out.println("Contraseña nula");
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
