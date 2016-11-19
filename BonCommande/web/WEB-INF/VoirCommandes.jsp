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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Commandes</title>
    </head>
    <body>
        <h1>Commandes</h1>
        
        <div>
			<table border="1">
				<tr><th>Customerid</th><th>quantité</th><th>productid</th><th>description</th><th>prix unitaire</th><th>prix total</th></tr>
				<c:forEach var="record" items="${requestScope.codes}">
					<tr>
						<td>${record.getcid()}</td>
						<td>${record.getQuantity()}</td>
                                                <td>${record.getpid()}</td>
                                                <td>${record.getDescription()}</td>
                                                <td>${record.getPrix()} $</td>
                                                <td>${record.getPrix()*record.getQuantity()} $</td>
					</tr>	  		    
				</c:forEach>  
			</table>
		</div>
    </body>
</html>
