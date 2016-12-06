

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>  
        <%@ include file="header.jsp" %>
    </head>
    <body>
        <%@ include file="menu.jsp" %>
        <div class="container col-md-8 col-md-offset-2">
            <form method="post" action="CreationClient">
                <fieldset>
                    <legend>Création d'un nouveau client</legend>
                    <div class="form-group row">
                        <label for="nomClient" class="col-md-3 col-form-label">Nom de l'entreprise</label>
                        <div class="col-md-9">
                            <input type="text" id="nomClient" class="form-control" name="nomClient" value="" />
                        </div>
                    </div>

                    <div class="form-group row">

                        <label for="adresseClient" class="col-md-3 col-form-label">Adresse de l'entreprise</label>
                        <div class="col-md-9">
                            <input type="text" id="adresseClient" name="adresseClient" value="" placeholder="9754 Main Street, ..." class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group row">

                        <label for="adresseClient" class="col-md-3 col-form-label">Complément d'adresse</label>
                        <div class="col-md-9">
                            <input type="text" id="adresseClient2" name="adresseClient2" value="" placeholder="Floor 4, ...." class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group row">

                        <label for="villeClient" class="col-md-3 col-form-label">Ville</label>
                        <div class="col-md-9">
                            <input type="text" id="villeClient" name="villeClient" value="" class="form-control"/>
                        </div>
                    </div>

                    <div class="form-group row">

                        <label for="codePostal" class="col-md-3 col-form-label">Code Postal</label>
                        <div class="col-md-9">
                            <input type="number" id="codePostal" name="codePostal" value="" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group row">
                    <label for="etat" class="col-md-3 col-form-label">Abrévation de l'Etat</label>
                    <div class="col-md-9">
                        <input type="text" id="etat" name="etat" value="" placeholder="TX, FL, ..." class="form-control"/>
                    </div>
                    </div>
                    <div class="form-group row">
                        <label for="faxClient" class="col-md-3 col-form-label">Numéro de fax</label>
                        <div class="col-md-9">
                            <input type="text" id="faxClient" name="faxClient" value="" class="form-control"/>
                        </div>
                    </div>
                    <div class="form-group row">
                    <label for="telephoneClient" class="col-md-3 col-form-label">Numéro de téléphone</label>
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
                    <div class="form-group row">
                    <label for="credit" class="col-md-3 col-form-label">Crédit limite</label>
                    <div class="col-md-9">
                        <input type="text" id="credit" name="credit" value="" class="form-control"/>
                    </div>
                    </div>
                    <div class="form-group row">
                    <label for="discountcode" class="col-md-3 col-form-label">Avez-vous un code de réduction ?</label>
                    <div class="col-md-9">
                        <select name="discount_code">
                            <option value="N">Non</option>
                            <option value="H">High</option>
                            <option value="M">Medium</option>
                            <option value="L">Low</option>
                        </select>
                    </div>
                    </div>
                </fieldset>
                <input type="submit" class="btn btn-primary" value="Valider" />
                <input type="reset" class="btn btn-warning" value="Remettre à zéro" /> <br />
            </form>
        </div>
    </body>
</html>
