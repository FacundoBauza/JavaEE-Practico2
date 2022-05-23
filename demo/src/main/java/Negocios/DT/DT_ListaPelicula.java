package Negocios.DT;

import java.util.ArrayList;
import java.util.List;

//@XmlRootElement(name="DtListPeliculas")
//@XmlAccessorType(XmlAccessType.FIELD)
public class DT_ListaPelicula
{

    List<DTPelicula> peliculas;

    public DT_ListaPelicula() {
        peliculas = new ArrayList<>();
    }

    public List<DTPelicula> getPeliculas() {
        return this.peliculas;
    }

    public void setPeliculas(List<DTPelicula> peliculas) {
        this.peliculas = peliculas;
    }
}