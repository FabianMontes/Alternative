/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interactiv;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javafx.scene.image.Image;
import javafx.scene.shape.*;
import Details.PerMov;
import Details.LectoEscritura;
import Details.Visual;
import java.util.ArrayList;


/**
 * Esta Clase sirve para representar al personaje manejado por el jugador
 * @author fanat
 * @version 2.5.3
 */
public class Player extends PerMov{
    private HashMap<String,Visual> visPlayer;
    private String traje;
    private String pose;
    private String pose2;
    private int anim;
    private String look;
    private String look2;
    private String power;
    private ArrayList<String> unlockedPowers;
    private int invultime;
    private boolean canGrow;
    
    /**
     * Constructor del jugador
     * @param level Nivel en donde se encuentra
     * @param x ubicacion original en X
     * @param y ubicacion original en Y
     * @throws IOException 
     */
    
    public Player(String level, double x, double y) throws IOException {
        super(4, 7, 10, false, 100, 350, 100,12,20,30,115,126,10);
        visPlayer= new HashMap<>();
        unlockedPowers=LectoEscritura.detectKey(new File("src/code/"+level+"lim.txt"),"powers");
        System.out.println(unlockedPowers.size());
        look2=look="R";
        pose2=pose="quiet";
        power=traje="default";
        visPlayer= LectoEscritura.PartesEnImagen("src/code/PlayerImage.txt", visPlayer);
        anim=0;
        invultime=20;
        canGrow=true;
    }
    
    /**
     * Dice si tiene o no espacio para crecer
     * @return tiene espacio?
     */

    public boolean isCanGrow() {
        return canGrow;
    }

    /**
     * Cambia la variable de tener espacio para crecer
     * @param canGrow nueva variable
     */
    
    public void setCanGrow(boolean canGrow) {
        this.canGrow = canGrow;
    }

    /**
     * consigue la imagen del traje usado por el personaje
     * @return imagen traje
     */
    
    public Image getvisPlayerImage(){
        return visPlayer.get(traje).getUbicacion();
    }
    
    /**
     * Consigue la ubicacion del pixel X en la imagen del personaje
     * @return ubicacion en X de la imagen
     */
    
    public double getVisPlayerX() {
        return visPlayer.get(traje).getPart(pose+look, 1)+(anim*visPlayer.get(traje).getPart(pose+look, 3));
    }
    
    /**
     * Consigue la ubicacion del pixel Y en la imagen del personaje
     * @return ubicacion en Y de la imagen
     */
    
    public double getVisPlayerY() {
        return visPlayer.get(traje).getPart(pose+look, 2);
    }
    
    /**
     * Consigue el largo de la imagen del personaje
     * @return largo de la imagen
     */
    public double getVisPlayerLarge() {
        return visPlayer.get(traje).getPart(pose+look, 3);
    }
    
    /**
     * Consigue el ancho de la imagen del personaje
     * @return ancho de la imagen
     */
    
    public double getVisPlayerAncho() {
        return visPlayer.get(traje).getPart(pose+look, 4);
    }
    
    /**
     * Consigue el espacio de la parte de arriba del jugador 
     * @return parte de arriba del personaje
     */
    
    public Shape upColid(){
        if(look.equals("R")){
            if(pose.contains("crouch")&&!traje.contains("terra")){
                return new Rectangle(getX()+getLarge()/16.0+16, getY()+66,40, 10);
            }else{
                return new Rectangle(getX()+getLarge()/16.0+16, getY(), 40, 10);
            }
        }else{
            if(pose.contains("crouch")&&!traje.contains("terra")){
                return new Rectangle(getX()+getLarge()/16.0+42, getY()+66,50, 10);
            }else{
                return new Rectangle(getX()+getLarge()/16.0+42, getY(), 50, 10);
            }
        }
        
    }
    
    /**
     * Consigue el espacio mas arrriba del jugador
     * @return parte mas arriba del jugador
     */
    
