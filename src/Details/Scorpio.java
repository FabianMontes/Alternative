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
public class Scorpio extends Enemie{
    
    public Scorpio(double Xref, double Yref, double large, double high, double minX, double maxX,double minY, double maxY) throws IOException {
        super("scorpio", 0.5, 0, 0, true, 10, Xref, Yref, 2, 0, 0, large, high, minX, minY, maxX, maxY,10);
    }

    @Override
    public void movY() {
        
    }
    
    
    
}
