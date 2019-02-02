/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Details;

import Interactiv.Enemie;
import java.io.IOException;

/**
 *
 * @author fanat
 */
public class Topo extends Enemie{
    
    public Topo(double Xref, double Yref, double large, double high, double minX, double maxX,double minY, double maxY) throws IOException {
        super("topo", 1, 0, 0, true, 10, Xref, Yref, 2, 0, 0, large, high, minX, minY, maxX, maxY);
    }

    @Override
    public void movY() {
    }
    
    
    
}
