package com.example.hoja11;

import com.example.hoja11.Control.TestRespuestas;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class VistaResultado {

    @FXML
    private Text descripcionPersonaje;

    @FXML
    private Button reinicio;

    @FXML
    private Button verResultados;

    private ObservableList<String> opcionesSeleccionadas;

    HelloController helloController = new HelloController();

    @FXML
    void resultado(ActionEvent event){
        descripcionPersonaje.setText(helloController.mostrarResultado());
    }


    @FXML
    void reintentarTest(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("vistaBienvenida.fxml"));
        Pane pane = (Pane) loader.load();
        Scene scene = new Scene(pane);
        stage.setTitle("Inicio");

        stage.setScene(scene);
    }

}
