/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;
import javafx.animation.AnimationTimer;
import java.io.IOException;

/**
 * La Clase Loop es donde generaremos la interaccion entre el uego y el jugador.
 * @author Fabián Montes.
 * @version 2.41.7.
 * @since Inicio de los tiempos.
 * 
 */
    


public class Loop extends AnimationTimer {
    private Ventana ventana;
    private General general;

    /**
     * Constructor de la clase
     * @param general lapiz y escena del juego
     * @throws IOException 
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
    
    /*
    
    private void Botons(){
                
                
            break;    
        
    }*/
}
