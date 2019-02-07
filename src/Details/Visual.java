/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Details;
import java.util.HashMap;
import javafx.scene.image.Image;

/**
 *
 * @author fanat
 */
public class Visual {
    private Image ubicacion;
    private HashMap<String,Cordenate> partes;
    
    /**
     * 
     * @param ubicacion 
     */
    
    public Visual(String ubicacion) {
        this.ubicacion = new Image(ubicacion);
        this.partes = new HashMap<>();
    }
    /**
     * 
     * @return 
     */
    public Image getUbicacion() {
        return ubicacion;
    }
    /**
     * 
     * 
     * 
     * @param ubicacion 
     */

    public void setUbicacion(String ubicacion) {
        this.ubicacion = new Image(ubicacion);
    }
    
    public void putPart(String key,double x, double y, double large, double high, double animationN){
        this.partes.put(key, new Cordenate(key,x,y,large,high,animationN));
    }
            
            
    public void putPart(String key,double x, double y, double large, double high){
        this.partes.put(key, new Cordenate(key, x, y, large, high));
    }
    
    public void removePart(String key){
        this.partes.remove(key);
    }
    public void replacePart(String key,double x, double y, double large, double high, double animationN){
        this.partes.replace(key,new Cordenate(key, x, y, large, high, animationN));
    }
    
    public double getPart(String key, int a){
        switch(a){
            case 1:
                return this.partes.get(key).getX();
            case 2:
                return this.partes.get(key).getY();
            case 3:
                return this.partes.get(key).getLarge();
            case 4:
                return this.partes.get(key).getHigh();
            case 5:
                return this.partes.get(key).getAnimationN();
            default:
                return 0;
        }
    }
    

    public HashMap<String, Cordenate> getPartes() {
        return partes;
    }

    public void setPartes(HashMap<String, Cordenate> partes) {
        this.partes = partes;
    }
    
    

}
