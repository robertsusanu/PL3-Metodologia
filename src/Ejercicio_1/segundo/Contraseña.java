package Ejercicio_1.segundo;

public class Contraseña {
    private String contraseña;

    public Contraseña(String con) {
        this.contraseña = con;
    }

    public static void contraseña(String contra) throws ContraseñaExcepción {
        if (contra != "9876matecompu#") {
            throw (new ContraseñaExcepción(contra));
        }
    }

    public static void main(String[] args) {
        try {
            contraseña("9876matecompu#");
            contraseña("Hola Antonio!");
        } catch (ContraseñaExcepción ex) {
            System.out.println("ContraseñaExcepción encontrada: " + ex.getMessage());
        } finally {
            System.out.println("¡Enhorabuena!¡Has sabido escribir una contraseña!");
        }
    }

    @Override
    public String toString() {
        return "La contraseña es: " + contraseña;
    }
}
