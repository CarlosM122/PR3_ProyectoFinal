module co.edu.uniquindio.billetera_digital {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;

    opens co.edu.uniquindio.billetera_digital to javafx.fxml;
    exports co.edu.uniquindio.billetera_digital;

    opens co.edu.uniquindio.billetera_digital.ViewController;
    exports co.edu.uniquindio.billetera_digital.ViewController;
    opens co.edu.uniquindio.billetera_digital.Controller;
    exports co.edu.uniquindio.billetera_digital.Controller;
}