package Negocios;

import java.awt.*;
import java.util.Date;
import java.util.Scanner;

public class Consola {
    static PeliculaSessionBean consola = new PeliculaSessionBean();
    static Scanner teclado = new Scanner(System.in);
    public static void AgregarPelicula(){
        System.out.print("Ingrese el nombre: ");
        String nom = "";
        do{
            nom = teclado.next();
        }while(nom=="");
        System.out.println("Nombre ingresado: "+nom);
        System.out.print("Ingrese el nombre: ");
        String det = "";
        do{
            det = teclado.next();
        }while (det=="");
        System.out.println("Detalle ingresado: "+det);
        System.out.print("Ingrese el fecha de lanzamiento dd/mm/aa: ");
        String lan = "";
        do{
            lan = teclado.next();
        }while(lan=="");
        System.out.println("Lazamiento ingresado: "+lan);
        consola.addPeliculas(lan,nom,det);
    }

    public static void listarPeliculas(){System.out.print(consola.toString());}

    public static void Menu(){
        System.out.println("      MENU");
        System.out.println("1) Agregar Pelicula");
        System.out.println("2) Listar Pelicula");
        System.out.println("0) Salir");
        System.out.print("Opcion: ");
        int op=-1;
        op = teclado.nextInt();
        switch (op){
            case 1:
                AgregarPelicula();
                break;
            case 2:
                listarPeliculas();
                break;
            case 0:
                System.out.println("Gracias por preferirnos");
                System.exit(0);
                break;
            default:
                System.out.println("OPCION INCORRECTA");
                Menu();
                break;
        }
    }
    public static void main (String [ ] args){
        while(true){
            Menu();
        }
    }
}