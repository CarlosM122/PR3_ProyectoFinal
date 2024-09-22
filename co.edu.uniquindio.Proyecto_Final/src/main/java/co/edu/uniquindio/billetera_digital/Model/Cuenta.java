package co.edu.uniquindio.billetera_digital.Model;

import lombok.Data;

@Data
public class Cuenta {
    private String nombreBanco;
    private int numeroCuenta;
    private String tipoCuenta;
    private final int idCuenta;
    private static int contadorCuentas;

    public Cuenta() {
        idCuenta= ++contadorCuentas;
    }
}
