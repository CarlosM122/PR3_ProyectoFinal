package co.edu.uniquindio.billetera_digital.Controller;

import co.edu.uniquindio.billetera_digital.Controller.Service.ILoginControllerService;
import co.edu.uniquindio.billetera_digital.Factory.ModelFactory;

public class Login_Controller implements ILoginControllerService {

    ModelFactory modelFactory;

    public Login_Controller() {
        modelFactory = ModelFactory.getInstance();
    }

    public boolean iniciarSesion(String user, String password) {
        return modelFactory.iniciarSesion(user,password);
    }

    public boolean registrarUsuario(String user, String password) {
        return modelFactory.registrarUsuario(user,password);
    }
}