package Aerolinea;

import java.util.Scanner;

public class Ruta {
    
    Scanner rd = new Scanner(System.in);
    private int maxi;
    private int id, clase1, llenos, fila;
    private String destino;
    private double precio1, precioe, costo;
    Pasajero pasajeros[][];
   
    /**
     * Constructor de Ruta
     * @param fila Fila del arreglo unidimensional de rutas donde se esta creando la ruta
     */
    public Ruta(int fila){
        this.fila = fila;
        System.out.print("Ingrese numero de Vuelo: "); id = rd.nextInt();
        System.out.print("Ingrese Destino: "); destino = rd.next();
        System.out.print("Ingrese Cantidad de Asientos: "); maxi = rd.nextInt();
        pasajeros[fila] = new Pasajero[maxi];
        System.out.print("Ingrese cantidad de asientos de primera clase: "); clase1 = rd.nextInt();
        System.out.print("Ingrese precio de asiento en primera clae: ");precio1 = rd.nextInt();
        System.out.print("Ingrese precio de asiento economico: ");precioe = rd.nextInt();
        System.out.print("Ingrese costo de despacho de avion: ");costo = rd.nextInt();
        System.out.print("<<----- RUTA CREADA ----->>");
    }
    
}

/* Codigos Eliminados
    public void add(int i, int c, int l, String d, int p, int cs){
        id = i;
        clase1 = c;
        llenos = 0;
        destino = d;
        precio = p;
        costo = cs;
    }

public boolean creada(int i){
        if (id==i)
            return true;
        return false;
    }
    public double getPrecio(){
        return precio;
    }
*/
