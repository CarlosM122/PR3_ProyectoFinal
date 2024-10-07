package co.edu.uniquindio.billetera_digital.Model;

import co.edu.uniquindio.billetera_digital.Exceptions.UsuarioException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BilleteraDigital implements Serializable {

    private static final long serialVersionUID = 1L;
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Cuenta> cuentas = new ArrayList<>();
    private ArrayList<Transaccion> transacciones = new ArrayList<>();

    public BilleteraDigital() {
    }
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(ArrayList<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public ArrayList<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(ArrayList<Transaccion> transacciones) {
        this.transacciones = transacciones;
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
        }
        if (!eliminado) {
            throw new UsuarioException("Usuario con cedula: "+ cedula+ " no existe");
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
            }
        }
        if(!actualizado){
                throw new UsuarioException("Usuario con cedula: "+ usuario.getIdUsuario()+ " no existe");
        }
        return actualizado;
    }
}