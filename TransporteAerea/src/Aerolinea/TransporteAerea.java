package Aerolinea;

import java.util.Scanner;

public class TransporteAerea {
   
   public static void main(String[] args) {
   	Scanner lea = new Scanner(System.in);
   	int res = 0, cant = 0;
   	Aerolinea aero;

   	do{
            System.out.print("Ingrese la cantidad MAXIMA de rutas que manejara la aerolinea: ");
            cant = lea.nextInt();
   	}while(cant <= 0);
	   	
	aero = new Aerolinea(cant);//CREACION DE LA AEROLINEA  	 
	
        do{//LOGIN	   		
            Usuario userAct = aero.login();
	    char op = 0;//variable de control de SUB-MENUS

            do{//MENU
                System.out.print("\n\t--***MENU***--\n1. Crear una ruta.\n2. Boleteria." +
                        "\n3. Despachar vuelo.\n4. Reportes.\n5. Usuarios.\n6. Cerrar sesion.\n7. Cerrar programa." +
                        "\nIngrese el numero de su seleccion: ");
                
               res = lea.nextInt();
               
                switch (res){	   				
                    case 1: 
                        if (!userAct.getTipoCuenta().equals("ADMIN"))
                            continue;
                        aero.createRuta();
                        break;	   
                        
                    case 2:	
                        System.out.print("\n\t***OPCIONES***\na. Vender ticket." +
                                "\nb. Cancelar ticket.\nc. Regresar al menú principal." +
                                "\nIngrese el caracter de su seleccion: ");
                        op = lea.next().charAt(0);
                        
                        switch (Character.toLowerCase(op)){//SUB-MENU BOLETERIA	   				
                            case 'a':                             
                                System.out.println("\n\t***VENDER TICKET***");        
                                aero.venderTicket();
                                break;	   				
                            case 'b':	   				
                                break;	   				
                            case 'c':	   				
                                break;	   				
                            default:
                                System.out.println("OPCION INCORRECTA! REGRESANDO AL MENU...");
                        }	   				
                        break;
                        
                    case 3:                                                
                        System.out.println("\n\t***DESPACHAR VUELO***"); 
                        aero.despacharVuelo();
                        break;	
                        
                    case 4:
                        System.out.print("\n\t***OPCIONES***\na. Estadisticas generales." +
                                "\nb. Estatidisticas por ruta.\nc. Listado de pasajeros." +
                                "\nd. Mis datos.\ne. Log.\nf. Regresar al menu principal." +
                                "\nIngrese el caracter de su seleccion: ");
                        op = lea.next().charAt(0);

                        switch (Character.toLowerCase(op)){//SUB-MENU REPORTES	   					
                            case 'a':	   					
                                break;	   					
                            case 'b':	   					
                                break;	   					
                            case 'c':	   					
                                break;	   					
                            case 'd':	   						
                                break;	   					
                            case 'e':	   					
                                break;	   					
                            case 'f':               
                                break;	   				
                            default:	   					
                        }                    	
                        break;	
                        
                    case 5:	 
                        System.out.print("\n\t***OPCIONES***\na. Editar mis datos." +
                                "\nb. Crear usuario.\nc. Regresar al menu principal." +
                                "\nIngrese el caracter de su seleccion: ");
                        op = lea.next().charAt(0);
                                                  
                        switch (Character.toLowerCase(op)){//SUB-MENU USUARIOS	   				
                            case 'a':	   				
                                break;	   					
                            case 'b':	   					
                                break;	   					
                            case 'c':	   					
                                break;	   					
                            default:	   					
                        }	   				
                        break;	
                        
                    case 6:
                        System.out.println("CERRANDO SESION...");
                        break;	  
                        
                    case 7:	   
                        System.out.println("SALIENDO DEL PROGRAMA...");
                        break;
                        
                    default:	   				
                        System.out.println("Opcion incorrecta; ingrese su opcion de nuevo.");	   			
                }   
                
            }while (res != 6 && res != 7);//repite mientras no se ingrese 6 o 7
            
        }while(res == 6);//si es 6, volver a login

   }
}
