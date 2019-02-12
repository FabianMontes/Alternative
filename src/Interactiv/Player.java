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
 * @version 2.5.2
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

    public boolean isCanGrow() {
        return canGrow;
    }

    public void setCanGrow(boolean canGrow) {
        this.canGrow = canGrow;
    }

    
    
    public Image getvisPlayerImage(){
        return visPlayer.get(traje).getUbicacion();
    }
    public double getVisPlayerX() {
        return visPlayer.get(traje).getPart(pose+look, 1)+(anim*visPlayer.get(traje).getPart(pose+look, 3));
    }
    
    public double getVisPlayerY() {
        return visPlayer.get(traje).getPart(pose+look, 2);
    }
    public double getVisPlayerLarge() {
        return visPlayer.get(traje).getPart(pose+look, 3);
    }
    
    
    
    public double getVisPlayerAncho() {
        return visPlayer.get(traje).getPart(pose+look, 4);
    }
    
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
    
    public Shape downColid(){
        if(look.equals("R")){
            return new Rectangle(getX()+36, getY()+(getHigh()-2), 34, 3);
        }else{
            return new Rectangle(getX()+45, getY()+(getHigh()-2), 34, 3);
        }
    }
    
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
    
    public ArrayList<Shape> damageColid(){
        ArrayList<Shape> damages =new ArrayList<>();
        switch(traje){
            case "terra":
                if(look.equals("R")){
                    damages.add(new Rectangle(getX()+27, getY()+5,getLarge()-75, getHigh()-5));
                }else{
                    damages.add(new Rectangle());
                }
                
            break;
        }
        return damages;
    }
    
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

    public String getPose2() {
        return pose2;
    }
    
    public String getTraje() {
        return traje;
    }

    public String getPose() {
        return pose;
    }

    public String getLook() {
        return look;
    }

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

    public void setPose(String pose) {
        this.pose = pose;
        if(!pose2.equals(this.pose)){
            this.anim=0;
            pose2=this.pose;
        }
    }

    public void Look(String d) {
        look=d;
        if(look.equals("L")){
            setLookLeft(true);
        }else{
            setLookLeft(false);
        }
    }

    public String getPower() {
        return power;
    }

    
    
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
    
    public void setHurt(int daño){
        if(invultime>=100){
            loselife(daño);
            invultime=0;
        }
        
    }

    public int getInvultime() {
        return invultime;
    }

    public void setInvultime(int invultime) {
        this.invultime = invultime;
    }

    public void setAnim(int anim) {
        this.anim = anim;
    }

    public ArrayList<String> getUnlockedPowers() {
        return unlockedPowers;
    }

    public void setUnlockedPowers(ArrayList<String> unlockedPowers) {
        this.unlockedPowers = unlockedPowers;
    }
    
}
