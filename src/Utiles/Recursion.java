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
public class Recursion {
    
    public static boolean esBinario(int num){
        boolean esBinario;
        
        if(num < 10){
            esBinario = num == 0 || num == 1;
        }else{
            esBinario = (num % 10 == 1 || num % 10 == 0) && esBinario(num / 10);
        }
        
        return esBinario;
    }
    
    
    public static int igualesA0(int[] a){
        return igualesA0(a, 0, a.length-1);
    }
    
    private static int igualesA0(int[] a, int ini, int fin){
        int cant = 0;
        
        if(ini < fin){
            if(a[ini] == 0){
                cant = 1 + igualesA0(a, ini+1, fin);
            }else{
                cant = igualesA0(a, ini+1, fin);
            }
        }
        
        return cant;
        
    }
    
    public static int igualesA0(String a){
        return igualesA0(a, 0, a.length() -1);
    }
    
    private static int igualesA0(String a, int ini, int fin){
        int cant = 0;
        
        if(ini < fin){
            if(a.charAt(ini) == '0'){
                cant = 1 + igualesA0(a, ini+1, fin);
            }else{
                cant = igualesA0(a, ini+1, fin);
            }
        }
        
        return cant;
        
    }
    
    public static int SearchbinarioRecursiva(int[] a, int n) {

        return SearchbinarioRecursiva(a, n, 0, a.length - 1);

    }
    
    private static int SearchbinarioRecursiva(int[] a, int n, int ini, int fin) {
        int centro, num, pos = -1;

        if (ini <= fin) {
            centro = (ini + fin) / 2;
            num = a[centro];

            if (num == n) {
                pos = centro;
            } else {
                if (n > num) {
                    pos = SearchbinarioRecursiva(a, n, centro+1, fin);
                } else {
                    pos = SearchbinarioRecursiva(a, n, ini, centro);
                }
            }
        }
        
        return pos;
    }

    public static int contarDigitos(int n) {
        int aux;

        if (n < 1) {
            aux = 0;
        } else {
            aux = 1 + contarDigitos(n / 10);
        }

        return aux;
    }

    public static int contarAparicionDigito(int n, int a) {
        int aux;

        if (n < 1) {
            if (n == a) {
                aux = 1;
            } else {
                aux = 0;
            }
        } else {
            if (n % 10 == a) {
                aux = 1 + contarAparicionDigito(n / 10, a);
            } else {
                aux = 0 + contarAparicionDigito(n / 10, a);
            }
        }

        return aux;
    }

    public static boolean arregloOrdenado(int[] a) {
        return arregloOrdenado(a, 0, a.length - 1);
    }

    private static boolean arregloOrdenado(int[] a, int ini, int fin) {
        boolean aux;

        if (ini < fin) {
            if (a[ini] > a[ini + 1]) {
                aux = false;
            } else {
                aux = arregloOrdenado(a, ini + 1, fin);
            }
        } else {
            aux = true;
        }

        return aux;
    }

    public static boolean digitoEnArreglo(int[] a, int n) {

        return digitoEnArreglo(a, n, 0, a.length - 1);
    }

    private static boolean digitoEnArreglo(int[] a, int n, int ini, int fin) {
        boolean aux;

        if (ini <= fin) {
            if (a[ini] == n) {
                aux = true;
            } else {
                aux = digitoEnArreglo(a, n, ini + 1, fin);
            }
        } else {
            aux = false;
        }

        return aux;

    }

    public static int secuenciaMultiploDe4() {
        System.out.print("Ingreso: ");
        return secuenciaMultiploDe4(TecladoIn.readLineInt());
    }

    private static int secuenciaMultiploDe4(int num) {
        int aux = 0;
        if (num != 0) {
            if (num % 4 == 0) {
                aux = 1;
            }
            System.out.print("Ingreso: ");
            aux += secuenciaMultiploDe4(TecladoIn.readLineInt());

        } else {
            aux = 0;
        }
        return aux;
    }

    public static int secuenciaIngresoMayor() {
        System.out.print("Ingreso: ");
        return secuenciaIngresoMayor(TecladoIn.readLineInt());
    }

    private static int secuenciaIngresoMayor(int max) {
        int aux;
        System.out.print("Ingreso: ");
        aux = TecladoIn.readLineInt();

        if (aux != 0) {
            if (aux > max) {
                max = aux;
            }
            max = secuenciaIngresoMayor(max);

        }

        return max;
    }

    public static int secuenciaCantidadDeUnCaracter(char n) {
        char aux;
        int cant = 0;

        System.out.print("Ingreso: ");
        aux = TecladoIn.readLineNonwhiteChar();

        if(aux != '.'){
            if(aux == n){
                cant = 1 + secuenciaCantidadDeUnCaracter(n);
            }else{
                cant = secuenciaCantidadDeUnCaracter(n);
            }
        }
        
        return cant;
    }

    public static void secuenciaInversoCaracteres(char n) {
        char aux;

        System.out.print("Ingreso: ");
        aux = TecladoIn.readLineNonwhiteChar();

        if (aux != '.') {
            secuenciaInversoCaracteres(n);

        }
        if(aux != n){
           System.out.println(aux); 
        }
        
    }

    public static int sumaRaraRecursiva(int n) {
        int aux;
        if (n == 0) {
            aux = 0;
        } else {
            aux = n + sumaRaraRecursiva(n - 1);
        }
        return aux;
    }

    public static int sumaRaraIterativa(int n) {
        int i, aux = 0;
        for (i = 0; i <= n; i++) {
            aux += i;
        }
        return aux;
    }

    public static int sumaRecursiva(int n) {
        int aux;
        if (n == 1) {
            aux = 1;
        } else {
            aux = sumaRecursiva(n - 1) + 1;
        }
        return aux;
    }

    public static int sumaIterativa(int n) {
        int i, aux = 0;
        for (i = 0; i < n; i++) {
            aux += 1;
        }
        return aux;
    }

    public static void aaaa(int a) {
        if (a != 0) {
            aaaa(a - 1);
            System.out.println("pasada" + a);

        }

    }
}
