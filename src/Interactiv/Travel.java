/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interactiv;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;
import Details.LectoEscritura;
import Details.UbiGroup;
import Details.Visual;
/**
 *
 * @author fanat
 */
public class Travel {
    private ArrayList<UbiGroup> Partes;
    private HashMap<String,Visual> Imagens;
    private Player Gamer;
    private ArrayList<Double> limites;
    private String Level;
    private ArrayList<Enemie> Enemigos;
    private HashMap<String,Boolean> botons;

    public Travel(String level, int slote) throws IOException {
        this.Level=level;        
        Gamer=new Player("src/code/SaveGame"+slote+".txt",0,0);
        this.Partes= new ArrayList<>();
        this.limites= new ArrayList<>();
        this.Imagens=new HashMap<>();
        this.Enemigos=new ArrayList<>();
        this.botons = new HashMap<>();
        
        this.botons.put("Right", false);
        this.botons.put("Left", Boolean.FALSE);
        this.botons.put("jump", Boolean.FALSE);
        this.botons.put("attack", Boolean.FALSE);
        this.botons.put("crouch", Boolean.FALSE);
        this.botons.put("up", Boolean.FALSE);
        this.botons.put("canJump",false);
        this.botons.put("isattacking",false);
        this.botons.put("hurt", Boolean.FALSE);
        this.botons.put("totalControl",false);
        this.botons.put("noControl", Boolean.FALSE);
        this.botons.put("onlyMove", Boolean.FALSE);
        setAll();
    }
    
    
    
    
    private void setAll() throws IOException{
        this.Partes.clear();
        this.Imagens.clear();
        this.limites.clear();
        this.Enemigos.clear();
        this.Partes=LectoEscritura.UbicarLevel(new File("src/code/"+Level+"Vis.txt"), Partes);
        this.Imagens=LectoEscritura.PartesEnImagen("src/code/"+Level+"Ub.txt", Imagens);
        this.Enemigos=LectoEscritura.getEnemie(new File("src/code/"+Level+"lim.txt"), "Enemies");
        ArrayList<String> limts=LectoEscritura.detectKey(new File("src/code/"+Level+"lim.txt"), "Lim");
        for (int i = 0; i < limts.size(); i++) {
            this.limites.add(Double.parseDouble(limts.get(i)));
        }
        Gamer.setXref(this.getiniPlayerX());
        Gamer.setYref(this.getiniPlayerY());
        
        
        
    }

    public ArrayList<UbiGroup> getPartes() {
        return Partes;

    }

    public HashMap<String, Visual> getImagens() {
        return Imagens;
    }

    public Player getGamer() {
        return Gamer;
    }

    public double getrefX() {
        return limites.get(0);
    }
    public double getrefY() {
        return limites.get(1);
    }
    public double getrefmaxX() {
        return limites.get(2);
    }
    public double getrefmaxY() {
        return limites.get(3);
    }
    public double getrefXini() {
        return limites.get(4);
    }
    public double getrefYini() {
        return limites.get(5);
    }
    public double getrefmaxXini() {
        return limites.get(6);
    }
    public double getrefmaxYini() {
        return limites.get(7);
    }
    public double getiniPlayerX() {
        return limites.get(8);
    }
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
    

    public String getLevel() {
        return Level;
    }

    public void setPartes(ArrayList<UbiGroup> Partes) {
        this.Partes = Partes;
    }

    public void setImagens(HashMap<String, Visual> Imagens) {
        this.Imagens = Imagens;
    }

    public void setGamer(Player Gamer) {
        this.Gamer = Gamer;
    }

    public void setLimites(ArrayList<Double> limites) {
        this.limites = limites;
    }

    public void setLevel(String Level) {
        this.Level = Level;
    }

    public ArrayList<Enemie> getEnemigos() {
        return Enemigos;
    }

    public void setEnemigos(ArrayList<Enemie> Enemigos) {
        this.Enemigos = Enemigos;
    }

    public HashMap<String, Boolean> getBotons() {
        return botons;
    }

