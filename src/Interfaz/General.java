/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 *
 * @author fanat
 */
public class General {
    private GraphicsContext lapiz;
    private Scene escena;
    private ArrayList<String> Pulsaciones;
    
    public General() {
        Pane layout= new Pane();
        Canvas canvas= new Canvas(1280,650);
        layout.getChildren().add(canvas);
        escena= new Scene(layout,1280,650,Color.WHITESMOKE);
        lapiz = canvas.getGraphicsContext2D();
        Pulsaciones = new ArrayList<>();
        escena.setOnKeyPressed(

            new EventHandler<KeyEvent>()

            {

                @Override

                public void handle(KeyEvent e)

                {

                    String code = e.getCode().toString();

                    if ( !Pulsaciones.contains(code) )

                        Pulsaciones.add( code );

                }

            });



        escena.setOnKeyReleased(

            new EventHandler<KeyEvent>()

            {

                @Override

                public void handle(KeyEvent e)

                {

                    String code = e.getCode().toString();

                    Pulsaciones.remove( code );

                }

            });

    
        
    }

    public GraphicsContext getLapiz() {
        return lapiz;
    }

    public Scene getEscena() {
        return escena;
    }
    
    public void CambiodeScena(){
        int a=0;
        while(a<100){
            double b= a/100.0;
            lapiz.setFill(Color.rgb(0, 0, 0, b));
            lapiz.fillRect(0, 0, 1280, 650);
            a++;
        }
            
    }

    public ArrayList<String> getPulsaciones() {
        return Pulsaciones;
    }
            
    
    
        
}
