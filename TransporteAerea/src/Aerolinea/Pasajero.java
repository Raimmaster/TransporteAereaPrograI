package Aerolinea;

public class Pasajero {
    private static int vendidos;
    private int edad, id, vuelo;
    private double subtotal, descuento, impuesto, total;
    private String nombre;
    private char genero;
    
    public Pasajero(int i, String n, int e, char g, int v){
        vendidos++;
        id = i;
        nombre = n;
        edad = e;
        genero = g;
        vuelo = v;
    }
    
    
    public boolean existeEnVuelo(int v){
        if (vuelo == v)
            return true;
        return false;
    }
    public void subtotal(double s){
        subtotal = s;
        if (edad>65)
            descuento = subtotal * 0.35;
        impuesto = subtotal * 0.15;
    }
}

