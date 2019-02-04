/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
/**
 * La Class Escenario es la clase que contiene el Main y el escenario donde crearemos todo el juego.
 * @author Fabian Montes.
 * @version 1.0.0
 * @since Inicio de los tiempos.
 * 
 */
public class Escenario extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane layout= new Pane();
        Canvas canvas= new Canvas(1280,650);
        layout.getChildren().add(canvas);
        Scene escena= new Scene(layout,1280,650,Color.WHITESMOKE);
        
        GraphicsContext lapiz = canvas.getGraphicsContext2D();
        Loop juego= new Loop(escena, lapiz);
        juego.start();
        
        
        primaryStage.setScene(escena);
        primaryStage.setTitle("Prueba escenario");
        primaryStage.show();
    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
