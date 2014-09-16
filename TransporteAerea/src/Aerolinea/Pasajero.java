package Aerolinea;

public class Pasajero {
    private static int vendidos;
    private int edad, vuelo;
    private double subtotal, descuento, impuesto, total;
    private String nombre, id;
    private char genero;
    
    public Pasajero(String i, String n, int e, char g, int v){
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
    
    public String getId(){
        return id;
    }
    
    public void printTotales(){
        System.out.printf("Subtotal: %f%nImpuesto: %f%nDescuento%d%nTotal a Pagar: %f%n",
                            subtotal, impuesto, descuento, total);
                    
    }
}

