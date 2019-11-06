/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles;

/**
 *
 * @author cmierez
 */
public class Menu {

    private static String mostrarMenu(String[] opcion) {
        String menu;
        int i;
        menu = "-----------------------------------------\n- MENÚ\n-----------------------------------------\n";

        for ( i = 0; i < opcion.length; i++) {
            menu += (i + 1) + ". " + opcion[i] + "\n";
        }

        
        menu += (i+1) + ". Finalizar.\n";
        menu += "-----------------------------------------";

        return menu;
    }

    public static int opcionMenu(String[] opcion) {
        int eleccion;
        boolean valido;
        System.out.println(mostrarMenu(opcion));
        do {
            System.out.print("Opción: ");
            eleccion = TecladoIn.readLineInt();
            valido = eleccion > 0 && eleccion <= opcion.length+1;
            if (!valido) {
                System.out.println("Opción invalida.");
            }
        } while (!valido);
        
        return eleccion;
    }

}
