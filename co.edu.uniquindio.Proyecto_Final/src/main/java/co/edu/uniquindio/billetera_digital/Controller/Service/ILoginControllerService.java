package co.edu.uniquindio.billetera_digital.Controller.Service;

public interface ILoginControllerService {
    boolean iniciarSesion(String user, String password);
    boolean registrarUsuario(String user, String password);
}
