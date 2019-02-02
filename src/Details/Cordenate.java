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
public class Cordenate {
    private String part;
    private double x;
    private double y;
    private double large;
    private double high;
    private double animationN;

    public Cordenate(String part, double x, double y, double large, double high, double animationN) {
        this.part = part;
        this.x = x;
        this.y = y;
        this.large = large;
        this.high = high;
        this.animationN = animationN;
    }
    
    public Cordenate(String part, double x, double y, double large, double high) {
        this.part = part;
        this.x = x;
        this.y = y;
        this.large = large;
        this.high = high;
        this.animationN = 0;
    }

    public String getPart() {
        return part;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getLarge() {
        return large;
    }

    public double getHigh() {
        return high;
    }

    public double getAnimationN() {
        return animationN;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setLarge(double large) {
        this.large = large;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public void setAnimationN(double animationN) {
        this.animationN = animationN;
    }
    
}

