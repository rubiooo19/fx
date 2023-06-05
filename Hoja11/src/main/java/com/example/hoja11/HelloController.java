package com.example.hoja11;
import com.example.hoja11.Control.TestPreguntas;
import com.example.hoja11.Control.TestRespuestas;
import com.example.hoja11.Datos.BaseDatos;
import com.example.hoja11.Datos.Resultado;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;

public class HelloController {
    Resultado resultado = new Resultado();

    ArrayList<Integer> respuestasSeleccionadas = new ArrayList<>();

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button buttonSiguiente;

    @FXML
    private Label labelPregunta;

    @FXML
    private Button fin;

    @FXML
    private RadioButton radioRespuesta1;

    @FXML
    private RadioButton radioRespuesta2;

    @FXML
    private RadioButton radioRespuesta3;

    @FXML
    private RadioButton radioRespuesta4;

    private ArrayList<TestPreguntas> preguntas;
    private int indicePreguntaActual;

    public int contador=0;

    @FXML
    public void initialize() {
        BaseDatos baseDatos = new BaseDatos();
        preguntas = baseDatos.obtenerPreguntasYRespuestasAleatorias();
        indicePreguntaActual = 0;

        mostrarPregunta(preguntas.get(indicePreguntaActual));
    }

    public int sumarPuntos(){
        int puntos = 0;
        for (Integer respuestas: respuestasSeleccionadas) {
            puntos+=respuestas;
        }
        System.out.println(puntos);
        return puntos;
    }
    @FXML
    public void mostrarPregunta(TestPreguntas pregunta) {


        labelPregunta.setText(pregunta.getNombre());

        ToggleGroup grupoRespuestas = new ToggleGroup();

        radioRespuesta1.setText(pregunta.getRespuestas().get(0).getNombre());
        radioRespuesta1.setToggleGroup(grupoRespuestas);
        radioRespuesta1.setUserData(1);

        radioRespuesta2.setText(pregunta.getRespuestas().get(1).getNombre());
        radioRespuesta2.setToggleGroup(grupoRespuestas);
        radioRespuesta2.setUserData(2);

        radioRespuesta3.setText(pregunta.getRespuestas().get(2).getNombre());
        radioRespuesta3.setToggleGroup(grupoRespuestas);
        radioRespuesta3.setUserData(3);

        radioRespuesta4.setText(pregunta.getRespuestas().get(3).getNombre());
        radioRespuesta4.setToggleGroup(grupoRespuestas);
        radioRespuesta4.setUserData(4);

        grupoRespuestas.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            int puntos;
            if (grupoRespuestas.getSelectedToggle() != null) {
                 puntos =  (int)grupoRespuestas.getSelectedToggle().getUserData();
                respuestasSeleccionadas.add(puntos);
            }
        });
    }
    @FXML
    public int calcularPuntosRespuesta() {

        if (radioRespuesta1.isSelected()) {
            contador = contador+1;
        } else if (radioRespuesta2.isSelected()) {
            contador = contador+2;
        } else if (radioRespuesta3.isSelected()) {
            contador = contador+3;
        } else if (radioRespuesta4.isSelected()) {
            contador = contador+4;
        }
        return contador;
    }

    @FXML
    public String mostrarResultado(){
        String texto = "";
        if (sumarPuntos()<=10){
            texto = "Mario";
        }else if (sumarPuntos() <= 20) {
            texto = "Luigi";
        } else if (sumarPuntos() <= 30) {
            texto="Peach";
        } else {
            texto = "toad";
        }
        return texto;
    }

    @FXML
    public void mostrarSiguientePregunta() {
        RadioButton[] opciones = {radioRespuesta1, radioRespuesta2, radioRespuesta3, radioRespuesta4};

        indicePreguntaActual++;

        if (indicePreguntaActual < 10) {
            fin.setDisable(true);
        }else if (indicePreguntaActual == 10){
            buttonSiguiente.setDisable(true);
            fin.setDisable(false);
        }
            mostrarPregunta(preguntas.get(indicePreguntaActual));

        for (RadioButton opt : opciones) {
            opt.setSelected(false);
        }

    }

    public void terminarTest(ActionEvent event) throws IOException {

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("vistaResultado.fxml"));
        Pane pane = (Pane) loader.load();
        Scene scene = new Scene(pane);
        stage.setTitle("Final");


        stage.setScene(scene);
    }


}
