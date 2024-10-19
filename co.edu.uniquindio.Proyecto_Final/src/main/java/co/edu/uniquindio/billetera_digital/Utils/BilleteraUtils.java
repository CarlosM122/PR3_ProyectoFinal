package co.edu.uniquindio.billetera_digital.Utils;

import co.edu.uniquindio.billetera_digital.Model.*;

import java.time.LocalDate;

public class BilleteraUtils {

    public static BilleteraDigital inicializarDatos() {
        BilleteraDigital billeteraDigital = new BilleteraDigital();

        Cuenta cuenta = new Cuenta();
        cuenta.setNumeroCuenta(14131313);
        cuenta.setTipoCuenta("Ahorro");
        cuenta.setNombreBanco("Bancolombia");

        billeteraDigital.getCuentas().add(cuenta);

        Cuenta cuenta2 = new Cuenta();
        cuenta2.setNumeroCuenta(15624238);
        cuenta2.setTipoCuenta("Ahorro");
        cuenta2.setNombreBanco("Bancolombia");

        billeteraDigital.getCuentas().add(cuenta2);

        Usuario usuario = new Usuario();
        usuario.setNombre("Luisa");
        usuario.setIdUsuario("8716321");
        usuario.setCorreo("samira@gmail.com");
        usuario.setTelefono("300 671376");
        usuario.setDireccion("Calle 65 #89-09");
        usuario.getCuentasAsociadas().add(cuenta);

        billeteraDigital.getUsuarios().add(usuario);

        Categoria categoria = new Categoria();
        categoria.setNombre("Deposito");
        categoria.setDescripcion("");

        Transaccion transaccion = new Transaccion();
        transaccion.setCategoria(categoria);
        transaccion.setTipoTransaccion("Deposito");
        transaccion.setFecha(LocalDate.of(2020, 1, 1));
        transaccion.setMonto(15000.00);
        transaccion.setCuentaOrigen(cuenta);
        transaccion.setCuentaDestino(cuenta2);

        billeteraDigital.getTransacciones().add(transaccion);
        return billeteraDigital;
    }
}
