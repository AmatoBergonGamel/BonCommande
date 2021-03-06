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
import java.util.logging.Level;
import java.util.logging.Logger;
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
     * ajoute un bon de commande à la base e données
     *
     * @param customerid
     * @param productid
     * @param quantity
     * @param company
     * @throws SQLException
     */
    public void ajoutCommande(int customerid, int productid, int quantity, String company) throws SQLException {

        String sql = "INSERT INTO PURCHASE_ORDER (ORDER_NUM,CUSTOMER_ID,PRODUCT_ID,QUANTITY, SHIPPING_COST, SALES_DATE, SHIPPING_DATE, FREIGHT_COMPANY) VALUES (?,?,?,?, ?, ?, ?, ?)";
        String sql2 = "SELECT MAX(ORDER_NUM) AS MAXI FROM PURCHASE_ORDER";
        int order = 0;

        System.out.println(sql);
        Connection connection = myDataSource.getConnection();

        PreparedStatement stmt2 = connection.prepareStatement(sql2);

        ResultSet rs = stmt2.executeQuery();

        java.util.Date utilNow = new java.util.Date();
        java.sql.Date sqlNow = new java.sql.Date(utilNow.getTime());

        if (rs.next()) {
            order = rs.getInt("MAXI") + 1;
        }
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, order);
        stmt.setInt(2, customerid);
        stmt.setInt(3, productid);
        stmt.setInt(4, quantity);
        stmt.setFloat(5, (float) 10.00);
        stmt.setDate(6, sqlNow);
        stmt.setDate(7, sqlNow);
        stmt.setString(8, company);
        stmt.executeUpdate();

        stmt.close();
        stmt2.close();
        rs.close();
        connection.close();

    }

    /**
     * modifie une commande de la base de données
     *
     * @param order_num
     * @param product_id
     * @param quantity
     * @param company
     * @throws SQLException
     */
    public void modifierCommande(int order_num, int product_id, int quantity, String company) throws SQLException {

        String sql = "UPDATE PURCHASE_ORDER SET PRODUCT_ID = ? , QUANTITY = ?, SHIPPING_COST = ?, SALES_DATE =?, SHIPPING_DATE =? , FREIGHT_COMPANY =? WHERE ORDER_NUM = ?";

        Connection connection = myDataSource.getConnection();

        java.util.Date utilNow = new java.util.Date();
        java.sql.Date sqlNow = new java.sql.Date(utilNow.getTime());

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, product_id);
        stmt.setInt(2, quantity);
        stmt.setFloat(3, (float) 10.00);
        // on rentre la date actuelle, récuperée ci-dessus en java
        stmt.setDate(4, sqlNow);
        stmt.setDate(5, sqlNow);
        stmt.setString(6, company);
        stmt.setInt(7, order_num);
        stmt.executeUpdate();

        stmt.close();
        connection.close();

    }

    /**
     * supprime une commande de la base de données
     *
     * @param order
     * @throws SQLException
     */
    public void supprimerCommande(int order) {

        String sql = "DELETE FROM PURCHASE_ORDER WHERE ORDER_NUM = ?";

        try {

            Connection connection = myDataSource.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, order);
            stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Commandes.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
    *   Recupere une commande de par son identifiant
     * @param order
     * @return une commande
     * @throws java.sql.SQLException
     */
    public OrderEntity recupererCommande(int order) throws SQLException {

        String sql = "SELECT ORDER_NUM, CUSTOMER_ID, PURCHASE_ORDER.PRODUCT_ID, QUANTITY, DESCRIPTION, PURCHASE_COST FROM PURCHASE_ORDER, PRODUCT WHERE ORDER_NUM = ?";

        Connection connection = myDataSource.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, order);
        ResultSet rs = stmt.executeQuery();

        int entityid = rs.getInt("ORDER_NUM");
        int userid = rs.getInt("CUSTOMER_ID");
        int productid = rs.getInt("PRODUCT_ID");
        int quantity = rs.getInt("QUANTITY");
        String desc = rs.getString("DESCRIPTION");
        float prix = rs.getInt("PURCHASE_COST");

        OrderEntity commande = new OrderEntity(entityid, userid, quantity, productid, desc, prix);

        return commande;
    }

    /**
     * recupere toutes les commandes de la base de données
     * Pas utilisée dans l'appli
     * @return @throws Exception
     */
    public List<OrderEntity> allCommands() throws Exception {

        List<OrderEntity> result = new LinkedList<>();

        //String sql = "SELECT * FROM PURCHASE_ORDER";
        String sql2 = "SELECT ORDER_NUM, CUSTOMER_ID, PRODUCT_ID, QUANTITY, DESCRIPTION,PURCHASE_COST FROM PURCHASE_ORDER NATURAL JOIN PRODUCT";
        try (Connection connection = myDataSource.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql2)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int entityid = rs.getInt("ORDER_NUM");
                int userid = rs.getInt("CUSTOMER_ID");
                int productid = rs.getInt("PRODUCT_ID");
                int quantity = rs.getInt("QUANTITY");
                String desc = rs.getString("DESCRIPTION");
                float prix = rs.getInt("PURCHASE_COST");
                OrderEntity c = new OrderEntity(entityid, userid, quantity, productid, desc, prix);
                result.add(c);
            }
        }
        return result;
    }

    /**
     * recuperer toutes les commandes d'un user
     * @param customer_id
     * @return @throws Exception
     */
    public List<OrderEntity> CommandsUser(int customer_id) throws Exception {

        List<OrderEntity> result = new LinkedList<>();

        //String sql = "SELECT * FROM PURCHASE_ORDER";
        String sql2 = "SELECT ORDER_NUM, CUSTOMER_ID, PRODUCT_ID, QUANTITY, DESCRIPTION,PURCHASE_COST FROM PURCHASE_ORDER NATURAL JOIN PRODUCT WHERE CUSTOMER_ID = ?";
        try (Connection connection = myDataSource.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql2)) {
            stmt.setInt(1, customer_id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int entityid = rs.getInt("ORDER_NUM");
                int userid = rs.getInt("CUSTOMER_ID");
                int productid = rs.getInt("PRODUCT_ID");
                int quantity = rs.getInt("QUANTITY");
                String desc = rs.getString("DESCRIPTION");
                float prix = rs.getInt("PURCHASE_COST");
                OrderEntity c = new OrderEntity(entityid, userid, quantity, productid, desc, prix);
                result.add(c);
            }
        }
        return result;
    }

    /**
     * recupere la liste de tous les produits de la base de données
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
                OrderEntity c = new OrderEntity(productid, quantity, desc, prix);
                result.add(c);
            }
        }
        return result;
    }

    /**
     * recupere la liste de toutes le compagnies de livraison de la base de données
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
