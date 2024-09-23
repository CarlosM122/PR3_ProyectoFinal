package co.edu.uniquindio.billetera_digital.Factory;

import co.edu.uniquindio.billetera_digital.Model.BilleteraDigital;
import co.edu.uniquindio.billetera_digital.Model.Usuario;
import co.edu.uniquindio.billetera_digital.Utils.BilleteraUtils;

import java.util.List;

public class ModelFactory {

    private static ModelFactory instance;
    BilleteraDigital billeteraDigital;

    public static ModelFactory getInstance() {
        if (instance == null) {
            instance = new ModelFactory();
        }
        return instance;
    }

    private ModelFactory() {
        billeteraDigital = BilleteraUtils.inicializarDatos();
    }

    public List<Usuario> obtenerUsuarios() {
        return billeteraDigital.getUsuarios();
    }

    public boolean crearUsuario(Usuario usuario) {
        return billeteraDigital.crearUsuario(usuario);
    }
}
