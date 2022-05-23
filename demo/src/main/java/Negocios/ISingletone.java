package Negocios;

import Clases.Pelicula;
import Negocios.DT.DTPelicula;
import Negocios.DT.DT_ListaPelicula;

public interface ISingletone {
    public abstract boolean altaPelicula(String nombre, String lanzamiento, String descripcion);
    public abstract boolean bajaPelicula(int id);
    public abstract DT_ListaPelicula listarPeliculas();
    public abstract DTPelicula buscarPelicula(int id);
}