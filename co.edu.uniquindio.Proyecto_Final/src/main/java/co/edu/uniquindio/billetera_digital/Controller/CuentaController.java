package co.edu.uniquindio.billetera_digital.Controller;

import co.edu.uniquindio.billetera_digital.Factory.ModelFactory;
import co.edu.uniquindio.billetera_digital.Model.Cuenta;

import java.util.List;

public class CuentaController {
    static ModelFactory modelFactory;
    public CuentaController(){
        modelFactory = ModelFactory.getInstance();
    }
    public boolean crearcuenta(Cuenta cuenta) {
        return modelFactory.crearCuenta(cuenta);
    }

    public List<Cuenta> obtenerCuentas() {
        return modelFactory.obtenerCuentas();
    }

    public boolean actualizarCuenta(Cuenta cuenta) {
        return modelFactory.actualizarCuenta(cuenta);
    }

    public boolean eliminarCuenta(String idCuenta) {
        return modelFactory.eliminarCuenta(idCuenta);
    }
}
