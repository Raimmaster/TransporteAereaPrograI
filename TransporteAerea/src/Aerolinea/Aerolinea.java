package Aerolinea;

import java.util.Scanner;

public class Aerolinea {
    //CONSTANTES
    private int CANT_MAXIMA_RUTAS;
    private static final int CANT_USERS = 10;
    //OBJETOS
    private Usuario [] users = new Usuario[CANT_USERS];
    private Ruta [] rutas;
    //OTRAS VARIABLES
    private String [][] listadoAsientos;
    private static Scanner lea = new Scanner(System.in);

    /**
     * Constructor de Aerolinea
     * @param cantRutas Cantidad máxima de rutas que tendrá la aerolinea
     */
    public Aerolinea(int cantRutas){
        CANT_MAXIMA_RUTAS = cantRutas;
        rutas = new Ruta[CANT_MAXIMA_RUTAS];
        listadoAsientos = new String[CANT_MAXIMA_RUTAS][];
        users[0] = new Usuario("admin", "admin", "admin", "ADMIN");        
    }

    /**
     * Función para encontrar la próxima posición disponible
     * en el arreglo de rutas
     * @return Regresa la posición i del arreglo o -1 si el 
     * arreglo ya está lleno
     */
    public int nextRutaPos(){
        for (int i = 0; i < CANT_MAXIMA_RUTAS; i++){
            if (rutas[i] == null)
                return i;
        }

        return -1;
    }
    
    /**
     * Funcion para buscar si la ruta ya existe
     * @param nVuelo Numero de vuelo que se desea buscar
     * @return Regresa el objeto Ruta encontrado si existe o null si no existe.
     */
    public Ruta buscarRuta(int nVuelo){        
        for (Ruta route : rutas){
            if (route != null && route.getNumVuelo() == nVuelo){
                System.out.printf("Ruta con el numero %d existe.\n", route.getNumVuelo());
                return route;            
            }
        }
        System.out.printf("Ruta con el numero %d no existe\n", nVuelo);
        return null;
    }    

    /**
     * Funcion para autenticar el usuario
     * @param us Username que se autenticara
     * @param pass Password que se autenticara
     * @return Usuario con las credenciales correctas
     */
    public Usuario autenticarUsuario(String us, String pass){
        for (Usuario usuario : users){
            if (usuario != null && usuario.getUsername().equals(us) && usuario.getPassword().equals(pass))
                return usuario;
        }

        return null;
    }

    /**
     * Funcion login para poder acceder al menu
     * @return Usuario el usuario del login
     */
    public Usuario login(){
        Usuario userActual;
        do{
            System.out.print("\n\n\t***LOGIN***\nIngrese su username: ");
            String us = lea.next();
            System.out.print("Ingrese su password: ");
            String pass = lea.next();

            userActual = autenticarUsuario(us, pass);
            if (userActual != null)            
                return userActual;  
        
            System.out.println("LOGIN INVALIDO! INGRESE SUS DATOS DE NUEVO.");
        }while (userActual == null);

        return null;
    }

    /**
     * Función para encontrar la próxima posición en el arreglo de usuario.
     * @return La posición i en el arreglo de usuarios
     */
    public int nextUserPos(){
        for (int i = 0; i < CANT_USERS; i++){
            if (users[i] == null)
                return i;
        }
        return -1;
    }
    
