package Aerolinea;

public class Pasajero {
    private int edad, id, vuelo;
    private double subtotal, descuento, impuesto, total;
    private String nombre, genero;
    
    public Pasajero(){
        vuelo=0;
        edad =0;
        id = 0;
        nombre = null;
        genero = null;
    }
    public void add(int i, String n, int e, String g, int v){
        id = i;
        nombre = n;
        edad = e;
        genero = g;
        vuelo = v;
    }
    public void delete(int i, String n, int e, String g){
        vuelo = 0;
        edad =0;
        id = 0;
        nombre = null;
        genero = null;
    }
    public boolean existe(int v){
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

