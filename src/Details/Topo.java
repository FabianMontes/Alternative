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
public class Topo extends Enemie{
    
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
    
    public Topo(double Xref, double Yref, double large, double high, double minX, double maxX,double minY, double maxY)  {
        super("topo", 1, 0, 0, true, 10, Xref, Yref, 2, 0, 0, large, high, minX, minY, maxX, maxY,10,0,0, true);
    }

    /**
     * Anula todo movimiento en Y
     */
    
    @Override
    public void movY() {
    }
    
    
    
}
