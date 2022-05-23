package Negocios;

import Clases.Pelicula;
import Negocios.DT.DTPelicula;
import Negocios.DT.DT_ListaPelicula;

public class Singletone implements ISingletone{

    public Singletone(){}

    Manejador m = Manejador.getinstance();

    @Override
    public boolean altaPelicula(String nombre, String lanzamiento, String descripcion)
    {
        Pelicula p = new Pelicula(nombre, lanzamiento, descripcion);
        return m.addPelicula(p);
    }

    @Override
    public boolean bajaPelicula(int id)
    {
        return m.deletePelicula(id);
    }

    @Override
    public DT_ListaPelicula listarPeliculas()
    {
        return m.getPeliculas();
    }

    @Override
    public DTPelicula buscarPelicula(int id)
    {
        return m.getPelicula(id);
    }
}