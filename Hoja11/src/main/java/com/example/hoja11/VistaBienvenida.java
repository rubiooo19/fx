package com.example.hoja11;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class VistaBienvenida {

    @FXML
    private Text bienvenida;

    @FXML
    private Button comenzar;

    @FXML
    void empezarTest(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Pane pane = (Pane) loader.load();
        Scene scene = new Scene(pane);
        stage.setTitle("Pregunta");

        stage.setScene(scene);
    }
}