/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import com.panamahitek.ArduinoException;
import com.panamahitek.PanamaHitek_Arduino;
import java.util.ArrayList;
import jssc.SerialPortEvent;

import java.util.logging.Logger;
import jssc.SerialPortEventListener;
import jssc.SerialPortException;
import sun.util.logging.PlatformLogger;

/**
 * This library has been created from Java Simple Serial Connector, by Alexey Sokolov
 * You can find all the information about this library at http://panamahitek.com
 * @author  Antony Garcia Gonzalez
 */
public class Controles {
    private static ArrayList<String> Pulsaciones = new ArrayList<>();
    
    private static PanamaHitek_Arduino ino = new PanamaHitek_Arduino();
    private static final SerialPortEventListener listener = new SerialPortEventListener() {

        @Override
        public void serialEvent(SerialPortEvent serialPortEvent) {
            try{
                if(ino.isMessageAvailable()){
                    String message = ino.printMessage();
                    
                    if(message.contains("UP")){
                        if(!Pulsaciones.contains("UP")){
                            Pulsaciones.add("UP");
                        }
                    }else{
                        Pulsaciones.remove("UP");
                    }

                    if(message.contains("DOWN")){
                        if(!Pulsaciones.contains("DOWN")){
                            Pulsaciones.add("DOWN");
                        }
                    }else{
                        Pulsaciones.remove("DOWN");
                    }

                    if(message.contains("RIGHT")){
                        if(!Pulsaciones.contains("RIGHT")){
                            Pulsaciones.add("RIGHT");
                        }
                    }else{
                        Pulsaciones.remove("RIGHT");
                    }

                    if(message.contains("LEFT")){
                        if(!Pulsaciones.contains("LEFT")){
                            Pulsaciones.add("LEFT");
                        }
                    }else{
                        Pulsaciones.remove("LEFT");
                    }

                    if(message.contains("START")){
                        if(!Pulsaciones.contains("START")){
                            Pulsaciones.add("START");
                        }
                    }else{
                        Pulsaciones.remove("START");
                    }

                    if(message.contains("SELECT")){
                        if(!Pulsaciones.contains("SELECT")){
                            Pulsaciones.add("SELECT");
                        }
                    }else{
                        Pulsaciones.remove("SELECT");
                    }

                    if(message.contains("LT")){
                        if(!Pulsaciones.contains("LT")){
                            Pulsaciones.add("LT");
                        }
                    }else{
                        Pulsaciones.remove("LT");
                    }

                    if(message.contains("RT")){
                        if(!Pulsaciones.contains("RT")){
                            Pulsaciones.add("RT");
                        }
                    }else{
                        Pulsaciones.remove("RT");
                    }

                    if(message.contains("BtnD")){
                        if(!Pulsaciones.contains("BtnD")){
                            Pulsaciones.add("BtnD");
                        }
                    }else{
                        Pulsaciones.remove("BtnD");
                    }

                    if(message.contains("BtnU")){
                        if(!Pulsaciones.contains("BtnU")){
                            Pulsaciones.add("BtnU");
                        }
                    }else{
                        Pulsaciones.remove("BtnU");
                    }

                    if(message.contains("BtnR")){
                        if(!Pulsaciones.contains("BtnR")){
                            Pulsaciones.add("BtnR");
                        }
                    }else{
                        Pulsaciones.remove("BtnR");
                    }
                    
                }else{
                    Pulsaciones.clear();
                }
            }catch(SerialPortException | ArduinoException ex){
                System.out.println(ex);
            }
        }
    };

    public static void genControles() {
        try{
            ino.arduinoRX("COM4", 115200, listener);
        }catch(SerialPortException | ArduinoException ex){
                System.out.println(ex);
        }
    }

    public static ArrayList<String> getPulsaciones() {

        return Pulsaciones;
    }
    
    
    
    
    
    public static void main(String[] args) {
        try{
            ino.arduinoRX("COM4", 115200, listener);
        }catch(SerialPortException | ArduinoException ex){
                System.out.println(ex);
        }
        
    }
    
}
