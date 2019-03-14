/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interactiv;
import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
/**
 * La clase Travel genera el nivel dentro del juego
 * @author Fabian Montes
 * @version 3.6.5
 */
public class SceneLevel {
    private Player gamer;
    private ArrayList<Double> limites;
    private ArrayList<Enemie> enemigos;
    private HashMap<String,Boolean> botons;
    private double[] sig;
    private String levelSig;
    private boolean paused;
    private boolean Btn;
    
    
    /**
     * Constructor de la clase
     * @param level nivel de la clase
     */
    
    public SceneLevel(String level){
        this.limites= new ArrayList<>();
        this.enemigos=new ArrayList<>();
        this.botons = new HashMap<>();
        this.botons.put("Right", false);
        this.botons.put("Left", Boolean.FALSE);
        this.botons.put("jump", Boolean.FALSE);
        this.botons.put("attack", Boolean.FALSE);
        this.botons.put("crouch", Boolean.FALSE);
        this.botons.put("up", Boolean.FALSE);
        this.botons.put("canJump",true);
        this.botons.put("isattacking",false);
        this.botons.put("hurt", Boolean.FALSE);
        this.botons.put("totalControl",false);
        this.botons.put("noControl", Boolean.FALSE);
        this.botons.put("onlyMove", Boolean.FALSE);
        this.botons.put("canMove", true);
        sig= new double[4];
        gamer= new Player(level, 0, 0);
        paused=false;
        Btn=false;
    }
    
    /**
     * Consigue al personaje usado del jugador
     * @return personaje usado por el jugador
     */

    public Player getGamer() {
        return gamer;
    }
    
    /**
     * Consigue la ubicacion del centro del plano en X
     * @return centro del plano en X
     */

    public double getrefX() {
        return limites.get(0);
    }
    
    /**
     * Consigue la ubicacion del centro del plano en Y
     * @return centro del plano en Y
     */
    
    public double getrefY() {
        return limites.get(1);
    }
    
    /**
     * Consigue la ubicacion del limite maximo del plano en X
     * @return limite maximo del plano en X
     */
    
    public double getrefmaxX() {
        return limites.get(2);
    }
    
    /**
     * Consigue la ubicacion del limite maximo del plano en Y
     * @return limite maximo del plano en Y
     */
    
    public double getrefmaxY() {
        return limites.get(3);
    }
    
    /**
     * Consigue la ubicacion inicial del centro de plano en X
     * @return inicial del centro del plano en X
     */
    
    public double getrefXini() {
        return limites.get(4);
    }
    
    /**
     * Consigue la ubicacion inicial del centro de plano en Y
     * @return inicial del centro del plano en Y
     */
    
    public double getrefYini() {
        return limites.get(5);
    }
    
    /**
     * Consigue la ubicacion inicial del maximo de plano en X
     * @return inicial del maximo del plano en X
     */
    
    public double getrefmaxXini() {
        return limites.get(6);
    }
    
    /**
     * Consigue la ubicacion inicial del maximo de plano en Y
     * @return inicial del maximo del plano en Y
     */
    
    public double getrefmaxYini() {
        return limites.get(7);
    }
    
    /**
     * consigue la ubicacion inicial del jugador en X
     * @return ubicacion inicial del jugador en X
     */
    
    public double getiniPlayerX() {
        return limites.get(8);
    }
    
    /**
     * consigue la ubicacion inicial del jugador en Y
     * @return ubicacion inicial del jugador en Y
     */
    
    public double getiniPlayerY() {
        return limites.get(9);
    }
    
    public void difrefX(double val) {
        limites.set(0, getrefX()+val);
    }
    public void difrefY(double val) {
        limites.set(1, getrefY()+val);
    }
    public void difrefmaxX(double val) {
        limites.set(2, getrefmaxX()+val);
    }
    public void difrefmaxY(double val) {
        limites.set(3, getrefmaxY()+val);
    }
    public void difrefXini(double val) {
        limites.set(4, getrefXini()+val);
    }
    public void difrefYini(double val) {
        limites.set(5, getrefYini()+val);
    }
    public void difrefmaxXini(double val) {
        limites.set(6, getrefmaxXini()+val);
    }
    public void difrefmaxYini(double val) {
        limites.set(7, getrefmaxYini()+val);
    }
    public void difiniPlayerX(double val) {
        limites.set(8, getiniPlayerX()+val);
    }
    public void difiniPlayerY(double val) {
        limites.set(9, getiniPlayerY()+val);
    }
    
