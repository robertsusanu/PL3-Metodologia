package Ejercicio_1.primero;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainEmployee {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < args.length; i++)
            sb.append("Argumento " + i + ": " + args[i] + "\n");
        System.out.println("Argumentos: \n" + sb);


        String operacion = args[0];
        String fichero = args[1];

        Gson gson = new Gson();

        if(operacion.equals("init")){
            Employee empleado = new Employee(8, "Pedro", "Fuentes", 2000);
            try(FileWriter fw = new FileWriter(fichero)){
                gson.toJson(empleado,fw);
                System.out.println("Empleado guardado");
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        if(operacion.equals("show")){
            try (FileReader reader = new FileReader(fichero)) {
                Employee empleado = gson.fromJson(reader, Employee.class);
                if(empleado != null){
                    System.out.println("Empleado cargado: " + empleado.toString());
                }else
                    System.out.println("Empleado nulo");
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