    public Shape upUPColid(){
        if(look.equals("R")){
            if(pose.contains("crouch")&&!traje.contains("terra")){
                return new Rectangle(getX()+getLarge()/16.0+16, getY()+63,40, 3);
            }else{
                return new Rectangle(getX()+getLarge()/16.0+16, getY()-5, 40, 5);
            }
        }else{
            if(pose.contains("crouch")&&!traje.contains("terra")){
                return new Rectangle(getX()+getLarge()/16.0+42, getY()+63,50, 3);
            }else{
                return new Rectangle(getX()+getLarge()/16.0+42, getY()-5, 50, 5);
            }
        }
    }
    
    /**
     * Consigue la parte baja del jugador
     * @return parte baja del jugador
     */
    
    public Shape downColid(){
        if(look.equals("R")){
            return new Rectangle(getX()+36, getY()+(getHigh()-2), 34, 3);
        }else{
            return new Rectangle(getX()+45, getY()+(getHigh()-2), 34, 3);
        }
    }
    
    /**
     * Consigue la parte zurda del jugador
     * @return parte zurda del jugador
     */
    
    public Shape leftColid(){
        if(look.equals("R")){
            if(pose.contains("crouch")&&!traje.contains("terra")){
                return new Rectangle(getX()+25, getY()+70, 10, 50);
            }else{
                return new Rectangle(getX()+25, getY()+7, 10, 100);
            }
        }else{
            if(pose.contains("crouch")&&!traje.contains("terra")){
                return new Rectangle(getX()+41, getY()+66, 10, 50);
            }else{
                return new Rectangle(getX()+41, getY()+7, 10, 100);
            }
        }
        
    }
    
    /**
     * Consigue la parte diestra del jugador
     * @return parte diestra del jugador
     */
    
    public Shape rightColid(){
        if(look.equals("R")){
            if(pose.contains("crouch")&&!traje.contains("terra")){
                return new Rectangle(getX()+getLarge()-52, getY()+70, 10, 50);
            }else{
                return new Rectangle(getX()+getLarge()-52, getY()+7, 10, 110);
            }
        }else{
            if(pose.contains("crouch")&&!traje.contains("terra")){
                return new Rectangle(getX()+getLarge()-35, getY()+66, 10, 50);
            }else{
                return new Rectangle(getX()+getLarge()-35, getY()+7, 10, 110);
            }
        }   
    }
    
    /**
     * Consigue la parte del personaje donde recibe daño
     * @return parte del personaje donde recibe daño
     */
    
    public Shape personColid(){
        if(look.equals("R")){
            if(pose.contains("crouch")&&!traje.contains("terra")){
                return new Rectangle(getX()+30, getY()+66,getLarge()-75, getHigh()/2-5);
            }else{
                return new Rectangle(getX()+27, getY()+5,getLarge()-75, getHigh()-5);
            }
        }else{
            if(getPose().contains("crouch")&&!getTraje().contains("terra")){
                return new Rectangle(getX()+45, getY()+66,getLarge()-75, getHigh()/2-5);
            }else{
                return new Rectangle(getX()+45, getY()+5,getLarge()-75, getHigh()-5);
            }

        }
    }
    
    /**
     * Lista de formas donde el jugador hace daño
     * @return lugares donde hacen daño
     */
    
    public ArrayList<Shape> damageColid(){
        ArrayList<Shape> damages =new ArrayList<>();
        damages.clear();
        switch(traje){
            case "terra":
                if(look.equals("R")){
                    damages.add(new Rectangle(getX()+27, getY()+5,getLarge()-75, getHigh()-5));
                }else{
                    damages.add(new Rectangle());
                }
                
            break;
            case "default":
                damages.clear();
            break;
        }
        return damages;
    }
    
    /**
     * Cambia la animacion del personaje segun el traje su orientacion y la pose 
     */
    
    public void setAnimation(){
        if(pose.equals("quiet")&&!look2.equals(look)){
            anim=0;
            look2=look;
        }
        if(pose2.equals(pose)){
            if(anim>=visPlayer.get(traje).getPart(pose+look, 5)){
                switch (pose) {
                    case "quiet":
                        anim=9;
                        break;
                    case "jump":
                    case "fall":
                        break;
                    default:
                        anim=0;
                        break;
                }
            }else{
                anim++;
            }
        }else{
            anim=0;
            pose2=pose;
        }       
    }
    
