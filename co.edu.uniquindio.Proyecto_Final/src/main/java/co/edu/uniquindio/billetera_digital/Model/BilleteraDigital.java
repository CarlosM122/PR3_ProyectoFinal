package co.edu.uniquindio.billetera_digital.Model;

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

    public boolean crearUsuario(Usuario usuario) {
        Usuario usuarioEncontrado = encontrarUsuario(usuario.getIdUsuario());
        if (usuarioEncontrado == null) {
            usuarios.add(usuario);
            return true;
        }else {
            return false;
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
}