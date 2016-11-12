<%-- 
    Document   : Connection
    Created on : 12 nov. 2016, 19:59:37
    Author     : nico
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Vous êtes connecté</h1>
         <% 
            String aemail = (String) request.getAttribute("attemail");
            String apassword = (String) request.getAttribute("attpassword");
            out.println( "email : " + aemail );
         %>
         <br>
         <% 
            out.println( "mot de passe : " + apassword );
         %>
         <br>
    </body>
</html>
