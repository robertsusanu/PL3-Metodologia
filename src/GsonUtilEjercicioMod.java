import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GsonUtilEjercicioMod {

    public static <T> T cargarObjetoDesdeArchivo(String rutaArchivo, Class<T> clase) {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(rutaArchivo)) {
            return gson.fromJson(reader, clase);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    static class Usuario {
        String nombre;
        int edad;
        String correo;

        public Usuario(String nombre, int edad, String correo) {
            this.nombre = nombre;
            this.edad = edad;
            this.correo = correo;
        }
    }

    public static void main(String[] args) {
        GsonUtilEjemplo.Usuario usuarioCargado = cargarObjetoDesdeArchivo("usuario.json", GsonUtilEjemplo.Usuario.class);
        if (usuarioCargado != null) {
            System.out.println("Usuario cargado: " + usuarioCargado.nombre);
        }
    }
}

// Si se ha modificado la salida del programa y no ha guardado ningun otro fichero