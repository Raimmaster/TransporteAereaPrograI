package Aerolinea;

import java.util.Scanner;

public class Ruta {
    private int numVuelo, posicion;
    private String ciudadDestino;
    private int cantAsientos, cantPrimeraClase;
    private double precioPrimeraClase, precioClaseEconomica;
    private double costoDespacho;
    private static int RUTAS_CREADAS;
    private Pasajero [] personas;
    
    private static Scanner lea = new Scanner(System.in);
    
    /**
     * Constructor de rutas
     * @param num Número de vuelo de la ruta
     * @param ciudad Ciudad de destino de la ruta
     * @param asientos Cantidad de asientos de la ruta
     * @param primera Cantidad de asientos de primera clase
     * @param precP Precio de asientos de primera clase
     * @param precE Precio de asientos de clase económica
     * @param costo Costo de despachar el vuelo
     * @param pos Posición de la ruta en el arreglo de rutas
     */
    public Ruta(int num, String ciudad, int asientos, 
        int primera,  double precP, double precE, double costo, int pos){
        numVuelo = num;
        ciudadDestino = ciudad;
        cantAsientos = asientos;
        cantPrimeraClase = primera;
        precioPrimeraClase = precP;
        precioClaseEconomica = precE;
        costoDespacho = costo;
        posicion = pos;
        RUTAS_CREADAS++;

        personas = new Pasajero[asientos];
        System.out.println("\nRUTA CREADA!");

    } 

    public int getNumVuelo(){
        return numVuelo;
    }

    public String getCiudadDestino(){
        return ciudadDestino;
    }

    public int getCantAsientos(){
        return cantAsientos;
    }

    public int getCantPrimeraClase(){
        return cantPrimeraClase;
    }

    public double getPrecioPrimeraClase(){
        return precioPrimeraClase;
    }

    public double getPrecioClaseEconomica(){
        return precioClaseEconomica;
    }

    public double getCostoDespacho(){
        return costoDespacho;
    }
    
    public int getPosicion(){
        return posicion;
    }

    /**
     * Imprime la información detallada de la ruta.
     */
    public void print(){
        System.out.printf("Numero de Vuelo: %d - Ciudad de destino: %s - Cantidad de asientos: %d " + 
            "\nCantidad de asientos de primera clase: %d - Precio Asiento de Primera Clase: %d - "+
            "\nPrecio Asiento de Clase Economica: % d - Costo de Despacho del Vuelo: % d", numVuelo, ciudadDestino,
            cantAsientos, cantPrimeraClase, precioPrimeraClase, precioClaseEconomica, costoDespacho);
    }
    
    public double calcularPrecioAsiento(int asiento){
        if (asiento > 0 && asiento <= getCantPrimeraClase()){
            return getPrecioPrimeraClase();
        }
        return getPrecioClaseEconomica();
    }
   
    /**
     * Función para buscar la próxima posición en
     * el arreglo de Pasajeros
     * @return La posicion i del arreglo de pasajeros.
     */
    public int nextPasaPos(){
        for(int i = 0; i < cantAsientos; i++){
            if (personas[i] == null)
                return i;
        }
        return -1;
    }
    
    /**
     * Crea el nuevo pasajero de la ruta.
     * @return La identidad del pasajero
     */
    public String createPasajero(){
        int esp = nextPasaPos();
        
        if (esp == -1)
            return null;
        
        System.out.print("Ingrese su numero de identidad: ");
        String ident = lea.next();
        System.out.print("Ingrese su primer nombre: ");
        String nomb = lea.next();
        System.out.print("Ingrese su apellido: ");
        nomb += " " + lea.next();
        System.out.print("Ingrese su edad: ");
        int ed = lea.nextInt();
        System.out.print("Ingrese su genero: ");
        String gen = lea.next();
        
        personas[esp] = new Pasajero(ident, numVuelo, ed, nomb, gen);
        
        //double sub = calcularPrecioAsiento(asiento);
        //personas[esp].setTotales(sub, getPrecioClaseEconomica(), getPrecioPrimeraClase());
        
        return ident;
    } 
         
    /**
     * Busca si el pasajero existe en la ruta a base de su identidad
     * @param id El número de identidad del pasajero a buscar.
     * @return El objeto Pasajero encontrado; null si no existe.
     */
    public Pasajero buscarPasajero(String id){
        for (Pasajero pas : personas){
            if (pas != null && pas.getId().equals(id)){
                System.out.printf("El pasajero ha sido creado.\n");
                return pas;            
            }
        }
        System.out.printf("El pasajero no existe.");
        return null;
    }    
    
    public void boletoPasajero(String id, int seat){
        Pasajero pasa = buscarPasajero(id);
        double subTotal = calcularPrecioAsiento(seat);
        pasa.setTotales(subTotal, getPrecioClaseEconomica(), getPrecioPrimeraClase());
        pasa.printBoleto();
    }
    
    public void borrarPasajeros(){
        for (Pasajero p : personas){
            p = null;
        }
    }
    
    public static int getRutasCreadas(){
        return RUTAS_CREADAS;
    }
    
}
