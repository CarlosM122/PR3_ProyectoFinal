package co.edu.uniquindio.billetera_digital.Model;

import co.edu.uniquindio.billetera_digital.Exceptions.UsuarioException;

import java.util.ArrayList;
import java.util.List;

public class BilleteraDigital {

    private List<Usuario> usuarios = new ArrayList<>();

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public boolean crearUsuario(Usuario usuario) throws UsuarioException {
        Usuario usuarioEncontrado = encontrarUsuario(usuario.getIdUsuario());
        if (usuarioEncontrado == null) {
            usuarios.add(usuario);
            return true;
        }else {
            throw new UsuarioException("Usuario con cedula: "+ usuario.getIdUsuario()+ " ya existe");
        }
    }

    private Usuario encontrarUsuario(String idUsuario) {
        Usuario usuarioEncontrado = null;
        for (Usuario usuario : usuarios) {
            if (usuario.getIdUsuario().equals(idUsuario)) {
                usuarioEncontrado = usuario;
                break;
            }else {
                usuarioEncontrado = null;
            }
        }
        return usuarioEncontrado;
    }

    public boolean eliminarUsuario(String cedula) throws UsuarioException {
        boolean eliminado = false;
        for(Usuario usuario:usuarios){
            if (usuario.getIdUsuario().equals(cedula)) {
                usuarios.remove(usuario);
                eliminado = true;
                break;
            }
             else{
                 throw new UsuarioException("Usuario con cedula: "+ cedula+ " no existe");
            }
        }
        return eliminado;
    }

    public boolean actualizarUsuario(Usuario usuario) throws UsuarioException {
        boolean actualizado = false;
        for (Usuario usuario1 : usuarios) {
            if (usuario.getIdUsuario().equals(usuario1.getIdUsuario())) {
                usuarios.set(usuarios.indexOf(usuario1), usuario);
                actualizado = true;
                break;
            }else {
                throw new UsuarioException("Usuario con cedula: "+ usuario.getIdUsuario()+ " no existe");
            }
        }
        return actualizado;
    }
}