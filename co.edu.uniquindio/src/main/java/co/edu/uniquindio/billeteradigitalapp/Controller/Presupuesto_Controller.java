package co.edu.uniquindio.billeteradigitalapp.Controller;

import co.edu.uniquindio.billeteradigitalapp.Factory.ModelFactory;
import co.edu.uniquindio.billeteradigitalapp.Model.Presupuesto;

import java.util.List;

public class Presupuesto_Controller {
    static ModelFactory modelFactory;
    public Presupuesto_Controller() {
        modelFactory = ModelFactory.getInstance();
    }

    public List<Presupuesto> obtenerPresupuestos() {
        return modelFactory.obtenerPresupuestos();
    }

    public boolean crearPresupuesto(Presupuesto presupuesto) {

        return modelFactory.crearPresupuesto(presupuesto);
    }
    public static boolean actualizarPresupuesto(Presupuesto presupuesto) {
        return modelFactory.actualizarPresupuesto(presupuesto);
    }

    public boolean eliminarPresupuesto(String idPresupuesto) {
        return modelFactory.eliminarPresupuesto(idPresupuesto);
    }
}
