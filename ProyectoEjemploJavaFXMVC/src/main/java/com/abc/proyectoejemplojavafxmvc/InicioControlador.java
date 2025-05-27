package com.abc.proyectoejemplojavafxmvc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.io.IOException;

public class InicioControlador {

    @FXML
    private void irAlFormulario(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("PersonaVista.fxml"));

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setScene(new Scene(root));
        stage.show();
    }
}

