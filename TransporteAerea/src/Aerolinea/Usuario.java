package Aerolinea;
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
    
    
    public void agregarUsuario( String nombre,String usuario, String password, String tipo){
        nombreUsuario = nombre;
        userName = usuario;
        userPassword = password;
        userTipo = tipo;
    }
    
    
    public void editUsuario( String nombre,String usuario, String password){
        nombreUsuario = nombre;
        userName = usuario;
        userPassword = password;
        
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

    boolean equalsIgnoreCase(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    boolean equalsIgnoreCase(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Object getUserName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Object getUserName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
