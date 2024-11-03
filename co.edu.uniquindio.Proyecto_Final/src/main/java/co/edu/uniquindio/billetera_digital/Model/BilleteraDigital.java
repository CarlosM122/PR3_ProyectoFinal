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
    private ArrayList<Presupuesto> presupuestos = new ArrayList<>();

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

    public ArrayList<Presupuesto> getPresupuestos() {
        return presupuestos;
    }

    public void setPresupuestos(ArrayList<Presupuesto> presupuestos) {
        this.presupuestos = presupuestos;
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

    public boolean crearCuenta(Cuenta cuenta) {
        Cuenta cuentaEncontrado = encontrarCuenta(cuenta.getIdCuenta());
        if (cuentaEncontrado == null) {
            cuentas.add(cuenta);
            return true;
        }else{
            return false;
        }
    }

    private Cuenta encontrarCuenta(int idCuenta) {
        Cuenta cuentaEncontrada = null;
        for(Cuenta cuenta: cuentas){
            if (cuenta.getIdCuenta() == idCuenta) {
                cuentaEncontrada = cuenta;
                break;
            }else{
                cuentaEncontrada = null;
            }
        }return cuentaEncontrada;
    }

    public boolean actualizarCuenta(Cuenta cuenta) {
        boolean actualizado = false;
        for (Cuenta cuenta1 : cuentas) {
            if(cuenta.getIdCuenta() == cuenta1.getIdCuenta()){
                cuentas.set(cuentas.indexOf(cuenta1), cuenta);
                actualizado = true;
                break;
            }else{
                actualizado = false;
            }
        }
        return actualizado;
    }

    public boolean eliminarCuenta(String idCuenta) {
        boolean eliminado = false;
        int idCuentaInt = Integer.parseInt(idCuenta);  // Convertir String a int
        for (Cuenta cuenta : cuentas) {
            if (cuenta.getIdCuenta() == idCuentaInt) {  // Usar == para comparar int
                cuentas.remove(cuenta);
                eliminado = true;
                break;
            }else {
                eliminado = false;
            }
        }
        return eliminado;
    }

    public boolean CrearPresupuesto(Presupuesto presupuesto) {
        Presupuesto presupuestoEncontrado = encontrarPresupuesto(presupuesto.getIdPresupuesto());
        if (presupuestoEncontrado == null) {
            presupuestos.add(presupuesto);
            return true;
        }else {
            return false;
        }
    }

    private Presupuesto encontrarPresupuesto(int idPresupuesto) {
        Presupuesto presupuestoEncontrado = null;
        for (Presupuesto presupuesto : presupuestos) {
            if (presupuesto.getIdPresupuesto() == idPresupuesto) {
                presupuestoEncontrado = presupuesto;
                break;
            }else {
                presupuestoEncontrado = null;
            }
        }
        return presupuestoEncontrado;
    }

    public boolean actualizarPresupuesto(Presupuesto presupuesto) {
        boolean actualizado = false;
        for (Presupuesto presupuesto1 : presupuestos) {
            if (presupuesto.getIdPresupuesto()==(presupuesto1.getIdPresupuesto())) {
                presupuestos.set(presupuestos.indexOf(presupuesto1), presupuesto);
                actualizado = true;
                break;
            }else {
                actualizado=false;
            }
        }
        return actualizado;
    }

    public boolean eliminarPresupuesto(String idPresupuesto) {
        boolean eliminado = false;
        int idPresupuestoInt = Integer.parseInt(idPresupuesto);
        for (Presupuesto presupuesto : presupuestos) {
            if (presupuesto.getIdPresupuesto() == idPresupuestoInt) {
                presupuestos.remove(presupuesto);
                eliminado = true;
                break;
            }
        }return eliminado;
    }


}