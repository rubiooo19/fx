package com.example.hoja11;

import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ResultadoFinalView extends Parent {

    public ResultadoFinalView(String resultado) {
        // Crea los elementos visuales para mostrar el resultado
        // Puedes utilizar etiquetas, paneles, imágenes u otros elementos según tus necesidades
        // Configura el diseño y la disposición de los elementos según tus preferencias
        // Por ejemplo:
        Label labelResultado = new Label(resultado);
        labelResultado.setFont(Font.font("Arial", FontWeight.BOLD, 20));
        labelResultado.setAlignment(Pos.CENTER);

        // Agrega los elementos al contenedor principal
        VBox vbox = new VBox(labelResultado);
        vbox.setAlignment(Pos.CENTER);
        getChildren().add(vbox);
    }


}

