package EjercicioCompleto;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainPrincipal {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i<args.length;i++)
            sb.append("Argumento " + i + ": " + args[i] + "\n");
        System.out.println("Argumentos: \n" + sb);

        /*
        El resultado que obtendo de esto es:
            Argumentos:


         */

        /*
        ¿Qué obtienes? ¿Por qué existe esa diferencia?

         C:\Users\rober\IdeaProjects\Metodologia-PL3-Robert\out\artifacts\Metodologia_PL3_Robert_jar>java -jar Metodologia-PL3-Robert.jar “Hola Mundo Cruel”
        Argumentos:
        Argumento 0: ?Hola
        Argumento 1: Mundo
        Argumento 2: Cruel?

        Se obtiene esa diferencia porque al indicar argumentos,
        se añaden en el main. La interrogacion se pone porque no
        reconoce las comillas.
         */


        // Ahora comienzo con el programa de verdad

        String operacion = args[0];
        String fichero = args[1];

        Gson gson = new Gson();

        if(operacion == "init"){
            Alumno alumno = new Alumno("Felix", 28);
            try(FileWriter fw = new FileWriter(fichero)){
                gson.toJson(alumno,fw);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        if(operacion == "show"){
            try (FileReader reader = new FileReader(fichero)) {
                Alumno alumno = gson.fromJson(reader,Alumno.class);
                if(alumno != null){
                    System.out.println("Alumno cargado: " + alumno.toString());
                }else
                    System.out.println("Alumno nulo");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error al leer el fichero");
            }
        }
        if(operacion != "init" || operacion != "show"){
            System.out.println("Usa 'init' o 'show'");
        }
    }
}
