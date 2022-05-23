package Negocios;

import Clases.Pelicula;
import Negocios.DT.DTPelicula;
import Negocios.DT.DT_ListaPelicula;

import javax.persistence.*;
import java.io.PrintWriter;
import java.util.List;

public class Manejador{
    private static Manejador instancia;

    @PersistenceContext
    EntityManager em;

    private Manejador(){

    }

    public static Manejador getinstance(){
        if (instancia==null)
            instancia = new Manejador();
        return instancia;
    }

    public static EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("cineCalidadPU");
        EntityManager manager = factory.createEntityManager();
        return manager;
    }

    public boolean existePelicula(String nombre) {
        for (int i = 0; i < getPeliculas().getPeliculas().size(); i++) {
            if (nombre.equalsIgnoreCase(getPeliculas().getPeliculas().get(i).getNombre())) {
                return true;
            }
        }
        return false;
    }

    public boolean addPelicula(Pelicula p) {

        EntityManager aux = Manejador.getEntityManager();
        EntityTransaction tx = aux.getTransaction();

        tx.begin();
        aux.persist(p);
        tx.commit();
        return true;

    }

    public boolean deletePelicula(int id) {
        return false;
    }

    public DT_ListaPelicula getPeliculas() {
        Query query = Manejador.getEntityManager().createQuery("select u from Pelicula u");
        List<Pelicula> aux = (List<Pelicula>) query.getResultList();
        DT_ListaPelicula result = new DT_ListaPelicula();

        aux.forEach(x -> {
            DTPelicula pe = new DTPelicula(x.getId(), x.getNombre(), x.getLanzamiento(), x.getDescripcion());
            result.getPeliculas().add(pe);
        });

        return result;
    }

    public DTPelicula getPelicula(int id) {
        return null;
    }
}