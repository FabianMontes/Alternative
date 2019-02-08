/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package Details;

import java.util.ArrayList;

/**
 *La Clase Loop es donde generaremos la interaccion entre el uego y el jugador.
 * @author Fabián Montes.
 * @version 2.41.7.
 */
public class UbiGroup {
    private String group;
    private ArrayList<Double> difX;
    private ArrayList<Double> difY;
    private ArrayList<Double> difLarge;
    private ArrayList<Double> difAncho;

    /**
     * Constuctor
     * @param group el nombre del grupo de objetos;
     */
    public UbiGroup(String group) {
        this.group = group;
        this.difX = new ArrayList<>();
        this.difY = new ArrayList<>();
        this.difLarge = new ArrayList<>();
        this.difAncho = new ArrayList<>();
    }

    /**
     * consigue el nombre de grupos
     * @return el nombre de el grupo
     */
    public String getGroup() {
        return group;
    }

    /**
     * cambiar el nombre del grupo
     * @param group nuevo nombre del grupo 
     */
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * añade un nuevo objeto al grupo
     * @param x ubicacion en x del objeto
     * @param y ubicacion en y del objeto
     * @param lar largo del objeto
     * @param anc ancho del objeto
     */
    public void addGroup(double x, double y,double lar, double anc){
        this.difX.add(x);
        this.difY.add(y);
        this.difLarge.add(lar);
        this.difAncho.add(anc);
    }
    
    /**
     * Borra un objeto del grupo
     * @param a numero del objeto a borrar
     */
    
    public void removeGroup(int a){
        this.difX.remove(a);
        this.difY.remove(a);
        this.difLarge.remove(a);
        this.difAncho.remove(a);
    }
    
    /**
     * Conseguir la Ubicacion en X de determinado objeto
     * @param a numero del objeto a conocer
     * @return la ubicacion en X del objeto
     */
    
    public double getGroupX(int a){
        return this.difX.get(a);
    }
    
    /**
     * Conseguir la Ubicacion en Y de determinado objeto
     * @param a numero del objeto a conocer
     * @return la ubicacion en Y del objeto
     */
    
    public double getGroupY(int a){
        return this.difY.get(a);
    }
    
    /**
     * Conseguir el largo de determinado objeto
     * @param a numero del objeto a conocer
     * @return el largo del objeto
     */
    
    public double getGroupLarge(int a){
        return this.difLarge.get(a);
    }
    
    /**
     * Conseguir el ancho de determinado objeto
     * @param a numero del objeto a conocer
     * @return el ancho del objeto
     */
    
    public double getGroupAncho(int a){
        return this.difAncho.get(a);
    }
    
    /**
     * Reemplazar un objeto del grupo por otro
     * @param a objeto a ser reemplazado
     * @param x nueva ubicacion en X
     * @param y nueva ubicacion en Y
     * @param lar nuevo largo
     * @param anc nuevo ancho
     */
    
    public void replaceGroup(int a, double x, double y,double lar, double anc){
        this.difX.set(a, x);
        this.difY.set(a, y);
        this.difLarge.set(a, lar);
        this.difAncho.set(a, anc);
    }
    
    /**
     * Cantidad de Objetos en el grupo
     * @return cantidad de objetos
     */
    
    public int size(){
        return Math.max(difX.size(), Math.max(difY.size(), Math.max(difLarge.size(), difAncho.size())));
    }       

    /**
     * da todas las ubicaciones en X de los objetos
     * @return todas las ubicaciones en X
     */
    
    public ArrayList<Double> getDifX() {
        return difX;
    }
    
    /**
     * da todas las ubicaciones en Y de los objetos
     * @return todas las ubicaciones en Y
     */

    public ArrayList<Double> getDifY() {
        return difY;
    }

    /**
     * da todos los largos de los objetos
     * @return todos los largos
     */
    
    public ArrayList<Double> getDifLarge() {
        return difLarge;
    }
    
    /**
     * da todos los anchos de los objetos
     * @return todos los anchos
     */
    
    public ArrayList<Double> getDifAncho() {
        return difAncho;
    }

    /**
     * cambia todas las ubicaciones en X de los objetos
     * @param difX todas las nuevas ubicaciones en X
     */
    
    public void setDifX(ArrayList<Double> difX) {
        this.difX = difX;
    }
    
    /**
     * cambia todas las ubicaciones en Y de los objetos
     * @param difY todas las nuevas ubicaciones en Y
     */
    
    public void setDifY(ArrayList<Double> difY) {
        this.difY = difY;
    }
    
    /**
     * Cambia todos los largos de los objetos
     * @param difLarge los nuevos largos 
     */

    public void setDifLarge(ArrayList<Double> difLarge) {
        this.difLarge = difLarge;
    }

    /**
     * Cambia todos los anchos de los objetos
     * @param difAncho los nuevos largos 
     */
    
    public void setDifAncho(ArrayList<Double> difAncho) {
        this.difAncho = difAncho;
    }
}
