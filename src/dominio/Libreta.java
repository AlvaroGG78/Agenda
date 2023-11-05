package dominio;
import java.util.*;
import java.io.Serializable;

public class Libreta implements Serializable{
    private String nombre;
    private ArrayList<Contacto> contactos;
 
    public Libreta() {
        contactos=new ArrayList<Contacto>();
    }
    public Libreta add(Contacto contacto){
        contactos.add(contacto);
        return this;
    }

    public Libreta borrar(Contacto contacto){
        contactos.remove(contacto);
        return this;
    }

    public int getNumeroDeTelefono(){
        int ntelefono=0;
        for(Contacto contacto:contactos){
            ntelefono+=contacto.getNumeroDeTelefono();
        }
        return ntelefono;
    }
    public int size(){
        return contactos.size();
    }
    public Contacto getContacto(int i){
        return contactos.get(i);
    }
    public String toString(){
        return "Libreta: "+nombre+" Número total de contactos: "+size() +" contactos\n"+contactos.toString()+"\n";
    }
    public String getNombre() {
        return nombre;
    }
    public ArrayList<Contacto> getContactos() {
        return Contacto.getNombre;
    }
 }
