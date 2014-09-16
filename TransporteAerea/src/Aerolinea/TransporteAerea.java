package Aerolinea;

import java.util.Scanner;

public class TransporteAerea {
   public static void main(String [] args){
       Aerolinea Taca = new Aerolinea();
       int resp;
       Scanner rd = new Scanner(System.in);
       boolean state=false;
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
                        Taca.crearRuta();
                        break;
                    case 2:
                        int res;
                        do{
                            System.out.print("--Menu de Boleteria--\n"
                        + "\t1 - Vender Boleto\n"
                        + "\t2 - Cancelar Ticket\n"
                        + "\t3 - Salir al Menu Principal\n"
                        + "\t Seleccione Opcion: ");res=rd.nextInt();
                        switch (res){
                            case 1:
                                Taca.venderTicket();
                                break;
                            case 2:
                                Taca.cancelarTicket();
                                break;
                            case 3:
                                System.out.println("Saliendo al Menu Principal");
                                break;
                            default:
                                System.out.println("Ingrese una opcion valida");
                        }
                        }while (res!=3);
                        
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
            }while(resp!=7);
            if(resp==7)
                break;
        }while(state==false);
   }
}
