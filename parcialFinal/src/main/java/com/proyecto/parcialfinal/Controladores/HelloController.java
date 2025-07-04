package com.proyecto.parcialfinal.Controladores;

import com.proyecto.parcialfinal.Modelos.Persona;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextField nameField;

    @FXML
    private void onHelloButtonClick() {
        String nombre = nameField.getText();
        if (!nombre.isEmpty()) {
            Persona persona = new Persona(nombre);
            welcomeText.setText("¡Hola " + persona.getNombre() + "!");
        } else {
            welcomeText.setText("Por favor, ingresa tu nombre");
        }
    }
}