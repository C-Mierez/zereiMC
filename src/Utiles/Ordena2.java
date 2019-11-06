/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles;

import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class Ordena2 {

//    public static int[] heapSort(int[] arr) {
//        int length = arr.length;
//        int[] sortedHeap,tempArr;
//        
//        if (length != 0) {
//            if (length != 1) {
//                tempArr = new int[length];
//                for(int i = 0; i < length-1; i++){
//                    if(i <= length/2){
//                        tempArr[i] = arr[i];
//                    }else{
//                        
//                    }
//                }
//            } else {
//
//            }
//        }
//        return sortedHeap;
//    }
    
    public static void radixSort( String [ ] arr, int maxLen )
    {
        final int BUCKETS = 256;

        ArrayList<String> [ ] wordsByLength = new ArrayList[ maxLen + 1 ];
        ArrayList<String> [ ] buckets = new ArrayList[ BUCKETS ];
        
        for( int i = 0; i < wordsByLength.length; i++ )
            wordsByLength[ i ] = new ArrayList<>( );
        
        for( int i = 0; i < BUCKETS; i++ )
            buckets[ i ] = new ArrayList<>( );
        
        for( String s : arr )
            wordsByLength[ s.length( ) ].add( s );
       
        int idx = 0;
        for( ArrayList<String> wordList : wordsByLength )
            for( String s : wordList )
                arr[ idx++ ] = s;
        
        int startingIndex = arr.length;    
        for( int pos = maxLen - 1; pos >= 0; pos-- )
        {
            startingIndex -= wordsByLength[ pos + 1 ].size( );
            
            for( int i = startingIndex; i < arr.length; i++ )
                buckets[ arr[ i ].charAt( pos ) ].add( arr[ i ] );
            
            idx = startingIndex;
            for( ArrayList<String> thisBucket : buckets )
            {
                for( String s : thisBucket )
                    arr[ idx++ ] = s;
                
                thisBucket.clear( );
            }
        }
    }
    
    

    public static void insercionCreciente(int[] a) {
        int i, x, aInsertar, tamaño = a.length;

        for (i = 1; i < tamaño; i++) {
            x = i;
            aInsertar = a[i];

            while (x > 0 && aInsertar < a[x - 1]) {

                a[x] = a[x - 1];

                x--;
            }

            a[x] = aInsertar;

        }
    }

    public static void mergeCreciente(int[] a) {
        int[] t = new int[a.length];
        mergeSort(a, t, 0, a.length - 1);
    }

    private static void mergeSort(int[] a, int[] t, int ini, int fin) {
        int centro;

        if (ini < fin) {
            centro = (ini + fin) / 2;
            mergeSort(a, t, ini, centro);
            mergeSort(a, t, centro + 1, fin);
            mergeMezcla(a, t, ini, centro, centro + 1, fin);
        }
    }
    
    public static void selectionSort( String[] array )
  {
    
    // Find the string reference that should go in each cell of
    // the array, from cell 0 to the end
    for ( int j=0; j < array.length-1; j++ )
    {
      // Find min: the index of the string reference that should go into cell j.
      // Look through the unsorted strings (those at j or higher) for the one that is first in lexicographic order
      int min = j;
      for ( int k=j+1; k < array.length; k++ )
        if ( array[k].compareTo( array[min] ) < 0 ) min = k;  

      // Swap the reference at j with the reference at min 
      String temp = array[j];
      array[j] = array[min];
      array[min] = temp;
    }
  
  }
   
    

    private static void mergeMezcla(int[] a, int[] t, int ini, int finIni, int iniDer, int fin) {
        int comienzo = ini;
        int posAux = ini, i;

        while (ini <= finIni && iniDer <= fin) {
            if (a[ini] < a[iniDer]) {
                t[posAux] = a[ini];
                ini++;
                posAux++;
            } else {
                t[posAux] = a[iniDer];
                iniDer++;
                posAux++;
            }
        }
        while (ini <= finIni) {
            t[posAux] = a[ini];
            ini++;
            posAux++;
        }

        while (iniDer <= fin) {
            t[posAux] = a[iniDer];
            iniDer++;
            posAux++;
        }

        for (i = fin; i >= comienzo; i--) {
            a[i] = t[i];
        }
    }

    public static void quickCreciente(int[] a) {

        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(int[] a, int ini, int fin) {
        int pivot, index;
        if (ini < fin) {
            pivot = (ini + fin) / 2;

            index = mezclarQuick(a, pivot, ini, fin);
            quickSort(a, ini, index - 1);
            quickSort(a, index + 1, fin);

        }

    }

    private static int mezclarQuick(int[] a, int pvt, int ini, int fin) {
        int aux;
        pvt = a[pvt];

        while (ini < fin) {

            while (a[ini] <= pvt) {
                ini++;
            }

            while (a[fin] > pvt) {
                fin--;
            }

            if (ini <= fin) {
                aux = a[fin];
                a[fin] = a[ini];
                a[ini] = aux;
                ini++;
                fin--;
            }
        }

        return ini;

    }

    public static boolean esCreciente(int[] a) {
        boolean esCreciente = true;
        int i = 0, limite = a.length - 1;
        while (esCreciente && i < limite) {
            if (a[i] > a[i + 1]) {
                esCreciente = false;
            }
            i++;
        }

        return esCreciente;
    }

    public static boolean esDecreciente(int[] a) {
        boolean esDecreciente = true;
        int i = 0, tamaño = a.length;
        while (esDecreciente && i < tamaño - 1) {
            if (a[i] < a[i + 1]) {
                esDecreciente = false;
            }
            i++;
        }

        return esDecreciente;
    }

    public static void seleccionCreciente(int[] a) {
        int i, x, tamaño = a.length, menor, temp;
        for (i = 0; i < tamaño - 1; i++) {
            menor = i;
            for (x = i + 1; x < tamaño; x++) {

                if (a[x] < a[menor]) {
                    menor = x;
                }
            }
            temp = a[i];
            a[i] = a[menor];
            a[menor] = temp;
        }
    }

    public static void seleccionDecreciente(int[] a) {
        int i, x, tamaño = a.length, menor, temp;
        for (i = tamaño - 1; i > 0; i--) {
            menor = i;
            for (x = i - 1; x >= 0; x--) {

                if (a[x] < a[menor]) {
                    menor = x;
                }
            }
            temp = a[i];
            a[i] = a[menor];
            a[menor] = temp;
        }
    }

    //Invertir
//    public static void burbujaCrecienteFor(int[] a) {
//        int i, x, tamaño = a.length, temp;
//
//        for (i = 0; i < tamaño; i++) {
//
//            for (x = 0; x < tamaño - 1 - i; x++) {
//
//                if (a[x] > a[x + 1]) {
//                    temp = a[x];
//                    a[x] = a[x + 1];
//                    a[x + 1] = temp;
//                }
//            }
//
//        }
//
//    }
    public static void burbujaCreciente(int[] a) {
        int i, x, tamaño = a.length, temp;
        boolean sinCambio = false;

        i = 0;
        while (!sinCambio && i < tamaño) {
            sinCambio = true;
            for (x = 0; x < tamaño - 1 - i; x++) {

                if (a[x] > a[x + 1]) {
                    temp = a[x];
                    a[x] = a[x + 1];
                    a[x + 1] = temp;
                    sinCambio = false;
                }

            }
            i++;
        }

    }

    public static void burbujaDecreciente(int[] a) {
        int i, x, tamaño = a.length, temp;
        boolean sinCambio = false;
        i = 0;
        while (!sinCambio && i < tamaño) {

            sinCambio = true;
            for (x = a.length - 1; x > 0 + i; x--) {

                if (a[x] > a[x - 1]) {
                    temp = a[x];
                    a[x] = a[x - 1];
                    a[x - 1] = temp;
                    sinCambio = false;
                }
            }
            i++;
        }

    }

    private static int[] union(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        int i;

        for (i = 0; i < a.length; i++) {
            c[i] = a[i];
        }

        for (i = 0; i < a.length; i++) {
            c[a.length + i] = a[i];
        }

        return c;
    }

    public static int[] unionCreciente(int[] a, int[] b) {
        //Une a y b en el array c
        int[] c;
        c = union(a, b);
        burbujaCreciente(c);

        return c;
    }

    public static int[] unionDecreciente(int[] a, int[] b) {
        //Une a y b en el array c
        int[] c;
        c = union(a, b);
        burbujaDecreciente(c);

        return c;
    }

    public static void invertirRecursivo(int[] a, int x) {
        int swap, b = 0 + x, c = a.length - 1 - x;
        if (c >= a.length / 2) {
            swap = a[c];
            a[c] = a[b];
            a[b] = swap;
            invertirRecursivo(a, x + 1);
        }

    }

    public static void invertirIterativo(int[] a) {
        int swap, limite = (a.length / 2), b, c;
        for (int i = 0; i < limite; i++) {
            b = 0 + i;
            c = a.length - 1 - i;
            swap = a[c];
            a[c] = a[b];
            a[b] = swap;
        }

    }

}
