/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Details;
import java.util.HashMap;
import javafx.scene.image.Image;

/**
 * La Clase Visual Guarda Todas las partes de una Imagen
 * @author Fabian Montes
 * @version 2.1.1
 */
public class Visual {
    private Image ubicacion;
    private HashMap<String,Cordenate> partes;
    
    /**
     * Constructor 
     * @param ubicacion La ubicacion de la imagen, para convertirla en imagen
     */
    
    public Visual(String ubicacion) {
        this.ubicacion = new Image(ubicacion);
        this.partes = new HashMap<>();
    }
    /**
     * Consigue la Imagen a utilizar
     * @return Imagen a utilizar
     */
    public Image getUbicacion() {
        return ubicacion;
    }
    /**
     * Cambia la imagen a utilizar
     * @param ubicacion nueva ubicacion de la imagen a utilizar
     */

    public void setUbicacion(String ubicacion) {
        this.ubicacion = new Image(ubicacion);
    }
    
    /**
     * Agrega una nueva parte de imagen a utilizar con animacion
     * @param key nombre de la parte a guardar
     * @param x ubicacion en X de la imagen
     * @param y ubicacion en Y de la imagen
     * @param large largo de la imagen
     * @param high alto de la imagen
     * @param animationN cantidad de animaciones de la parte
     */
    
    public void putPart(String key,double x, double y, double large, double high, double animationN){
        this.partes.put(key, new Cordenate(key,x,y,large,high,animationN));
    }
    
    /**
     * Agrega una nueva parte a utilizar sin animacion
     * @param key nombre de la parte a guardar
     * @param x ubicacion en X de la imagen
     * @param y ubicacion en Y de la imagen
     * @param large largo de la imagen
     * @param high alto de la imagen
     */
            
            
    public void putPart(String key,double x, double y, double large, double high){
        this.partes.put(key, new Cordenate(key, x, y, large, high));
    }
    
    /**
     * Remueve una parte de la imagen
     * @param key nombre de la parte a borrar
     */
    
    public void removePart(String key){
        this.partes.remove(key);
    }
    
    /**
     * Reemplaza una parte de la imagen
     * @param key nombre de la parte a reemplazar
     * @param x nuevo X de la parte
     * @param y nuevo Y de la parte
     * @param large nuevo largo de la parte
     * @param high nuevo alto de la parte
     * @param animationN nueva cantidad de animaciones
     */
    
    public void replacePart(String key,double x, double y, double large, double high, double animationN){
        this.partes.replace(key,new Cordenate(key, x, y, large, high, animationN));
    }
    
    /**
     * Consigue determinada parte de una parte
     * @param key la parte de la cual se desea conocer la informacion
     * @param a variable a conocer (1:X,2:Y,3:Largo,4:Alto,5:animacion)
     * @return valor de la variable
     */
    
    public double getPart(String key, int a){
        switch(a){
            case 1:
                return this.partes.get(key).getX();
            case 2:
                return this.partes.get(key).getY();
            case 3:
                return this.partes.get(key).getLarge();
            case 4:
                return this.partes.get(key).getHigh();
            case 5:
                return this.partes.get(key).getAnimationN();
            default:
                return 0;
        }
    }
    
    /**
     * Consigue todas las partes
     * @return todas las partes de la imagen
     */

    public HashMap<String, Cordenate> getPartes() {
        return partes;
    }

    /**
     * cambia todas las partes de una imagen
     * @param partes nuevas partes de la imagen
     */
    
    public void setPartes(HashMap<String, Cordenate> partes) {
        this.partes = partes;
    }
    
}
