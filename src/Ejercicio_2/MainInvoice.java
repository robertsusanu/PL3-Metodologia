package Ejercicio_2;

import Ejercicio_1.primero.Employee;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainInvoice {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < args.length; i++)
            sb.append("Argumento " + i + ": " + args[i] + "\n");
        System.out.println("Argumentos: \n" + sb);


        String operacion = args[0];
        String fichero = args[1];

        Gson gson = new Gson();

        if(operacion.equals("init")){
            Customer cliente = new Customer(12, "Pedro", 20);
            Invoice recibo = new Invoice(8, cliente, 200);
            try(FileWriter fw = new FileWriter(fichero)){
                gson.toJson(recibo,fw);
                System.out.println("Recibo guardado");
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        if(operacion.equals("show")){
            try (FileReader reader = new FileReader(fichero)) {
                Invoice recibo = gson.fromJson(reader, Invoice.class);
                if(recibo != null){
                    System.out.println("Recibo cargado: " + recibo.toString());
                }else
                    System.out.println("Recibo nulo");
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
