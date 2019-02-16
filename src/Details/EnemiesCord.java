/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Details;
/**
 * La Clase EnemiesCord Un rango de desplazamiento del enemigo 
 * @author Fabian Montes
 * @version 1.6.1
 */
public class EnemiesCord {
    private String minion;
    private double x;
    private double y;
    private double minX;
    private double maxX;
    private double minY;
    private double maxY;
    private double animationN;

    /**
     * Constructor de la clase
     * @param minion Nombre del Enemigo
     * @param x Ubicacion en X del enemigo
     * @param y Ubicacion en Y del enemigo
     * @param minX Ubicacion minima del Xdel enemigo
     * @param maxX Ubicacion maxima del X enemigo
     * @param minY Ubicacion minima del Y enemigo
     * @param maxY Ubicacion maxima del Y enemigo
     */
    public EnemiesCord(String minion, double x, double y, double minX, double maxX, double minY, double maxY) {
        this.minion = minion;
        this.x = x;
        this.y = y;
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
        this.animationN = 0;
    }

    /**
     * Consigue le ubicacion en X del enemigo
     * @return ubicacion en X
     */
    
    public double getX() {
        return x;
    }

    /**
     * Consigue le ubicacion en Y del enemigo
     * @return ubicacion en Y
     */
    
    public double getY() {
        return y;
    }
    
    /**
     * Consigue el numero de la animacion del enemigo
     * @return numero de animacion
     */

    public double getAnimationN() {
        return animationN;
    }
    
    /**
     * Cambia la ubicacion en X del enemigo
     * @param x nueva ubicacion en X
     */

    public void setX(double x) {
        this.x = x;
    }
    
    /**
     * Cambia la ubicacion en Y del enemigo
     * @param y nueva ubicacion en Y
     */

    public void setY(double y) {
        this.y = y;
    }
    
    /**
     * Cambia el numero de animacion del enemigo
     * @param animationN nuevo numero de animacion
     */

    public void setAnimationN(double animationN) {
        this.animationN = animationN;
    }
    
    /**
     * Consigue la ubicacion maxima en X del enemigo
     * @return ubicacion maxima en X
     */

    public double getMaxX() {
        return maxX;
    }
    
    /**
     * Consigue el nombre del enemigo
     * @return nombre del enemigo
     */

    public String getMinion() {
        return minion;
    }

    /**
     * Consigue la ubicacion minima en X del enemigo
     * @return ubicacion minima en X
     */
    
    public double getMinX() {
        return minX;
    }
    
    /**
     * Consigue la ubicacion minima en Y del enemigo
     * @return ubicacion minima en Y
     */

    public double getMinY() {
        return minY;
    }

    /**
     * Consigue la ubicacion maxima en Y del enemigo
     * @return ubicacion maxima en Y
     */
    
    public double getMaxY() {
        return maxY;
    }
    
    /**
     * Cambia el nombre del enemigo 
     * @param minion nuevo nombre del enemigo
     */

    public void setMinion(String minion) {
        this.minion = minion;
    }
    
    /**
     * Cambia la ubicacion minima del X
     * @param minX nuva ubicacion minima en X
     */
    

    public void setMinX(double minX) {
        this.minX = minX;
    }
    
    /**
     * Cambia la ubicacion maxima del X
     * @param maxX nuva ubicacion maxima en X
     */

    public void setMaxX(double maxX) {
        this.maxX = maxX;
    }

    /**
     * Cambia la ubicacion minima del Y
     * @param minY nuva ubicacion minima en Y
     */
    
    public void setMinY(double minY) {
        this.minY = minY;
    }
    
    /**
     * Cambia la ubicacion maxima del Y
     * @param maxY nuva ubicacion maxima en Y
     */

    public void setMaxY(double maxY) {
        this.maxY = maxY;
    }
    
    /**
     * Dice si el enemigo se encuentra en el limite en X
     * @param look Orientacion del enemigo
     * @param large Largo del enemigo
     * @return se encuentra fuera del limite en X?
     */
    
    public boolean inLimitX(boolean look,double large){
        if(look){
            return x<minX;
        }else{
            return x+large>maxX;
        }
    }
    
    /**
     * Dice si el enemigo se encuentra en el limite en Y
     * @param up el enemigo sube?
     * @param alto Alto del enemigo
     * @return se encuentra fuera del limite en Y?
     */
    
    public boolean inLimitY(boolean up,double alto){
        if(up){
            return y>maxY;
        }else{
            return y+alto>minY;
        }
    }   
}

