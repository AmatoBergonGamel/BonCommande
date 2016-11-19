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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Commandes</h1>
        
        <div>
			<table border="1">
				<tr><th>Code</th><th>Taux</th><th>Action</th></tr>
				<c:forEach var="record" items="${requestScope.codes}">
					<tr>
						<td>${record.getcid()}</td>
						<td>${record.getquantity()}</td>
                                                <td>${record.getpid()}</td>
					</tr>	  		    
				</c:forEach>  
			</table>
		</div>
    </body>
</html>
