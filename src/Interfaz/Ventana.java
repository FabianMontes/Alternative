/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Details.LectoEscritura;
import Details.UbiGroup;
import Details.Visual;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Administra La Ventana dentro del juego
 * @author fanat
 */
public abstract class Ventana {
    protected General general;
    protected String name;
    protected ArrayList<UbiGroup> partes;
    protected HashMap<String,Visual> imagens;

    /**
     * Constructor Clase
     * @param name nombre inicial de la ventana
     * @param general lapiz y escena
     */
    
    public Ventana(String name, General general){
        this.name= name;
        this.general = general;
        partes = new ArrayList<>();
        imagens= new HashMap<>();
    }
    
    /**
     * Inicia todas las partes de la ventana
     */
    
    public void setAll() {
            partes.clear();
            imagens.clear();
            this.imagens=LectoEscritura.PartesEnImagen(new File("src/code/"+name+"Ub.txt"), imagens);
            this.partes=LectoEscritura.UbicarLevel(new File("src/code/"+name+"Vis.txt"), partes);
    }
    
    /**
     * Guarda Todo lo que se quiera realizar en ciclo de la ventana
     */
    
    public abstract void Ciclo();
    
    /**
     * Consigue una linea determinada segun los botones recibidos
     * @return nueva ventana
     */
    
    public abstract String Btn();
    
}
