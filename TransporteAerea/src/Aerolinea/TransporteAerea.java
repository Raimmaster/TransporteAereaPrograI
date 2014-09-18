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
                        aero.createRuta(); 
                    case 2:	
                        do{
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
                                    System.out.println("\n\t***CANCELAR TICKET***"); 
                                    aero.cancelarTicket();
                                    break;	   				
                                case 'c':
                                    System.out.println("\n\t***SALIENDO AL MENU PRINCIPAL***"); 
                                    break;	   				
                                default:
                                    System.out.println("OPCION INCORRECTA! REGRESANDO AL MENU...");
                            }	
                        }while(op!='c');   				
                        break;
                        
                    case 3:                                                
                        System.out.println("\n\t***DESPACHAR VUELO***"); 
                        aero.despacharVuelo();
                        break;	
                        
                    case 4:
                        do{
                            System.out.print("\n\t***OPCIONES***\na. Estadisticas generales." +
                                    "\nb. Estatidisticas por ruta.\nc. Listado de pasajeros." +
                                    "\nd. Mis datos.\ne. Log.\nf. Regresar al menu principal." +
                                    "\nIngrese el caracter de su seleccion: ");
                            op = lea.next().charAt(0);

                            switch (Character.toLowerCase(op)){//SUB-MENU REPORTES	   					
                                case 'a':
                                    aero.statsGenerales();
                                    break;	   					
                                case 'b':                                
                                    System.out.println("\n\t***ESTATIDISTICAS POR RUTA***");
                                    aero.printStatsRuta();
                                    break;	   					
                                case 'c':
                                    System.out.println("\n\t***LISTADO DE PASAJEROS***");
                                    aero.printListadoPasajeros();
                                    break;	   					
                                case 'd':
                                    System.out.println("\n\t***MIS DATOS***");
                                    userAct.print();
                                    break;	   					
                                case 'e':	   					
                                    break;	   					
                                case 'f':                                                                   
                                    System.out.println("\n\t***SALIENDO AL MENU PRINCIPAL***"); 
                                    break;	   				
                                default:                                                                   
                                    System.out.println("OPCION INCORRECTA! REGRESANDO AL MENU...");
                            }             
                        }while(op!='f');
                        break;	
                        
                    case 5:	
                        do{
                            System.out.print("\n\t***OPCIONES***\na. Editar mis datos." +
                                    "\nb. Crear usuario.\nc. Regresar al menu principal." +
                                    "\nIngrese el caracter de su seleccion: ");
                            op = lea.next().charAt(0);

                            switch (Character.toLowerCase(op)){//SUB-MENU USUARIOS	   				
                                case 'a':	
                                    System.out.println("\n\t***EDITAR MIS DATOS***"); 
                                    aero.editarUsuario();
                                    break;	   					
                                case 'b':	  
                                    System.out.println("\n\t***CREAR USUARIO***"); 
                                    aero.crearUsuario();
                                    break;	   					
                                case 'c':	   
                                    System.out.println("\n\t***SALIENDO AL MENU PRINCIPAL***"); 
                                    break;	   					
                                default:	  
                                    System.out.println("OPCION INCORRECTA! REGRESANDO AL MENU...");
                            }	   	
                        }while (op!='c');
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
