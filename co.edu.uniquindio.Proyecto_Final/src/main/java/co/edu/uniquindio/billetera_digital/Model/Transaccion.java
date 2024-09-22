package co.edu.uniquindio.billetera_digital.Model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Transaccion {
    private LocalDate fecha;
    private String tipoTransaccion;
    private double monto;
    private String descripcionTransaccion;
    private final int idTransaccion;
    private static int cantidadTransacciones;
    private Cuenta cuentaOrigen;
    private Cuenta cuentaDestino;
    private Categoria categoria;

    public Transaccion() {
        idTransaccion = ++cantidadTransacciones;
    }
}