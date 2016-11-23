/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
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
    public void ajoutCommande(int ordernum, int customerid, int productid, int quantity) throws SQLException {

        String sql = "INSERT INTO PURCHASE_ORDER (?,?,?,?,,,,)";
        Connection connection = myDataSource.getConnection();
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.executeQuery();

        stmt.close();
        connection.close();

    }

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

}
