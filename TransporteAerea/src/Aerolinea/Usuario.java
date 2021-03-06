package Aerolinea;

public class Usuario {
    
    private String nombre, username, password, tipoCuenta;

    public Usuario(String n, String user, String pass, String tipo){
    	nombre = n;
    	username = user;
    	password = pass;
    	tipoCuenta = tipo;
    }

    public String getNombre(){
    	return nombre;
    }

    public void setNombre(String n){
    	nombre = n;
    }

    public String getUsername(){
    	return username;
    }

    public void setUsername(String user){
    	username = user;
    }

    public String getPassword(){
    	return password;
    }

    public void setPassword(String p){
    	password = p;
    }

    public String getTipoCuenta(){
    	return tipoCuenta;
    }

    /**
     * Imprime los datos del usuario, exceptuando password.
     */
    public void print(){
        System.out.printf("Nombre: %s - Username: %s - Tipo de Cuenta: %s \n", 
                getNombre(), getUsername(), getTipoCuenta());
    }
}
