package interfaz;
import dominio.*;
import java.io.*;
import java.util.*;

public class Interfaz {
    private  ArrayList<Libreta> l;
    private  Scanner sc = new Scanner(System.in);
    private Libreta libreta = new Libreta();
    public Interfaz(){
        File f=new File("libreta.dat");
        try {
            ObjectInputStream ois=new ObjectInputStream(new FileInputStream(f));
            l=(ArrayList<Libreta>)ois.readObject();
            ois.close();
        } catch (Exception e) {
            l=new ArrayList<Libreta>();
        }
    }
 
    public void grabar(){
        File f=new File("libreta.dat");
        try {
            ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(f));
            oos.writeObject(libreta);
            oos.close();
        } catch (Exception e) {
            System.out.print("Error al grabar");
        }
    }

    public void borrarContacto (){
        System.out.println ("Introduce el nombre del contacto que quieras borrar: ");
        String nombre = sc.nextLine();
        libreta.borrar(new Contacto(nombre));
    }

    public void editarContacto (){
        System.out.println("Introduce el nombre del contacto que deseas editar:");
        String contactoViejo = sc.nextLine();
        libreta.borrar(new Contacto(contactoViejo));
        aniadirContactoEdit();
        } 

    public  boolean procesarPeticion (String peticion){
        String [] p=peticion.split(" ");
        if (p.length==1)
            /*if  (p[0].equals("addLibreta"))
               aniadirLibreta();*/
            if (p[0].equals("addContacto"))
               aniadirContacto();
            else if (p[0].equals("borrar"))
                borrarContacto();
            else if (p[0].equals("editarContacto"))
                editarContacto();
                
            /*else if (p[0].equals("read"))
                leer();*/
            else if (p[0].equals("list"))
                    System.out.println (libreta);
            else if (p[0].equals("guardar"))
                    grabar();
            else if (p[0].equals("help"))
                    System.out.println("Introduzca una de las siguientes peticiones: \n addContacto: añadir Contacto\n borrar: Borrar contacto\n editarContacto: editar contacto\n list: Listar el contenido\n read: Lectura inicial\n exit: Salir\n");
            else if (p[0].equals("exit")){
                    grabar();
                    return false; //no se procesarán más peticiónes
            }
            else {
                    System.out.println("Petición erronea");
                    procesarPeticion("help");
                }
        else {
            System.out.println("Petición erronea");
            procesarPeticion("help");
        }
        return true; //en todos los casos debe seguir pidiendo y procesando peticiones
    }
 
    public void aniadirContacto(){
        System.out.print("Introduzca el nombre del contacto: ");
        String nombre=sc.nextLine();
        System.out.print("Introduzca el número de teléfono del contacto: ");
        int numeroDeTelefono=sc.nextInt();
        Contacto contacto=new Contacto(nombre, numeroDeTelefono);
        libreta.add(contacto);
    }

    public void aniadirContactoEdit(){
        System.out.print("Introduzca el nuevo nombre del contacto: ");
        String nuevoNombre=sc.nextLine();
        System.out.print("Introduzca el nuevo número de teléfono del contacto: ");
        int nuevoNumeroDeTelefono=sc.nextInt();
        Contacto nuevoContacto=new Contacto(nuevoNombre, nuevoNumeroDeTelefono);
        libreta.add(nuevoContacto);
    }
    
    public String leerPeticion(){
        System.out.print("?>");
        String cadena = sc.nextLine();
        return cadena;
    }
}