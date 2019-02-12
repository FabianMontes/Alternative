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
public class EnemiesCord {
    private String minion;
    private double x;
    private double y;
    private double minX;
    private double maxX;
    private double minY;
    private double maxY;
    private double animationN;

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

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getAnimationN() {
        return animationN;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setAnimationN(double animationN) {
        this.animationN = animationN;
    }

    public double getMaxX() {
        return maxX;
    }

    public String getMinion() {
        return minion;
    }

    public double getMinX() {
        return minX;
    }

    public double getMinY() {
        return minY;
    }

    public double getMaxY() {
        return maxY;
    }

    public void setMinion(String minion) {
        this.minion = minion;
    }

    public void setMinX(double minX) {
        this.minX = minX;
    }

    public void setMaxX(double maxX) {
        this.maxX = maxX;
    }

    public void setMinY(double minY) {
        this.minY = minY;
    }

    public void setMaxY(double maxY) {
        this.maxY = maxY;
    }
    
    public boolean inLimitX(boolean look,double large){
        if(look){
            return x<minX;
        }else{
            return x+large>maxX;
        }
    }
    
    public boolean inLimitY(boolean up,double alto){
        if(up){
            return y>maxY;
        }else{
            return y+alto>minY;
        }
    }
    
}

