module com.proyecto.parcialfinal {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.proyecto.parcialfinal.Controladores to javafx.fxml;
    opens com.proyecto.parcialfinal.Modelos to javafx.fxml;
    opens com.proyecto.parcialfinal.Util to javafx.fxml;

    exports com.proyecto.parcialfinal.Util;
    exports com.proyecto.parcialfinal.Controladores;
    exports com.proyecto.parcialfinal.Modelos;
}