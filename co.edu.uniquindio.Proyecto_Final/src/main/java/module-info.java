module co.edu.uniquindio.parcial1.billetera_digital {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;

    opens co.edu.uniquindio.parcial1.billetera_digital to javafx.fxml;
    exports co.edu.uniquindio.parcial1.billetera_digital;
}