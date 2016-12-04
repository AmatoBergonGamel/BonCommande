/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import beans.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import jdbc.Commandes;
import jdbc.DataAccess;

/**
 *
 * @author Anaïs
 */
public class CreerBonCommande extends HttpServlet {

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
                    this.getServletContext().getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request,response);
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
                
                Commandes bon = new Commandes(getDataSource());
                DataAccess dao = new DataAccess(getDataSource());
                /*
                int id = dao.findIdOfCustomer(request.getParameter("nomClient"));
                String idp = request.getParameter("idproduit");
                
                int idprod = Integer.parseInt(idp);
                int quantity = Integer.parseInt(q);
                */
                
                String q = request.getParameter("quantite");
                int quantity = Integer.parseInt(q);
                String p = request.getParameter("produit");
                int product = Integer.parseInt(p);
                String freightCompany = request.getParameter("compagnieLivraisonCommande");
                
                try {
                    request.setAttribute("codes", bon.allsproducts());
                } catch (Exception ex) {
                    Logger.getLogger(VoirCommandes.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                HttpSession session = request.getSession();
                User user = (User) session.getAttribute("utilisateur");

                String id = request.getParameter("id_costumer"); // recupere l'id d"un input hidden du formulaire
                int customerid = Integer.parseInt(id); 
                bon.ajoutCommande(customerid, product, quantity, freightCompany); // recupere toutes ses valeurs puis plante durant la fonction
                
                String message = "Votre commande a bien été créée.";
                request.setAttribute( "message", message );
               processRequest(request, response);
                
               // this.getServletContext().getRequestDispatcher("/WEB-INF/VoirCommandes.jsp").forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(CreerBonCommande.class.getName()).log(Level.SEVERE, null, ex);
            }
            
           // this.getServletContext().getRequestDispatcher("/WEB-INF/VoirCommandes.jsp").forward(request, response);
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
