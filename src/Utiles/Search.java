/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles;

/**
 *
 * @author Carlos
 */
public class Search {

    public static int secuencial(int[] a, int num) {
        //Devuelve la posición. Si no está, devuelve -1
        int i, pos = -1;
        boolean encontrado = false;

        i = 0;
        while (!encontrado && i < a.length) {

            if (a[i] == num) {
                encontrado = true;
                pos = i;
            } else {
                i++;
            }

        }
        return pos;
    }

    public static int binarioCreciente(int[] a, int num) {
        //Devuelve la posición. Si no está, devuelve -1
        int pos = -1, inicio = 0, fin = a.length - 1, medio;
        boolean encontrado = false;

        while (!encontrado && inicio <= fin) {

            medio = (inicio + fin) / 2;
            if (a[medio] == num) {
                encontrado = true;
                pos = medio;
            } else if (num < medio) {
                fin = medio - 1;
            } else {
                inicio = medio + 1;
            }
        }
        return pos;

    }

    public static int binarioRecursiva(int[] a, int n) {

        return binarioRecursiva(a, n, 0, a.length - 1);

    }

    private static int binarioRecursiva(int[] a, int n, int ini, int fin) {
        int centro, num, pos = -1;

        if (ini <= fin) {
            centro = (ini + fin) / 2;
            num = a[centro];

            if (num == n) {
                pos = centro;
            } else {
                if (n > num) {
                    pos = binarioRecursiva(a, n, centro+1, fin);
                } else {
                    pos = binarioRecursiva(a, n, ini, centro);
                }
            }
        }
        
        return pos;
    }


    public static int binarioDecreciente(int[] a, int num) {
        //Devuelve la posición. Si no está, devuelve -1
        int pos = -1, inicio = 0, fin = a.length - 1, medio;
        boolean encontrado = false;

        while (!encontrado && inicio <= fin) {

            medio = (inicio + fin) / 2;
            if (a[medio] == num) {
                encontrado = true;
                pos = medio;
            } else if (num < medio) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }
        return pos;

    }

}
