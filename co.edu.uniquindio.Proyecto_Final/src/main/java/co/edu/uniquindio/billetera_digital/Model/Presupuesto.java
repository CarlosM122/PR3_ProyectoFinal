package co.edu.uniquindio.billetera_digital.Model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Presupuesto implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nombre;
    private double montoTotalAsignado;
    private double montoGastado;
    private final int idPresupuesto;
    private static int numPresupuestos;
    private Categoria categoria;

    public Presupuesto() {
        idPresupuesto = ++numPresupuestos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getMontoTotalAsignado() {
        return montoTotalAsignado;
    }

    public void setMontoTotalAsignado(double montoTotalAsignado) {
        this.montoTotalAsignado = montoTotalAsignado;
    }

    public double getMontoGastado() {
        return montoGastado;
    }

    public void setMontoGastado(double montoGastado) {
        this.montoGastado = montoGastado;
    }

    public int getIdPresupuesto() {
        return idPresupuesto;
    }

    public static int getNumPresupuestos() {
        return numPresupuestos;
    }

    public static void setNumPresupuestos(int numPresupuestos) {
        Presupuesto.numPresupuestos = numPresupuestos;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}