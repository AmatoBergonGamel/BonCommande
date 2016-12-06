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

        <% if (session.getAttribute("utilisateur") != null) {
                User user = (User) session.getAttribute("utilisateur");

            }

        %>

        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <h1>Vos Commandes</h1>
                <table class="table table-striped">
                    <thead><tr><th>Description</th><th>Quantité</th><th>Prix unitaire</th><th>Prix total</th><th>Modifier</th><th>Supprimer</th></tr></thead>
                                <c:forEach var="record" items="${requestScope.codes}">
                        <tbody>  
                            <tr>
                                <td>${record.getDescription()}</td>
                                <td>${record.getQuantity()}</td>              
                                <td>${record.getPrix()} $</td>
                                <td>${record.getPrix()*record.getQuantity()} $</td>
                                <td><form method="post" action="ModificationBonCommande">
                                        <input type="hidden" name="num_order" id="num_order" value="${record.getoid()}">
                                        <input type='submit' class='btn btn-warning' value='Modifier'>
                                    </form>
                                </td>
                                <td><form method="post" action="SupprimerBonCommande">
                                        <input type="hidden" name="num_order" id="num_order" value="${record.getoid()}">
                                        <input type='submit' class='btn btn-danger' value='Supprimer'>
                                    </form>
                                    </td>
                            </tr>
                        </tbody>
                    </c:forEach>  
                </table>
            </div>
        </div>
    </body>
</html>