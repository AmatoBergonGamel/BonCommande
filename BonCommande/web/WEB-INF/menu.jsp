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
                    
                    <div class="" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li><a href="#">Ajouter</a></li>
                            <li><a href="#">Modifier</a></li>
                            <li><a href="#">Supprimer</a></li>     
                         </ul>
                    </div>
       
                     <% 

                        if(session.getAttribute("utilisateur") != null) {
                            User user = (User) session.getAttribute("utilisateur");
                           
                           
                        if (user.getEmail() != null) {

                            
                           out.println("<p class='nav navbar-nav' id='bonjourCo'>Bonjour "+ user.getName()+"</p>"
                                    + "<div class='nav navbar-nav navbar-right'>"
                                    + "<form method='post' action='/BonCommande/Deconnection'>"
                                    + "<input type='submit' class='btn btn-danger' value='Se déconnecter'>"
                                    + "</form>"
                                    + "</div>");
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
                            out.println("<form method='post' id='formCo' action='/BonCommande/Authentification'>"
                            + "<input type='submit' class='btn btn-primary pull-right' value='Se connecter'>"
                                    + "</form>");
                        }
                        %> 
                </div>
               
            </nav>
        </header>
