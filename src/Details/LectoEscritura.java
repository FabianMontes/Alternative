/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Details;


import Interactiv.Enemie;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author fanat
 */
public class LectoEscritura {
    @SuppressWarnings("empty-statement")
    public static ArrayList<UbiGroup> UbicarLevel(File archivo, ArrayList<UbiGroup> objeto) throws FileNotFoundException, IOException{
        Scanner in = new Scanner(new FileReader(archivo));
        while (in.hasNext()) {
            String a= in.nextLine();
            objeto.add(new UbiGroup(a));
            int parts = Integer.parseInt(in.nextLine());
            for(int i=0;i<parts;i++){
                double x = Double.parseDouble(in.nextLine());
                double y = Double.parseDouble(in.nextLine());
                double large= Double.parseDouble(in.nextLine());
                double ancho= Double.parseDouble(in.nextLine());
                objeto.get(objeto.size()-1).addGroup(x, y,large,ancho);
            }
        }
        in.close();
        return objeto;
    }
    
    public static ArrayList<String> detectKey(File Ffichero,String Key) throws FileNotFoundException, IOException{
        ArrayList<String> Keys =new ArrayList<>();
        boolean c=false;
        try {
            if(Ffichero.exists()){
                BufferedReader Flee= new BufferedReader(new FileReader(Ffichero));
                String Slinea;
                while((Slinea=Flee.readLine())!=null&&!Slinea.equals("F"+Key)) {
                    if(c)
                        Keys.add(Slinea);
                    if(Slinea.equals(Key)){
                        c=true;
                    }
                                  
                }
                Flee.close();
            }else{
                System.out.println("Fichero No Existe");
            }
        } catch (Exception ex) {
            /*Captura un posible error y le imprime en pantalla*/ 
             System.out.println(ex.getMessage());
        }
        return Keys;
    }
    public static HashMap<String,Integer> getPowers(File Ffichero,String Key) throws FileNotFoundException, IOException{
        HashMap<String,Integer> Keys =new HashMap<>();
        boolean c=false;
        try {
            if(Ffichero.exists()){
                BufferedReader Flee= new BufferedReader(new FileReader(Ffichero));
                String Slinea;
                while((Slinea=Flee.readLine())!=null&&!Slinea.equals("F"+Key)) {
                    int bet = 0;
                    if(c){
                        bet= Integer.parseInt(Flee.readLine());
                        Keys.put(Slinea,bet);
                    }if(Slinea.equals(Key)){
                        c=true;
                    }
                                  
                }
                Flee.close();
            }else{
                System.out.println("Fichero No Existe");
            }
        } catch (Exception ex) {
            /*Captura un posible error y le imprime en pantalla*/ 
             System.out.println(ex.getMessage());
        }
        return Keys;
    }
    
    public static ArrayList<Enemie> getEnemie(File Ffichero,String Key) throws FileNotFoundException, IOException{
        ArrayList<Enemie> minions =new ArrayList<>();
        boolean c=false;
        try {
            if(Ffichero.exists()){
                BufferedReader Flee= new BufferedReader(new FileReader(Ffichero));
                String Slinea;
                while((Slinea=Flee.readLine())!=null&&!Slinea.equals("F"+Key)) {
                    System.out.println(Slinea);
                    if(c){
                        System.out.println("ahhh");
                        String type=Flee.readLine();
                        System.out.println(type);
                        int cant=Integer.parseInt(Flee.readLine());
                        for (int i = 0; i < cant; i++) {
                            double x= Double.parseDouble(Flee.readLine());
                            double y= Double.parseDouble(Flee.readLine());
                            double large= Double.parseDouble(Flee.readLine());
                            double ancho= Double.parseDouble(Flee.readLine());
                            double minX= Double.parseDouble(Flee.readLine());
                            double maxX= Double.parseDouble(Flee.readLine());
                            double minY= Double.parseDouble(Flee.readLine());
                            double maxY= Double.parseDouble(Flee.readLine());
                            switch(type){
                                case "scorpio":
                                    System.out.println(type);
                                    minions.add(new Scorpio(x, y, large, ancho, minX,maxX,minY, maxY));
                                break;
                                case "topo":
                                    System.out.println(type);
                                    minions.add(new Topo(x, y, large, ancho, minX,maxX,minY, maxY));
                                break;
                            }
                            
                        }
                    }
                    if(Slinea.equals(Key)){
                        System.out.println("bhhhhh");
                        c=true;
                    }         
                }
                Flee.close();
            }else{
                System.out.println("Fichero No Existe");
            }
        } catch (Exception ex) {
            /*Captura un posible error y le imprime en pantalla*/ 
             System.out.println(ex.getMessage());
        }
        return minions;
    }

