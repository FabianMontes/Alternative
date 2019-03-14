/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Details.LectoEscritura;
import Interactiv.SceneLevel;
import java.io.File;
import java.util.ArrayList;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.SVGPath;
import javafx.scene.shape.Shape;




/**
 *
 * @author fanat
 */
public class Levels extends Ventana{
    private SceneLevel scene;
    private int BtnCount;
    
    
    public Levels(String name, General general) {
        super(name, general);
        scene= new SceneLevel(name);
        BtnCount=0;
    }

    @Override
    public void setAll() {
        super.setAll();
        scene.getLimites().clear();
        scene.getEnemigos().clear();
        scene.setEnemigos(LectoEscritura.getEnemie(new File("src/code/"+name+"Lim.txt"), "Enemies"));
        ArrayList<String> limts=LectoEscritura.detectKey(new File("src/code/"+name+"Lim.txt"), "Lim");
        ArrayList<String> desbloquea;
        desbloquea=LectoEscritura.detectKey(new File("src/code/"+name+"Lim.txt"), "desbloquea");
        scene.setLevelSig(desbloquea.get(0));
        desbloquea.remove(0);
        scene.getSig()[0]=Double.parseDouble(desbloquea.get(0));
        scene.getSig()[1]=Double.parseDouble(desbloquea.get(1));
        scene.getSig()[2]=Double.parseDouble(desbloquea.get(2));
        scene.getSig()[3]=Double.parseDouble(desbloquea.get(3));
        desbloquea.remove(3);
        desbloquea.remove(2);
        desbloquea.remove(1);
        desbloquea.remove(0);
        for (int i = 0; i < limts.size(); i++) {
            scene.getLimites().add(Double.parseDouble(limts.get(i)));
        }
        scene.getGamer().setUnlockedPowers(LectoEscritura.detectKey(new File("src/code/"+name+"lim.txt"),"powers"));
        scene.getGamer().setXref(scene.getiniPlayerX());
        scene.getGamer().setYref(scene.getiniPlayerY());
        scene.getGamer().getFisicas().setGround(true);
        scene.getGamer().setTimeFalling(0);
        scene.getGamer().setPower("default");
        scene.getGamer().setTraje();
    }
    
    int time=0;

    @Override
    public void Ciclo() {
        if(!scene.isPaused()){
            Nivel();
            scene.changeUbicacion();
            general.getLapiz().drawImage(scene.getGamer().getvisPlayerImage(), scene.getGamer().getVisPlayerX(), scene.getGamer().getVisPlayerY(), scene.getGamer().getVisPlayerLarge(), scene.getGamer().getVisPlayerAncho(), scene.getGamer().getX(), scene.getGamer().getY(), scene.getGamer().getLarge(), scene.getGamer().getHigh());
            if(time>10){
                scene.getGamer().setAnimation();
                time=0;

            }
            time++;
        }
        Interfaz();
    }
    
    /**
     * En este metodo es donde se dibuja todo lo que pertenece al nivel, ademas de generar las colisiones.
     */
    
