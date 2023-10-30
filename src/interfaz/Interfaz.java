package interfaz;
import dominio.*;
import java.io.*;
import java.util.*;

public class Interfaz {
    private  ArrayList<Libreta> l;
    private  Scanner sc = new Scanner(System.in);
    public Interfaz(){
        File f=new File("libretas.dat");
        try {
            ObjectInputStream ois=new ObjectInputStream(new FileInputStream(f));
            l=(ArrayList<Libreta>)ois.readObject();
            ois.close();
        } catch (Exception e) {
            l=new ArrayList<Libreta>();
        }
    }
 
    public void grabar(){
        File f=new File("libretas.dat");
        try {
            ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(f));
            oos.writeObject(l);
            oos.close();
        } catch (Exception e) {
            System.out.print("Error al grabar");
        }
    }
    public  boolean procesarPeticion (String peticion){
        String [] p=peticion.split(" ");
        if (p.length==1)
            if  (p[0].equals("addLibreta"))
               aniadirLibreta();
            else if (p[0].equals("addContacto"))
               aniadirContacto();
            else if (p[0].equals("read"))
                leer();
            else if (p[0].equals("list"))
                    System.out.println (l);
            else if (p[0].equals("help"))
                    System.out.println("Introduzca una de las siguientes peticiones: \n addLibreta: añadir Libreta\n addContacto: añadir Contacto\n list: Listar el contenido\n read: Lectura inicial\n exit: Salir\n");
            else if (p[0].equals("exit")){
                    grabar();
                    return false;//no se procesarán más peticiónes
            }
            else {
                    System.out.println("Petición erronea");
                    procesarPeticion("help");
                }
        else {
            System.out.println("Petición erronea");
            procesarPeticion("help");
        }
        return true;//en todos los casos debe seguir pidiendo y procesando peticiones
    }
    public void aniadirLibreta(){
        System.out.print("Introduzca el nombre de la libreta: ");
        String nombre=sc.nextLine();
        Libreta lib=new Libreta(nombre);
        l.add(lib);
    }
 
    /*public  void aniadirMunicipio(){
        System.out.print("Introduzca el nombre del municipio: ");
        String nombre=sc.nextLine();
        Municipio m=new Municipio(nombre);
        for (int i=0;i<l.size();i++)
            System.out.println(i+": " + l.get(i).getNombre());
        System.out.print("Introduzca el número de la provincia: ");
        int i=sc.nextInt();
        sc.nextLine();
        l.get(i).add(m);
    }*/
 
    public void aniadirContacto(){
        System.out.print("Introduzca el nombre del contacto: ");
        String nombre=sc.nextLine();
        System.out.print("Introduzca lel número de teléfono del contacto: ");
        int numeroDeTelefono=sc.nextInt();
        Contacto contacto=new Contacto(nombre, numeroDeTelefono);
        for (int i=0;i<l.size();i++)
            System.out.println(i+": " + l.get(i).getNombre());
        System.out.print("Introduzca el número de la libreta: ");
        int i=sc.nextInt();
        sc.nextLine();
        for (int j=0;j<l.get(i).size();j++)
            System.out.println(j+": " + l.get(i).getContacto(j).getNombre());
            l.get(i).add(contacto);
        
            /*System.out.print("Introduzca el número del municipio: ");
        int j=sc.nextInt();
        sc.nextLine();
        l.get(i).getMunicipio(j).add(localidad);*/
    }
    public String leerPeticion(){
        System.out.print("?>");
        String cadena = sc.nextLine();
        return cadena;
    }
 
    public void leer(){
            String nombreLib, nombreCon;
            do {
            System.out.print("Introduce el nombre de la libreta (<enter> para finalizar): ");
            nombreLib=sc.nextLine();
            if(!nombreLib.equals("")){
                Libreta libreta=new Libreta(nombreLib);
                do {
                    System.out.print("Introduce el nombre del contacto (<enter> para finalizar): ");
                    nombreCon=sc.nextLine();
                    if(!nombreCon.equals("")){
                        System.out.print("Introduce el número de teléfono del contacto): ");
                        int nTelefono=sc.nextInt();
                        sc.nextLine();
                        Contacto contacto=new Contacto(nombreCon,nTelefono);
                        libreta.add(contacto);
                    }
                } while (!nombreCon.equals(""));
                        l.add(libreta);
            } 
     } while (!nombreLib.equals(""));
    }  
}