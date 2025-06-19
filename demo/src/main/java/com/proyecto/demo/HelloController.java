package com.proyecto.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class HelloController {

    private Figura figura;
    private int radio;
    private int base;
    private int altura;

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private TextField alturaTextField;

    @FXML
    private TextField radioTextField;

     @FXML
    private TextField baseTextField;

     @FXML
    private Button buildCirculoButton;

     @FXML
    private Button buildRectanguloButton;

     @FXML
    public void initialize() {
         figura = new Figura();
     }


    public void construirRect() {
         figura.setBase(Integer.parseInt(baseTextField.getText()));
         figura.setAltura(Integer.parseInt(alturaTextField.getText()));
         figura.setRadio(Integer.parseInt(radioTextField.getText()));


         VBox vbox = new VBox();
        Scene escena = new Scene(vbox, base+100, altura+100);
         Rectangle rectangle = new Rectangle();
         rectangle.setHeight(figura.getAltura());
         rectangle.setWidth(figura.getBase());
         rectangle.setFill(Color.BLUE);
         vbox.getChildren().add(rectangle);
         Stage stage = new Stage();
         stage.setScene(escena);
         stage.show();

     }

    public void construirCirc() {
        figura.setBase(Integer.parseInt(baseTextField.getText()));
        figura.setAltura(Integer.parseInt(alturaTextField.getText()));
        figura.setRadio(Integer.parseInt(radioTextField.getText()));

        VBox vbox = new VBox();
        Scene escena = new Scene(vbox, base+100, altura+100);
        Circle circle = new Circle();
        circle.setRadius(figura.getRadio());
        circle.setFill(Color.RED);
        vbox.getChildren().add(circle);
        Stage stage = new Stage();
        stage.setScene(escena);
        stage.show();
    }
}