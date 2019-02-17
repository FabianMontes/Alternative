/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Details;

/**
 * Esta clase guarda las variables fisicas que tiene determinado personaje
 * @author fanat
 * @version 3.6.1
 */
public class Fisica {
    private double peso;
    private double weightinW;
    private double velmaxX;
    private double velmaxY;
    private boolean jumping;
    private int timejump;
    private boolean ground;
    private boolean inWater;
    private int timeinWater;
    private double velmaxXinW;
    private double velmaxYinW;
    
    /**
     * Constructor de la clase 1 que cambia los pesos
     * @param velmaxX velocidad del dezplazamiento en X
     * @param velmaxY velocidad de dezplazamiento en Y
     * @param timejump tiempo maximo de salto
     * @param velmaxXinW velocidad de dezplazamiento en X en el agua
     * @param velmaxYinW velocidad de dezplazamiento en Y en el agua
     * @param timeinWater tiempo maximo de estadia en el agua
     * @param peso fuerza de descenso que recibe el personaje
     * @param weightinW fuerza de descenso que recibe en el agua
     */

    public Fisica(double velmaxX, double velmaxY, int timejump, double velmaxXinW, double velmaxYinW, int timeinWater, double peso, double weightinW) {
        this.peso = peso;
        this.weightinW = weightinW;
        this.velmaxX = velmaxX;
        this.velmaxY = velmaxY;
        this.jumping = false;
        this.timejump = timejump;
        this.ground = false;
        this.inWater = false;
        this.timeinWater = timeinWater;
        this.velmaxXinW = velmaxXinW;
        this.velmaxYinW = velmaxYinW;
    }

    /**
     * Constructor de la clase 1 que deja los pesos por un valor estandar
     * @param velmaxX velocidad del dezplazamiento en X
     * @param velmaxY velocidad de dezplazamiento en Y
     * @param timejump tiempo maximo de salto
     * @param velmaxXinW velocidad de dezplazamiento en X en el agua
     * @param velmaxYinW velocidad de dezplazamiento en Y en el agua
     * @param timeinWater tiempo maximo de estadia en el agua
     */
    
    public Fisica(double velmaxX, double velmaxY, int timejump, double velmaxXinW, double velmaxYinW, int timeinWater) {
        this.peso = 0.3;
        this.weightinW = 0.1;
        this.velmaxX = velmaxX;
        this.velmaxY = velmaxY;
        this.jumping =false;
        this.timejump=timejump;
        this.ground =false;
        this.velmaxXinW = velmaxXinW;
        this.velmaxYinW = velmaxYinW;
        this.inWater =false;
        this.timeinWater=timeinWater;
    }
    
    /**
     * Consigue el peso que recibe el personaje
     * @return peso
     */

    public double getGravedad() {
        return peso;
    }

    /**
     * Consigue la velocidad de desplazamiento en X
     * @return desplazamiento en X
     */
    
    public double getVelmaxX() {
        return velmaxX;
    }
    
    /**
     * Consigue la velocidad de desplazamiento en X
     * @return desplazamiento en Y
     */

    public double getVelmaxY() {
        return velmaxY;
    }
    
    /**
     * Cambia el peso de un personaje
     * @param peso nuevo peso
     */

    public void setGravedad(double peso) {
        this.peso = peso;
    }
    
    /**
     * Cambia la velocidad de desplazamiento en X de un personaje
     * @param velmaxX nueva velocidad en X 
     */

    public void setVelmaxX(double velmaxX) {
        this.velmaxX = velmaxX;
    }

    /**
     * Cambia la velocidad de desplazamiento en Y de un personaje
     * @param velmaxY nueva velocidad en Y
     */
    
    public void setVelmaxY(double velmaxY) {
        this.velmaxY = velmaxY;
    }
    
    /**
     * Dice si el personaje esta saltando
     * @return esta saltando?
     */

    public boolean isJumping() {
        return jumping;
    }
    
    /**
     * Cambia la variable de salto
     * @param jumping nueva variable de salto
     */

    public void setJumping(boolean jumping) {
        this.jumping = jumping;
    }

    /**
     * Consigue el tiempo maximo de salto
     * @return tiempo maximo de salto
     */
    
    public int getTimejump() {
        return timejump;
    }
    
    /**
     * Cambia el tiempo de  salto maximo
     * @param timejump nuevo tiempo maximo de salto
     */

    public void setTimejump(int timejump) {
        this.timejump = timejump;
    }
    
    /**
     * Dice si el personaje esta en el suelo o no
     * @return esta en el suelo?
     */
    
    public boolean isGround() {
        return ground;
    }
    
    /**
     * Cambia la variable encontrarse en el suelo
     * @param ground nueva variable
     */

    public void setGround(boolean ground) {
        this.ground = ground;
    }

    /**
     * Consigue el peso en el agua
     * @return getGravityinW
     */

    public double getGravityinW() {
        return weightinW;
    }

    /**
     * dice si el personaje esta en el agua
     * @return esta en el agua?
     */
    
    public boolean isInWater() {
        return inWater;
    }
    
    /**
     * Consigue el tiempo maximo de estadia en el agua
     * @return tiempo maximo en el agua
     */

    public int getTimeinWater() {
        return timeinWater;
    }
    
    /**
     * consigue la velocidad de desplazamiento en X en el agua
     * @return desplazamiento en X en el agua
     */

    public double getVelmaxXinW() {
        return velmaxXinW;
    }

    /**
     * consigue la velocidad de desplazamiento en Y en el agua
     * @return desplazamiento en Y en el agua
     */
    
    public double getVelmaxYinW() {
        return velmaxYinW;
    }
    
    /**
     * Cambia el peso en el agua 
     * @param weightinW nuevo peso en el agua
     */

    public void setGravityinW(double weightinW) {
        this.weightinW = weightinW;
    }
    
    /**
     * Cambia la variable de agua 
     * @param inWater nueva variable en agua
     */

    public void setInWater(boolean inWater) {
        this.inWater = inWater;
    }
    
    /**
     * Cambia la cantidad de tiempo maximo en el agua
     * @param timeinWater nueva tiempo maximo de agua
     */

    public void setTimeinWater(int timeinWater) {
        this.timeinWater = timeinWater;
    }
    
    /**
     * Cambia la velocidad de desplazamiento en  X en el agua
     * @param velmaxXinW nuevo desplazamiento en X en el agua
     */

    public void setVelmaxXinW(double velmaxXinW) {
        this.velmaxXinW = velmaxXinW;
    }
    
    /**
     * Cambia la velocidad de desplazamiento en  Y en el agua
     * @param velmaxYinW nuevo desplazamiento en Y en el agua
     */

    public void setVelmaxYinW(double velmaxYinW) {
        this.velmaxYinW = velmaxYinW;
    }
    
}
