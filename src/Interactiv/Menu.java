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
import Details.UbiGroup;
import Details.Visual;
import Details.LectoEscritura;

/**
 * La clase Menu se Encarga de Gestionar todo lo que respecta a los menues dentro del juego
 * @author Fabian Montes
 * @version 3.0.3
 */

public class Menu {
    private String name;
    private ArrayList<UbiGroup> Destellos;
    private HashMap<String,Visual> Imagens;
    private HashMap<Double,String> Codes;
    private int[] code;
    private int boton;

    /**
     * Constructor
     * @param name Nombre Inicial del menu
     * @throws IOException 
     */
    
    public Menu(String name) throws IOException {
        this.name=name;
        this.Destellos = new ArrayList<>();
        this.Imagens = new HashMap<>();
        this.Codes=new HashMap<>();
        code= new int[5];
        boton=0;
        setAll();
    }
    
    /**
     * Consigue todas las ubicaciones de las partes del menu
     * @return  todas las ubicaciones de las partes del menu
     */

    public ArrayList<UbiGroup> getDestellos() {
        return Destellos;
    }
    
    /**
     * Consigue todas las imagenes y sus partes usadas en el menu
     * @return todas las imagenes y partes usadas
     */

    public HashMap<String, Visual> getImagens() {
        return Imagens;
    }
    
    /**
     * Consigue el nombre del menu
     * @return nombre del menu
     */
    
    public String getName() {
        return name;
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
     * cambia los numeros del codigo
     * @param code nuevo numeros del codigo
     */
    
    public void setCode(int[] code) {
        this.code = code;
    }
    
    /**
     * Borra y relee las partes del menu, segun el nombre de este
     * @throws IOException 
     */
    
    private void setAll() throws IOException{
        Destellos.clear();
        Imagens.clear();
        Codes.clear();
        this.Imagens=LectoEscritura.PartesEnImagen("src/code/"+name+"Ub.txt", Imagens);
        this.Destellos=LectoEscritura.UbicarLevel(new File("src/code/"+name+"Vis.txt"), Destellos);
    }
    
    /**
     * Cambia el menu a un nombre especifico
     * @param name nuevo nombre del menu 
     * @throws IOException 
     */
    
    public void putMenu(String name) throws IOException{
        this.name=name;
        boton=0;
        setAll();  
        if(this.name.equals("Password")){
            ArrayList<String> trade =LectoEscritura.detectKey(new File("src/code/"+name+"Lim.txt"), "codes");
            for (int i = 0; i < trade.size(); i=i+2) {
                double codes=Integer.parseInt(trade.get(i));
                String level=trade.get(i+1);
                this.Codes.put(codes, level);
            }
            code[0]=0;
            code[1]=0;
            code[2]=0;
            code[3]=0;
            code[4]=0;
        }
    }
    
    /**
     * Cambia el boton del menu
     * @param s valor de cambio(s>0:boton mueve hacia derecham otros: boton mueve izquierda)
     */
    
    public void changeOne(int s){
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
        Destellos.get(0).replaceGroup(0, 406, 442+(100*boton), 62, 56);
    }
    
    /**
     * Cambia la ubicacion del boton, o del codigo señalado
     * @param s accion a realizar
     */
    
    public void changeTwo(String s){
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
        
        Destellos.get(0).replaceGroup(0, 154+(212*boton), 350, 126, 126);
    }
    
    /**
     * Descifra si el codigo dado existe en la lista de codigos
     * @return si existe el codigo
     */
    
    public boolean canChangeCode(){
        Double a=code[0]*Math.pow(10, 4)+code[1]*Math.pow(10, 3)+code[2]*Math.pow(10, 2)+code[3]*Math.pow(10, 1)+code[4]*Math.pow(10, 0);
        return this.Codes.get(a)!=null;
    }
    
    /**
     * Lee el codigo existente y ofrece un nivel segun este
     * @return nombre del nivel
     */
    
    public String changeCode(){
        Double a=code[0]*Math.pow(10, 4)+code[1]*Math.pow(10, 3)+code[2]*Math.pow(10, 2)+code[3]*Math.pow(10, 1)+code[4]*Math.pow(10, 0);
        return this.Codes.get(a);
    }
    
    /**
     * Cambia todos los codigos posibles
     * @param Codes nuevos codigos a existir
     */
    
    public void setCodes(HashMap<Double, String> Codes) {
        this.Codes = Codes;
    }

}
