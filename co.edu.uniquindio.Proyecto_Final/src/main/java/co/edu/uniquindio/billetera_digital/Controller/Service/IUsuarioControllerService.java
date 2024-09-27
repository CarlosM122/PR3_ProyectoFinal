package co.edu.uniquindio.billetera_digital.Controller.Service;

import co.edu.uniquindio.billetera_digital.Model.Usuario;

import java.util.List;

public interface IUsuarioControllerService {

    public List<Usuario> obtenerUsuarios();

    public boolean crearUsuario(Usuario usuario);

    public boolean actualizarUsuario(Usuario usuario);

    public boolean eliminarUsuario(String cedula);
}