    /**
     * Consigue la pose anterior que tenia el personaje
     * @return pose anterior del personaje
     */

    public String getPose2() {
        return pose2;
    }
    
    /**
     * Consigue el traje actual del personaje
     * @return traje actual
     */
    
    public String getTraje() {
        return traje;
    }
    
    /**
     * Consigue a pose actual del personaje
     * @return pose actual
     */

    public String getPose() {
        return pose;
    }
    
    /**
     * consigue la orientacion actual del personaje
     * @return orientacion actual
     */

    public String getLook() {
        return look;
    }
    
    /**
     * Cambia el traje por el poder actual siempre que sea posible
     */

    public void setTraje() {
        if(!traje.equals(power)){
            if(power.equals("terra")){
                if(canGrow){
                    this.traje = this.power;
                    anim=0;
                }
            }else{
                this.traje = this.power;
                anim=0;
            }
            
        }
    }
    
    /**
     * Cambia la pose actual
     * @param pose nueva pose 
     */

    public void setPose(String pose) {
        this.pose = pose;
        if(!pose2.equals(this.pose)){
            this.anim=0;
            pose2=this.pose;
        }
    }
    
    /**
     * Cambia la orientacion del personaje
     * @param d nueva orientacion
     */

    public void Look(String d) {
        look=d;
        if(look.equals("L")){
            setLookLeft(true);
        }else{
            setLookLeft(false);
        }
    }

    /**
     * Consigue el poder actual del personaje
     * @return poder actual
     */
    
    public String getPower() {
        return power;
    }

    /**
     * Cambia el poder actual por el siguiente desbloqueado
     */
    
    public void changePower() {
        switch(unlockedPowers.size()){
            case 1:
                switch(power){
                    case "default":
                        power="terra";
                    break;
                    case "terra":
                        power="default";
                    break;
                }
            break;
            case 2:
                switch(power){
                    case "default":
                        power="terra";
                    break;
                    case "terra":
                        power="aero";
                    break;
                    case "aero":
                        power="default";
                    break;
                }
            break;
            case 3:
                switch(power){
                    case "default":
                        power="terra";
                    break;
                    case "terra":
                        power="aero";
                    break;
                    case "aero":
                        power="aqua";
                    break;
                    case "aqua":
                        power="default";
                    break;
                }
            break;
            case 4:
                switch(power){
                    case "default":
                        power="terra";
                    break;
                    case "terra":
                        power="aero";
                    break;
                    case "aero":
                        power="aqua";
                    break;
                    case "aqua":
                        power="pyro";
                    break;
                    case "pyro":
                        power="default";
                    break;
                }
            break;
        }
    }
    
    /**
     * Hiere al personaje cierta cantidad de daño siempre que no sea invulnerable
     * @param daño daño recibido
     */
    
    public void setHurt(int daño){
        if(invultime>=100){
            loselife(daño);
            invultime=0;
        }
    }
    
    /**
     * Consigue el tiempo sin recibir daño
     * @return tiempo sin recibir daño
     */

    public int getInvultime() {
        return invultime;
    }
    
    /**
     * 
     * Cambia el tiempo sin recibir daño
     * @param invultime nuevo  tiempo sin daño
     */

    public void setInvultime(int invultime) {
        this.invultime = invultime;
    }
    
    /**
     * cambia la animacion a uno en especifico
     * @param anim nueva animacion
     */

    public void setAnim(int anim) {
        this.anim = anim;
    }
    
    /**
     * consigue la lista de los poderes despbloqueados
     * @return poderes desbloqueados
     */

    public ArrayList<String> getUnlockedPowers() {
        return unlockedPowers;
    }
    
    /**
     * Cambia toda la lista de poderes desbloqueados
     * @param unlockedPowers nuevos poderes desbloqueados
     */

    public void setUnlockedPowers(ArrayList<String> unlockedPowers) {
        this.unlockedPowers = unlockedPowers;
    }
    
}
