package co.edu.uniquindio.billetera_digital.Model;

import lombok.Data;

public class Cuenta {
    private String nombreBanco;
    private int numeroCuenta;
    private String tipoCuenta;
    private final int idCuenta;
    private static int contadorCuentas;

    public Cuenta() {
        idCuenta= ++contadorCuentas;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public static int getContadorCuentas() {
        return contadorCuentas;
    }

    public static void setContadorCuentas(int contadorCuentas) {
        Cuenta.contadorCuentas = contadorCuentas;
    }
}
