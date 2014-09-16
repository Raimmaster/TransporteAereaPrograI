package Aerolinea;

import java.util.Scanner;

public class Ruta {
    private static Pasajero rentable;
    private static double ventas;
    private static double ganancias;
    Pasajero pasajeros[];
    Scanner rd = new Scanner(System.in);
    private int maxi;
    private int id, clase1, llenos, fila;
    private String destino;
    private double precio1, precioe, costo;
    
       
    /**
     * Constructor de Ruta
     * @param fila Fila del arreglo unidimensional de rutas donde se esta creando la ruta
     */
    public Ruta(int fila){
        this.fila = fila;
        System.out.print("Ingrese numero de Vuelo: "); id = rd.nextInt();
        System.out.print("Ingrese Destino: "); destino = rd.next();
        System.out.print("Ingrese Cantidad de Asientos: "); maxi = rd.nextInt();
        pasajeros = new Pasajero[maxi];
        System.out.print("Ingrese cantidad de asientos de primera clase: "); clase1 = rd.nextInt();
        System.out.print("Ingrese precio de asiento en primera clase: ");precio1 = rd.nextInt();
        System.out.print("Ingrese precio de asiento economico: ");precioe = rd.nextInt();
        System.out.print("Ingrese costo de despacho de avion: ");costo = rd.nextInt();
        System.out.print("<<----- RUTA CREADA ----->>");
    }

    Ruta(int vacia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Funcion para agregar nuevo pasajero a la ruta
     */
    public void addPasajeroToRuta(){
        String nombre;
        char genero;
        int edad, id, vuelo, numero;
        boolean state=false;
        
        System.out.print("Ingrese numero de identidad: "); id = rd.nextInt();
        System.out.print("ingrese Nombre Completo: "); nombre = rd.next();
        System.out.print("Ingrese edad: "); edad = rd.nextInt();
        System.out.print("Ingrese genero: "); genero = rd.next().charAt(0);
        do{
            System.out.print("Ingrese Numero de Asiento: "); numero = rd.nextInt();
            if (numero <=getMaxAsientos() && numero!=0){
                if (pasajeros[numero-1]==null){
                    pasajeros[numero-1] = new Pasajero(id, nombre, edad, genero, fila);
                    if (numero>0 && numero<=clase1){
                        pasajeros[numero-1].calcularTotal(precio1, precio1, precioe);
                    }else{
                        pasajeros[numero-1].calcularTotal(precioe, precio1, precioe);
                    }
                    System.out.print("-->>Imprimiendo facturacion de boleto:\n");
                    System.out.printf("Subtotal: %f%nImpuesto: %f%nDescuento%d%nTotal a Pagar: %f%n",
                            pasajeros[numero-1].getSubtotal(), pasajeros[numero-1].getImpuesto(), 
                            pasajeros[numero-1].getDescuento(), pasajeros[numero-1].getTotal());
                    ventas+=pasajeros[numero-1].getTotal();
                    llenos++;
                    state = true;
                }else{
                    System.out.print("Asiento no disponible, Intentelo de Nuevo");
                }
            }else if(numero==-1){
                System.out.print("Accion Cancelada");
                break;
            }else
                System.out.print("Numero de Asiento no Existe, Intentelo de Nuevo");
        }while (state = false);
        System.out.print("<<----- PASAJERO CREADO ----->>");
    }
    
    public void deletePasajero(){
        int numero, id, cont=0;
        String conf;
        int state=0;
        System.out.print("Ingrese Numero de Identidad: "); id = rd.nextInt();
        System.out.print("Ingrese Numero de Asiento: "); numero = rd.nextInt();
        if (numero <=getMaxAsientos() && numero!=0){
            for(Pasajero p : pasajeros){
                if (p.getId()== id && cont==numero-1){
                    ventas-=p.getTotal();
                    System.out.print("Realmente desea eliminar su Ticket(si/no)?"); conf = rd.next();
                    if (conf.equalsIgnoreCase("si")){
                        p = null;
                        System.out.print("Pasajero Eliminado Correctamente");
                        state = 1;
                    }else
                        System.out.print("Accion Cancelada\n");
                    break;
                }else
                    state = 2;
                cont++;
            }
        }
        if (state==2)
            System.out.print("No existe Pasajero con dicho numero de identidad");
        
    }
    
    /**
     * Funcion para obtener la cantidad de asientos disponibles
     * @return Devuelve el numero de asientos vacios
     */
    public int cantAsientos(){
        int cant=0;
        for(Pasajero p : pasajeros){
            if (p==null)
                cant++;
        }
        if (cant>0)
            System.out.print("\tAsientos disponibles: "+cant);
        else
            System.out.print("\tNo hay asientos disponibles, Avion listo para despachar");
        return cant;
    }
    
    /**
     * Funcion para obtener el destino de la ruta en la que se encuentra
     * @return Devuelve el destino de la ruta.
     */
    public String getDestino(){
        return destino;
    }
    
    /**
     * Funcion para obtener el numero de vuelo de la ruta en que se encuentra
     * @return Devuelve el numero de vuelo que representa a la ruta
     */
    public int getNumeroVuelo(){
        return id;
    }
    
    /**
     * Funcion para obtener la cantidad maxima de asientos de la ruta
     * @return Devuelve la cantidad maxima de asientos que se pueden crear en la ruta
     */
    public int getMaxAsientos(){
        return maxi;
    }
    
    /**
     * Funcion para obtenes la cantidad de asientos de primera clase
     * @return Devuelve la cantidad de asientos de primera clase
     */
    public int getPrimeraClase(){
        return clase1;
    }
    
    /**
     * Funcion para obtener el precio del asiento tomando el cuenta la clase donde se encuentra el asiento
     * @param x Numero de asiento
     * @return Devuelve el precio del asiento
     */
    public double getPrecio(int x){
        if (x<=clase1)
            return precio1;
        return precioe;
    }
    
    /**
     * Funcion para validar que el asiento x exista en la ruta
     * @param x Numero de asiento a validar.
     * @return Devuelve true si el asiento existe o false caso contrario
     */
    public boolean validarNumeroAsientoExista(int x){
        if (x<=maxi)
            return true;
        return false;
    }
    
    /**
     * Funcion para validar que el asiento x esta vacio
     * @param x Numero de asiento a validar
     * @return Devuelve true si el asiento esta vacio o false en caso contrario
     */
    public boolean validarAsientoVacio(int x){
        if (pasajeros[x] == null)
            return true;
        return false;
    }
    
    /**
     * Funcion para devolver las ganancias de la ruta
     * @return Devuelve las ganancias percibidas
     */
    public double getGanancias(){
        return ganancias;
    }
    
    /**
     * Funcion para obtener el Numero de Vuelo
     * @return Devuelve el numero de vuelo
     */
    public int getId(){
        return id;
    }
    
    /**
     * Funcion para obtener la fila
     * @return Devuelve la fila
     */
    public int getFila(){
        return fila;
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
