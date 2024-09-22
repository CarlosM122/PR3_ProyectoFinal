package co.edu.uniquindio.billetera_digital.Model;

import lombok.Data;

@Data
public class Categoria {
    private String nombre;
    private final int idCategoria;
    private String descripcion;
    private static int cantidadCategorias;

    public Categoria() {
        idCategoria = ++cantidadCategorias;
    }
}