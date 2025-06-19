module com.proyecto.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.proyecto.demo to javafx.fxml;
    exports com.proyecto.demo;
}