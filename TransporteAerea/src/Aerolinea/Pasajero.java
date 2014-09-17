package Aerolinea;

public class Pasajero {
    private int edad, vuelo, asiento;
    private String nombre, genero, id;    
    private double subtotal, descuento, impuesto, total;
    
    /**
     * Constructor de Pasajero
     * @param i Identidad del pasajero
     * @param v Número de vuelo del pasajero
     * @param e Edad del pasajero
     * @param a Número del asiento
     * @param nom Nombre completo del pasajero
     * @param gen Género del Pasajero
     */
    public Pasajero(String i, int v, int e, String nom, String gen){
        id = i;
        vuelo = v;
        edad = e;
        //asiento = a;
        nombre = nom;
        genero = gen;
        descuento = 0;
        impuesto = 0;
        total = 0;
        subtotal = 0;
    }

    public String getId(){
        return id;
    }
    
    public int getAsiento(){
        return asiento;
    }

    public boolean existe(int v){
        if (vuelo == v)
            return true;
        return false;
    }
    
    public double getSubtotal(){
        return subtotal;
    }
    
    public double getDescuento(){
        return descuento;
    }
    
    public double getImpuesto(){
        return impuesto;
    }
    
    public double getTotal(){
        return total;
    }
    
    public void setTotales(double sub, double pE, double pP){
        subtotal = sub;
        if (edad > 65)
            descuento = subtotal * 0.35;
        impuesto = (pE + pP) * 0.05;
        total = subtotal - descuento + impuesto;
    }
    
    public void printBoleto(){
        System.out.printf("\n\tFACTURACION\nSubtotal: %.2f \nDescuento: %.2f \nImpuesto: %.2f \nTotal: %.2f \n",
                getSubtotal(), getDescuento(), getImpuesto(), getTotal());
    }
}

