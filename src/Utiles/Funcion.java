/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles;

import java.util.Locale;

/**
 *
 * @author cmierez
 */
public class Funcion {
    
    public static int doblamiento(int ingreso, int tam){
        int clave = tam;
        
        while(clave > tam){
            clave = (ingreso / 7);
        }        
        
        return clave;
        
    }
    
    public static int porASCII(String ingreso, int tam){
        int clave = 0, aux = 0;
        
        ingreso = ingreso.toLowerCase();
        
        for(int i = 0; i < (ingreso.length()); i++){
            //System.out.println(clave);
            aux += (int)ingreso.charAt(i) % tam;
            
        }
        clave = aux % tam;
        
        //System.out.println(clave);
        
        return clave;
        
    }
    
}
