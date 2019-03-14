/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Details.LectoEscritura;
import Interactiv.SceneMenu;
import java.io.File;
import java.util.ArrayList;

/**
 * Ventana de Menus
 * @author Fabian Montes
 */
public class Menu extends Ventana{
    private SceneMenu scene;
    
    /**
     * Constructor
     * @param name nombre del menu
     * @param general lapiz y escena
     */
    
    public Menu(String name, General general){
        super(name, general);
        scene= new SceneMenu();
    }
    
    @Override
    public void setAll(){
        super.setAll();
        scene.getCodes().clear();
        scene.setBtnCount(0);
        scene.setBoton(0);
        scene.getCode()[0]=0;
        scene.getCode()[1]=0;
        scene.getCode()[2]=0;
        scene.getCode()[3]=0;
        scene.getCode()[4]=0;
    }
    
    @Override
    public void Ciclo() {
        
        general.getLapiz().drawImage(imagens.get("fondo").getUbicacion(), imagens.get("fondo").getPart("fondo", 1)+(scene.getFondoAnim()*imagens.get("fondo").getPart("fondo", 3)), imagens.get("fondo").getPart("fondo", 2), imagens.get("fondo").getPart("fondo", 3), imagens.get("fondo").getPart("fondo", 4), 0, 0, 1280, 650);
        if(!name.equals("IniPantalla")){
            general.getLapiz().drawImage(imagens.get("parts").getUbicacion(), (imagens.get("parts").getPart(partes.get(0).getGroup(), 1)+(imagens.get("parts").getPart(partes.get(0).getGroup(), 3)*imagens.get("parts").getPart(partes.get(0).getGroup(), 5))), imagens.get("parts").getPart(partes.get(0).getGroup(), 2), imagens.get("parts").getPart(partes.get(0).getGroup(), 3), imagens.get("parts").getPart(partes.get(0).getGroup(), 4), partes.get(0).getGroupX(0), partes.get(0).getGroupY(0), partes.get(0).getGroupLarge(0), partes.get(0).getGroupAncho(0));
            for (int i = 1; i < partes.size(); i++) {
                for (int j = 0; j < partes.get(i).size(); j++) {
                    general.getLapiz().drawImage(imagens.get("parts").getUbicacion(), imagens.get("parts").getPart(this.partes.get(i).getGroup()+scene.getCode()[j],1), imagens.get("parts").getPart(this.partes.get(i).getGroup()+scene.getCode()[j], 2), imagens.get("parts").getPart(this.partes.get(i).getGroup()+scene.getCode()[j], 3), imagens.get("parts").getPart(this.partes.get(i).getGroup()+scene.getCode()[j], 4), partes.get(i).getGroupX(j), partes.get(i).getGroupY(j), partes.get(i).getGroupLarge(j), partes.get(i).getGroupAncho(j));
                }

            }
        }
                
    }
    
    @Override
    public String Btn() {
        scene.setBtnCount();
        if(name.contains("IniPantalla")){
            return BtnPan();
        }else if(name.contains("IniMenu")){
            return BtnMenu();
        }else{
            return BtnPassword();
        }
    }

    /**
     * realiza acciones para la primera pantalla 
     * @return nueva ventana
     */
    
    private String BtnPan() {
        if(!general.getPulsaciones().isEmpty()&&scene.getBtnCount()>20){
            general.CambiodeScena();
            name="IniMenu";
            setAll();
        }
        return "";
    }
    
    /**
     * realiza acciones para el menu inicial
     * @return nueva ventana
     */

    private String BtnMenu() {
        if(general.getPulsaciones().contains("UP")&&scene.getBtnCount()>20){
            scene.changeOne(-1, partes);
            scene.setBtnCount(0);
            
        }
        if(general.getPulsaciones().contains("DOWN")&&scene.getBtnCount()>20){
            scene.changeOne(1, partes);
            scene.setBtnCount(0);
        }
        if(general.getPulsaciones().contains("ENTER")||general.getPulsaciones().contains("X")&&scene.getBtnCount()>20){
            scene.setBtnCount(0);
            return MenuOptions(scene.getBoton());
        }
        return "";
    }

    /**
     * realiza una accion segun el boton escogido
     * @return nueva ventana
     */
    
    private String MenuOptions(int boton) {
        if(boton==0){
            general.CambiodeScena();
            return "Level1.0";
        }else{
            general.CambiodeScena();
            name="Password";
            setAll();
            ArrayList<String> trade =LectoEscritura.detectKey(new File("src/code/PasswordLim.txt"), "codes");
            for (int i = 0; i < trade.size(); i=i+2) {
                double code1 = Integer.parseInt(trade.get(i));
                String level=trade.get(i+1);
                scene.getCodes().put(code1, level);

            }
            
            return "";
        }
        
    }

    /**
     * realiza acciones para el menu de password
     * @return nueva ventana
     */
    
    private String BtnPassword() {
        if(general.getPulsaciones().contains("UP")&&scene.getBtnCount()>20){
            scene.changeTwo("up", partes);
            scene.setBtnCount(0);
        }
        if(general.getPulsaciones().contains("DOWN")&&scene.getBtnCount()>20){
            scene.changeTwo("down", partes);
            scene.setBtnCount(0);
        }
        if(general.getPulsaciones().contains("LEFT")&&scene.getBtnCount()>20){
            scene.changeTwo("left", partes);
            scene.setBtnCount(0);
        }
        if(general.getPulsaciones().contains("RIGHT")&&scene.getBtnCount()>20){
            scene.changeTwo("right", partes);
            scene.setBtnCount(0);
        }

        if(general.getPulsaciones().contains("ENTER")||general.getPulsaciones().contains("X")&&scene.getBtnCount()>20){
            scene.setBtnCount(0);
            for(int i=0;i<5;i++){
                System.out.print(scene.getCode()[i]);
            }
            System.out.println("");
            if(scene.canChangeCode()){
                System.out.println(scene.changeCode());
                return scene.changeCode();
            }
            
        }
        if(general.getPulsaciones().contains("ESCAPE")&&scene.getBtnCount()>20){
            general.CambiodeScena();
            name="IniMenu";
            setAll();
        }
        return "";
    }
    
}
