/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles;

/**
 *
 * @author nacho
 */
public class Aleatorio {

    public static double doubleAleatorio(double min, double max) {
        return Math.random() * (max - min) + min;
    }

    public static int intAleatorio(int min, int max) {
        return (int) doubleAleatorio(min, max+1);
    }

    public static char charAleatorio() {
        char a;
        if (Math.random() >= 0.5) {
            // letras mayúsculas
            a = (char) intAleatorio(97, 123);
        } else {
            // letras minúsculas
            a = (char) intAleatorio(65, 91);
        }
        return a;
    }
    
    public static boolean boolAleatorio(){
        return (intAleatorio(0, 1) == 0);
    }
    
    public static boolean boolAleatorio(int porcentaje){
        return (intAleatorio(0, 100) < porcentaje);
    }

    public static String stringAleatorio(int tam) {
        String res = "";
        for (int i = 0; i < tam; i++) {
            res = res + charAleatorio();
        }
        return res;
    }

    public static String nombreAleatorio() {
        String arr[] = {"Juan", "Carlos", "Pedro", "José", "Tobías", "Laura", "María", "Joanna", "Hugo", "Susana", "Melania", "Antonio", "Margarett", "Marina", "Rodrigo", "Nacho", "Alguien"};
        return arr[intAleatorio(0, arr.length - 1)];
    }

    public static String nombrePerroAleatorio() {
        String arr[] = {"Sparky", "Lulu", "Tito", "Cacho", "Manchas", "Fluffy", "Spots", "Pelusa"};
        return arr[intAleatorio(0, arr.length - 1)];
    }

    public static String stringAleatorio2() {
        String res = "";
         String arr[] = {"A", "B", "C","D", "E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        for(int i = 0; i < intAleatorio(1, 15); i++){
            res += arr[intAleatorio(0, arr.length - 1)];
        }
        return res;
    }

    public static String razaPerroAleatorio() {
        String arr[] = {"Labrador", "Beagle", "Rottweiler", "Bulldog", "Caniche", "Dóberman", "Husky", "Doge", "Pug", "Corgi", "Terrier"};
        return arr[intAleatorio(0, arr.length - 1)];
    }

    public static String nombreAnimalAleatorio() {
        String arr[] = {"Perro", "Gato", "Conejo", "Elefante", "León", "Girafa", "Serpiente", "Zebra", "Hipopotamo"};
        return arr[intAleatorio(0, arr.length - 1)];
    }

    public static char generoAleatorio() {
        char arr[] = {'M', 'H', 'M', 'H', 'M', 'H'}; //Agrego varios para que sea un poco mas variado. Suelen salir puras Ms.
        return arr[intAleatorio(0, arr.length - 1)];
    }

    public static void arregloAleatorio(int[] a) {
        for (int i = 0; i < a.length; i++) {
            a[i] = intAleatorio(0, 100);
        }
    }

    public static String nombreModeloAutoAleatorio() {
        String arr[] = {"Nissan", "Ford", "Audi", "Ferari", "Honda", "BMW", "Toyota"};
        return arr[intAleatorio(0, arr.length - 1)];
    }

    public static void arregloAleatorio(int[] a, int min, int max) {
        for (int i = 0; i < a.length; i++) {
            a[i] = intAleatorio(min, max);
        }
    }
    
    public static void arregloStringAleatorio(String[] a, int min, int max){
        for (int i = 0; i < a.length; i++) {
            a[i] = stringAleatorio(intAleatorio(min, max));
        }
    }
}
