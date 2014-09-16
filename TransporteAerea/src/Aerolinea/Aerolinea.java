package Aerolinea;

import java.util.Scanner;

public class Aerolinea {
    Usuario [] user;
    
    private static final int CANT_USER = 10;
    int max, resp;
    Ruta rutas[];
    Scanner rd = new Scanner(System.in);
    public Aerolinea(){
        user = new Usuario[CANT_USER];
        System.out.print("Ingrese cantidad maxima de rutas de la Aerolinea: "); 
        max = rd.nextInt();
        rutas = new Ruta[max];
    }
    
    public int usuarioVacio(){
        for (int i = 0; i < 10; i++){
                if(user[i] == null)
                    return  i;
        }
        System.out.println("No hay Usuario");
        return -1;
    }
    
    public boolean validarNombreUsuario(String n){
        
        for (Usuario us : user){  
           if(us != null && us.getUserName().equalsIgnoreCase(n)){
               return true;
           }
           
    }
        return false;
    }
        
    
    public void crearRuta(){
        int vacia = rutaVacia();
            if(vacia>=0){
                rutas[vacia] = new Ruta(vacia);
            }
        System.out.print("\n\n");
    }
    
    public void boleteria(){
        if (rutasCreadas()==true){
           do{
                System.out.print("--Menu de Boleteria--\n"
                        + "\t1 - Vender Boleto\n"
                        + "\t2 - Cancelar Ticket\n"
                        + "\t3 - Salir al Menu Principal\n"
                        + "\t Seleccione Opcion: ");resp=rd.nextInt();
                if (resp==1){
                    int num;
                    System.out.print("Ingrese numero de vuelo: "); num = rd.nextInt();
                    if (getFilaById(num)!=-1 && rutaDisponibleByFila(getFilaById(num))==true)
                        rutas[getFilaById(num)].addPasajeroToRuta();
                    else
                        System.out.print("Numero de vuelo no existe\n");
                    System.out.println("");
                }else if(resp==2){
                    int num;
                    System.out.print("Ingrese numero de vuelo: "); num = rd.nextInt();
                    if (getFilaById(num)!=-1 && rutaDisponibleByFila(getFilaById(num))==true)
                        rutas[getFilaById(num)].deletePasajero();
                    else
                        System.out.print("Numero de vuelo no existe\n");
                    System.out.println("");
                }else if(resp==3){
                    System.out.print("Saliendo al menu principal");
                }else
                    System.out.print("Ingrese una opcion valida");
            }while(resp!=3);
        }else
            System.out.print("No hay rutas Creadas\n");
    }
    /**
     * Funcion para ver si hay espacios para crear rutas
     * @return Retorna la posicion del arreglo donde hay espacio para crear ruta
     */
    public int rutaVacia(){
        //System.out.print("Entro en rutavacia");
        for (int i = 0; i < max; i++) {
            if (rutas[i]==null){
                return i;
            }
        }
        System.out.print("No hay rutas vacias");
        return -1;
    }
    
    public boolean rutasCreadas(){
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
    public boolean rutaDisponibleByFila(int x){
        if (rutas[x]!=null){
                System.out.printf("\tRuta: %d\n\tDestino: %s\n", rutas[x].getNumeroVuelo(), rutas[x].getDestino());
                return true;
        }
        System.out.print("No existe dicha ruta\n\n");
        return false;
    }
    
    public int getFilaById(int x){
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
    public Ruta rentable(){
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
