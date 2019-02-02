/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interactiv;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import Details.PerMov;
import Details.EnemiesCord;
import Details.Visual;
import Details.LectoEscritura;
import javafx.scene.image.Image;
/**
 *
 * @author fanat
 */
public class Enemie extends PerMov{
    private String type;
    private EnemiesCord minion; 
    private HashMap<String,Visual> visEnemies;

    public Enemie(String type, double velmaxX, double velmaxY, int time, boolean lookLeft, int live, double Xref, double Yref, double velmaxXinW, double velmaxYinW, int time2, double large, double high, double minX, double minY, double maxX, double maxY) throws IOException {
        super(velmaxX, velmaxY, time, lookLeft, live, Xref, Yref, velmaxXinW, velmaxYinW, time2, large, high);
        this.type = type;
        this.minion= new EnemiesCord(type, Xref, Yref, minX, maxX, minY, maxY);
        this.visEnemies= LectoEscritura.PartesEnImagen("src/code/Enemigos.txt", new HashMap<>());
    }

    public void hurt(int x,int damage){
        loselife(damage);
    }
    
    public HashMap<String, Visual> getVisEnemies() {
        return visEnemies;
    }

    public String getType() {
        return type;
    }
    
    public void setMinions(EnemiesCord minion) {
        this.minion = minion;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setVisEnemies(HashMap<String, Visual> visEnemies) {
        this.visEnemies = visEnemies;
    }
    
    public void swicthMinion(){
        setLookLeft(!isLookingLeft());
    }
    
    public Image getMinionImage(){
        return visEnemies.get("enemigos").getUbicacion();
    }
    
    public double getMinionImVal(int x){
        if(isLookingLeft()){
            return visEnemies.get("enemigos").getPart(type+"L", x);
        }else{
            return visEnemies.get("enemigos").getPart(type+"R", x);
        }   
    }
    
    public double getMiniVal(int x){
        switch(x){
            case 1:
                return getX();
            case 2:
                return getY();
            case 3:
                return getLarge();
            default:
                return getHigh();
        }
    }
    
    public Shape getShape(double refX, double refY){
        return new Rectangle(refX+getMiniVal(1),refY-getMiniVal(2), getMiniVal(3), getMiniVal(4));
    }

    @Override
    public void desplazar() {
        if(minion.inLimitX(lookingLeft, getLarge())){
            this.swicthMinion();
            if(this.lookingLeft){
                this.minion.setX(this.cord[1]-=this.fisicas.getVelmaxX());
                
            }else{
                this.minion.setX(this.cord[1]+=this.fisicas.getVelmaxX());
            }
        }else{
            if(this.lookingLeft){
                this.minion.setX(this.cord[1]-=this.fisicas.getVelmaxX());
            }else{
                this.minion.setX(this.cord[1]+=this.fisicas.getVelmaxX());
            }
        }
        
    }
    
    
    
}
