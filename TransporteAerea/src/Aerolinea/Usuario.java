package Aerolinea;
import java.util.Scanner;
public class Usuario {
    
   //Atributos
    private String nombreUsuario,userName,userPassword,userTipo;
   
    

    //Constructor
    /**
     * 
     * @param nombre
     * @param usuario
     * @param password
     * @param tipo 
     */
    public Usuario( String nombre,String usuario, String password, String tipo){
        nombreUsuario = nombre;
        userName = usuario;
        userPassword = password;
        userTipo = tipo;
    }
    
     public String getNombreUsuario() {
        return nombreUsuario;
    }
    
    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserTipo() {
        return userTipo;
    }
    
          
      
    /**
     * 
     * @param u
     * @return 
     */
    public boolean UserExist(String u){
        if(userName == u )
            return true;
        return false;
    }
    
  
    
    
    
}
