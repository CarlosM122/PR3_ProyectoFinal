package co.edu.uniquindio.billetera_digital.Model;

import lombok.Data;

@Data
public class Presupuesto {
    private String nombre;
    private double montoTotalAsignado;
    private double montoGastado;
    private final int idPresupuesto;
    private static int numPresupuestos;
    private Categoria categoria;

    public Presupuesto() {
        idPresupuesto = ++numPresupuestos;
    }
}