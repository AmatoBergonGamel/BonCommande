<%-- 
    Document   : VoirCommandes
    Created on : 19 nov. 2016, 15:43:22
    Author     : nico
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="header.jsp" %>
    </head>
    <body>
        <%@ include file="menu.jsp" %>

        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <h1>Commandes</h1>
                <table class="table table-striped">
                    <thead><tr><th>Customerid</th><th>quantité</th><th>productid</th><th>description</th><th>prix unitaire</th><th>prix total</th></tr></thead>
                            <c:forEach var="record" items="${requestScope.codes}">
                        <tbody>    <tr>
                            <th class"row">${record.getcid()}</th>
                            <td>${record.getQuantity()}</td>
                            <td>${record.getpid()}</td>
                            <td>${record.getDescription()}</td>
                            <td>${record.getPrix()} $</td>
                            <td>${record.getPrix()*record.getQuantity()} $</td>
                        </tr>
                        </tbody>
                    </c:forEach>  
                </table>
            </div>
        </div>
    </body>
</html>