package co.edu.uniquindio.billetera_digital.Model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Usuario {
    private String nombre;
    private String correo;
    private String telefono;
    private String direccion;
    private final int idUsuario;
    private static int cantidadUsuarios;
    private List<Cuenta> cuentasAsociadas = new ArrayList<>();

    public Usuario() {
        idUsuario = ++cantidadUsuarios;
    }
}