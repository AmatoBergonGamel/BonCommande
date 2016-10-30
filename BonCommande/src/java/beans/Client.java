
package beans;

/*
 Création d'un javabean pour les propriétés des clients
 */
public class Client {
    
    private String adress,name,password;
    
    public Client(){
        
    }
    
    public String getAdress(){
        return adress;
    }
    
    public String getName(){
        return name;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setAdress(String adresse){
        adress = adresse;
    }
    
    public void setName(String nom){
        name = nom;
    }
    
    public void setPassword(String mdp){
        password = mdp;
    }
}
