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
    private HashMap<String,Integer> powers1;
    private HashMap<String,Integer> powers2;
    private HashMap<String,Integer> powers3;
    private int boton;

    public Menu(String name) throws IOException {
        this.name=name;
        this.Destellos = new ArrayList<>();
        this.Imagens = new HashMap<>();
        powers1=new HashMap<>();
        powers2=new HashMap<>();
        powers3=new HashMap<>();
        boton=0;
        setAll();
    }

    public ArrayList<UbiGroup> getDestellos() {
        return Destellos;
    }

    public HashMap<String, Visual> getImagens() {
        return Imagens;
    }
    
    public void setMenu(String name) throws IOException{
        this.name=name;
        setAll();
    }

    public String getName() {
        return name;
    }
    
    public void putMenu() throws IOException{
        name="MenuSave";
        boton=0;
        setAll();        
        powers1=LectoEscritura.getPowers(new File("src/code/SaveGame1.txt"), "powers");
        powers2=LectoEscritura.getPowers(new File("src/code/SaveGame2.txt"), "powers");
        powers3=LectoEscritura.getPowers(new File("src/code/SaveGame3.txt"), "powers"); 
        Destellos.add(new UbiGroup("terra"));
        Destellos.get(Destellos.size()-1).addGroup(792, 61, 64, 64);
        Destellos.get(Destellos.size()-1).addGroup(792, 308, 64, 64);
        Destellos.get(Destellos.size()-1).addGroup(792, 538, 64, 64);
        Destellos.add(new UbiGroup("aero"));
        Destellos.get(Destellos.size()-1).addGroup(792, 125, 64, 64);
        Destellos.get(Destellos.size()-1).addGroup(792, 372, 64, 64);
        Destellos.get(Destellos.size()-1).addGroup(792, 602, 64, 64);
        Destellos.add(new UbiGroup("aqua"));
        Destellos.get(Destellos.size()-1).addGroup(856, 61, 64, 64);
        Destellos.get(Destellos.size()-1).addGroup(856, 308, 64, 64);
        Destellos.get(Destellos.size()-1).addGroup(856, 538, 64, 64);
        Destellos.add(new UbiGroup("pyro"));
        Destellos.get(Destellos.size()-1).addGroup(856, 125, 64, 64);
        Destellos.get(Destellos.size()-1).addGroup(856, 372, 64, 64);
        Destellos.get(Destellos.size()-1).addGroup(856, 602, 64, 64);
        
    }
    
    public String getTipePow(String power, int a) throws IOException{
        switch(a){
            case 1:
                return (power+powers1.get(power));
            
            case 2:
                return (power+powers2.get(power));
            
            default:
                return (power+powers3.get(power));
                
        }
    }
    
    private void setAll() throws IOException{
        Destellos.clear();
        Imagens.clear();
        this.Destellos=LectoEscritura.UbicarLevel(new File("src/code/"+name+"Vis.txt"), Destellos);
        this.Imagens=LectoEscritura.PartesEnImagen("src/code/"+name+"Ub.txt", Imagens);
    }
    
    public void change(int s){
        if(s>0){
            if(boton==2){
                boton=0;
            }else{
                boton++;
            }
        }else{
            if(boton==0){
                boton=2;
            }else{
                boton--;
            }
        }
        Destellos.get(0).replaceGroup(0, 150, 70+(247*boton), 128, 128);
    }

    public int getBoton() {
        return boton;
    }
    
    
}
