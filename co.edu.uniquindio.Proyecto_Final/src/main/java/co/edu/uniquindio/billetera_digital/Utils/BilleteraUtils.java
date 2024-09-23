package co.edu.uniquindio.billetera_digital.Utils;

import co.edu.uniquindio.billetera_digital.Model.BilleteraDigital;
import co.edu.uniquindio.billetera_digital.Model.Cuenta;
import co.edu.uniquindio.billetera_digital.Model.Usuario;

public class BilleteraUtils {

    public static BilleteraDigital inicializarDatos() {
        BilleteraDigital billeteraDigital = new BilleteraDigital();

        Cuenta cuenta = new Cuenta();
        cuenta.setNumeroCuenta(14131313);
        cuenta.setTipoCuenta("Ahorro");
        cuenta.setNombreBanco("Bancolombia");

        Usuario usuario = new Usuario();
        usuario.setNombre("Samira");
        usuario.setIdUsuario("8716321");
        usuario.setCorreo("samira@gmail.com");
        usuario.setTelefono("300 671376");
        usuario.setDireccion("Calle 65 #89-09");
        usuario.getCuentasAsociadas().add(cuenta);

        billeteraDigital.getUsuarios().add(usuario);

        return billeteraDigital;
    }
}
