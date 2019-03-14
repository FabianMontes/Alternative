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
import java.util.HashMap;
import javafx.scene.paint.Color;

/**
 *
 * @author fanat
 */
public class Password extends Ventana{
    private int code;
    private int time;

    /**
     * Constructor
     * @param name nombre del menu
     * @param general general.getLapiz() y escena
     */
    
    public Password(String name, General general){
        super(name, general);
        code=0;
    }
    
    @Override
    public void setAll(){
        this.imagens.clear();
        this.partes.clear();
        this.imagens=LectoEscritura.PartesEnImagen(new File("src/code/PasswordUb.txt"), imagens);
        ArrayList<String> trade =LectoEscritura.detectKey(new File("src/code/PasswordLim.txt"), "codes");
        for (int i = 0; i < trade.size(); i=i+2) {
            int code1 = Integer.parseInt(trade.get(i));
            String level=trade.get(i+1);
            if(name.contains(level)){
                this.code=code1;
                break;
            }
            
        }
        
    }
    
    @Override
    public void Ciclo() {
        general.getLapiz().setFill(Color.ORANGE);
        general.getLapiz().fillRect(0, 0, 1280, 650);
        general.getLapiz().setFill(Color.BLACK);
        general.getLapiz().fillRect(100, 300, 200, 200);        
        general.getLapiz().fillRect(300, 300, 200, 200);
        general.getLapiz().fillRect(550, 300, 200, 200);
        general.getLapiz().fillRect(750, 300, 200, 200);
        general.getLapiz().fillRect(950, 300, 200, 200);
        general.getLapiz().setFill(Color.DARKGRAY);
        general.getLapiz().fillRect(154, 300, 126, 126);        
        general.getLapiz().fillRect(366, 300, 126, 126);
        general.getLapiz().fillRect(578, 300, 126, 126);
        general.getLapiz().fillRect(790, 300, 126, 126);
        general.getLapiz().fillRect(1002, 300, 126, 126);
        int code1=code/10000;
        int code2=(code-code1*10000)/1000;
        int code3=(code-code1*10000-code2*1000)/100;
        int code4=(code-code1*10000-code2*1000-code3*100)/10;
        int code5=(code-code1*10000-code2*1000-code3*100-code4*10);
        general.getLapiz().drawImage(imagens.get("parts").getUbicacion(), imagens.get("parts").getPart("code"+code1,1), imagens.get("parts").getPart("code"+code1, 2), imagens.get("parts").getPart("code"+code1, 3), imagens.get("parts").getPart("code"+code1, 4), 154, 300, 126, 126);
        general.getLapiz().drawImage(imagens.get("parts").getUbicacion(), imagens.get("parts").getPart("code"+code2,1), imagens.get("parts").getPart("code"+code2, 2), imagens.get("parts").getPart("code"+code2, 3), imagens.get("parts").getPart("code"+code2, 4), 366, 300, 126, 126);
        general.getLapiz().drawImage(imagens.get("parts").getUbicacion(), imagens.get("parts").getPart("code"+code3,1), imagens.get("parts").getPart("code"+code3, 2), imagens.get("parts").getPart("code"+code3, 3), imagens.get("parts").getPart("code"+code3, 4), 578, 300, 126, 126);
        general.getLapiz().drawImage(imagens.get("parts").getUbicacion(), imagens.get("parts").getPart("code"+code4,1), imagens.get("parts").getPart("code"+code4, 2), imagens.get("parts").getPart("code"+code4, 3), imagens.get("parts").getPart("code"+code4, 4), 790, 300, 126, 126);
        general.getLapiz().drawImage(imagens.get("parts").getUbicacion(), imagens.get("parts").getPart("code"+code5,1), imagens.get("parts").getPart("code"+code5, 2), imagens.get("parts").getPart("code"+code5, 3), imagens.get("parts").getPart("code"+code5, 4),1002, 300, 126, 126);
    }
    
    @Override
    public String Btn() {
        if(time>100){
            if(!general.getPulsaciones().isEmpty()){
                return "IniPantalla";
            }
            
        }
        time++;
        return "";
    }
}
