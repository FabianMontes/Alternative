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
 *
 * @author fanat
 */
public class Menu {
    private String name;
    private ArrayList<UbiGroup> Destellos;
    private HashMap<String,Visual> Imagens;
    private HashMap<Double,String> Codes;
    private int[] code;
    private int boton;

    public Menu(String name) throws IOException {
        this.name=name;
        this.Destellos = new ArrayList<>();
        this.Imagens = new HashMap<>();
        this.Codes=new HashMap<>();
        code= new int[5];
        boton=0;
        setAll();
    }

    public ArrayList<UbiGroup> getDestellos() {
        return Destellos;
    }

    public HashMap<String, Visual> getImagens() {
        return Imagens;
    }
    
    public String getName() {
        return name;
    }
    
    public int getBoton() {
        return boton;
    }
    
    public int[] getCode() {
        return code;
    }
    
    public void setCode(int[] code) {
        this.code = code;
    }
    
    private void setAll() throws IOException{
        Destellos.clear();
        Imagens.clear();
        Codes.clear();
        this.Imagens=LectoEscritura.PartesEnImagen("src/code/"+name+"Ub.txt", Imagens);
        this.Destellos=LectoEscritura.UbicarLevel(new File("src/code/"+name+"Vis.txt"), Destellos);
    }
   
    public void setMenu(String name) throws IOException{
        this.name=name;
        setAll();
    }

    public void putMenu(int a) throws IOException{
        if(a==0){
            name="MenuSave";
        }else{
            name="Pasword";
        }
        
        boton=0;
        setAll();  
        if(a!=0){
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
    
    public boolean canChangeCode(){
        Double a=code[0]*Math.pow(10, 4)+code[1]*Math.pow(10, 3)+code[2]*Math.pow(10, 2)+code[3]*Math.pow(10, 1)+code[4]*Math.pow(10, 0);
        return this.Codes.get(a)!=null;
    }
    
    public String changeCode(){
        Double a=code[0]*Math.pow(10, 4)+code[1]*Math.pow(10, 3)+code[2]*Math.pow(10, 2)+code[3]*Math.pow(10, 1)+code[4]*Math.pow(10, 0);
        return this.Codes.get(a);
    }

}
