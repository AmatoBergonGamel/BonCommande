/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

/**
 *
 * @author nico
 */
public class OrderEntity {
    
    private int customerid,quantity,productid;
    private String description;
    private float prix;
            
    public OrderEntity(int c, int q, int p){
        
        customerid=c;
        quantity=q;
        productid=p;
        
    }
    
    public OrderEntity(int c, int q, int p, String d){
        
        customerid=c;
        quantity=q;
        productid=p;
        description=d;
        
    }
    
    public OrderEntity(int c, int q, int p, String d, float pr){
        
        customerid=c;
        quantity=q;
        productid=p;
        description=d;
        prix=pr;
        
    }
    
    public int getcid(){
        
        return customerid;
        
    }
    
    public int getpid(){
        
        return productid;
        
    }
    
    public int getQuantity(){
        
        return quantity;
        
    }
    
    public String getDescription(){
        
        return description;
        
    }
    
    public float getPrix(){
        
        return prix;
        
    }
    
}
