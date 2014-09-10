/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Aerolinea;

import java.util.Scanner;

/**
 *
 * @author KELVIN
 */
public class Pruebas {
    public static void main(String[] args){
        Scanner rd = new Scanner(System.in);
        System.out.print("Ingrese cantidad maxima de rutas de la Aerolinea: "); int max = rd.nextInt();
        Ruta rutas[][] = new Ruta[max][];
        rutas[0] = new Ruta[5];
        Ruta hola = new Ruta();
    }
}
