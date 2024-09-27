package co.edu.uniquindio.billetera_digital.Factory;

import co.edu.uniquindio.billetera_digital.Exceptions.UsuarioException;
import co.edu.uniquindio.billetera_digital.Model.BilleteraDigital;
import co.edu.uniquindio.billetera_digital.Model.Usuario;
import co.edu.uniquindio.billetera_digital.Utils.BilleteraUtils;

import java.util.List;

public class ModelFactory {

    private static ModelFactory instance;
    BilleteraDigital billeteraDigital;

    private static class SingletonHolder {
        private final static ModelFactory eINSTANCE = new ModelFactory();
    }

    public static ModelFactory getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    private ModelFactory() {
        billeteraDigital = BilleteraUtils.inicializarDatos();
    }

    public List<Usuario> obtenerUsuarios() {
        return billeteraDigital.getUsuarios();
    }

    public boolean crearUsuario(Usuario usuario) {
        try {
            return billeteraDigital.crearUsuario(usuario);
        }catch (UsuarioException e){
            System.out.printf(e.getMessage());
            return false;
        }
    }

    public boolean eliminarUsuario(String cedula) {
        try {
            return billeteraDigital.eliminarUsuario(cedula);
        }catch (UsuarioException e){
            System.out.printf(e.getMessage());
            return false;
        }
    }

    public boolean actualizarUsuario(Usuario usuario) {
        try {
            return billeteraDigital.actualizarUsuario(usuario);
        }catch (UsuarioException e){
            System.out.printf(e.getMessage());
            return false;
        }
    }
}
