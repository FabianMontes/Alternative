/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.*;
import java.util.ArrayList;
 

import Interactiv.Menu;
import Interactiv.Travel;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fanat
 */
public class BucleGame extends AnimationTimer {
    private  Scene escena;
    private GraphicsContext lapiz;
    private Travel level;
    private String nivel;
    
    private ArrayList<String> pulsacionTeclado = null;
    private int FondoAnim;
    private Menu presentacion;

    
    public BucleGame(Scene escena,GraphicsContext lapiz) throws IOException {
        this.lapiz = lapiz;
        this.escena = escena;
        FondoAnim=0;
        this.level = new Travel("Level1.0",1);
        this.presentacion= new Menu("IniPantalla");  
        this.pulsacionTeclado = new ArrayList<>();
        
        this.nivel="default";
        lapiz.setFill(Color.BLACK);
        lapiz.fillRect(0, 0, 1280, 620);

        escena.setOnKeyPressed(
            new EventHandler<KeyEvent>()
            {
                @Override
                public void handle(KeyEvent e)
                {
                    String code = e.getCode().toString();
                    if ( !pulsacionTeclado.contains(code) )
                        pulsacionTeclado.add( code );
                }
            });

        escena.setOnKeyReleased(
            new EventHandler<KeyEvent>()
            {
                @Override
                public void handle(KeyEvent e)
                {
                    String code = e.getCode().toString();
                    pulsacionTeclado.remove( code );
                }
            });
    }
    
