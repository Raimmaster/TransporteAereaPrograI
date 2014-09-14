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
                        break;
                    case 2:
                        
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
}
