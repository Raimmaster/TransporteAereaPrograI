package Aerolinea;

public class Ruta {
    private static int maxi;
    private int id, clase1, llenos;
    private String destino;
    private double precio, costo;
    
    public Ruta(){
        System.out.println("Entraste en el constructor Ruta");
    }
    
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
}
