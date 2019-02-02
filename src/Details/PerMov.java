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
public class PerMov {
    protected Fisica fisicas;
    protected boolean lookingLeft;
    protected Live live;
    protected double[] cord= new double[6];
    protected double timeJump;
    protected double timeFalling;
    

    public PerMov(double velmaxX,  double velmaxY, int time, boolean lookLeft, int live, double Xref, double Yref, double velmaxXinW,double velmaxYinW,int time2, double large, double high) {
        this.fisicas = new Fisica(velmaxX, velmaxY, time, velmaxXinW, velmaxYinW, time2, 0.5,0.2);
        this.lookingLeft = lookLeft;
        this.live = new Live(live);
        this.cord[0]= Xref;
        this.cord[1]= Xref;
        this.cord[2]= Yref;
        this.cord[3]= Yref;
        this.cord[4]= large;
        this.cord[5]= high;
    }

    public Fisica getFisicas() {
        return fisicas;
    }

    public boolean isLookingLeft() {
        return lookingLeft;
    }

    public Live getLive() {
        return live;
    }
    
    public void loselife(int daño){
        this.live.lossLive(daño);
    }

    public void setFisicas(Fisica fisicas) {
        this.fisicas = fisicas;
    }

    public void setLookLeft(boolean lookLeft) {
        this.lookingLeft = lookLeft;
    }

    public void setLive(Live live) {
        this.live = live;
    }

    public void desplazar(){
        if(this.lookingLeft){
            this.cord[1]-=this.fisicas.getVelmaxX();
        }else{
            this.cord[1]+=this.fisicas.getVelmaxX();
        }
    }
    
    
    
    public void saltar(){
        if(this.fisicas.isGround()){
            this.fisicas.setJumping(true);
            this.timeJump=0;   
        } 
    }
    
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

    public double getX() {
        return this.cord[1];
    }
    
    public double getXref() {
        return this.cord[0];
    }
    
    public double getY() {
        return this.cord[3];
    }
    
    public double getYref() {
        return this.cord[2];
    }
    
    
    public double getLarge() {
        return this.cord[4];
    }
    
    public double getHigh() {
        return this.cord[5];
    }
    
    
    public void setX(double X) {
         this.cord[1]=X;
    }
    
    public void setXref(double Xref) {
         setX(this.cord[0]=Xref);
    }
    
    public void setY(double Y) {
         this.cord[3]=Y;
    }
    
    public void setYref(double Y) {
         setY(this.cord[2]=Y);
         
    }
    
    public void setLarge(double Y) {
         this.cord[4]=Y;
    }
    
    public void setHigh(double Y) {
         this.cord[5]=Y;
    }

    public double getTimeJump() {
        return timeJump;
    }

    public double getTimeFalling() {
        return timeFalling;
    }

    public void setCord(double[] cord) {
        this.cord = cord;
    }

    public void setTimeJump(double timeJump) {
        this.timeJump = timeJump;
    }

    public void setTimeFalling(double timeFalling) {
        this.timeFalling = timeFalling;
    }
    
    

    
    
    
    
    
}
