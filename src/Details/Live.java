/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Details;

/**
 *
 * @author fanat
 */
public class Live {
    private int live;
    private int liveTotal;
    
    

    public Live(int liveTotal) {
        this.live = liveTotal;
        this.liveTotal = liveTotal;
    }

    public int getLive() {
        return live;
    }

    public int getLiveTotal() {
        return liveTotal;
    }

    public void setLive(int live) {
        this.live = live;
    }

    public void setLiveTotal(int liveTotal) {
        this.liveTotal = liveTotal;
    }
    
    public void fillLive(){
        this.live=this.liveTotal;
    }
    
    public void lossLive(int daño){
        this.live-=daño;
    }
    
    
    
}
