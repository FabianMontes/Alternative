/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Details;
/**
 * La clase Cordenate Ubica las cordenadas de cierta parte de una imagen, junto con la cantidad de imagenes tiene para la animacion
 * @author fanat
 */
public class Cordenate {
    private String part;
    private double x;
    private double y;
    private double large;
    private double high;
    private double animationN;
    
    /**
     * Constructor 1 de la clase
     * @param part nombre de la parte recibida
     * @param x cordenada X inicial de la parte
     * @param y cordenada Y inicial de la parte
     * @param large largo de la parte 
     * @param high ancho de la pate
     * @param animationN cantidad de imagenes que contiene esa parte
     */

    public Cordenate(String part, double x, double y, double large, double high, double animationN) {
        this.part = part;
        this.x = x;
        this.y = y;
        this.large = large;
        this.high = high;
        this.animationN = animationN;
    }
    
    /**
     * Constructor 2, deja el numero de animaciones en 0
     * @param part nombre de la parte recibida
     * @param x cordenada X inicial de la parte
     * @param y cordenada Y inicial de la parte
     * @param large largo de la parte 
     * @param high ancho de la pate
     */
    
    public Cordenate(String part, double x, double y, double large, double high) {
        this.part = part;
        this.x = x;
        this.y = y;
        this.large = large;
        this.high = high;
        this.animationN = 0;
    }

    /**
     * Consigue el nombre de la imagen
     * @return nombre de la imagen
     */
    
    public String getPart() {
        return part;
    }
    
    /**
     * Consigue el X de la imagen
     * @return X de la imagen
     */

    public double getX() {
        return x;
    }
    
    /**
     * Consigue el Y de la imagen
     * @return Y de la imagen
     */

    public double getY() {
        return y;
    }
    
    /**
     * Consigue el Largo de la imagen
     * @return Largo de la imagen
     */

    public double getLarge() {
        return large;
    }
    
    /**
     * Consigue el Ancho de la imagen
     * @return Ancho de la imagen
     */

    public double getHigh() {
        return high;
    }

    /**
     * Consigue la cantidad de imagenes de la parte
     * @return cantidad de imagenes de la parte
     */
    public double getAnimationN() {
        return animationN;
    }

    /**
     * Cambia el nombre la parte
     * @param part nuevo nombre de la parte
     */
    
    public void setPart(String part) {
        this.part = part;
    }
    
    /**
     * Cambia la ubicacion en X de la parte
     * @param x nueva ubicacion en X
     */

    public void setX(double x) {
        this.x = x;
    }
    
    /**
     * Cambia la ubicacion en Y de la parte
     * @param y nueva ubicacion en Y
     */

    public void setY(double y) {
        this.y = y;
    }
    
    /**
     * Cambia el largo de la parte
     * @param large nuevo largo de la parte
     */

    public void setLarge(double large) {
        this.large = large;
    }

    /**
     * Cambia el ancho de la parte
     * @param high nuevo ancho de la parte
     */
    
    public void setHigh(double high) {
        this.high = high;
    }

    /**
     * Cambia la cantidad de animaciones de la parte
     * @param animationN nueva cantidad de partes
     */
    public void setAnimationN(double animationN) {
        this.animationN = animationN;
    }
    
}

