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

                <%

                    if (session.getAttribute("utilisateur") != null) {
                        User user = (User) session.getAttribute("utilisateur");

                        if (user.getEmail() != null) {
                            out.println("<div class='collapse navbar-collapse' id='bs-example-navbar-collapse-1'>"
                                    + "<ul class='nav navbar-nav'>"
                                    + "<li class='dropdown'>"
                                    + "<a href='' class='dropdown-toggle' data-toggle='dropdown' role='button' "
                                    + "aria-haspopup='true' aria-expanded='false'>Bon de Commande<span class='caret'></span></a>"
                                    + "<ul class='dropdown-menu'>"
                                    + "<li><a href='/BonCommande/CreationCommande'>Créer un bon de commande</a></li>"
                                    + "<li><a href='/BonCommande/VoirCommandes'>Voir vos bons de commande</a></li>"
                                    + "</ul></li></ul>"
                                    + "</div></div>");

                            out.println(""
                                    + "<div class='nav navbar-right'>"
                                    + "<form method='post' action='/BonCommande/Deconnection'>"
                                    + "<input type='submit' class='btn btn-danger' value='Se déconnecter'>"
                                    + "</form>"
                                    + "</div><p class='nav navbar-right' id='bonjourCo'>Bonjour " + user.getName() + "&nbsp;</p></DIV>");

                        }
                    } else {
                        out.println("</div><div class='nav navbar-right'>"
                                + "<form method='post' action='/BonCommande/Authentification'>"
                                + "<input type='submit' class='btn btn-primary' value='Se connecter'>"
                                + "</form></div>");
                    }
                %>                                                                                       
           
    </nav>
</header>
