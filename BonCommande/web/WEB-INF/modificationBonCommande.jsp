<%-- 
    Document   : modificationBonCommande
    Created on : 4 déc. 2016, 22:16:19
    Author     : Anaïs
--%>

<%@page import="jdbc.OrderEntity"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="header.jsp" %>
    </head>
    <body>
        <%@ include file="menu.jsp" %>

    <div class=row">
            <div class="col-md-8 col-md-offset-2"> 
                <form method="post" action="ModifierBonCommande">

                    <%
                        
                       String num = (String) request.getAttribute("num_order");
                        //out.println(num);
                        OrderEntity commande = (OrderEntity) request.getAttribute("commande");
                       
                     
                    %>
                    
                    <fieldset>
                        <legend>Modifier votre commande</legend>
                        <div class="form-group row">
                            <label for="produitCommande" class="col-md-3 col-form-label">Produit<span class="requis">*</span></label>
                            <div class="col-md-9">
                                <select id="produit" name="produit" class="form-control">
                                     <c:forEach var="record" items="${requestScope.produits}">
                                        <option value="${record.getpid()}">${record.getDescription()} (${record.getPrix()} €)</option>
                                    </c:forEach> 
                                </select>
                            </div>
                            <br />
                        </div>
                        <div class="form-group row">
                            <label for="quantite" class="col-md-3 col-form-label">Quantité <span class="requis">*</span></label>
                            <div class="col-md-9">
                                <input type="number" class="form-control" id="quantite" name="quantite" value=""/>
                            </div>
                            <br />
                        </div>
                                                
                        <div class="form-group row">
                            <label for="compagnieLivraisonCommande" class="col-md-3 col-form-label">Compagnie de livraison</label>
                            <div class="col-md-9">
                                <select id="compagnieLivraisonCommande" name="compagnieLivraisonCommande" class="form-control">
                                  
                                    <c:forEach var="record" items="${requestScope.compagnies}">
                                        <option value="${record.getCompany()}">${record.getCompany()}</option>
                                   </c:forEach> 
                                </select>
                            </div>
                            <br />
                        </div>
                    </fieldset>
            </div>
            <div  class="col-md-8 col-md-offset-2">
                <%
                   
                    if (session.getAttribute("utilisateur") != null) {
                            User user = (User) session.getAttribute("utilisateur");
                            out.println("<input type='hidden' id='id_costumer' name='id_costumer' value='"+user.getPassword()+"'/>");
                    }
                    out.println("<input type='hidden' name='num_order' id='num_order' value='"+num+"'>");
                   
                %>
                <input type="submit" class="btn btn-primary" value="Modifier"  />
                <input type="reset" class="btn btn-warning" value="Remettre à zéro" /> <br />
            </div>
        </form>

    </div>
    </body>
</html>