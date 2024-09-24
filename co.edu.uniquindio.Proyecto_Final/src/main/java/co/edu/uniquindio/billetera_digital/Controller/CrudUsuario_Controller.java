package co.edu.uniquindio.billetera_digital.Controller;

import co.edu.uniquindio.billetera_digital.Factory.ModelFactory;
import co.edu.uniquindio.billetera_digital.Model.Usuario;
import javafx.collections.ObservableList;

import java.util.List;

public class CrudUsuario_Controller {
    static ModelFactory modelFactory;

    public CrudUsuario_Controller() {
        modelFactory = ModelFactory.getInstance();
    }

    public List<Usuario> obtenerUsuarios() {
        return modelFactory.obtenerUsuarios();
    }

    public boolean crearUsuario(Usuario usuario) {
        return modelFactory.crearUsuario(usuario);
    }

    public boolean eliminarUsuario(String cedula) {
        return modelFactory.eliminarUsuario(cedula);
    }

    public boolean actualizarUsuario(Usuario usuario) {
        return modelFactory.actualizarUsuario(usuario);
    }
}
