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
         * 
         * @param email
         * @return l'identifiant correspondant au mail saisi
         * @throws SQLException 
         */
        public int verifAuthentification(String email) throws SQLException{
                
                int result = 0;
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
                
                return result;
        }
        
        /**
	 * Trouver un Customer Ã  partir de sa clÃ©
	 *
	 * @param customerID la clÃ© du CUSTOMER Ã  rechercher
	 * @return l'enregistrement correspondant dans la table CUSTOMER, ou null si pas trouvÃ©
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
}