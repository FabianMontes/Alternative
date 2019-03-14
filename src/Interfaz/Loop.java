/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;
import javafx.animation.AnimationTimer;

/**
 * La Clase Loop es donde generaremos la interaccion entre el juego y el jugador.
 * @author Fabián Montes.
 * @version 5.1.1
 * @since Inicio de los tiempos.
 * 
 */
    


public class Loop extends AnimationTimer {
    private Ventana ventana;
    private General general;

    /**
     * Constructor de la clase
     * @param general lapiz y escena del juego
     */
    public Loop(General general) {
        this.general= general;
        general.CambiodeScena();
        
        this.ventana= new Menu("IniPantalla",general);
        ventana.setAll();
    }
    
    /**
     * Este metodo es el loop donde se ejecuta el juego
     * @param now 
     */
    
    @Override
    public void handle(long now) {
        ventana.Ciclo();
        String name =ventana.Btn();
        if(name.contains("IniPantalla")){
            general.CambiodeScena();
            ventana= new Menu("IniPantalla", general);
            ventana.setAll();
        }else if (name.contains("Password")){
            System.out.println("habia");
            general.CambiodeScena();
            ventana= new Password(name, general);
            ventana.setAll();
        }else if(name.contains("Level")){
            general.CambiodeScena();
            ventana= new Levels(name, general);
            ventana.setAll();
        }
        
    }
    
}
