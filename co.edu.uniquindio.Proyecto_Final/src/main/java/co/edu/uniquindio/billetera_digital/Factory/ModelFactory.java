package co.edu.uniquindio.billetera_digital.Factory;

public class ModelFactory {
    private static ModelFactory instance;

    public static ModelFactory getInstance() {
        if (instance == null) {
            instance = new ModelFactory();
        }
        return instance;
    }
}
