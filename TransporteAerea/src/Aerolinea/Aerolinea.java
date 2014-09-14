package Aerolinea;

import java.util.Scanner;

public class Aerolinea {
    int max;
    Ruta rutas[];
    public Aerolinea(){
        Scanner rd = new Scanner(System.in);
        System.out.print("Ingrese cantidad maxima de rutas de la Aerolinea: "); 
        max = rd.nextInt();
        rutas = new Ruta[max];
        boolean state=false; //variable para el estado del login
        int resp;
        do{
            do{
            //login
                state=true;
            }while(state==false);
            do{
                //MENU PRINCIPAL
                System.out.print("MENU PRINCIPAL:\n"
                        + "\t 1 - CREAR UNA RUTA \n"
                        + "\t 2 - BOLETERIA \n"
                        + "\t 3 - DESPACHAR VUELO \n"
                        + "\t 4 - REPORTES \n"
                        + "\t 5 - USUARIOS \n"
                        + "\t 6 - CERRAR SESION \n"
                        + "\t 7 - CERRAR PROGRAMA \n"
                        + "Seleccione opcion: "); resp=rd.nextInt();
                switch(resp){
                    case 1:
                        int vacia = rutaVacia();
                        if(vacia>=0){
                            rutas[vacia] = new Ruta(vacia);
                        }
                        System.out.print("\n\n");
                        break;
                    case 2:
                        int num;
                        System.out.print("Ingrese numero de vuelo: "); num = rd.nextInt();
                        if (rutaDisponible(num))
                            rutas[rutas[num].getNumeroVuelo()].addPasajeroToRuta();
                        System.out.println("");
                        break;
                    case 3:
                        
                        break;
                    case 4:
                        
                        break;
                    case 5:
                        
                        break;
                    case 6:
                        System.out.print("\t--Cerrando Sesion..!!");
                        break;
                    case 7:
                        System.out.print("\t--Saliendo del Programa...!!");
                        break;
                    default:
                        System.out.print("Ingrese una opcion valida");
                }
            }while(resp!=6 && resp!=7);
            if(resp==7)
                break;
        }while(state==false);
        
        
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
    
    /**
     * 
     * @param x Especifica la posicion del arreglo para verificar si existe
     * @return Retorna true si existe la ruta o false en caso contrario
     */
    public boolean rutaDisponible(int x){
        if (rutas[x]!=null){
                System.out.printf("\tRuta: %d\n\tDestino: %s\n", rutas[x].getNumeroVuelo(), rutas[x].getDestino());
                return true;
        }
        System.out.print("No existe dicha ruta\n\n");
        return false;
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