    /**
     * Funcion para crear una ruta.
     */
    public void createRuta(){
        int esp = nextRutaPos();        
        if (esp == -1){
            System.out.println("Las rutas totales han sido llenadas; ya no hay espacio.");
            return;
        }
        int n = 0;
        do{
            System.out.print("\nIngrese el numero de vuelo: ");
            n = lea.nextInt();
        }while(buscarRuta(n) != null);
        
        System.out.print("\nIngrese la ciudad de destino: ");
        String c = lea.next();
        System.out.print("Ingrese la cantidad maxima de asientos que posee el vuelo: ");
        int max = lea.nextInt();
        listadoAsientos[esp] = new String[max];//asignar la cantidad maxima de asientos a la fila/vuelo
        System.out.print("Ingrese el limite de asientos de primera clase: ");
        int pClas = lea.nextInt();
        System.out.print("Ingrese el precio de los asientos de primera clase: ");
        double precP = lea.nextDouble();
        System.out.print("Ingrese el precio de los asientos de clase economica: ");
        double precE = lea.nextDouble();
        System.out.print("Ingrese el costo que conlleva despachar esta ruta: ");
        double cost = lea.nextDouble();
        
        rutas[esp] = new Ruta(n, c, max, pClas, precP, precE, cost, esp);  
        
    }
    
    /**
     * Encuentra la cantidad de asientos disponibles en el vuelo
     * @param pos La posicion del vuelo en el arreglo.
     * @return La cantidad de asientos disponibles en el vuelo.
     */
    public int asientosDisponibles(int pos){       
        int disponibles = 0;
              
        for (int i = 0; i < listadoAsientos[pos].length; i++){
            if(listadoAsientos[pos][i] == null)
                disponibles++;
        }
        
        return disponibles;
    }
    
    /**
     * Función que comprueba si el asiento a comprar está vacío.
     * @param f La posicion de la ruta en el arreglo.
     * @param c La posicion del asiento a comprarse
     * @return Regresa true si el asiento está vacío y false si está lleno o 
     * hubo un ingreso inválido.
     */
    public boolean comprobarAsiento(int f, int c){
        if (c <= 0){
            System.out.printf("Error. Ingrese un numero entre 1 y %d.\n", 
                    listadoAsientos[f].length);
            return false;
        }
        if (listadoAsientos[f][c - 1] == null)
            return true;       
        
        System.out.println("El asiento ya esta ocupado.");
        return false;
    }
    
    /**
     * Función que hace todos los procesos
     * necesarios para vender un ticket.
     */
    public void venderTicket(){
        System.out.print("\nIngrese el numero de vuelo: ");        
        int n = lea.nextInt();        
        Ruta rut = buscarRuta(n);
        if (rut == null)
            return;            
        
        System.out.println("Destino: " + rut.getCiudadDestino());
        int rutPos = rut.getPosicion();
        int disp = asientosDisponibles(rutPos);
        if (disp == 0)
        {
            System.out.println("\nNO HAY BOLETOS, AVION LISTO PARA DESPACHAR.\n");
            return;
        }
        System.out.printf("Cantidad de asientos disponibles: %d\n", disp);  
        
        String id = rut.createPasajero();
        elegirAsiento(rut, id);                
    }
    
    /**
     * Cancela el ticket del pasajero basandose en la función adyacente
     * eliminarPasajeroById(id).
     */
    public void cancelarTicket(){
        System.out.print("\nIngrese el numero de vuelo: ");        
        int n = lea.nextInt();        
        Ruta rut = buscarRuta(n);
        if (rut == null)
            return;            
        System.out.print("Ingrese Identidad del pasajero: ");
        String id = lea.next();
        System.out.print("Ingrese numero de Asiento del pasajero: ");
        int asiento = lea.nextInt();
        if (listadoAsientos[rut.getPosicion()][asiento-1].equals(id)){
            listadoAsientos[rut.getPosicion()][asiento-1] = null;
            rut.eliminarPasajeroById(id);
            System.out.print("Ticket Cancelado");
        }
    }
    
    /**
     * Función para elegir el asiento del pasajero
     * @param rut El objeto Ruta 
     * @param id El número de identidad (String) del pasajero
     */
    public void elegirAsiento(Ruta rut, String id){
        boolean comp = false;
        int seat = 0, rutPos = rut.getPosicion();
        
        do{
            System.out.printf("Ingrese un numero entre 1 y %d del asiento que desea comprar: ", 
                    listadoAsientos[rutPos].length);
            seat = lea.nextInt();
            if (seat == -1){
                System.out.println("CANCELANDO...");
                break;
            }                
            comp = comprobarAsiento(rutPos, seat);
        }while(!comp);
        
        setListadoAsientos(rutPos, seat, id);
        rut.boletoPasajero(id, seat);
    }    
    
