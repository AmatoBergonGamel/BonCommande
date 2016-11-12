<%-- 
    Document   : authentification
    Created on : 1 nov. 2016, 08:30:24
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
        <div class="container col-md-8 col-md-offset-2">
                <form method="post" action="Connection">
                    <fieldset>
                        <legend>Formulaire d'authentification</legend>
                        <div class="form-group row">
                            <label for="email" class="col-sm-2 col-form-label">Email :</label>
                            <div class="col-sm-10">
                                <input type="email" id="email" name="email" class="form-control"placeholder="Email">
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="password" class="col-sm-2 col-form-label">Password :</label>
                            <div class="col-sm-10">
                                <input type="password" id="password" name="password" class="form-control" id="password" placeholder="Password">
                            </div>
                        </div>
                        <input type="submit" class="btn btn-primary" value="Se connecter">
                    </fieldset>
                </form>

            </div>
    </body>
</html>
