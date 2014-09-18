package Aerolinea;

public class Usuario {
    
    private String nombre, apellido, nombrec, username, password, tipoCuenta;

    public Usuario(String n, String a, String user, String pass, String tipo){
    	nombre = n;
        apellido = a;
        nombrec = nombre + " " + apellido;
    	username = user;
    	password = pass;
    	tipoCuenta = tipo;
    }
    
    public void editUsuario(String n, String a, String user, String pass){
        nombre = n;
        apellido = a;
        nombrec = nombre + " " + apellido;
        username = user;
        password = pass;
        System.out.println("\nDatos Modificados!");
    }
    
    public String getNombre(){
    	return nombrec;
    }

    
    public String getUsername(){
    	return username;
    }

    
    public String getPassword(){
    	return password;
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