    public void Nivel(){
        boolean tratra=false;
        boolean up =true;
        boolean move =true;
        boolean grow =true;
        if(scene.getGamer().getY()>scene.getrefY()){
            scene.getGamer().loselife(10);
            setAll();
        }
        general.getLapiz().drawImage(imagens.get("fondo").getUbicacion(), imagens.get("fondo").getPart("fondo", 1), imagens.get("fondo").getPart("fondo", 2), imagens.get("fondo").getPart("fondo", 3), imagens.get("fondo").getPart("fondo", 4), 0, 0, 1280, 650);
        for(int i=0;i<partes.size();i++){
            for(int j=0;j<partes.get(i).size();j++){
                general.getLapiz().drawImage(imagens.get("parts").getUbicacion(), imagens.get("parts").getPart(partes.get(i).getGroup(), 1), imagens.get("parts").getPart(partes.get(i).getGroup(), 2), imagens.get("parts").getPart(partes.get(i).getGroup(), 3), imagens.get("parts").getPart(partes.get(i).getGroup(), 4), scene.getrefX()+partes.get(i).getGroupX(j), scene.getrefY()-partes.get(i).getGroupY(j), getPartes().get(i).getGroupLarge(j), getPartes().get(i).getGroupAncho(j));
                Shape Obs= new Rectangle(scene.getrefX()+partes.get(i).getGroupX(j),scene.getrefY()-partes.get(i).getGroupY(j),partes.get(i).getGroupLarge(j),partes.get(i).getGroupAncho(j));

                Shape intersection =SVGPath.intersect(scene.getGamer().upUPColid(), Obs);

                if(intersection.getBoundsInLocal().getWidth() != -1){
                    if(scene.getGamer().getPose().contains("crouch")&&!scene.getGamer().getTraje().contains("terra")){
                        scene.getBotons().replace("crouch", true);
                        if(scene.getGamer().getTraje().contains("aero")){
                            scene.getBotons().replace("canMove", false);
                        }
                        grow=false;
                    }
                    scene.getBotons().replace("canJump", false);
                    scene.getGamer().getFisicas().setJumping(false);
                    move=false;
                }
                scene.getGamer().setCanGrow(grow);    
                intersection = SVGPath.intersect(scene.getGamer().upColid(), Obs);

                if(intersection.getBoundsInLocal().getWidth() != -1){
                    scene.getGamer().getFisicas().setJumping(false);
                    move=false;
                }

                intersection = SVGPath.intersect(scene.getGamer().leftColid(), Obs);

                if(intersection.getBoundsInLocal().getWidth() != -1 && intersection.getBoundsInLocal().getWidth() <= 1){
                    scene.getBotons().replace("Left", Boolean.FALSE);
                    up=false;
                }else if(intersection.getBoundsInLocal().getWidth() != -1){
                    if(move){
                        do{
                            scene.getGamer().setX(scene.getGamer().getX()+1);
                            scene.getBotons().replace("Left", Boolean.FALSE);
                            intersection = SVGPath.intersect(scene.getGamer().leftColid(), Obs);
                        }while(!(intersection.getBoundsInLocal().getWidth() != -1 && intersection.getBoundsInLocal().getWidth() <= 1));
                    }
                    up=false;
                }   

                intersection = SVGPath.intersect(scene.getGamer().rightColid(), Obs);

                if(intersection.getBoundsInLocal().getWidth() != -1 && intersection.getBoundsInLocal().getWidth() <= 1){
                    scene.getBotons().replace("Right", Boolean.FALSE);
                    up=false;
                }else if(intersection.getBoundsInLocal().getWidth() != -1){
                    if(move){
                        do{
                            scene.getGamer().setX(scene.getGamer().getX()-1);
                            scene.getBotons().replace("Right", Boolean.FALSE);
                            intersection = SVGPath.intersect(scene.getGamer().rightColid(), Obs);
                        }while(!(intersection.getBoundsInLocal().getWidth() != -1 && intersection.getBoundsInLocal().getWidth() <= 1));
                    }

                    up=false;
                }

                intersection = SVGPath.intersect(scene.getGamer().downColid(), Obs);
                if (intersection.getBoundsInLocal().getHeight() <= 1&& intersection.getBoundsInLocal().getHeight() != -1) {
                    scene.getGamer().getFisicas().setGround(true);
                    scene.getGamer().getFisicas().setJumping(false);
                    tratra=true;
                }else if(intersection.getBoundsInLocal().getHeight() != -1 && up){
                    scene.getGamer().setY(scene.getrefY()-partes.get(i).getGroupY(j)-scene.getGamer().getHigh());
                    scene.getGamer().getFisicas().setGround(true);
                    scene.getGamer().getFisicas().setJumping(false);
                    tratra=true;
                }else{
                    scene.getGamer().getFisicas().setGround(tratra);
                }
            }
        }
        int i=0;
        while(i<scene.getEnemigos().size()){
            if(scene.getEnemigos().get(i).getLive().getLive()<=0){
                scene.getEnemigos().remove(i);
            }else{
                Shape inter;
                if(scene.getGamer().getPose().contains("crouch")&&scene.getGamer().getTraje().contains("terra")){
                    inter =SVGPath.intersect(scene.getGamer().personColid(), scene.getEnemigos().get(i).getShape(scene.getrefX(), scene.getrefY()));
                    if(inter.getBoundsInLocal().getWidth() !=-1){
                        scene.getEnemigos().get(i).swicthMinion();
                    }
                    
                }else{
                    if(scene.getEnemigos().get(i).isEspichable()){
                        inter =SVGPath.intersect(scene.getGamer().downColid(),scene.getEnemigos().get(i).getShape(scene.getrefX(), scene.getrefY()));
                        if(inter.getBoundsInLocal().getWidth() != -1){
                            scene.getEnemigos().get(i).hurt(scene.getEnemigos().get(i).getLive().getLive());
                            scene.getGamer().setTimeJump(0);
                            scene.getGamer().getFisicas().setJumping(true);
                        }else{
                            if(scene.getGamer().getTraje().equals("terra")&&scene.getGamer().getPose().equals("attack")){
                                inter=SVGPath.intersect(scene.getGamer().damageColid().get(0),scene.getEnemigos().get(i).getShape(scene.getrefX(), scene.getrefY()));
                                if(inter.getBoundsInLocal().getWidth()!=-1){
                                    scene.getEnemigos().get(i).hurt(scene.getGamer().getDamage()+5*scene.getGamer().getPowerBar()/10);
                                }
                            }else if (scene.getGamer().getTraje().equals("aero")&&scene.getGamer().getPose().equals("attack")){
                                inter = SVGPath.intersect(scene.getGamer().damageColid().get(0),scene.getEnemigos().get(i).getShape(scene.getrefX(), scene.getrefY()));
                                if(inter.getBoundsInLocal().getWidth()!= -1){
                                    scene.getEnemigos().get(i).hurt(scene.getGamer().getDamage());
                                }
                                inter = SVGPath.intersect(scene.getGamer().damageColid().get(1),scene.getEnemigos().get(i).getShape(scene.getrefX(), scene.getrefY()));
                                if(inter.getBoundsInLocal().getWidth()!= -1){
                                    System.out.println("addd");
                                    scene.getEnemigos().get(i).retroceder();
                                    scene.getEnemigos().get(i).retroceder();
                                    scene.getEnemigos().get(i).retroceder();
                                }
                            }else{
                                inter = SVGPath.intersect(scene.getGamer().personColid(),scene.getEnemigos().get(i).getShape(scene.getrefX(), scene.getrefY()));
                                if(inter.getBoundsInLocal().getWidth() != -1){
                                    int ahh=scene.getGamer().getLives();
                                    scene.getGamer().setHurt(scene.getEnemigos().get(i).getDamage());
                                    if(ahh>scene.getGamer().getLives()){
                                        scene.getGamer().getLive().fillLive();
                                        setAll();
                                    }
                                }
                            }
                        }

                    }else if(scene.getGamer().getTraje().equals("terra")&&scene.getGamer().getPose().equals("attack")){
                        inter=SVGPath.intersect(scene.getGamer().damageColid().get(0),scene.getEnemigos().get(i).getShape(scene.getrefX(), scene.getrefY()));
                        if(inter.getBoundsInLocal().getWidth()!=-1){
                            scene.getEnemigos().get(i).hurt(scene.getGamer().getDamage()+5*scene.getGamer().getPowerBar()/10);
                        }
                    }else if (scene.getGamer().getTraje().equals("aero")&&scene.getGamer().getPose().equals("attack")){
                        inter = SVGPath.intersect(scene.getGamer().damageColid().get(0),scene.getEnemigos().get(i).getShape(scene.getrefX(), scene.getrefY()));
                        if(inter.getBoundsInLocal().getWidth()!= -1){
                            scene.getEnemigos().get(i).hurt(scene.getGamer().getDamage());
                        }
                        inter = SVGPath.intersect(scene.getGamer().damageColid().get(1),scene.getEnemigos().get(i).getShape(scene.getrefX(), scene.getrefY()));
                        if(inter.getBoundsInLocal().getWidth()!= -1){
                            System.out.println("addd");
                            scene.getEnemigos().get(i).retroceder();
                            scene.getEnemigos().get(i).retroceder();
                            scene.getEnemigos().get(i).retroceder();
                        }
                    }else{
                        inter = SVGPath.intersect(scene.getGamer().personColid(),scene.getEnemigos().get(i).getShape(scene.getrefX(), scene.getrefY()));
                        if(inter.getBoundsInLocal().getWidth() != -1){
                            int ahh=scene.getGamer().getLives();
                            scene.getGamer().setHurt(scene.getEnemigos().get(i).getDamage());
                            if(ahh>scene.getGamer().getLives()){
                                scene.getGamer().getLive().fillLive();
                                setAll();
                            }
                        }
                    }
                }
                general.getLapiz().drawImage(scene.getEnemigos().get(i).getMinionImage(), scene.getEnemigos().get(i).getMinionImVal(1)+(scene.getEnemigos().get(i).getMinionImVal(3)*scene.getEnemigos().get(i).getMinionImVal(5)), scene.getEnemigos().get(i).getMinionImVal(2),scene.getEnemigos().get(i).getMinionImVal(3), scene.getEnemigos().get(i).getMinionImVal(4), scene.getrefX()+ scene.getEnemigos().get(i).getMiniVal(1),scene.getrefY()-scene.getEnemigos().get(i).getMiniVal(2), scene.getEnemigos().get(i).getMiniVal(3), scene.getEnemigos().get(i).getMiniVal(4));
                scene.getEnemigos().get(i).desplazar();
                scene.getEnemigos().get(i).movY();
                i++;
            }
        }
        Shape inter = SVGPath.intersect(scene.getNext(scene.getrefX(),scene.getrefY()), scene.getGamer().personColid());
        if(inter.getBoundsInLocal().getWidth() != -1){
            changeLevel(scene.getLevelSig());
        }
    }

