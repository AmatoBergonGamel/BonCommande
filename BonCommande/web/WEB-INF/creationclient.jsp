

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>  
        <%@ include file="header.jsp" %>
    </head>
    <body>
        <%@ include file="menu.jsp" %>
        <div class="container col-md-8 col-md-offset-2">
            <form method="post" action="creationClient">
                <fieldset>
                    <legend>Création d'un nouveau client</legend>
                    <div class="form-group row">
                        <label for="nomClient" class="col-md-3 col-form-label">Nom <span class="requis">*</span></label>
                        <div class="col-md-9">
                            <input type="text" id="nomClient" class="form-control" name="nomClient" value="" />
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="prenomClient" class="col-md-3 col-form-label">Prénom </label>
                        <div class="col-md-9">
                            <input type="text" id="prenomClient" name="prenomClient" value="" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group row">

                        <label for="adresseClient" class="col-md-3 col-form-label">Adresse de livraison <span class="requis">*</span></label>
                        <div class="col-md-9">
                            <input type="text" id="adresseClient" name="adresseClient" value="" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group row">

                        <label for="telephoneClient" class="col-md-3 col-form-label">Numéro de téléphone <span class="requis">*</span></label>
                        <div class="col-md-9">
                            <input type="text" id="telephoneClient" name="telephoneClient" value="" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group row">

                        <label for="emailClient" class="col-md-3 col-form-label">Adresse email</label>
                        <div class="col-md-9">
                            <input type="email" id="emailClient" name="emailClient" value="" class="form-control"/>
                        </div>
                    </div>
                </fieldset>
                <input type="submit" class="btn btn-primary" value="Valider" />
                <input type="reset" class="btn btn-warning" value="Remettre à zéro" /> <br />
            </form>
        </div>
    </body>
</html>
