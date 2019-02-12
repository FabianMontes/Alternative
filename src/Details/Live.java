/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Details;

/**
 * La Clase Live administra la vida de un personaje u objeto
 * @author Fabian Montes
 * @version 1.0.3
 */
public class Live {
    private int live;
    private int liveTotal;

    /**
     * Constructor de la Clase
     * @param liveTotal vida total que tiene el personaje/objeto
     */
    
    public Live(int liveTotal) {
        this.live = liveTotal;
        this.liveTotal = liveTotal;
    }
    
    /**
     * Consigue la vida actual del personaje/objeto
     * @return la vida actual
     */

    public int getLive() {
        return live;
    }
    
    /**
     * Consigue la vida total del personaje/objeto
     * @return la vida total
     */

    public int getLiveTotal() {
        return liveTotal;
    }
    
    /**
     * Cambia la vida actual del personaje/objeto0
     * @param live nueva vida
     */

    public void setLive(int live) {
        this.live = live;
    }
    
    /**
     * Cambia la vida total del personaje/objeto0
     * @param liveTotal nueva vida total
     */

    public void setLiveTotal(int liveTotal) {
        this.liveTotal = liveTotal;
    }
    
    /**
     * llena la vida al maximo
     */
    
    public void fillLive(){
        this.live=this.liveTotal;
    }
    
    /**
     * Reduce cierta cantidad de vida a la vida actual
     * @param daño vida rducida
     */
    
    public void lossLive(int daño){
        this.live-=daño;
    }
    
}
