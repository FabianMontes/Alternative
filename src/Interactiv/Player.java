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


/**
 *
 * @author fanat
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
    private HashMap<String,Integer> unlockedPowers;
    private int trajesDesbloq;
    private int invultime;

    public Player(String Savegame, String pose2, int anim, String look, String look2, String power, HashMap<String, Integer> unlockedPowers, int trajesDesbloq, int invultime, double velmaxX, double velmaxY, int time, boolean lookLeft, int live, double Xref, double Yref, double velmaxXinW, double velmaxYinW, int time2, double large, double high) throws IOException {
        super(velmaxX, velmaxY, time, lookLeft, live, Xref, Yref, velmaxXinW, velmaxYinW, time2, large, high);
        visPlayer= new HashMap<>();
        this.unlockedPowers=LectoEscritura.getPowers(new File(Savegame),"powers");
        this.visPlayer = visPlayer;
        this.traje = traje;
        this.pose = pose;
        this.pose2 = pose2;
        this.anim = anim;
        this.look = look;
        this.look2 = look2;
        this.power = power;
        this.unlockedPowers = unlockedPowers;
        this.trajesDesbloq = trajesDesbloq;
        this.invultime = invultime;
    }
    
    
    
    
    public Player(String Savegame, double x, double y) throws IOException {
        super(3, 8, 10, false, 100, 350, 100,12,20,30,115,126);
        visPlayer= new HashMap<>();
        unlockedPowers=LectoEscritura.getPowers(new File(Savegame),"powers");
        trajesDesbloq=cantPowers(unlockedPowers);
        System.out.println(trajesDesbloq);
        look2=look="R";
        pose2=pose="quiet";
        power=traje="default";
        visPlayer= LectoEscritura.PartesEnImagen("src/code/PlayerImage.txt", visPlayer);
        anim=0;
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
    
    private int cantPowers(HashMap<String,Integer> powers){
        if(powers.get("terra")==0){
            return 0;
        }else if(powers.get("aero")==0){
            return 1;
        }else if(powers.get("aqua")==0){
            return 2;
        }else if(powers.get("pyro")==0){
            return 3;
        }else{
            return 4;
        }
    }
    
    public Shape upColid(){
        if(look.equals("R")){
            if(pose.contains("crouch")&&!traje.contains("terra")){
                return new Rectangle(getX()+getLarge()/16.0+26, getY()+66,50, 10);
            }else{
                return new Rectangle(getX()+getLarge()/16.0+26, getY(), 50, 10);
            }
        }else{
            if(pose.contains("crouch")&&!traje.contains("terra")){
                return new Rectangle(getX()+getLarge()/16.0+42, getY()+66,50, 10);
            }else{
                return new Rectangle(getX()+getLarge()/16.0+42, getY(), 50, 10);
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
                return new Rectangle(getX()+25, getY()+66, getLarge()-52, getHigh()/2+5);
            }else{
                return new Rectangle(getX()+25, getY()+7, getLarge()-52, getHigh());
            }
        }else{
            if(pose.contains("crouch")&&!traje.contains("terra")){
                return new Rectangle(getX()+41, getY()+66, getLarge()-35, 50);
            }else{
                return new Rectangle(getX()+41, getY()+7, getLarge()-35, 110);
            }
        }
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
            this.traje = this.power;
            anim=0;
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

    public void setUnlockedPowers(HashMap<String,Integer> unlockedPowers) {
        this.unlockedPowers = unlockedPowers;
    }

    public String getPower() {
        return power;
    }

    public void changePower() {
        switch(trajesDesbloq){
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

    public HashMap<String, Integer> getUnlockedPowers() {
        return unlockedPowers;
    }

    public int getTrajesDesbloq() {
        return trajesDesbloq;
    }

    public void setTrajesDesbloq(int trajesDesbloq) {
        this.trajesDesbloq = trajesDesbloq;
    }
    
    public void setHurt(int daño){
        if(invultime>=20){
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
    
    

     
}
