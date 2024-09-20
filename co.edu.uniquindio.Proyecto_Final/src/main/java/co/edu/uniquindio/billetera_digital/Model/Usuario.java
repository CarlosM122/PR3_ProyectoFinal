package co.edu.uniquindio.billetera_digital.Model;

import lombok.Data;

@Data
public class Usuario {
    private String nombre;
    private String correo;
    private String telefono;
    private String direccion;
    private String idUsuario;

    public Usuario() {
    }
}