    int espboton=10;
    int time=0;
    int cas=0;
    boolean c=true;
    @Override
    public void handle(long now) {
        try {    
            Botons();
            Fondo();
            Nivel();
            if(!nivel.equals("menu")){
                level.changeUbicacion();
                
                Player();
                Interfaz();
            }
            Animation();
            
            espboton++;
            time++;
        } catch (IOException ex) {
            Logger.getLogger(BucleGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        cas++;
    }
    
    private void Fondo(){
        switch(nivel){
            case "menu":
                lapiz.drawImage(this.presentacion.getImagens().get("fondo").getUbicacion(), this.presentacion.getImagens().get("fondo").getPart("fondo", 1)+(FondoAnim*this.presentacion.getImagens().get("fondo").getPart("fondo", 3)), this.presentacion.getImagens().get("fondo").getPart("fondo", 2), this.presentacion.getImagens().get("fondo").getPart("fondo", 3), this.presentacion.getImagens().get("fondo").getPart("fondo", 4), 0, 0, 1280, 650);
            break;    
                
            default:
                lapiz.drawImage(this.level.getImagens().get("fondo").getUbicacion(), this.level.getImagens().get("fondo").getPart("fondo", 1), this.level.getImagens().get("fondo").getPart("fondo", 2), this.level.getImagens().get("fondo").getPart("fondo", 3), this.level.getImagens().get("fondo").getPart("fondo", 4), 0, 0, 1280, 650);
            break;
        }
    }
    
    private void Nivel() throws IOException{
        switch(nivel){
            case "menu":
                if(!presentacion.getName().equals("IniPantalla")){
                    lapiz.drawImage(this.presentacion.getImagens().get("parts").getUbicacion(), (this.presentacion.getImagens().get("parts").getPart(presentacion.getDestellos().get(0).getGroup(), 1)+(this.presentacion.getImagens().get("parts").getPart(presentacion.getDestellos().get(0).getGroup(), 3)*this.presentacion.getImagens().get("parts").getPart(presentacion.getDestellos().get(0).getGroup(), 5))), this.presentacion.getImagens().get("parts").getPart(presentacion.getDestellos().get(0).getGroup(), 2), this.presentacion.getImagens().get("parts").getPart(presentacion.getDestellos().get(0).getGroup(), 3), this.presentacion.getImagens().get("parts").getPart(presentacion.getDestellos().get(0).getGroup(), 4), presentacion.getDestellos().get(0).getGroupX(0), presentacion.getDestellos().get(0).getGroupY(0), presentacion.getDestellos().get(0).getGroupLarge(0), presentacion.getDestellos().get(0).getGroupAncho(0));
                    for (int i = 1; i < presentacion.getDestellos().size(); i++) {
                        for (int j = 1; j < 4; j++) {
                               lapiz.drawImage(this.presentacion.getImagens().get("parts").getUbicacion(), this.presentacion.getImagens().get("parts").getPart(presentacion.getTipePow(presentacion.getDestellos().get(i).getGroup(),j), 1), this.presentacion.getImagens().get("parts").getPart(presentacion.getTipePow(presentacion.getDestellos().get(i).getGroup(),j), 2), this.presentacion.getImagens().get("parts").getPart(presentacion.getTipePow(presentacion.getDestellos().get(i).getGroup(),j), 3), this.presentacion.getImagens().get("parts").getPart(presentacion.getTipePow(presentacion.getDestellos().get(i).getGroup(),j), 4), presentacion.getDestellos().get(i).getGroupX(j-1), presentacion.getDestellos().get(i).getGroupY(j-1), presentacion.getDestellos().get(i).getGroupLarge(j-1), presentacion.getDestellos().get(i).getGroupAncho(j-1));
                               
                        }
                    }
                }
                
            break;            
            default:
                boolean tratra=false;
                boolean up =true;
                for(int i=0;i<level.getPartes().size();i++){
                    for(int j=0;j<level.getPartes().get(i).size();j++){
                        lapiz.drawImage(this.level.getImagens().get("parts").getUbicacion(), this.level.getImagens().get("parts").getPart(level.getPartes().get(i).getGroup(), 1), this.level.getImagens().get("parts").getPart(level.getPartes().get(i).getGroup(), 2), this.level.getImagens().get("parts").getPart(level.getPartes().get(i).getGroup(), 3), this.level.getImagens().get("parts").getPart(level.getPartes().get(i).getGroup(), 4), level.getrefX()+level.getPartes().get(i).getGroupX(j), level.getrefY()-level.getPartes().get(i).getGroupY(j), this.level.getPartes().get(i).getGroupLarge(j), this.level.getPartes().get(i).getGroupAncho(j));
                        
                        Shape Obs= new Rectangle(level.getrefX()+level.getPartes().get(i).getGroupX(j),level.getrefY()-level.getPartes().get(i).getGroupY(j),level.getPartes().get(i).getGroupLarge(j),level.getPartes().get(i).getGroupAncho(j));
                        
                        Shape intersection = SVGPath.intersect(level.getGamer().leftColid(), Obs);
                        
                        if(intersection.getBoundsInLocal().getWidth() != -1 && intersection.getBoundsInLocal().getWidth() <= 1){
                            level.getBotons().replace("Left", Boolean.FALSE);
                            up=false;
                        }else if(intersection.getBoundsInLocal().getWidth() != -1){
                            do{
                            level.getGamer().setX(level.getGamer().getX()+1);
                            level.getBotons().replace("Left", Boolean.FALSE);
                            intersection = SVGPath.intersect(level.getGamer().leftColid(), Obs);
                            }while(!(intersection.getBoundsInLocal().getWidth() != -1 && intersection.getBoundsInLocal().getWidth() <= 1));
                            up=false;
                        }   

                        intersection = SVGPath.intersect(level.getGamer().rightColid(), Obs);

                        if(intersection.getBoundsInLocal().getWidth() != -1 && intersection.getBoundsInLocal().getWidth() <= 1){
                            level.getBotons().replace("Right", Boolean.FALSE);
                            up=false;
                        }else if(intersection.getBoundsInLocal().getWidth() != -1){
                            do{
                            level.getGamer().setX(level.getGamer().getX()-1);
                            level.getBotons().replace("Right", Boolean.FALSE);
                            intersection = SVGPath.intersect(level.getGamer().rightColid(), Obs);
                            }while(!(intersection.getBoundsInLocal().getWidth() != -1 && intersection.getBoundsInLocal().getWidth() <= 1));
                            up=false;
                        }
                
                        intersection = SVGPath.intersect(this.level.getGamer().downColid(), Obs);
                        if (intersection.getBoundsInLocal().getHeight() <= 1&& intersection.getBoundsInLocal().getHeight() != -1) {
                            this.level.getGamer().getFisicas().setGround(true);
                            this.level.getGamer().getFisicas().setJumping(false);
                            tratra=true;
                        }else if(intersection.getBoundsInLocal().getHeight() != -1 && up){
                            this.level.getGamer().setY(level.getrefY()-level.getPartes().get(i).getGroupY(j)-level.getGamer().getHigh());
                            this.level.getGamer().getFisicas().setGround(true);
                            this.level.getGamer().getFisicas().setJumping(false);
                            tratra=true;
                        }else{
                            this.level.getGamer().getFisicas().setGround(tratra);
                        }

                        intersection = SVGPath.intersect(level.getGamer().upColid(), Obs);

                        if(intersection.getBoundsInLocal().getWidth() != -1){
                            this.level.getGamer().getFisicas().setJumping(false);
                        }
                    }
                }
                int i=0;
                while(i<level.getEnemigos().size()){
                    if(level.getEnemigos().get(i).getLive().getLive()<=0){
                        level.getEnemigos().remove(i);
                    }else{
                        lapiz.fillRect(level.getrefX()+level.getEnemigos().get(i).getMiniVal(1),level.getrefY()-level.getEnemigos().get(i).getMiniVal(2), level.getEnemigos().get(i).getMiniVal(3), level.getEnemigos().get(i).getMiniVal(4));
                        lapiz.drawImage(level.getEnemigos().get(i).getMinionImage(), level.getEnemigos().get(i).getMinionImVal(1)+(level.getEnemigos().get(i).getMinionImVal(3)*level.getEnemigos().get(i).getMinionImVal(5)), level.getEnemigos().get(i).getMinionImVal(2),level.getEnemigos().get(i).getMinionImVal(3), level.getEnemigos().get(i).getMinionImVal(4), level.getrefX()+ level.getEnemigos().get(i).getMiniVal(1),level.getrefY()-level.getEnemigos().get(i).getMiniVal(2), level.getEnemigos().get(i).getMiniVal(3), level.getEnemigos().get(i).getMiniVal(4));
                        Shape inter;
                        if(level.getEnemigos().get(i).getType().equals("topo")){
                            System.out.println("ahh");
                            inter =SVGPath.intersect(level.getGamer().downColid(),level.getEnemigos().get(i).getShape(level.getrefX(), level.getrefY()));
                            if(inter.getBoundsInLocal().getWidth() != -1){
                                System.out.println("dhhh");
                                level.getEnemigos().get(i).hurt(10);
                            }else{
                                System.out.println("ehhh");
                                inter = SVGPath.intersect(level.getGamer().personColid(),level.getEnemigos().get(i).getShape(level.getrefX(), level.getrefY()));
                                if(inter.getBoundsInLocal().getWidth() != -1){
                                    System.out.println("chhh");
                                    level.getGamer().setHurt(level.getEnemigos().get(i).getDamage());
                                }
                            }

                        }else{
                            inter = SVGPath.intersect(level.getGamer().personColid(),level.getEnemigos().get(i).getShape(level.getrefX(), level.getrefY()));
                            System.out.println(inter.getBoundsInLocal().getWidth());
                            if(inter.getBoundsInLocal().getWidth() != -1){
                                level.getGamer().setHurt(level.getEnemigos().get(i).getDamage());
                            }
                        }
                        level.getEnemigos().get(i).desplazar();
                        level.getEnemigos().get(i).movY();
                        i++;
                    }
                }
                
            break;
        }
    }
    
    private void Player(){
        lapiz.drawImage(this.level.getGamer().getvisPlayerImage(), this.level.getGamer().getVisPlayerX(), this.level.getGamer().getVisPlayerY(), this.level.getGamer().getVisPlayerLarge(), this.level.getGamer().getVisPlayerAncho(), this.level.getGamer().getX(), this.level.getGamer().getY(), this.level.getGamer().getLarge(), this.level.getGamer().getHigh());
        
    }
    

    private void Animation(){
        if(time>10){
            if(FondoAnim>=this.presentacion.getImagens().get("fondo").getPart("fondo", 5)){
                FondoAnim=0;
            }else{
                FondoAnim++;
            }    
            time=0;
            if(!nivel.equals("menu")){
            this.level.getGamer().setAnimation();
            }
        }
        
 
    }
    
    
    
    private void Interfaz(){
        lapiz.fillRect(0, 100, this.level.getGamer().getLive().getLive()*10, 50);
        lapiz.scale(10, 10);
        lapiz.strokeText(this.level.getGamer().getPower(), 10, 10);
        lapiz.scale(0.1, 0.1);
    }
    private void changeLevel() throws IOException{
        lapiz.fillRect(0, 0, 1280, 650);
        this.presentacion.putMenu();
        
    }
    private void changeLevel(String nivel, int slote) throws IOException{
        lapiz.setFill(Color.BLACK);
        lapiz.fillRect(0, 0, 1280, 650);
        this.nivel="default";
        level=new Travel(nivel,slote);
        
    }
    
    private void Botons() throws IOException {
        switch(nivel){
            case "menu":
                if(presentacion.getName().equals("IniPantalla")){
                    if(pulsacionTeclado.contains("ENTER")){
                    changeLevel();
                    }
                }else{
                    if(pulsacionTeclado.contains("UP")&&espboton>5){
                        presentacion.change(-1);
                        espboton=0;
                    }
                    if(pulsacionTeclado.contains("DOWN")&&espboton>5){
                        presentacion.change(1);
                        espboton=0;
                    }
                    if(pulsacionTeclado.contains("ENTER")&&espboton>10){
                        changeLevel("Level1.0",presentacion.getBoton()+1);
                    }
                    if(pulsacionTeclado.contains("X")&&espboton>10){
                        System.out.println(presentacion.getBoton());
                        //LectoEscritura.resetLevel(presentacion.getBoton()+1);
                        changeLevel();
                    }
                    
                }
                    
            break;
            default:
                if (pulsacionTeclado.contains("LEFT")||pulsacionTeclado.contains("A")){
                    level.getBotons().replace("Left", Boolean.TRUE);
                }else{
                    level.getBotons().replace("Left", Boolean.FALSE);
                }
                    
                if(pulsacionTeclado.contains("RIGHT")||pulsacionTeclado.contains("D")){
                    level.getBotons().replace("Right", Boolean.TRUE);
                }else{
                    level.getBotons().replace("Right", Boolean.FALSE);
                }
                if(pulsacionTeclado.contains("UP")||pulsacionTeclado.contains("W")){
                    level.getBotons().replace("up", Boolean.TRUE);
                }else{
                    level.getBotons().replace("up", Boolean.FALSE);
                }
                if(pulsacionTeclado.contains("DOWN")||pulsacionTeclado.contains("S")){
                    level.getBotons().replace("crouch",true);
                }else{
                    level.getBotons().replace("crouch", Boolean.FALSE);
                }
                if(pulsacionTeclado.contains("Z")){
                    level.getBotons().replace("attack",true);
                }else{
                    level.getBotons().replace("attack", Boolean.FALSE);
                }
                if(pulsacionTeclado.contains("SPACE")&&this.level.getGamer().getFisicas().isGround()){
                    level.getBotons().replace("jump",true);
                }else{
                    level.getBotons().replace("jump", Boolean.FALSE);
                }
                if(pulsacionTeclado.contains("X")&&espboton>10){
                    this.level.getGamer().changePower();
                    espboton=0;
                }
                if(pulsacionTeclado.contains("C")&&espboton>10){
                    this.level.getGamer().setTraje();
                    espboton=0;
                }
                if(pulsacionTeclado.contains("Z")){
                    if(!this.level.getGamer().getTraje().equals("equals")){
                        this.level.getGamer().setPose("attack");
                    }
                }
            break;    
        }
        
        

            
    }
}
