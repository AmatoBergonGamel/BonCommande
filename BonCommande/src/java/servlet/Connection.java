/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import jdbc.DataAccess;
import beans.User;

/**
 *
 * @author nico
 */
public class Connection extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/Connection.jsp").forward(request,response);
    }
    
     public DataSource getDataSource() throws SQLException {
		org.apache.derby.jdbc.ClientDataSource ds = new org.apache.derby.jdbc.ClientDataSource();
		ds.setDatabaseName("sample");
		ds.setUser("app");
		ds.setPassword("app");
		// The host on which Network Server is running
		ds.setServerName("localhost");
		// port on which Network Server is listening
		ds.setPortNumber(1527);
		return ds;
    }	

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Creer le DAO avec sa source de donnÃ©es
            DataAccess dao = new DataAccess(getDataSource());
            
            String email = request.getParameter( "email" );
            String motDePasse = request.getParameter( "password" );
            int mdp; 
            mdp = Integer.parseInt(motDePasse); 

            boolean res = dao.verifAuthentification(email,mdp);
                    
            if(res) {
                request.setAttribute("attemail", email);
                request.setAttribute("attpassword", motDePasse);
                User user = (User) dao.findAllOfCustomer(mdp);
              //  User user = new User(email,motDePasse);
                HttpSession UserSession = request.getSession();
                UserSession.setAttribute("utilisateur", user);
                processRequest(request, response);
            } else {
                              
                processRequest(request, response);
            }
            
        } catch(Exception ex) {
        
        }
      
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
