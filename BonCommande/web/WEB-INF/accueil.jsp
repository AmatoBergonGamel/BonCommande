<%-- 
    Document   : accueil
    Created on : 1 nov. 2016, 08:42:19
    Author     : Anaïs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="header.jsp" %>
    </head>
    <body>
        <%@ include file="menu.jsp" %>
        
        <div class="row">
            <!-- <a href="/BonCommande/authentification">lien vers la page d'authentification</a><br> -->
            <p class="col-md-8 col-md-offset-2">Bienvenue, sur l'application <i><strong>Bon de Commande</strong></i>.</p>
            
             
                <% 
                    if(session.getAttribute("utilisateur") != null) {
                            User user = (User) session.getAttribute("utilisateur");     
                            
                            out.println("<div class='alert alert-success col-md-8 col-md-offset-2' role='alert'>"
                                        + "<p><strong>Bonjour :</strong> "+ user.getName() + "</p>"
                                        + "<p>Vous êtes connecté. Vous avez accés à toutes les fonctionnalités de l'application.</p>"
                                        + "</div>");
                    } else {
                            
                             out.println("<div class='alert alert-danger col-md-8 col-md-offset-2' role='alert'>"
                                        + "<p><strong>Attention :</strong> Vous n'êtes pas connecté.</p>"
                                        + "<p>Vous ne pouvez pas accédez à toutes les fonctionnalités de l'application</p>"
                                        + "<p>Veuillez vous connecter, ou vous inscrire si vous ne possédez pas de compte utilisateur chez nous.</p>"
                                        + "</div>");
                    }
                    
                    String message = (String) request.getAttribute("message");
                    if(message != null) {
                        out.println("<div class='alert alert-success col-md-8 col-md-offset-2' role='alert'>"
                                + message
                                + "</DIV>");                
                    }
                    
                %>
        </div>
    </body>
</html>
