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
import javax.sql.DataSource;
import beans.User;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Anaïs
 */
public class DataAccess {

    private final DataSource myDataSource;

    /**
     *
     * @param dataSource la source de donnÃ©es Ã  utiliser
     */
    public DataAccess(DataSource dataSource) {
        this.myDataSource = dataSource;
    }

    /**
     * verifie si l'email rentré correspond au mot de passe, c'est à dire à
     * l'identifiant d'un user
     *
     * @param email
     * @param mdp
     * @return l'identifiant correspondant au mail saisi
     * @throws SQLException
     */
    public boolean verifAuthentification(String email, int mdp) throws SQLException {

        int result = 0;
        // recupere l'id du user par rapport à son email
        String sql = "SELECT CUSTOMER_ID FROM APP.CUSTOMER WHERE EMAIL = ?";
        // Ouvrir une connexion
        Connection connection = myDataSource.getConnection();
        // On crÃ©e un statement pour exÃ©cuter une requÃªte
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, email);
        // Un ResultSet pour parcourir les enregistrements du rÃ©sultat
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) { // Pas la peine de faire while, il y a 1 seul enregistrement
            // On rÃ©cupÃ¨re le champ CUSTOMER_ID de l'enregistrement courant
            result = rs.getInt("CUSTOMER_ID");
        }
        // On ferme tout
        rs.close();
        stmt.close();
        connection.close();

        return result == mdp;
    }

    /**
     * Trouver un Customer Ã  partir de sa clÃ©
     * @param customerID la clÃ© du CUSTOMER Ã  rechercher
     * @return l'enregistrement correspondant dans la table CUSTOMER, ou null si
     * pas trouvÃ©
     * @throws SQLException
     */
    public String findNameOfCustomer(int customerID) throws SQLException {
        String result = null;

        // Une requÃªte SQL paramÃ©trÃ©e
        String sql = "SELECT NAME FROM CUSTOMER WHERE CUSTOMER_ID = ?";
        // Ouvrir une connexion
        Connection connection = myDataSource.getConnection();
        // On crÃ©e un statement pour exÃ©cuter une requÃªte
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, customerID);

        // Un ResultSet pour parcourir les enregistrements du rÃ©sultat
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) { // Pas la peine de faire while, il y a 1 seul enregistrement
            // On rÃ©cupÃ¨re les champs nÃ©cessaires de l'enregistrement courant
            result = rs.getString("NAME");
        }
        // On ferme tout
        rs.close();
        stmt.close();
        connection.close();

        return result;
    }
        /**
     * Trouve un user par rapport à son id
     * @param identifiant
     * @return un user
     * @throws SQLException
     */
    public int findIdOfCustomer(String identifiant) throws SQLException {
        int result = 0;

        // Une requÃªte SQL paramÃ©trÃ©e
        String sql = "SELECT CUSTOMER_ID FROM CUSTOMER WHERE NAME = ?";
        String sql2 = "SELECT MAX(CUSTOMER_ID) as nbId  FROM CUSTOMER";
        // Ouvrir une connexion
        Connection connection = myDataSource.getConnection();
        // On crÃ©e un statement pour exÃ©cuter une requÃªte
        PreparedStatement stmt = connection.prepareStatement(sql);
        PreparedStatement stmt2 = connection.prepareStatement(sql2);
        stmt.setString(1, identifiant);

        // Un ResultSet pour parcourir les enregistrements du rÃ©sultat
        ResultSet rs = stmt.executeQuery();
        ResultSet rs2 = stmt2.executeQuery();
        if (rs.next()) { // Pas la peine de faire while, il y a 1 seul enregistrement
            // On rÃ©cupÃ¨re les champs nÃ©cessaires de l'enregistrement courant

            result = rs.getInt("CUSTOMER_ID");

        } else {
            if (rs2.next()) {

                result = rs2.getInt("nbId") + 1;
            }
        }
        // On ferme tout
        rs.close();
        rs2.close();
        stmt.close();
        stmt2.close();
        connection.close();

        return result;
    }

    /**
     * Trouver un Customer Ã  partir de sa clÃ©
     *
     * @param customerID la clÃ© du CUSTOMER Ã  rechercher
     * @return l'enregistrement correspondant dans la table CUSTOMER, ou null si
     * pas trouvÃ©
     * @throws SQLException
     */
    public User findAllOfCustomer(int customerID) throws SQLException {
        User result = null;

        // Une requÃªte SQL paramÃ©trÃ©e
        String sql = "SELECT * FROM CUSTOMER WHERE CUSTOMER_ID = ?";
        // Ouvrir une connexion
        Connection connection = myDataSource.getConnection();
        // On crÃ©e un statement pour exÃ©cuter une requÃªte
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, customerID);

        // Un ResultSet pour parcourir les enregistrements du rÃ©sultat
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) { // Pas la peine de faire while, il y a 1 seul enregistrement
            // On rÃ©cupÃ¨re les champs nÃ©cessaires de l'enregistrement courant
            String name = rs.getString("NAME");
            String email = rs.getString("EMAIL");
            String password = Integer.toString(customerID);

            result = new User(name, email, password);

        }
        // On ferme tout
        rs.close();
        stmt.close();
        connection.close();

        return result;
    }
}
