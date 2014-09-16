package Aerolinea;

public class Usuario {
    
    private String name,user,tip;
    private int pass;
   
    
    
    //Constructor
    public Usuario( String use,int pas, String tp, String nam){
        name = nam;
        user = use;
        pass= pas;
        tip = tp;
        
        
    }
    
    
    public void edit(String nam , String use, int pas , String tp){
        name = nam;
        user = use;
        pass = pas;
        tip = tp;
    }
    
    public boolean creado(String u){
        if(user == u )
            return true;
        return false;
    }
    
    
    
}
