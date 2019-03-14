/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Details;

import Interactiv.Enemie;

/**
 * La Clase Topo es un enemigo con forma de topo
 * @author Fabian Montes
 * @version 1.2.1
 */
public class Bird extends Enemie{
    
    /**
     * Constructor
     * @param Xref Ubicacion inicial en X
     * @param Yref Ubicacion inicial en Y
     * @param large largo del pajaro
     * @param high alto del pajaro
     * @param minX ubicacion minima para el escorpion en X
     * @param maxX ubicacion minima para el escorpion en X
     * @param minY ubicacion minima para el escorpion en X
     * @param maxY ubicacion minima para el escorpion en X
     */
    
    public Bird(double Xref, double Yref, double large, double high, double minX, double maxX,double minY, double maxY) {
        super("bird", 1, 1, 0, true, 20, Xref, Yref, 2, 0, 0, large, high, minX, minY, maxX, maxY,10,0,0, true);
    }

    @Override
    public void desplazar() {
        if(!(minion.getMinX()==minion.getMaxX())){
            super.desplazar(); 
        }
    }

    @Override
    public void movY() {
        if(!(minion.getMinY()==minion.getMaxY())){
            super.movY();
        }

    }
    
    

    
    
}