    public static HashMap<String,Visual> PartesEnImagen(String archivo, HashMap<String,Visual> objeto)throws FileNotFoundException, IOException{
        Scanner in = new Scanner(new FileReader(archivo));
        while (in.hasNext()) {
            String a= in.nextLine();
            String b= in.nextLine();
            objeto.put(a,new Visual(b));
            int parts = Integer.parseInt(in.nextLine());
            for(int i=0;i<parts;i++){
                String key = in.nextLine();
                System.out.println(key);
                double x = Double.parseDouble(in.nextLine());
                double y = Double.parseDouble(in.nextLine());
                double c= Double.parseDouble(in.nextLine());
                double s= Double.parseDouble(in.nextLine());
                double N= Double.parseDouble(in.nextLine());
                objeto.get(a).putPart(key, x, y, c, s, N);
            }
        }
        in.close();
        
        return objeto;
    }
    
    public static void EcribirFichero(File Ffichero,String SCadena){
        try {

            if(!Ffichero.exists()){
                Ffichero.createNewFile();
            }

            BufferedWriter Fescribe = new BufferedWriter(new FileWriter(Ffichero,true));
            Fescribe.write(SCadena + "\n");

        } catch (IOException ex) {
           //Captura un posible error le imprime en pantalla 
            System.out.println(ex.getMessage());
        } 
    }
    