    /**
     * Ingresa la identidad del pasajero en el asiento.
     * @param v Número del vuelo
     * @param p Número del asiento
     * @param i Número de identidad
     */
    public void setListadoAsientos(int v, int p, String i){
        listadoAsientos[v][p - 1] = i;
    }    

    /**
     * Función para despachar el vuelo. Se ingresa el número de vuelo
     * y luego hace uso de las funciones adyacentes, incluyendo la de borrar pasajeros
     * (función de la clase Ruta).
     */
    public void despacharVuelo() {
        System.out.print("Ingrese el numero de vuelo: ");
        int n = lea.nextInt();
        
        Ruta rut = buscarRuta(n);
        if (rut == null)
            return;
        
        printDespacho(rut);
        rut.borrarPasajeros();
        rut.resetStats();
        limpiarAsientos(rut.getPosicion());
    }
    
    /**
     * Reset para que todos los asientos del vuelo
     * a despachar vuelvan a null
     * @param vuelo El vuelo que se limpiará
     */
    public void limpiarAsientos(int vuelo){
        for (int i = 0; i < listadoAsientos[vuelo].length; i++){
            listadoAsientos[vuelo][i] = null;
        }
    }
    
    /**
     * Imprime todos los datos de despacho de la ruta
     * A la vez calcula las ganancias y costos
     * @param rut Ruta a despachar
     */
    public void printDespacho(Ruta rut){
        double totalBoletos = rut.calcularTotalBoletos();
        System.out.printf("\nDespachando la ruta %d hacia %s\n" +
                "Cantidad de asientos comprados: %d\n" + 
                "Cantidad de primera clase: %d\n" +
                "Cantidad de clase economica: %d\n" +
                "Monto total generado: %.2f\n", rut.getNumVuelo(), rut.getCiudadDestino(),
                rut.getTotalVendidos(), rut.getPrimerVendidos(), rut.getEcoVendidos(), totalBoletos);
        rut.calcularGanancia(totalBoletos);
        Ruta.setCostoTotal(rut.getCostoDespacho());
    }

    public void statsGenerales() {
        System.out.printf("Cantidad de rutas creadas: %d\nCantidad de boletos históricos vendidos: %d" + 
                "Monto historico generado: %.2f\nCosto historico incurrido: %.2f\nRuta MAS rentable: %d",
                Ruta.getRutasCreadas());
    }
    
    /**
     * Imprime todos los pasajeros de una ruta.
     */
    public void printListadoPasajeros(){
        System.out.print("Ingrese el numero de vuelo: ");
        int n = lea.nextInt();
        
        Ruta rut = buscarRuta(n);
        if (rut == null)
            return;
        
        rut.printPasajeros();
        System.out.println("El total de pasajeros en la ruta es de: " + rut.getTotalVendidos());
    }
    
    /**
     * Imprime las estadísticas generales de una ruta
     */
    public void printStatsRuta(){
        System.out.print("Ingrese el numero de vuelo: ");
        int n = lea.nextInt();
        
        Ruta rut = buscarRuta(n);
        if (rut == null)
            return;
        
        rut.printDatosRuta();
        System.out.printf("\nCantidad de boletos vendido historicamente en la ruta: %d\n" + 
                "Monto total de ingresos obtenidos: %.2f\nCosto incurrido historicamente en la ruta: %.2f\n" 
                ,Ruta.getTotalVendidosTotal(), Ruta.getMontoTotal(), Ruta.getCostoTotal());
        Ruta.calcularGananciaOrPerdidaTotal();
    }
}
