/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interactiv;
import java.io.IOException;
import java.util.HashMap;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import Details.PerMov;
import Details.EnemiesCord;
import Details.Visual;
import Details.LectoEscritura;
import javafx.scene.image.Image;
/**
 * Esta clase define a un enemigo
 * @author Fabian Montes
 * @version 1.8.1
 */
public class Enemie extends PerMov{
    protected String type;
    protected EnemiesCord minion; 
    protected HashMap<String,Visual> visEnemies;

    /**
     * Constructor de la clase
     * @param type tipo de enemigo
     * @param velmaxX velocidad maxima en X
     * @param velmaxY velocidad maxima en Y
     * @param time tiempo de salto
     * @param lookLeft orientacion de la mirada
     * @param live vida del enemigo
     * @param Xref Ubicacion en X
     * @param Yref Ubicacion en Y
     * @param velmaxXinW velocidad en X dentro del agua
     * @param velmaxYinW velocidad en Y dentro del agua
     * @param time2 Tiempo maximo en el agua
     * @param large largo del enemigo
     * @param high alto del enemigo
     * @param minX ubicacion minima en X
     * @param minY ubicacion minima en Y
     * @param maxX ubicacion maxima en X
     * @param maxY ubicacion maxima en Y
     * @param damage daño que realiza el enemigo
     * @param weight peso del enemigo
     * @param weightinW peso en el agua del enemigo
     * @throws IOException 
     */
    
    public Enemie(String type, double velmaxX, double velmaxY, int time, boolean lookLeft, int live, double Xref, double Yref, double velmaxXinW, double velmaxYinW, int time2, double large, double high, double minX, double minY, double maxX, double maxY, int damage, double weight, double weightinW) throws IOException {
        super(velmaxX, velmaxY, time, lookLeft, live, Xref, Yref, velmaxXinW, velmaxYinW, time2, large, high,damage,weight,weightinW);
        this.type = type;
        this.minion= new EnemiesCord(type, Xref, Yref, minX, maxX, minY, maxY);
        this.visEnemies= LectoEscritura.PartesEnImagen("src/code/Enemigos.txt", new HashMap<>());
    }

    public void hurt(int damage){
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