    public void setrefX(double val) {
        limites.set(0,val);
    }
    public void setrefY(double val) {
        limites.set(1, val);
    }
    public void setrefmaxX(double val) {
        limites.set(2,val);
    }
    public void setrefmaxY(double val) {
        limites.set(3,val);
    }
    public void setrefXini(double val) {
        limites.set(4,val);
    }
    public void setrefYini(double val) {
        limites.set(5, val);
    }
    public void setrefmaxXini(double val) {
        limites.set(6, val);
    }
    public void setrefmaxYini(double val) {
        limites.set(7, val);
    }
    public void setiniPlayerX(double val) {
        limites.set(8, val);
    }
    public void setiniPlayerY(double val) {
        limites.set(9, val);
    }

    public ArrayList<Enemie> getEnemigos() {
        return enemigos;
    }
    
    public HashMap<String, Boolean> getBotons() {
        return botons;
    }
    
    public void changeUbicacion(){     
        gamer.setInvultime(gamer.getInvultime()+1);
        if(this.botons.get("jump")&&this.botons.get("canJump")){
            gamer.setJumping(true);
        }
        this.botons.replace("canJump", true);
        
        
        if((getrefY()<=650)&&!(gamer.getY()<=300)){
            gamer.movY();
        }else{
            if(gamer.getTimeJump()>=gamer.getFisicas().getTimejump()){
            gamer.setJumping(false);
            }
            if(gamer.getFisicas().isJumping()){
                if(!(getrefmaxY()+gamer.getFisicas().getVelmaxY()>=0)){
                    difrefmaxY(+gamer.getFisicas().getVelmaxY()-gamer.getFisicas().getGravedad()*gamer.getTimeFalling());
                    double a=gamer.getTimeFalling();
                    double b=gamer.getTimeJump();
                    gamer.setTimeFalling(a+0.5);
                    gamer.setTimeJump(b+0.5);
                    setrefY(getrefmaxY()+getrefmaxYini());
                }else{
                    gamer.movY();
                }
            }else if(!gamer.getFisicas().isGround()){
                if(getrefY()-gamer.getFisicas().getGravedad()*gamer.getTimeFalling()<650){
                    gamer.setY(gamer.getY()-(650-getrefY()-gamer.getFisicas().getGravedad()*gamer.getTimeFalling()));
                    setrefY(650);
                    double a=gamer.getTimeFalling();
                    gamer.setTimeFalling(a+0.5);
                    setrefmaxY(getrefY()-getrefmaxYini());
                }else if(getrefY()-gamer.getFisicas().getGravedad()*gamer.getTimeFalling()>650){
                    difrefY(-gamer.getFisicas().getGravedad()*gamer.getTimeFalling());
                    double a=gamer.getTimeFalling();
                    gamer.setTimeFalling(a+0.5);
                    setrefmaxY(getrefY()-getrefmaxYini());
                }else{
                    gamer.movY();
                }
            }else{
                gamer.movY();
            }
        }
        
        if(this.botons.get("canMove")){
            if(this.botons.get("attack")){
                if(this.botons.get("Right")){
                    gamer.Look("R");   
                }else if(this.botons.get("Left")){
                    gamer.Look("L");
                }
                gamer.setPose("attack");
            }else if(gamer.getFisicas().isGround()){
                if(this.botons.get("Right")){
                    gamer.Look("R");
                    if(this.botons.get("crouch")&&this.gamer.getTraje().equals("default")){
                        gamer.setPose("Mcrouch");
                    }else{
                        gamer.setPose("walk");
                    }
                    if(gamer.getX()>=700&&getrefmaxX()>1280){
                        if(getrefmaxX()-gamer.getFisicas().getVelmaxX()<1280){
                            setrefmaxX(1280);
                        }else{
                            difrefmaxX(-gamer.getFisicas().getVelmaxX());
                        }
                        setrefX(getrefmaxX()-getrefmaxXini());
                    }else{
                        gamer.desplazar();
                    }
                }else if(this.botons.get("Left")){
                    if(this.botons.get("crouch")&&this.gamer.getTraje().equals("default")){
                        gamer.setPose("Mcrouch");
                    }else{
                        gamer.setPose("walk");
                    }
                    gamer.Look("L");
                    if(gamer.getX()<=600&&getrefX()<0){
                        if(getrefX()+gamer.getFisicas().getVelmaxX()>0){
                            setrefX(0);
                        }else{
                            difrefX(gamer.getFisicas().getVelmaxX());
                        }
                        setrefmaxX(getrefX()+getrefmaxXini());
                    }else{
                        gamer.desplazar();
                    }
                }else{
                    if(botons.get("crouch")){
                        gamer.setPose("crouch");
                        if(gamer.getTraje().equals("aero")){
                            gamer.addPowerBar();
                            gamer.addPowerBar();
                        }
                    }else{
                        gamer.setPose("quiet");
                    }

                } 

            }else if(gamer.getFisicas().isJumping()){
                if(this.botons.get("Right")){
                    gamer.Look("R");
                    gamer.setPose("jump");
                    if(gamer.getX()>=700&&getrefmaxX()>1280){
                        if(getrefmaxX()-gamer.getFisicas().getVelmaxX()<1280){
                            setrefmaxX(1280);
                        }else{
                            difrefmaxX(-gamer.getFisicas().getVelmaxX());
                        }
                        setrefX(getrefmaxX()-getrefmaxXini());
                    }else{
                        gamer.desplazar();
                    }
                }else if(this.botons.get("Left")){
                    gamer.Look("L");
                    gamer.setPose("jump");
                    if(gamer.getX()<=600&&getrefX()<0){
                        if(getrefX()+gamer.getFisicas().getVelmaxX()>0){
                            setrefX(0);
                        }else{
                            difrefX(gamer.getFisicas().getVelmaxX());
                        }
                        setrefmaxX(getrefX()+getrefmaxXini());
                        }else{
                            gamer.desplazar();
                        }
                    }else{
                        gamer.setPose("jump");
                    }
            }else{
                if(this.botons.get("Right")){
                    gamer.Look("R");
                    gamer.setPose("fall");
                    if(gamer.getX()>=700&&getrefmaxX()>1280){
                        if(getrefmaxX()-gamer.getFisicas().getVelmaxX()<1280){
                            setrefmaxX(1280);
                        }else{
                            difrefmaxX(-gamer.getFisicas().getVelmaxX());
                        }
                        setrefX(getrefmaxX()-getrefmaxXini());
                    }else{
                        gamer.desplazar();
                    }
                }else if(this.botons.get("Left")){
                    gamer.Look("L");
                    gamer.setPose("fall");
                    if(gamer.getX()<=600&&getrefX()<0){
                        if(getrefX()+gamer.getFisicas().getVelmaxX()>0){
                            setrefX(0);
                        }else{
                            difrefX(gamer.getFisicas().getVelmaxX());
                        }
                        difrefmaxX(getrefX()+getrefmaxXini());
                        }else{
                            gamer.desplazar();
                        }
                    }else{
                        gamer.setPose("fall");
                    }
            }
        }
        if(gamer.getFisicas().isGround()&&gamer.getTraje().equals("aero")){
            gamer.reducePowerBar(1);
        }
        if(gamer.getPose2().equals("attack")&&!gamer.getPose().equals("attack")&&gamer.getTraje().equals("terra")){
            gamer.setPowerBar(0);
        }
        this.botons.replace("canMove", true);
        
        
    }

    public String getLevelSig() {
        return levelSig;
    }

    public Shape getNext(double refX,double refY) {
        return new Rectangle(refX+sig[0],refY-sig[1],sig[2],sig[3]);
    }

    public ArrayList<Double> getLimites() {
        return limites;
    }

    public double[] getSig() {
        return sig;
    }
    
    public boolean isPaused(){
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    public void switchPaused(){
        paused = !paused;
    }
    
    public boolean isBtn(){
        return Btn;
    }

    public void setBtn(boolean Btn) {
        this.Btn = Btn;
    }

    public void switchBtn(){
        Btn = !Btn;
    }

    public void setEnemigos(ArrayList<Enemie> enemigos) {
        this.enemigos = enemigos;
    }

    public void setLevelSig(String levelSig) {
        this.levelSig = levelSig;
    }
}