    private void Interfaz(){
        if(!scene.isPaused()){
            general.getLapiz().drawImage(imagens.get("interfaz").getUbicacion(), imagens.get("interfaz").getPart("barra", 1), imagens.get("interfaz").getPart("barra", 2), imagens.get("interfaz").getPart("barra", 3), imagens.get("interfaz").getPart("barra", 4), imagens.get("interfaz").getPart("barra", 1), imagens.get("interfaz").getPart("barra", 2), imagens.get("interfaz").getPart("barra", 3), imagens.get("interfaz").getPart("barra", 4));
            int equal;
            if(scene.getGamer().getPower().equals(scene.getGamer().getTraje())){
                equal=1;
            }else{
                equal=0;
            }
            String figura = scene.getGamer().getPower()+equal;
            general.getLapiz().setFill(Color.GREEN);
            general.getLapiz().fillRect(66, 1, scene.getGamer().getLive().getLive()*3, 28);
            general.getLapiz().setFill(Color.ORANGE);
            general.getLapiz().fillRect(66, 32, scene.getGamer().getPowerBar(), 12);
            general.getLapiz().drawImage(imagens.get("interfaz").getUbicacion(), imagens.get("interfaz").getPart(figura, 1), imagens.get("interfaz").getPart(figura, 2), imagens.get("interfaz").getPart(figura, 3), imagens.get("interfaz").getPart(figura, 4), 0,0,64,64);

            general.getLapiz().scale(2, 2);
            general.getLapiz().setFill(Color.BLACK);
            if(scene.getGamer().getLives()>=10){
                general.getLapiz().strokeText(String.valueOf(scene.getGamer().getLives()), 130, 29);
            }else{

                general.getLapiz().strokeText(String.valueOf(scene.getGamer().getLives()), 138, 29);
            }
            general.getLapiz().scale(0.5, 0.5);
        }else{
            general.getLapiz().setFill(Color.BLACK);
            general.getLapiz().fillRect(0, 0, 1280,650);
            general.getLapiz().setFill(Color.WHITE);
            if(!scene.isBtn()){
                general.getLapiz().fillOval(400, 200, 50, 50);
            }else{
                general.getLapiz().fillOval(400, 400, 50, 50);
            }
            general.getLapiz().drawImage(imagens.get("pause").getUbicacion(), imagens.get("pause").getPart("continuar", 1), imagens.get("pause").getPart("continuar", 2), imagens.get("pause").getPart("continuar", 3), imagens.get("pause").getPart("continuar", 4), 500,200,imagens.get("pause").getPart("continuar", 3), imagens.get("pause").getPart("continuar", 4));
            general.getLapiz().drawImage(imagens.get("pause").getUbicacion(), imagens.get("pause").getPart("END", 1), imagens.get("pause").getPart("END", 2), imagens.get("pause").getPart("END", 3), imagens.get("pause").getPart("END", 4), 500,400,imagens.get("pause").getPart("END", 3), imagens.get("pause").getPart("END", 4));
            
        }
        
        
    }
    
