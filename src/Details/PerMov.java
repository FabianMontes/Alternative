/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Details;

/**
 * Clase usada para todo personaje que realize movimiento
 * @author Fabian Montes
 * @version 3.2.2
 */
public class PerMov {
    protected Fisica fisicas;
    protected boolean lookingLeft;
    protected Live live;
    protected double[] cord= new double[6];
    protected double timeJump;
    protected double timeFalling;
    protected int damage;
    
    /**
     * Constructor 1 con gravedad especifica
     * @param velmaxX velocidad del dezplazamiento en X
     * @param velmaxY velocidad de dezplazamiento en Y
     * @param time tiempo maximo de salto
     * @param lookLeft direccion hacia donde mira
     * @param live viva total del objetivo
     * @param Xref ubicacion inical en X
     * @param Yref ubicacion inical en Y
     * @param velmaxXinW velocidad de dezplazamiento en X en el agua
     * @param velmaxYinW velocidad de dezplazamiento en Y en el agua
     * @param time2 tiempo maximo de estadia en el agua
     * @param large largo del personaje
     * @param high alto del personaje
     * @param damage daño que realiza el personaje
     * @param gravity Gravedad del personaje
     * @param gravityinW Gravedad en el agua del personaje
     */

    public PerMov(double velmaxX,  double velmaxY, int time, boolean lookLeft, int live, double Xref, double Yref, double velmaxXinW,double velmaxYinW,int time2, double large, double high, int damage, double gravity, double gravityinW) {
        this.fisicas = new Fisica(velmaxX, velmaxY, time, velmaxXinW, velmaxYinW, time2, gravity, gravityinW);
        this.lookingLeft = lookLeft;
        this.live = new Live(live);
        this.cord[0]= Xref;
        this.cord[1]= Xref;
        this.cord[2]= Yref;
        this.cord[3]= Yref;
        this.cord[4]= large;
        this.cord[5]= high;
        this.damage =damage;
    }
    
    /**
     * Constructor 2 con gravedad estandar
     * @param velmaxX velocidad del dezplazamiento en X
     * @param velmaxY velocidad de dezplazamiento en Y
     * @param time tiempo maximo de salto
     * @param lookLeft direccion hacia donde mira
     * @param live viva total del objetivo
     * @param Xref ubicacion inical en X
     * @param Yref ubicacion inical en Y
     * @param velmaxXinW velocidad de dezplazamiento en X en el agua
     * @param velmaxYinW velocidad de dezplazamiento en Y en el agua
     * @param time2 tiempo maximo de estadia en el agua
     * @param large largo del personaje
     * @param high alto del personaje
     * @param damage daño que realiza el personaje
     */
    
    public PerMov(double velmaxX,  double velmaxY, int time, boolean lookLeft, int live, double Xref, double Yref, double velmaxXinW,double velmaxYinW,int time2, double large, double high, int damage) {
        this.fisicas = new Fisica(velmaxX, velmaxY, time, velmaxXinW, velmaxYinW, time2);
        this.lookingLeft = lookLeft;
        this.live = new Live(live);
        this.cord[0]= Xref;
        this.cord[1]= Xref;
        this.cord[2]= Yref;
        this.cord[3]= Yref;
        this.cord[4]= large;
        this.cord[5]= high;
        this.damage =damage;
    }
    
    /**
     * Consigue las fisicas del personaje
     * @return fisicas del personaje
     */

    public Fisica getFisicas() {
        return fisicas;
    }
    
    /**
     * Dice en que orientacion mira el personaje
     * @return orientacion actual
     */

    public boolean isLookingLeft() {
        return lookingLeft;
    }
    
    /**
     * Consigue la informacion de la vida del personaje
     * @return informacion de vida
     */

    public Live getLive() {
        return live;
    }
    
    /**
     * Pierde cierta cantidad de vida
     * @param daño vida perdida/daño recibido
     */
    
    public void loselife(int daño){
        this.live.lossLive(daño);
    }
    
    /**
     * Cambia todas las fisicas de los campeones
     * @param fisicas nuevas fisicas
     */

    public void setFisicas(Fisica fisicas) {
        this.fisicas = fisicas;
    }
    
    /**
     * Cambia la orientacion del personaje
     * @param lookLeft nueva orientacion
     */

    public void setLookLeft(boolean lookLeft) {
        this.lookingLeft = lookLeft;
    }
    
    /**
     * Cambia la informacion de la vida del personaje
     * @param live nueva vida
     */

    public void setLive(Live live) {
        this.live = live;
    }
    
