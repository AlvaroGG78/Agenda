package aplicacion;
import dominio.*;
import interfaz.Interfaz;
import java.util.ArrayList;
public class Principal {
    public static void main(String[] args) {
        Interfaz interfaz=new Interfaz();
        String peticion;
        interfaz.procesarPeticion("help");// para que muestre la ayuda al principio
        do {
            peticion=interfaz.leerPeticion();
        } while (interfaz.procesarPeticion(peticion));
    }
}