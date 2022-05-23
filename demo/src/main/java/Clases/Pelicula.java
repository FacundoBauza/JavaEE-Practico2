package Clases;

import javax.persistence.*;

@Entity
@Table(name="Pelicula")
//@XmlAccessorType(XmlAccessType.FIELD)
public class Pelicula {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int Id;
    private String Lanzamiento;
    private String Nombre;
    private String Descripcion;

    public Pelicula() {}

    public Pelicula(String nombre, String lanzamiento, String descripcion) {
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

    @Override
    public String toString() {
        return  "Id=" + Id +"| Lanzamiento=" + Lanzamiento +"| Nombre='" + Nombre + "| Descripcion='" + Descripcion;
    }
}