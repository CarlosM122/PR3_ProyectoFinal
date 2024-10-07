package co.edu.uniquindio.billetera_digital.Model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nombre;
    private final int idCategoria;
    private String descripcion;
    private static int cantidadCategorias;

    public Categoria() {
        idCategoria = ++cantidadCategorias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public static int getCantidadCategorias() {
        return cantidadCategorias;
    }

    public static void setCantidadCategorias(int cantidadCategorias) {
        Categoria.cantidadCategorias = cantidadCategorias;
    }
}