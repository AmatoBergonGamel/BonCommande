<%-- 
    Document   : menu
    Created on : 1 nov. 2016, 08:20:33
    Author     : Anaïs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="beans.User"%>
<!DOCTYPE html>

        <!-- barre de nav,  inclure dans chaque fichier aussi -->
        <header>
            <!-- menu de navigation !-->
        <nav class="navbar navbar-default">
                <div class="container-fluid">

                    <div class="navbar-header">
                        <a class="navbar-brand" href="/BonCommande">Application Bon de Commande</a> <!-- lien qui revient à l'accueil -->
                       
                       
                      
                    </div>
                     <% 
                        //User utilisateur = (User) session.getAttribute("utilisateur");
                        if(session.getAttribute("utilisateur") != null) {
                            User user = (User) session.getAttribute("utilisateur");
                           
                           
                        if (user.getEmail() != null) {
                            out.println("<form method='post' action='/BonCommande/Deconnection'>"
                                       + "<input type='submit' class='btn btn-danger pull-right' value='Se déconnecter'>"
                                       + "</form>");
                            out.println("<form method='get' action='/BonCommande/CreationCommande'>"
                                       + "<input type='submit' class='btn btn-danger pull-right' value='Créer une nouvelle commande'>"
                                       + "</form>");
                            out.println("<form method='get' action='/BonCommande/VoirCommandes'>"
                                       + "<input type='submit' class='btn btn-danger pull-right' value='Commandes'>"
                                       + "</form>");
                            out.println(user.getEmail());
                           }                         
                        } else {
                            out.println("<form method='post' action='/BonCommande/Authentification'>"
                            + "<input type='submit' class='btn btn-primary pull-right' value='Se connecter'>"
                                    + "</form>");
                        }
                        %> 
                </div>
               
            </nav>
        </header>
