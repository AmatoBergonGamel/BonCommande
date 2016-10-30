<%-- 
    Document   : pagetest
    Created on : 30 oct. 2016, 13:26:47
    Author     : nico
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Authentification</title>
    </head>
    <body>
        <h1>Page générée à l'aide de jsp</h1>
        <p>cette page pourra par la suite servir à l'authentification des clients ainsi qu'à leur inscription dans la base de donnée</p>
        <%
            String attribut1 = (String) request.getAttribute("name");
            out.println(attribut1);
        %><br>
        <%
            
            String attribut2 = (String) request.getAttribute("login");
            out.println(attribut2);
        %>
    </body>
</html>
