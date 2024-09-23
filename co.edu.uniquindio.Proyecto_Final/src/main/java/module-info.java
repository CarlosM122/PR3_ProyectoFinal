module co.edu.uniquindio.billetera_digital {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires org.mapstruct;

    opens co.edu.uniquindio.billetera_digital to javafx.fxml;
    exports co.edu.uniquindio.billetera_digital;

    opens co.edu.uniquindio.billetera_digital.ViewController;
    exports co.edu.uniquindio.billetera_digital.ViewController;
    opens co.edu.uniquindio.billetera_digital.Controller;
    exports co.edu.uniquindio.billetera_digital.Controller;
    exports co.edu.uniquindio.billetera_digital.Mappings.Mapper;
    exports co.edu.uniquindio.billetera_digital.Mappings.Dto;
    exports co.edu.uniquindio.billetera_digital.Model;
}