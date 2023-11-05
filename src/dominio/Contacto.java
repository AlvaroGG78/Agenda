package dominio;
import java.io.Serializable;
import java.util.ArrayList;

public class Contacto implements Serializable{
    public static ArrayList<Contacto> getNombre;
    private String nombre;
    private int numeroDeTelefono;
 
    public Contacto(String nombre_,int numeroDeTelefono_) {
        nombre=nombre_;
        numeroDeTelefono=numeroDeTelefono_;
    }

    public Contacto(String nombre_){
        nombre=nombre_;
    }

    public String toString(){
        return "Contacto: "+ nombre+". Número de teléfono: "+numeroDeTelefono+"\n";
    }
 
    public int getNumeroDeTelefono() {
        return numeroDeTelefono;
    }
 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumero(int numero) {
        this.numeroDeTelefono = numero;
    }

    public boolean equals (Object o){
        Contacto contacto = (Contacto)o;
        return nombre.equals(contacto.nombre);
    }
}

