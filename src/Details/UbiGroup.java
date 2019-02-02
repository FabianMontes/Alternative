/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package Details;

import java.util.ArrayList;

/**
 *
 * @author fanat
 */
public class UbiGroup {
    private String group;
    private ArrayList<Double> difX;
    private ArrayList<Double> difY;
    private ArrayList<Double> difLarge;
    private ArrayList<Double> difAncho;

    public UbiGroup(String group) {
        this.group = group;
        this.difX = new ArrayList<>();
        this.difY = new ArrayList<>();
        this.difLarge = new ArrayList<>();
        this.difAncho = new ArrayList<>();
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void addGroup(double x, double y,double lar, double anc){
        this.difX.add(x);
        this.difY.add(y);
        this.difLarge.add(lar);
        this.difAncho.add(anc);
    }
    
    public void removeGroup(int a){
        this.difX.remove(a);
        this.difY.remove(a);
        this.difLarge.remove(a);
        this.difAncho.remove(a);
    }
    
    public double getGroupX(int a){
        return this.difX.get(a);
    }
    
    public double getGroupY(int a){
        return this.difY.get(a);
    }
    
    public double getGroupLarge(int a){
        return this.difLarge.get(a);
    }
    
    public double getGroupAncho(int a){
        return this.difAncho.get(a);
    }
    
    public void replaceGroup(int a, double x, double y,double lar, double anc){
        this.difX.set(a, x);
        this.difY.set(a, y);
        this.difLarge.set(a, lar);
        this.difAncho.set(a, anc);
    }
    
    public int size(){
        return Math.max(difX.size(), Math.max(difY.size(), Math.max(difLarge.size(), difAncho.size())));
    }       

    public ArrayList<Double> getDifX() {
        return difX;
    }

    public ArrayList<Double> getDifY() {
        return difY;
    }

    public ArrayList<Double> getDifLarge() {
        return difLarge;
    }

    public ArrayList<Double> getDifAncho() {
        return difAncho;
    }

    public void setDifX(ArrayList<Double> difX) {
        this.difX = difX;
    }

    public void setDifY(ArrayList<Double> difY) {
        this.difY = difY;
    }

    public void setDifLarge(ArrayList<Double> difLarge) {
        this.difLarge = difLarge;
    }

    public void setDifAncho(ArrayList<Double> difAncho) {
        this.difAncho = difAncho;
    }
    
    
    
}
