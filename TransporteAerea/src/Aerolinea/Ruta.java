package Aerolinea;

import java.util.Scanner;

public class Ruta {
    private int numVuelo, posicion;
    private String ciudadDestino;
    private int cantAsientos, cantPrimeraClase, pasajerosRuta, ecoVendidos, primerVendidos, totalVendidosRuta;
    private double precioPrimeraClase, precioClaseEconomica;
    private double costoDespacho, gananciaOrPerdida;
    private static int RUTAS_CREADAS = 0, ECO_VENDIDOS_TOTAL = 0, PRIMER_VENDIDOS_TOTAL = 0;//variables static de boletos y rutas
    private static double MONTO_HISTORICO = 0, COSTO_HISTORICO = 0;
    private double montoTotal = 0, costoTotal = 0, gananciaOrPerdidaTotal = 0;//variables static de totales
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
        pasajerosRuta = 0;
        totalVendidosRuta = 0;
        RUTAS_CREADAS++;

        personas = new Pasajero[asientos];
        System.out.println("\nRUTA CREADA!");

    } 
    
    /**
     * Imprime los datos del vuelo. Son los mismos ingresados al crear la ruta.
     */
    public void printDatosRuta(){
        System.out.printf("\nNumero de vuelo: %d - Ciudad de Destino: %s\n" +
                "Cantidad de asientos totales: %d - Cantidad de asientos de primera clase: %d\n" + 
                "Precio de asientos de primera clase: %.2f - Precio de asientos de clase economica: %.2f\n" + 
                "Costo de despacho del vuelo: %.2f", getNumVuelo(), getCiudadDestino(), getCantAsientos(),
                getCantPrimeraClase(), getPrecioPrimeraClase(), getPrecioClaseEconomica(), getCostoDespacho());
    }
    
    public double getMontoTotal(){
        return montoTotal;
    }
    
    /**
     * Obtiene el costo histórico de la ruta
     * @return Valor de COSTO_TOTAL
     */
    public double getCostoTotal(){
        return costoTotal;
    }
    
    /**
     * Setea el costo histórico de despacho de la ruta
     * @param tot Valor de costo de despacho
     */
    public void setCostoTotal(double tot){
        costoTotal += tot;
        COSTO_HISTORICO += costoTotal;
    }
    
    public static double getMontoHistorico(){
        return MONTO_HISTORICO;
    }
    
    public static double getCostoHistorico(){
        return COSTO_HISTORICO;
    }
    
    public static int getVentaBoletosHistorico(){
        return ECO_VENDIDOS_TOTAL + PRIMER_VENDIDOS_TOTAL;
    }
    
    /**
     * Calcula y muestra la ganancia o pérdida total generada del vuelo
     */
    public void calcularGananciaOrPerdidaTotal(){                    
        gananciaOrPerdidaTotal = montoTotal - costoTotal;
        if (gananciaOrPerdidaTotal >= 0)
            System.out.println("La ganancia total generada es de: " + gananciaOrPerdidaTotal);
        else
            System.out.println("La perdida total generada es de: " + gananciaOrPerdidaTotal);        
    }
    
    public double getGananciaOrPerdidaTotal(){
        return gananciaOrPerdidaTotal;
    }
    
    public int getNumVuelo(){
        return numVuelo;
    }

    public String getCiudadDestino(){
        return ciudadDestino;
    }
    
    public int getPasajerosRuta(){
        return pasajerosRuta;
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
    
    /**
     * Calcula el precio del asiento dependiendo si es de primera clase o no.
     * También incrementa la cantidad de asientos vendidos por clase.
     * @param asiento Número del asiento
     * @return El precio.
     */
    public double calcularPrecioAsiento(int asiento){
        if (asiento > 0 && asiento <= getCantPrimeraClase()){
            PRIMER_VENDIDOS_TOTAL++;
            primerVendidos++;
            return getPrecioPrimeraClase();
        }                   
           
        ECO_VENDIDOS_TOTAL++;
        ecoVendidos++;
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
        pasajerosRuta++;
        //double sub = calcularPrecioAsiento(asiento);
        //personas[esp].setTotales(sub, getPrecioClaseEconomica(), getPrecioPrimeraClase());
        
        return ident;
    } 
    
    /**
     * Elimina el pasajero de determinado id
     * @param id La identidad del pasajero
     */
    public void eliminarPasajeroById(String id){
        for (int i = 0; i < personas.length; i++){
            if (personas[i] != null && personas[i].getId().equals(id)){
                personas[i] = null;
                pasajerosRuta--;
                break;
            }
        }
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
    
    /**
     * Busca el pasajero al cual imprimir su boleto
     * y setear sus totales y también el tipo de asiento del pasajero.
     * @param id Identidad del pasajero.
     * @param seat Asiento del pasajero.
     */
    public void boletoPasajero(String id, int seat){
        Pasajero pasa = buscarPasajero(id);
        double subTotal = calcularPrecioAsiento(seat);
        pasa.setTipoAsiento(determinarTipoAsiento(seat));
        pasa.setAsiento(seat);
        pasa.setTotales(subTotal, getPrecioClaseEconomica(), getPrecioPrimeraClase());
        pasa.printBoleto();
        totalVendidosRuta++;
    }
    
    /**
     * Determina el tipo de asiento del pasajero
     * @param seat El número de asiento del pasajero.
     * @return 
     */
    public String determinarTipoAsiento(int seat){
        if (seat > 0 && seat <= getCantPrimeraClase())
            return "Primera Clase";
           
        return "Clase economica";
    }
    
    /**
     * Borra todos los pasajeros de la ruta.
     */
    public void borrarPasajeros(){
        for (int i = 0; i < personas.length; i++){
            personas[i] = null;            
        }
    }
    
    /**
     * Calcula el monto total
     * generado en la ruta
     * @return El total generado.
     */
    public double calcularTotalBoletos(){
        double total = 0;
        for (Pasajero p : personas){
            if (p != null)
                total += p.getTotal();
        }
        montoTotal += total;
        MONTO_HISTORICO += total;
        return total;
    }
    
    /**
     * Calcula la ganancia o perdida de la ruta al 
     * momento de despachar
     * @param total La perdida o ganancia.
     */
    public void calcularGanancia(double total){               
        gananciaOrPerdida = total - costoDespacho;
        if (gananciaOrPerdida >= 0)
            System.out.println("La ganancia es: " + gananciaOrPerdida);        
        else
            System.out.println("La perdida es: " + gananciaOrPerdida);               
    }
    
    public double getGananciaOrPerdida(){
        return gananciaOrPerdida;
    }
    
    /**
     * Obtiene el total de rutas creadas.
     * @return La cantidad de rutas creadas en su totalidad.
     */
    public static int getRutasCreadas(){
        return RUTAS_CREADAS;
    }
    
    /**
     * Obtiene la cantidad de boletos económicos vendidos.
     * @return La cantidad de boletos de clase económica vendidos.
     */
    public static int getEcoVendidosTotal(){
        return ECO_VENDIDOS_TOTAL;
    }
    
    /**
     * Obtiene la cantidad de boletos de primera clase vendidos
     * @return Total de boletos de primera clase
     */
    public static int getPrimerVendidosTotal(){
        return PRIMER_VENDIDOS_TOTAL;
    }
    
    /**
     * Obtiene el total de boletos vendidos en la ruta
     * @return La suma de boletos económicos y de primera clase
     */
    public int getTotalVendidosRuta(){
        return totalVendidosRuta;
    }
    
    /**
     * Obtiene la cantidad de boletos de clase económica vendidos en la ruta
     * @return El total de boletos económicos vendidos
     */
    public int getEcoVendidos(){
        return ecoVendidos;
    }
    
    /**
     * Obtiene la cantidad de boletos de primera clase vendidos en la ruta
     * @return Total de boletos de primera clase
     */
    public int getPrimerVendidos(){
        return primerVendidos;
    }
    
    /**
     * Obtiene el total de boletos vendidos en la ruta
     * @return La suma de boletos económicos y de primera clase en la ruta
     */
    public int getTotalVendidos(){
        return ecoVendidos + primerVendidos;
    }
    
    /**
     * Imprime la información personal de todos los pasajeros de la ruta
     */
    public void printPasajeros(){
        for (Pasajero p : personas){
            if ( p != null)
                p.printInfo();
        }
    }
    
    /**
     * Resetea los valores contadores de cantidad de boletos 
     * vendidos y la ganancia o perdida.
     */
    public void resetStats() {        
        pasajerosRuta = 0;
        ecoVendidos = 0;
        primerVendidos = 0;
        gananciaOrPerdida = 0;
    }
    
}
