<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="header.jsp" %>
    </head>
    <body>
        <%@ include file="menu.jsp" %>
        
        <div class="row">
        <% 
            
            String aemail = (String) request.getAttribute("attemail");
            String apassword = (String) request.getAttribute("attpassword");

            if(aemail == null) {
        
            out.println("<h1 class='col-md-8 col-md-offset-2'>Connection impossible</h1>"
                    + "<div class='alert alert-danger col-md-8 col-md-offset-2' role='alert'>"
                    + "<p> Une erreur est survenue lors de la connection.</p>"
                    + "<p> Votre mot de passe ou votre identifiant doit être incorrect.</p>"
                    + "</div>");
        
             } else {
       
        
            out.println("<h1 class='col-md-8 col-md-offset-2'>Vous êtes connecté(e)</h1>"
                        + "<div class='alert alert-success col-md-8 col-md-offset-2' role='alert'>"
                        + "<p>Connection à votre compte réussie</p>"
                        + "</div>");
                
       
           }
        %>
        
        </div>
          
    </body>
</html>
