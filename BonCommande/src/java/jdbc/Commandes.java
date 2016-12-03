/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author Anaïs
 */
public class Commandes {

    private final DataSource myDataSource;

    /**
     *
     * @param dataSource la source de donnÃ©es Ã  utiliser
     */
    public Commandes(DataSource dataSource) {
        this.myDataSource = dataSource;
    }

    /**
     *
     * @param email
     * @return l'identifiant correspondant au mail saisi
     * @throws SQLException
     */
    public void ajoutCommande(int customerid, int productid, int quantity, String company) throws SQLException{
              		              
                String sql = "INSERT INTO PURCHASE_ORDER (ORDER_NUM,CUSTOMER_ID,PRODUCT_ID,QUANTITY, SHIPPING_COST, SALES_DATE, SHIPPING_DATE, FREIGHT_COMPANY) VALUES (?,?,?,?, ?, DATE(NOW()), DATE(NOW()), ?)";
                String sql2 = "SELECT MAX(ORDER_NUM) AS MAXI FROM PURCHASE_ORDER";
                int order = 0;
                  
              
                System.out.println(sql);
                Connection connection = myDataSource.getConnection();		  		  		                  
 				                 
                PreparedStatement stmt2 = connection.prepareStatement(sql2);
                 		                 
                ResultSet rs = stmt2.executeQuery();
                 		                 
                 if (rs.next()){
                 order = rs.getInt("MAXI")+1;
                 }
                 PreparedStatement stmt = connection.prepareStatement(sql);
                 stmt.setInt(1, order);
                 stmt.setInt(2, customerid );
                 stmt.setInt(3, productid );
                 stmt.setInt(4, quantity );
                 stmt.setFloat(5, (float) 10.00);
                 stmt.setString(6, company );
  		stmt.executeUpdate();		  		
  		 
                
  		stmt.close();		  		
                 stmt2.close();
                 rs.close();
  		connection.close();
                
    }
    
     
              		              
    /**
     *
     * @return
     * @throws Exception
     */
    public List<OrderEntity> allCommands() throws Exception {

        List<OrderEntity> result = new LinkedList<>();

        //String sql = "SELECT * FROM PURCHASE_ORDER";
        String sql2 = "SELECT CUSTOMER_ID, PRODUCT_ID, QUANTITY, DESCRIPTION,PURCHASE_COST FROM PURCHASE_ORDER NATURAL JOIN PRODUCT";
        try (Connection connection = myDataSource.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql2)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int userid = rs.getInt("CUSTOMER_ID");
                int productid = rs.getInt("PRODUCT_ID");
                int quantity = rs.getInt("QUANTITY");
                String desc = rs.getString("DESCRIPTION");
                float prix = rs.getInt("PURCHASE_COST");
                OrderEntity c = new OrderEntity(userid, quantity, productid, desc, prix);
                result.add(c);
            }
        }
        return result;
    }
    /**
     *
     * @return
     * @throws Exception
     */
    public List<OrderEntity> CommandsUser(int customer_id) throws Exception {

        List<OrderEntity> result = new LinkedList<>();

        //String sql = "SELECT * FROM PURCHASE_ORDER";
        String sql2 = "SELECT CUSTOMER_ID, PRODUCT_ID, QUANTITY, DESCRIPTION,PURCHASE_COST FROM PURCHASE_ORDER NATURAL JOIN PRODUCT WHERE CUSTOMER_ID = ?";
        try (Connection connection = myDataSource.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql2)) {
           stmt.setInt(1, customer_id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int userid = rs.getInt("CUSTOMER_ID");
                int productid = rs.getInt("PRODUCT_ID");
                int quantity = rs.getInt("QUANTITY");
                String desc = rs.getString("DESCRIPTION");
                float prix = rs.getInt("PURCHASE_COST");
                OrderEntity c = new OrderEntity(userid, quantity, productid, desc, prix);
                result.add(c);
            }
        }
        return result;
    }
    
     /**
     *
     * @return la liste des produits ne vente
     * @throws Exception
     */
    public List<OrderEntity> allsproducts() throws Exception {

        List<OrderEntity> result = new LinkedList<>();

        
        String sql2 = "SELECT PRODUCT_ID, QUANTITY_ON_HAND, PURCHASE_COST, DESCRIPTION FROM PRODUCT";
        try (Connection connection = myDataSource.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql2)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int productid = rs.getInt("PRODUCT_ID");
                int quantity = rs.getInt("QUANTITY_ON_HAND");
                String desc = rs.getString("DESCRIPTION");
                float prix = rs.getInt("PURCHASE_COST");
                OrderEntity c = new OrderEntity(productid, quantity,desc, prix);
                result.add(c);
            }
        }
        return result;
    }
    
     /**
     *
     * @return la liste des produits ne vente
     * @throws Exception
     */
    public List<OrderEntity> allfreightcompanies() throws Exception {

        List<OrderEntity> result = new LinkedList<>();

        
        String sql2 = "SELECT DISTINCT FREIGHT_COMPANY FROM PURCHASE_ORDER";
        try (Connection connection = myDataSource.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql2)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String company = rs.getString("FREIGHT_COMPANY");
                OrderEntity c = new OrderEntity(company);
                result.add(c);
            }
        }
        return result;
    }
}