    /**
     * Desplaza al personaje en el eje X segun su orientacion
     */

    public void desplazar(){
        if(this.lookingLeft){
            this.cord[1]-=this.fisicas.getVelmaxX();
        }else{
            this.cord[1]+=this.fisicas.getVelmaxX();
        }
    }
    
    /**
     * hace que el personaje entre en estado de salto
     */
    
    public void saltar(){
        if(this.fisicas.isGround()){
            this.fisicas.setJumping(true);
            this.timeJump=0;   
        } 
    }
    
    /**
     * Desplaza al personaje en el eje Y
     */
    
    public void movY(){
        if(this.timeJump>=this.fisicas.getTimejump()){
            this.fisicas.setJumping(false);
        }
        if(this.fisicas.isGround()){
            this.timeFalling=0;
            this.timeJump=0;
        }else{
            this.timeFalling+=0.5;
        }
            
        if(this.fisicas.isJumping()){
            this.timeFalling=this.timeJump;
            this.cord[3]-= this.fisicas.getVelmaxY()-this.fisicas.getGravedad()*this.timeFalling;
            this.timeJump+=0.5;
        }else if(!this.fisicas.isGround()){
            this.cord[3]+=this.fisicas.getGravedad()*this.timeFalling;
            this.fisicas.setJumping(false);
        }
    }
    
    /**
     * Consigue la ubicacion en X
     * @return ubicacion en X
     */

    public double getX() {
        return this.cord[1];
    }
    
    /**
     * Consigue la ubicacion inicial en X
     * @return ubicacion inicial en X
     */
    
    public double getXref() {
        return this.cord[0];
    }
    
    /**
     * Consigue la ubicacion en Y
     * @return ubicacion en Y
     */
    
    public double getY() {
        return this.cord[3];
    }
    
    /**
     * Consigue la ubicacion inicial en Y
     * @return ubicacion inicial en Y
     */
    
    public double getYref() {
        return this.cord[2];
    }
    
    /**
     * Consigue el largo del personaje
     * @return largo del personaje
     */
    
    public double getLarge() {
        return this.cord[4];
    }
    
    /**
     * Consigue el alto del personaje
     * @return alto del personaje
     */
    
    public double getHigh() {
        return this.cord[5];
    }
    
    /**
     * Cambia la ubicacion del X del personaje
     * @param X nuevo X
     */
    
    public void setX(double X) {
         this.cord[1]=X;
    }
    
    /**
     * Cambia la ubicacion del X inicial del personaje
     * @param Xref nuevo X inicial
     */
    
    public void setXref(double Xref) {
         setX(this.cord[0]=Xref);
    }
    
    /**
     * Cambia la ubicacion del Y del personaje
     * @param Y nuevo X
     */
    
    public void setY(double Y) {
         this.cord[3]=Y;
    }
    
    /**
     * Cambia la ubicacion del Y inicial del personaje
     * @param Yref nuevo Y inicial
     */
    
    public void setYref(double Yref) {
         setY(this.cord[2]=Yref);
    }
    
    /**
     * Cambia el largo del personaje
     * @param large 
     */
    
    public void setLarge(double large) {
         this.cord[4]=large;
    }
    
    /**
     * Cambia el alto del personaje
     * @param high
     */
    
    public void setHigh(double high) {
         this.cord[5]=high;
    }

    /**
     * Consigue el tiempo del personaje saltando
     * @return tiempo saltando
     */
    
    public double getTimeJump() {
        return timeJump;
    }
    
    /**
     * Consigue el tiempo callendo del personaje
     * @return tiempo saltando
     */

    public double getTimeFalling() {
        return timeFalling;
    }
    
    /**
     * Cambia todas las coordenadas del personaje
     * @param cord nuevas coordenadas
     */

    public void setCord(double[] cord) {
        this.cord = cord;
    }
    
    /**
     * Cambia el tiempo que lleva saltando el personaje
     * @param timeJump nuevo tiempo saltando
     */

    public void setTimeJump(double timeJump) {
        this.timeJump = timeJump;
    }
    
    /**
     * Cambia el tiempo saltando
     * @param timeFalling nuevo tiempo saltando
     */

    public void setTimeFalling(double timeFalling) {
        this.timeFalling = timeFalling;
    }
    
    /**
     * Consigue el daño que realiza el personaje
     * @return el daño del personaje
     */

    public int getDamage() {
        return damage;
    }
    
    /**
     * Cambia daño que realiza el personaje
     * @param damage nuevo daño
     */

    public void setDamage(int damage) {
        this.damage = damage;
    }
    
}
