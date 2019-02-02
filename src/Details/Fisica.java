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
public class Fisica {
    private double gravedad;
    private double gravityinW;
    private double velmaxX;
    private double velmaxY;
    private boolean jumping;
    private int timejump;
    private boolean ground;
    private boolean inWater;
    private int timeinWater;
    private double velmaxXinW;
    private double velmaxYinW;

    public Fisica(double velmaxX, double velmaxY, int timejump, double velmaxXinW, double velmaxYinW, int timeinWater, double gravedad, double gravityinW) {
        this.gravedad = gravedad;
        this.gravityinW = gravityinW;
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

    
    
    public Fisica(double velmaxX, double velmaxY, int time1, double velmaxXinW, double velmaxYinW, int time2) {
        this.velmaxX = velmaxX;
        this.velmaxY = velmaxY;
        this.jumping =false;
        this.timejump=time1;
        this.ground =false;
        this.velmaxXinW = velmaxXinW;
        this.velmaxYinW = velmaxYinW;
        this.inWater =false;
        this.timeinWater=time2;
    }

    public double getGravedad() {
        return gravedad;
    }

    public double getVelmaxX() {
        return velmaxX;
    }

    public double getVelmaxY() {
        return velmaxY;
    }

    public void setGravedad(double gravedad) {
        this.gravedad = gravedad;
    }

    public void setVelmaxX(double velmaxX) {
        this.velmaxX = velmaxX;
    }

    public void setVelmaxY(double velmaxY) {
        this.velmaxY = velmaxY;
    }

    public boolean isJumping() {
        return jumping;
    }

    public void setJumping(boolean jumping) {
        this.jumping = jumping;
    }

    public int getTimejump() {
        return timejump;
    }

    public void setTimejump(int timejump) {
        this.timejump = timejump;
    }

    public void setGround(boolean ground) {
        this.ground = ground;
    }

    public boolean isGround() {
        return ground;
    }

    public double getGravityinW() {
        return gravityinW;
    }

    public boolean isInWater() {
        return inWater;
    }

    public int getTimeinWater() {
        return timeinWater;
    }

    public double getVelmaxXinW() {
        return velmaxXinW;
    }

    public double getVelmaxYinW() {
        return velmaxYinW;
    }

    public void setGravityinW(double gravityinW) {
        this.gravityinW = gravityinW;
    }

    public void setInWater(boolean inWater) {
        this.inWater = inWater;
    }

    public void setTimeinWater(int timeinWater) {
        this.timeinWater = timeinWater;
    }

    public void setVelmaxXinW(double velmaxXinW) {
        this.velmaxXinW = velmaxXinW;
    }

    public void setVelmaxYinW(double velmaxYinW) {
        this.velmaxYinW = velmaxYinW;
    }
    
        
}
