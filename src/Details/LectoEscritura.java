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
 * Esta Clase sirve para leer determinadas partes de determinados archivos archivos
 * @author Fabian Montes
 * @version 2.6.1
 */
public class LectoEscritura {
    @SuppressWarnings("empty-statement")
    
    /**
     * Consigue la ubicacion de todos los objetos en un nivel
     * @param File archivo del nivel a leer
     * @param objeto lista donde guardaremos los objetos
     * @return Lista de objetos con sus ubicaciones en nivel
     * @throws FileNotFoundException
     * @throws IOException 
     */
    
    public static ArrayList<UbiGroup> UbicarLevel(File archivo, ArrayList<UbiGroup> objeto) throws FileNotFoundException, IOException{
        try (Scanner in = new Scanner(new FileReader(archivo))) {
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
        }
        return objeto;
    }
    
    /**
     * Busca en un archivo cierta clave y guarda todas las lineas entre la clave y la clave cerrada (F+clave)
     * @param Ffichero archivo a investigar
     * @param Key Clave para allar los datos
     * @return lista de datos encontrados
     * @throws FileNotFoundException
     * @throws IOException 
     */
    
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
        } catch (IOException ex) {
            /*Captura un posible error y le imprime en pantalla*/ 
             System.out.println(ex.getMessage());
        }
        return Keys;
    }
    
    /**
     * Consigue la Ubicacion de los enemigos de un nivel usando la tecnica de las claves
     * @param Ffichero Archivo a investigar
     * @param Key Nombre clave de los enemigos en el nivel
     * @return lista de enemigos del nivel
     * @throws FileNotFoundException
     * @throws IOException 
     */
    
    public static ArrayList<Enemie> getEnemie(File Ffichero,String Key) throws FileNotFoundException, IOException{
        ArrayList<Enemie> minions =new ArrayList<>();
        boolean c=false;
        try {
            if(Ffichero.exists()){
                BufferedReader Flee= new BufferedReader(new FileReader(Ffichero));
                String Slinea;
                while((Slinea=Flee.readLine())!=null&&!Slinea.equals("F"+Key)) {
                    if(c){
                        String type=Flee.readLine();
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
                                    minions.add(new Scorpio(x, y, large, ancho, minX,maxX,minY, maxY));
                                break;
                                case "topo":
                                    minions.add(new Topo(x, y, large, ancho, minX,maxX,minY, maxY));
                                break;
                            }
                            
                        }
                    }
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
        return minions;
    }
    
    /**
     * Consigue las partes de Una lista de imagenes requeridas
     * @param archivo Nombre del archivo a utilizar
     * @param objeto Lista donde se guardaran las partes de las imagenes
     * @return nueva lista de partes de imagenes requeridas
     * @throws FileNotFoundException
     * @throws IOException 
     */

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
}