    public void setBotons(HashMap<String, Boolean> botons) {
        this.botons = botons;
    }
    
    
    public void changeUbicacion(){     
        Gamer.setInvultime(Gamer.getInvultime()+1);
        if(this.botons.get("jump")){
            Gamer.getFisicas().setJumping(true);
        }
        
        if((getrefY()==650)&&!(Gamer.getY()<=300)){
            Gamer.movY();
        }else{
            if(Gamer.getTimeJump()>=Gamer.getFisicas().getTimejump()){
            Gamer.getFisicas().setJumping(false);
            }
            if(Gamer.getFisicas().isJumping()){
                if(!(getrefmaxY()+Gamer.getFisicas().getVelmaxY()>=0)){
                    difrefmaxY(-Gamer.getFisicas().getVelmaxY()+Gamer.getFisicas().getGravedad()*Gamer.getTimeFalling());
                    double a=Gamer.getTimeFalling();
                    double b=Gamer.getTimeJump();
                    Gamer.setTimeFalling(a+0.5);
                    Gamer.setTimeJump(b+0.5);
                    setrefY(getrefmaxY()+getrefmaxYini());
                    
                }else{
                    Gamer.movY();
                    
                }
            }else if(!Gamer.getFisicas().isGround()){
                if(getrefY()-Gamer.getFisicas().getGravedad()*Gamer.getTimeFalling()<650){
                    Gamer.setY(Gamer.getY()-(650-getrefY()-Gamer.getFisicas().getGravedad()*Gamer.getTimeFalling()));
                    setrefY(650);
                    double a=Gamer.getTimeFalling();
                    Gamer.setTimeFalling(a+0.5);
                    setrefmaxY(getrefY()-getrefmaxYini());
                }else if(getrefY()-Gamer.getFisicas().getGravedad()*Gamer.getTimeFalling()>650){
                    difrefY(-Gamer.getFisicas().getGravedad()*Gamer.getTimeFalling());
                    double a=Gamer.getTimeFalling();
                    Gamer.setTimeFalling(a+0.5);
                    setrefmaxY(getrefY()-getrefmaxYini());
                }else{
                    Gamer.movY();
                }
            }else{
                Gamer.movY();
            }
        }
        
        if(this.botons.get("attack")){
            if(this.botons.get("Right")){
                Gamer.Look("R");   
            }else if(this.botons.get("Left")){
                Gamer.Look("L");
            }
            Gamer.setPose("attack");
        }else if(Gamer.getFisicas().isGround()){
            if(this.botons.get("Right")){
                Gamer.Look("R");
                if(this.botons.get("crouch")&&this.Gamer.getTraje().equals("default")){
                    Gamer.setPose("Mcrouch");
                }else{
                    Gamer.setPose("walk");
                }
                if(Gamer.getX()>=700&&getrefmaxX()>1280){
                    if(getrefmaxX()-Gamer.getFisicas().getVelmaxX()<1280){
                        setrefmaxX(1280);
                    }else{
                        difrefmaxX(-Gamer.getFisicas().getVelmaxX());
                    }
                    setrefX(getrefmaxX()-getrefmaxXini());
                }else{
                    Gamer.desplazar();
                }
            }else if(this.botons.get("Left")){
                if(this.botons.get("crouch")&&this.Gamer.getTraje().equals("default")){
                    Gamer.setPose("Mcrouch");
                }else{
                    Gamer.setPose("walk");
                }
                Gamer.Look("L");
                if(Gamer.getX()<=600&&getrefX()<0){
                    if(getrefX()+Gamer.getFisicas().getVelmaxX()>0){
                        setrefX(0);
                    }else{
                        difrefX(Gamer.getFisicas().getVelmaxX());
                    }
                    setrefmaxX(getrefX()+getrefmaxXini());
                }else{
                    Gamer.desplazar();
                }
            }else{
                if(botons.get("crouch")){
                    Gamer.setPose("crouch");
                }else{
                    Gamer.setPose("quiet");
                }
                
            } 

        }else if(Gamer.getFisicas().isJumping()){
            if(this.botons.get("Right")){
                Gamer.Look("R");
                Gamer.setPose("jump");
                if(Gamer.getX()>=700&&getrefmaxX()>1280){
                    if(getrefmaxX()-Gamer.getFisicas().getVelmaxX()<1280){
                        setrefmaxX(1280);
                    }else{
                        difrefmaxX(-Gamer.getFisicas().getVelmaxX());
                    }
                    setrefX(getrefmaxX()-getrefmaxXini());
                }else{
                    Gamer.desplazar();
                }
            }else if(this.botons.get("Left")){
                Gamer.Look("L");
                Gamer.setPose("jump");
                if(Gamer.getX()<=600&&getrefX()<0){
                    if(getrefX()+Gamer.getFisicas().getVelmaxX()>0){
                        setrefX(0);
                    }else{
                        difrefX(Gamer.getFisicas().getVelmaxX());
                    }
                    setrefmaxX(getrefX()+getrefmaxXini());
                    }else{
                        Gamer.desplazar();
                    }
                }else{
                    Gamer.setPose("jump");
                }
        }else{
            if(this.botons.get("Right")){
                Gamer.Look("R");
                Gamer.setPose("fall");
                if(Gamer.getX()>=700&&getrefmaxX()>1280){
                    if(getrefmaxX()-Gamer.getFisicas().getVelmaxX()<1280){
                        setrefmaxX(1280);
                    }else{
                        difrefmaxX(-Gamer.getFisicas().getVelmaxX());
                    }
                    setrefX(getrefmaxX()-getrefmaxXini());
                }else{
                    Gamer.desplazar();
                }
            }else if(this.botons.get("Left")){
                Gamer.Look("L");
                Gamer.setPose("fall");
                if(Gamer.getX()<=600&&getrefX()<0){
                    if(getrefX()+Gamer.getFisicas().getVelmaxX()>0){
                        setrefX(0);
                    }else{
                        difrefX(Gamer.getFisicas().getVelmaxX());
                    }
                    difrefmaxX(getrefX()+getrefmaxXini());
                    }else{
                        Gamer.desplazar();
                    }
                }else{
                    Gamer.setPose("fall");
                }
        }
    }
    
}
