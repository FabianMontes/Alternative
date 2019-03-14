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
     * @param file archivo del nivel a leer
     * @param objeto lista donde guardaremos los objetos
     * @return Lista de objetos con sus ubicaciones en nivel 
     */
    
    public static ArrayList<UbiGroup> UbicarLevel(File file, ArrayList<UbiGroup> objeto){
        try (Scanner sc = new Scanner(file)) {
            System.out.println(file.getName());
            while (sc.hasNext()) {
                sc.useDelimiter(",");
                String a= sc.next().trim();
                System.out.println(a);
                objeto.add(new UbiGroup(a));
                String part=sc.next().trim();
                int parts = Integer.parseInt(part);
                for(int i=0;i<parts;i++){
                    double x = Double.parseDouble(sc.next().trim());
                    double y = Double.parseDouble(sc.next().trim());
                    double large= Double.parseDouble(sc.next().trim());
                    double ancho= Double.parseDouble(sc.next().trim());
                    objeto.get(objeto.size()-1).addGroup(x, y,large,ancho);
                }
            }
            sc.close();
        }catch(IOException ex){
            System.out.println(ex);
        }
            
        return objeto;
    }
    
    /**
     * Busca en un archivo cierta clave y guarda todas las lineas entre la clave y la clave cerrada (F+clave)
     * @param file archivo a investigar
     * @param Key Clave para allar los datos
     * @return lista de datos encontrados
     */
    
    public static ArrayList<String> detectKey(File file,String Key){
        ArrayList<String> Keys =new ArrayList<>();
        boolean c=false;
        try (Scanner sc = new Scanner(file)) {
            sc.useDelimiter(",");
            String Slinea;
            while(sc.hasNext()){
                Slinea= sc.next().trim();
                if(Slinea.equals("F"+Key)){
                    c=false;
                }
                if(c){
                    System.out.println(Slinea);
                    Keys.add(Slinea);
                }
                if(Slinea.equals(Key)){
                    c=true;
                }
            }
            sc.close();
        } catch (IOException ex) {
            /*Captura un posible error y le imprime en pantalla*/ 
             System.out.println(ex.getMessage());
        }
        return Keys;
    }
    
    /**
     * Consigue la Ubicacion de los enemigos de un nivel usando la tecnica de las claves
     * @param file Archivo a investigar
     * @param Key Nombre clave de los enemigos en el nivel
     * @return lista de enemigos del nivel
     */
    
    public static ArrayList<Enemie> getEnemie(File file,String Key){
        ArrayList<Enemie> minions =new ArrayList<>();
        boolean c=false;
        try (Scanner sc= new Scanner(file)){
            sc.useDelimiter(",");
            String Slinea;
            while(sc.hasNext()){
                Slinea= sc.next().trim();
                if(Slinea.equals("F"+Key)){
                    break;
                }
                System.out.println(Slinea);
                if(c){
                    int cant=Integer.parseInt(sc.next().trim());
                    for (int i = 0; i < cant; i++) {
                        double x= Double.parseDouble(sc.next().trim());
                        double y= Double.parseDouble(sc.next().trim());
                        double large= Double.parseDouble(sc.next().trim());
                        double ancho= Double.parseDouble(sc.next().trim());
                        double minX= Double.parseDouble(sc.next().trim());
                        double maxX= Double.parseDouble(sc.next().trim());
                        double minY= Double.parseDouble(sc.next().trim());
                        double maxY= Double.parseDouble(sc.next().trim());
                        switch(Slinea){
                            case "scorpio":
                                System.out.println("escorpion añadida");
                                minions.add(new Scorpio(x, y, large, ancho, minX,maxX,minY, maxY));
                            break;
                            case "topo":
                                System.out.println("topo añadido");
                                minions.add(new Topo(x, y, large, ancho, minX,maxX,minY, maxY));
                            break;
                            case "light":
                                minions.add(new Light(x, y, large, ancho, minX,maxX,minY, maxY));
                            break;
                            case "bird":
                                minions.add(new Bird(x, y, large, ancho, minX,maxX,minY, maxY));
                            break;
                        }

                    }
                }
                if(Slinea.equals(Key)){
                    c=true;
                }
            }
            sc.close();
        } catch (IOException | NumberFormatException ex) {
            /*Captura un posible error y le imprime en pantalla*/ 
             System.out.println(ex.getMessage());
        }
        return minions;
    }
    
    /**
     * Consigue las partes de Una lista de imagenes requeridas
     * @param file archivo a utilizar
     * @param objeto Lista donde se guardaran las partes de las imagenes
     * @return nueva lista de partes de imagenes requeridas
     */

    public static HashMap<String,Visual> PartesEnImagen(File file, HashMap<String,Visual> objeto){
        try(Scanner sc = new Scanner(file)){
            sc.useDelimiter(",");
            while (sc.hasNext()) {
                String a= sc.next().trim();
                String b= sc.next().trim();
                System.out.println(b);
                objeto.put(a,new Visual(b));
                int parts= Integer.parseInt(sc.next().trim());
                for(int i=0;i<parts;i++){
                    String key = sc.next().trim();
                    double x = Double.parseDouble(sc.next().trim());
                    double y = Double.parseDouble(sc.next().trim());
                    double c= Double.parseDouble(sc.next().trim());
                    double s= Double.parseDouble(sc.next().trim());
                    double N= Double.parseDouble(sc.next().trim());
                    objeto.get(a).putPart(key, x, y, c, s, N);
                }
            }
            sc.close();
        }catch(IOException ex){
            System.out.println(ex);
        }
        return objeto;
    }
}
