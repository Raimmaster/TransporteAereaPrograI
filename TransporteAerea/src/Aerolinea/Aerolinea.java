package Aerolinea;

import java.util.Scanner;

public class Aerolinea {
    int max, resp;
    Ruta rutas[];
    String asientos[][];
    Scanner rd = new Scanner(System.in);
    
    public Aerolinea(){
        System.out.print("Ingrese cantidad maxima de rutas de la Aerolinea: "); 
        max = rd.nextInt();
        rutas = new Ruta[max];
        asientos = new String[max][];
    }
    
    public void crearRuta(){
        int vacia = rutaVacia();
            if(vacia>=0){
                rutas[vacia] = new Ruta(vacia);
                asientos[vacia] = new String[rutas[vacia].getMaxiAsientos()];
            }
        System.out.print("\n\n");
    }
    
    public void venderTicket(){
        int num;
        System.out.print("Ingrese numero de vuelo: "); num = rd.nextInt();
        if (getFilaById(num)!=-1 && rutaDisponibleByFila(getFilaById(num))==true){
            if (rutas[getFilaById(num)].addPasajeroToRuta()==true){
                asientos[getFilaById(num)][Ruta.getAsientoCreado()] = Ruta.getIdCreado();
            }
        }else
            System.out.print("Numero de vuelo no existe\n");
        System.out.println("");
    }
    
    public void cancelarTicket(){
        int num;
        System.out.print("Ingrese numero de vuelo: "); num = rd.nextInt();
        if (getFilaById(num)!=-1 && rutaDisponibleByFila(getFilaById(num))==true)
            rutas[getFilaById(num)].deletePasajero();
        else
            System.out.print("Numero de vuelo no existe\n");
        System.out.println("");
    }
    
    
    /**
     * Funcion para ver si hay espacios para crear rutas
     * @return Retorna la posicion del arreglo donde hay espacio para crear ruta
     */
    private int rutaVacia(){
        //System.out.print("Entro en rutavacia");
        for (int i = 0; i < max; i++) {
            if (rutas[i]==null){
                return i;
            }
        }
        System.out.print("No hay rutas vacias");
        return -1;
    }
    
    private boolean rutasCreadas(){
        for (int i = 0; i < max; i++) {
            if (rutas[i]!=null){
                return true;
            }
        }
        return false;
    }
    
    /**
     * 
     * @param x Especifica la posicion del arreglo para verificar si existe
     * @return Retorna true si existe la ruta o false en caso contrario
     */
    private boolean rutaDisponibleByFila(int x){
        if (rutas[x]!=null){
                System.out.printf("\tRuta: %d\n\tDestino: %s\n", rutas[x].getNumeroVuelo(), rutas[x].getDestino());
                return true;
        }
        System.out.print("No existe dicha ruta\n\n");
        return false;
    }
    
    private int getFilaById(int x){
        for (int i = 0; i < max; i++) {
            if (rutas[i]!=null && rutas[i].getId()==x){
                return rutas[i].getFila();
            }
        }
        return -1;
    }
    
    /**
     * Funcion para devolver la ruta que mas ganancias percibio
     * @return Retorna el objeto Ruta que percibio mas ganancias
     */
    private Ruta rentable(){
        Ruta rent = null;
        double gan = 0;
        for (int i = 0; i < max; i++) {
            if (rutas[i]!=null &&rutas[i].getGanancias()>gan){
                gan = rutas[i].getGanancias();
                rent = rutas[i];
            }
        }
        if (rent==null)
            return null;
        return rent;
    }
}
