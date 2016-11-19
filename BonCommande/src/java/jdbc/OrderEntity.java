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
            
            
    public OrderEntity(int c, int q, int p){
        
        customerid=c;
        quantity=q;
        productid=p;
        
    }
    
    public int getcid(){
        
        return customerid;
        
    }
    
    public int getpid(){
        
        return productid;
        
    }
    
    public int getquantity(){
        
        return quantity;
        
    }
    
}