    public static  void BorrarFichero(File Ffichero){
        try {
            /*Si existe el fichero*/
            if(Ffichero.exists()){
                /*Borra el fichero*/  
                Ffichero.delete(); 
                System.out.println("Fichero Borrado con Exito");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static  void ModificarFichero(File FficheroAntiguo,String Satigualinea,String Snuevalinea){        
        String SnombFichNuev=FficheroAntiguo.getParent()+"/auxiliar.txt";
        File FficheroNuevo=new File(SnombFichNuev);
        try {
            /*Si existe el fichero inical*/
            if(FficheroAntiguo.exists()){
                /*Abro un flujo de lectura*/
                BufferedReader Flee= new BufferedReader(new FileReader(FficheroAntiguo));
                String Slinea;
                /*Recorro el fichero de texto linea a linea*/
                while((Slinea=Flee.readLine())!=null) { 
                    /*Si la lia obtenida es igual al la bucada
                     *para modificar*/
                    if (Slinea.toUpperCase().trim().equals(Satigualinea.toUpperCase().trim())) {
                       /*Escribo la nueva linea en vez de la que tenia*/
                        EcribirFichero(FficheroNuevo,Snuevalinea);
                    }else{
                        /*Escribo la linea antigua*/
                         EcribirFichero(FficheroNuevo,Slinea);
                    }             
                }
                /*Obtengo el nombre del fichero inicial*/
                String SnomAntiguo=FficheroAntiguo.getName();
                /*Borro el fichero inicial*/
                BorrarFichero(FficheroAntiguo);
                /*renombro el nuevo fichero con el nombre del 
                *fichero inicial*/
                FficheroNuevo.renameTo(FficheroAntiguo);
                /*Cierro el flujo de lectura*/
                Flee.close();
            }else{
                System.out.println("Fichero No Existe");
            }
        } catch (Exception ex) {
            /*Captura un posible error y le imprime en pantalla*/ 
             System.out.println(ex.getMessage());
        }
    }
    
    public static  void EliminarRegistro(File FficheroAntiguo,String Satigualinea){        
        String SnombFichNuev=FficheroAntiguo.getParent()+"/auxiliar.txt";
        File FficheroNuevo=new File(SnombFichNuev);
        try {
            /*Si existe el fichero inical*/
            if(FficheroAntiguo.exists()){
                /*Abro un flujo de lectura*/
                BufferedReader Flee= new BufferedReader(new FileReader(FficheroAntiguo));
                String Slinea;
                /*Recorro el fichero de texto linea a linea*/
                while((Slinea=Flee.readLine())!=null) { 
                     /*Si la linea obtenida es distinta al la buscada
                     *para eliminar*/
                    if (!Slinea.toUpperCase().trim().equals(Satigualinea.toUpperCase().trim())) {
                       /*la escribo en el fichero nuevo*/ 
                       EcribirFichero(FficheroNuevo,Slinea);
                    }else{
                        /*Si es igual simple mete no hago nada*/
                    }             
                }
                /*Obtengo el nombre del fichero inicial*/
                String SnomAntiguo=FficheroAntiguo.getName();
                /*Borro el fichero inicial*/
                BorrarFichero(FficheroAntiguo);
                /*renombro el nuevo fichero con el nombre del fichero inicial*/
                FficheroNuevo.renameTo(FficheroAntiguo);
                /*Cierro el flujo de lectura*/
                Flee.close();
            }else{
                System.out.println("Fichero No Existe");
            }
        } catch (Exception ex) {
             System.out.println(ex.getMessage());
        }
         BorrarFichero(FficheroAntiguo);
    }
    public static  void EliminarPieza(File FficheroAntiguo,String Clase, String key){        
        String SnombFichNuev=FficheroAntiguo.getParent()+"/auxiliar.txt";
        File FficheroNuevo=new File(SnombFichNuev);
        boolean x=false;
        try {
            /*Si existe el fichero inical*/
            if(FficheroAntiguo.exists()){
                /*Abro un flujo de lectura*/
                BufferedReader Flee= new BufferedReader(new FileReader(FficheroAntiguo));
                String Slinea;
                /*Recorro el fichero de texto linea a linea*/
                while((Slinea=Flee.readLine())!=null) { 
                     /*Si la linea obtenida es distinta al la buscada
                     *para eliminar*/
                    if (Slinea.toUpperCase().trim().equals(Clase.toUpperCase().trim())) {
                       /*la escribo en el fichero nuevo*/ 
                       x=true;
                    }
                    if(x){
                        if (Slinea.toUpperCase().trim().equals(key.toUpperCase().trim())) {
                            Flee.readLine();
                            Flee.readLine();
                        }else{
                            EcribirFichero(FficheroNuevo,Slinea);
                        }
                    }else{
                        EcribirFichero(FficheroNuevo,Slinea);
                    }

                }
                /*Obtengo el nombre del fichero inicial*/
                String SnomAntiguo=FficheroAntiguo.getName();
                /*Borro el fichero inicial*/
                BorrarFichero(FficheroAntiguo);
                /*renombro el nuevo fichero con el nombre del fichero inicial*/
                FficheroNuevo.renameTo(FficheroAntiguo);
                /*Cierro el flujo de lectura*/
                Flee.close();
            }else{
                System.out.println("Fichero No Existe");
            }
        } catch (Exception ex) {
             System.out.println(ex.getMessage());
        }
        BorrarFichero(FficheroAntiguo);
    }
    
    public static  void ResetPowers(File FficheroAntiguo){        
        String SnombFichNuev=FficheroAntiguo.getParent()+"/auxiliar.txt";
        File FficheroNuevo=new File(SnombFichNuev);
        try {
            /*Si existe el fichero inical*/
            if(FficheroAntiguo.exists()){
                /*Abro un flujo de lectura*/
                BufferedReader Flee= new BufferedReader(new FileReader(FficheroAntiguo));
                String Slinea;
                /*Recorro el fichero de texto linea a linea*/
                while((Slinea=Flee.readLine())!=null) { 
                    /*Si la lia obtenida es igual al la bucada
                     *para modificar*/
                    if (Slinea.toUpperCase().trim().equals("terra")||Slinea.toUpperCase().trim().equals("aero")||Slinea.toUpperCase().trim().equals("aqua")||Slinea.toUpperCase().trim().equals("pyro")) {
                       /*Escribo la nueva linea en vez de la que tenia*/
                        EcribirFichero(FficheroNuevo,"0");
                    }else{
                        /*Escribo la linea antigua*/
                         EcribirFichero(FficheroNuevo,Slinea);
                    }             
                }
                /*Obtengo el nombre del fichero inicial*/
                //String SnomAntiguo=FficheroAntiguo.getName();
                /*Borro el fichero inicial*/
                //BorrarFichero(FficheroAntiguo);
                /*renombro el nuevo fichero con el nombre del 
                *fichero inicial*/
                //FficheroAntiguo.renameTo(FficheroNuevo);
                /*Cierro el flujo de lectura*/
                Flee.close();
            }else{
                System.out.println("Fichero No Existe");
            }
        } catch (Exception ex) {
            /*Captura un posible error y le imprime en pantalla*/ 
             System.out.println(ex.getMessage());
        }
        //BorrarFichero(FficheroNuevo);
         
    }
    
    public static void resetLevel(int option){
        System.out.println(option);
        switch(option){
            case 1:
                ModificarFichero(new File("src/code/SaveGame1.txt"),"3","0");
            break;
            case 2:
                ResetPowers(new File("src/code/SaveGame2.txt"));
            break;
            case 3:
                ResetPowers(new File("src/code/SaveGame3.txt"));
            break;
        }
    }

}
