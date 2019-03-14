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
public class Light extends Enemie{
    
    /**
     * Constructor
     * @param Xref Ubicacion inicial en X
     * @param Yref Ubicacion inicial en Y
     * @param large largo del escorpion
     * @param high alto del escorpion
     * @param minX ubicacion minima para el escorpion en X
     * @param maxX ubicacion minima para el escorpion en X
     * @param minY ubicacion minima para el escorpion en X
     * @param maxY ubicacion minima para el escorpion en X
     */
    
    public Light(double Xref, double Yref, double large, double high, double minX, double maxX,double minY, double maxY) {
        super("light", 0, 7, 0, true, 1, Xref, Yref, 2, 0, 0, large, high, minX, minY, maxX, maxY,20,0,0, false);
    }

    @Override
    public void hurt(int damage) {
    }

    @Override
    public void desplazar() {
    }

    @Override
    public void movY() {
        if(minion.inLimitY(up, getHigh())){
            minion.setY(this.cord[3]=minion.getMaxY());
        }
         minion.setY(this.cord[3]-=fisicas.getVelmaxY());
                
    }
    
    
    
}
