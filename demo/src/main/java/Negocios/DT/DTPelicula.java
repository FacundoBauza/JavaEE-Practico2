package Negocios.DT;

public class DTPelicula{
    private int Id;
    private String Lanzamiento;
    private String Nombre;
    private String Descripcion;

    public DTPelicula() {
    }

    public DTPelicula(int id, String lanzamiento, String nombre, String descripcion) {
        Id = id;
        Lanzamiento = lanzamiento;
        Nombre = nombre;
        Descripcion = descripcion;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getLanzamiento() {
        return Lanzamiento;
    }

    public void setLanzamiento(String lanzamiento) {
        Lanzamiento = lanzamiento;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
}