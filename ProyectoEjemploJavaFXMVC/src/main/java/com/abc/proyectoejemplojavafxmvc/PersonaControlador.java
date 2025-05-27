package com.abc.proyectoejemplojavafxmvc;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;

public class PersonaControlador {
    @FXML
    private TextField nombreTextField;

    @FXML
    private ComboBox generoComboBox;
    ObservableList<String> generos = FXCollections.observableArrayList("Femenino", "Masculino");

    @FXML
    private DatePicker aNacDatePicker;

    @FXML
    private Label resultadosLabel;

    @FXML
    private Label errorIngresoDatosLabel;

    @FXML
    private Button mostrarDatosButton;

    private Persona persona;

    @FXML
    public void initialize() {
        persona = new Persona();
        generoComboBox.setItems(generos);
        mostrarDatosButton.setDisable(true);
    }

    /**
     * Metodo para guardar datos en objeto
     */
    @FXML
    private void guardarDatos() {

        errorIngresoDatosLabel.setText("");


        String nombre = nombreTextField.getText().trim();
        String genero = (String) generoComboBox.getSelectionModel().getSelectedItem();
        LocalDate fechaNac = aNacDatePicker.getValue();


        if (nombre.isEmpty()) {
            errorIngresoDatosLabel.setText("Por favor ingrese un nombre.");
            return;
        }

        if (genero == null || genero.isEmpty()) {
            errorIngresoDatosLabel.setText("Por favor seleccione un género.");
            return;
        }

        if (fechaNac == null || fechaNac.isAfter(LocalDate.now())) {
            errorIngresoDatosLabel.setText("Por favor ingrese una fecha de nacimiento válida.");
            return;
        }


        persona.setNombre(nombre);
        persona.setGenero(genero);
        persona.setANac(fechaNac.getYear());


        errorIngresoDatosLabel.setText("Datos guardados correctamente.");
        mostrarDatosButton.setDisable(false);
    }

    /**
     * Metodo para imprimir los datos
     */
    @FXML
    private void mostrarDatos() {



        resultadosLabel.setText(persona.getNombre() + " " + persona.getGenero() + " " + " Edad: " +persona.calcularEdad());
    }
}