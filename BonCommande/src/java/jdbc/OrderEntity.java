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

    private int orderEntityId, customerid, quantity, productid;
    private String description, company;
    private float prix;

    public OrderEntity(int c, int q, int p) {
        customerid = c;
        quantity = q;
        productid = p;
    }

    public OrderEntity(int c, int q, int p, String d) {
        customerid = c;
        quantity = q;
        productid = p;
        description = d;
    }

    public OrderEntity(int i, int c, int q, int p, String d, float pr) {
        orderEntityId = i;
        customerid = c;
        quantity = q;
        productid = p;
        description = d;
        prix = pr;
    }

    public OrderEntity(int p, int q, String d, float pr) {
        productid = p;
        quantity = q;
        description = d;
        prix = pr;
    }

    public OrderEntity(String c) {
        company = c;
    }

    public int getoid() {
        return orderEntityId;
    }
    
    public int getcid() {
        return customerid;
    }

    public int getpid() {
        return productid;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public String getCompany() {
        return company;
    }

    public float getPrix() {
        return prix;
    }

}