    @Override
    public String Btn() {
            BtnCount++;
            if(!scene.isPaused()){
                if (general.getPulsaciones().contains("LEFT")){
                    scene.getBotons().replace("Left", Boolean.TRUE);
                }else{
                    scene.getBotons().replace("Left", Boolean.FALSE);
                }

                if(general.getPulsaciones().contains("RIGHT")){
                    scene.getBotons().replace("Right", Boolean.TRUE);
                }else{
                    scene.getBotons().replace("Right", Boolean.FALSE);
                }
                if(general.getPulsaciones().contains("UP")){
                    scene.getBotons().replace("up", Boolean.TRUE);
                }else{
                    scene.getBotons().replace("up", Boolean.FALSE);
                }
                if(general.getPulsaciones().contains("DOWN")){
                    scene.getBotons().replace("crouch",true);
                }else{
                    scene.getBotons().replace("crouch", Boolean.FALSE);
                }
                if(general.getPulsaciones().contains("Z")){
                    if(!this.scene.getGamer().getTraje().contains("default")){
                        scene.getBotons().replace("attack",true);
                    }
                }else{
                    scene.getBotons().replace("attack", Boolean.FALSE);
                }
                if(general.getPulsaciones().contains("X")||general.getPulsaciones().contains("SPACE")&&this.scene.getGamer().getFisicas().isGround()){
                    scene.getBotons().replace("jump",true);
                }else{
                    scene.getBotons().replace("jump", Boolean.FALSE);
                }
                if(general.getPulsaciones().contains("A")&&BtnCount>10){
                    this.scene.getGamer().changePower(-1);
                    BtnCount=0;
                }
                if(general.getPulsaciones().contains("S")&&BtnCount>10){
                    this.scene.getGamer().setTraje();
                    BtnCount=0;
                }
                if(general.getPulsaciones().contains("D")&&BtnCount>10){
                    this.scene.getGamer().changePower(1);
                    BtnCount=0;
                }
                
            }else{
                if(general.getPulsaciones().contains("UP")||general.getPulsaciones().contains("DOWN")&&BtnCount>10){
                    scene.switchBtn();
                    BtnCount=0;
                }
                if(general.getPulsaciones().contains("ENTER")||general.getPulsaciones().contains("X")){
                    if(scene.isBtn()){
                        return "Password"+name;
                    }else{
                        scene.setPaused(false);
                        if(scene.getGamer().getLives()<=0){
                            scene.getGamer().setLives(3);
                            setAll();
                        }
                    }
                }
            }
            
            if(general.getPulsaciones().contains("R")&&general.getPulsaciones().contains("E")){
                this.setAll();
            }
            if(general.getPulsaciones().contains("P")&&BtnCount>10){
                scene.switchPaused();
                BtnCount=0;
            }
            if(scene.getGamer().getLives()<=0){
                scene.setPaused(true);
            }
            return "";
    }

    private void changeLevel(String sceneSig) {
        general.CambiodeScena();
        name=sceneSig;
        setAll();
    }

    
        
    

    
}
