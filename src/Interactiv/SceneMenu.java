/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interactiv;
import java.util.HashMap;
import java.util.ArrayList;
import Details.UbiGroup;

/**
 * La clase Menu se Encarga de Gestionar todo lo que respecta a los menues dentro del juego
 * @author Fabian Montes
 * @version 3.0.3
 */

public class SceneMenu {
    private HashMap<Double,String> codes;
    private int[] code;
    private int boton;
    private int BtnCount;
    private int fondoAnim;
    private int fondoTime;

    /**
     * Constructor
     */
    
    public SceneMenu() {
        this.codes=new HashMap<>();
        code= new int[5];
        boton=0;
        BtnCount=0;
        fondoAnim=0;
        fondoTime=0;
    }
    
    /**
     * consigue el numero que se señala en el menu
     * @return opcion señalada en el menu
     */
    
    public int getBoton() {
        return boton;
    }
    
    /**
     * Consigue los cinco numeros actuales usados como supuesto codigo
     * @return cinco numeros codigo
     */
    
    public int[] getCode() {
        return code;
    }

    /**
     * regresa el numero de animacion del fondo
     * @return 
     */
    
    public int getFondoAnim(){
        return fondoAnim; 
    }
    
    /**
     * Cambia la animacion de fondo
     * @param maxFondoAnim maxima cantidad de animaciones del fondo
     */
    
    public void setFondoAnim(int maxFondoAnim){
        if(fondoTime>10){
            if(maxFondoAnim<=fondoAnim){
                fondoAnim=0;
            }else{
                fondoAnim++;
            }
        }
        fondoTime++;
    }
    
    /**
     * 
     * @return Consigue los codigos para niveles
     */
    
    public HashMap<Double, String> getCodes() {
        return codes;
    }
    
    /**
     * 
     * @return tiempo transcurrido sin oprimir botones
     */

    public int getBtnCount() {
        return BtnCount;
    }
    
    /**
     * continua el tiempo transcurrido sin oprimir botones
     */

    public void setBtnCount() {
        this.BtnCount++;
    }
    
    /**
     * cambia el tiempo sin oprimir botones
     * @param BtnCount nuevo tiempo contado
     */

    public void setBtnCount(int BtnCount) {
        this.BtnCount = BtnCount;
    }
    
    /**
     * cambia los numeros del codigo
     * @param code nuevo numeros del codigo
     */
    
    public void setCode(int[] code) {
        this.code = code;
    }

    /**
     * cambia el boton a un  nuevo valor
     * @param boton nuevo valor 
     */
    
    public void setBoton(int boton) {
        this.boton = boton;
    }
    
    /**
     * Cambia el boton del menu
     * @param s valor de cambio(s mayor que 0:boton mueve hacia derecham otros: boton mueve izquierda)
     * @param partes partes donde se encuentra el boton
     */
    
    public void changeOne(int s, ArrayList<UbiGroup> partes){
        if(s>0){
            if(boton==1){
                boton=0;
            }else{
                boton++;
            }
        }else{
            if(boton==0){
                boton=1;
            }else{
                boton--;
            }
        }
        partes.get(0).replaceGroup(0, 406, 442+(100*boton), 62, 56);
    }

    /**
     * Cambia la ubicacion del boton, o del codigo señalado
     * @param s accion a realizar
     * @param partes partes donde se encuentra el boton
     */
    
    public void changeTwo(String s, ArrayList<UbiGroup> partes){
        switch(s){
            case "up":
                if(code[boton]==0){
                    code[boton]=4;
                }else{
                    code[boton]--;
                }
            break;
            case "down":
                if(code[boton]==4){
                    code[boton]=0;
                }else{
                    code[boton]++;
                }
            break;
            case "left":
                if(boton==0){
                    boton=4;
                }else{
                   boton--;
                }
            break;
            default:
                if(boton==4){
                    boton=0;
                }else{
                   boton++;
                }
            break;
        }
        
        partes.get(0).replaceGroup(0, 154+(212*boton), 350, 126, 126);
    }
    
    /**
     * Descifra si el codigo dado existe en la lista de codigos
     * @return si existe el codigo
     */
    
    public boolean canChangeCode(){
        Double a=code[0]*Math.pow(10, 4)+code[1]*Math.pow(10, 3)+code[2]*Math.pow(10, 2)+code[3]*Math.pow(10, 1)+code[4]*Math.pow(10, 0);
        return this.codes.get(a)!=null;
    }
    
    /**
     * Lee el codigo existente y ofrece un nivel segun este
     * @return nombre del nivel
     */
    
    public String changeCode(){
        Double a=code[0]*Math.pow(10, 4)+code[1]*Math.pow(10, 3)+code[2]*Math.pow(10, 2)+code[3]*Math.pow(10, 1)+code[4]*Math.pow(10, 0);
        return this.codes.get(a);
    }
    
    /**
     * Cambia todos los codigos posibles
     * @param codes nuevos codigos a existir
     */
    
    public void setCodes(HashMap<Double, String> codes) {
        this.codes = codes;
    }

}
