package Negocios;
import Clases.Pelicula;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
 
@Stateless
public class PeliculaSessionBean implements PeliculaSessionBeanRemote {

   public String h="hola";
   private List<Pelicula> Peliculas= new ArrayList<Pelicula>();


   public PeliculaSessionBean() {
      Peliculas.add(new Pelicula("10/9/2003","La casa de Cera","Terror"));
      Peliculas.add(new Pelicula("7/4/2001","Harry Potter y la camara de los Secretos","Fantasia"));
      Peliculas.add(new Pelicula("10/10/2012","Los Vengadores","Ciencia Ficcion"));
   }

   @Override
   public void addPeliculas(String lanzamiento, String nombre, String descripcion){
      int id;
      if (Peliculas==null){
         Peliculas = new ArrayList<Pelicula>();
         id =0;
      }else{id= Peliculas.size();}
      Peliculas.add(new Pelicula (lanzamiento, nombre, descripcion));
   }
   @Override
   public Pelicula getPelicula(int id){
      return Peliculas.get(id);
   }
   @Override
   public List<Pelicula> getPeliculas(){
      return Peliculas;
   }

   @Override
   public String toString() {
      String ret="Peliculas: \n";
      if (Peliculas!= null){
         for (int i=0; i< Peliculas.size();i++){
            ret = ret + Peliculas.get(i).toString();
            ret = ret +"\n";
         }
      }else{ret = ret + "VACIO";}
      return ret;
   }
}
