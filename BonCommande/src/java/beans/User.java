/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Anaïs
 */
public class User {
    
    private String login, adress,name,password;
    
    public User(String name, String login, String password){
        this.name = name;
        this.login = login;
        this.password = password;
    }
    
    public String getEmail(){
        return login;
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
    
    public void setEmail(String email){
        login = email;
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
