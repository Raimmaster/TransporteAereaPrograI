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
    
    public void calcularTotal(double s, double p1, double p2){
        subtotal = s;
        if (edad>65)
            descuento = subtotal * 0.35;
        impuesto = (p1+p2)* 0.05;
        total = subtotal - descuento + impuesto;
    }
    
    public double getSubtotal(){
        return subtotal;
    }
    
    public double getTotal(){
        return total;
    }
    
    public double getImpuesto(){
        return impuesto;
    }
    
    public double getDescuento(){
        return descuento;
    }
    
    public int getId(){
        return id;
    }
}

