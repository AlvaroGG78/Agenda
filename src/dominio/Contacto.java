package dominio;
import java.io.Serializable;

public class Contacto implements Serializable{
    private String nombre;
    private int numeroDeTelefono;
 
    public Contacto(String nombre_,int numeroDeTelefono_) {
        nombre=nombre_;
        numeroDeTelefono=numeroDeTelefono_;
    }
    public String toString(){
        return "Contacto: "+ nombre+" Número de teléfono: "+numeroDeTelefono+"\n";
    }
 
    public int getNumeroDeTelefono() {
        return numeroDeTelefono;
    }
 
    public String getNombre() {
        return nombre;
    }
}

