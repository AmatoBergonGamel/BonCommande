
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <div class=row">
            <div class="col-md-4 col-md-offset-2"> 
                <form method="post" action="creationCommande">
                    <fieldset>
                        <legend>Informations client</legend>
                        <div class="form-group row">
                            <label for="nomClient" class="col-md-3 col-form-label">Nom <span class="requis">*</span></label>
                            <div class="col-md-9">
                                <input type="text" class="form-control" id="nomClient" name="nomClient" value=""/>
                            </div>
                            <br />
                        </div>
                        <div class="form-group row">
                            <label for="prenomClient" class="col-md-3 col-form-label">Prénom </label>
                            <div class="col-md-9">
                                <input type="text" class="form-control" id="prenomClient" name="prenomClient" value="" />
                            </div>
                            <br />
                        </div>
                        <div class="form-group row">
                            <label for="adresseClient" class="col-md-3 col-form-label">Adresse de livraison <span class="requis">*</span></label>
                            <div class="col-md-9">
                                <input type="text" class="form-control" id="adresseClient" name="adresseClient" value=""/>
                            </div>
                            <br />
                        </div>
                        <div class="form-group row">
                            <label for="telephoneClient" class="col-md-3 col-form-label">Numéro de téléphone <span class="requis">*</span></label>
                            <div class="col-md-9">
                                <input type="text" class="form-control" id="telephoneClient" name="telephoneClient" value=""/>
                            </div>
                            <br />
                        </div>
                        <div class="form-group row">
                            <label for="emailClient" class="col-md-3 col-form-label">Adresse email</label>
                            <div class="col-md-9">
                                <input type="email" class="form-control" id="emailClient" name="emailClient" value=""/>
                            </div>
                            <br />
                        </div>
                    </fieldset>
            </div>
            <div class="col-md-4"> 
                <fieldset>
                    <legend>Informations commande</legend>
                    <div class="form-group row">
                        <label for="dateCommande" class="col-md-3 col-form-label">Date <span class="requis">*</span></label>
                        <div class="col-md-9">
                            <input type="date" class="form-control" id="dateCommande" name="dateCommande" value=""/>
                        </div>
                        <br />
                    </div>
                    <div class="form-group row">
                        <label for="montantCommande" class="col-md-3 col-form-label">Montant <span class="requis">*</span></label>
                        <div class="col-md-9">
                            <input type="number" id="montantCommande" name="montantCommande" value="" class="form-control" />
                        </div>
                        <br />
                    </div>
                    <div class="form-group row">
                        <label for="modePaiementCommande" class="col-md-3 col-form-label">Mode de paiement <span class="requis">*</span></label>
                        <div class="col-md-9">
                            <input type="text" id="modePaiementCommande" name="modePaiementCommande" value="" class="form-control" />
                        </div>
                        <br />
                    </div>
                    <div class="form-group row">
                        <label for="statutPaiementCommande" class="col-md-3 col-form-label">Statut du paiement</label>
                        <div class="col-md-9">
                            <input type="text" id="statutPaiementCommande" name="statutPaiementCommande" value="" class="form-control" />
                        </div>
                        <br />
                    </div>
                    <div class="form-group row">
                        <label for="modeLivraisonCommande" class="col-md-3 col-form-label">Mode de livraison <span class="requis">*</span></label>
                        <div class="col-md-9">
                            <input type="text" id="modeLivraisonCommande" name="modeLivraisonCommande" value="" class="form-control" />
                        </div>
                        <br />
                    </div>
                    <div class="form-group row">
                        <label for="statutLivraisonCommande" class="col-md-3 col-form-label">Statut de la livraison</label>
                        <div class="col-md-9">
                            <input type="text" id="statutLivraisonCommande" name="statutLivraisonCommande" value="" class="form-control"/>
                        </div>
                        <br />
                    </div>
                </fieldset>
            </div>
            <div  class="col-md-8 col-md-offset-2">
                <input type="submit" class="btn btn-primary" value="Valider"  />
                <input type="reset" class="btn btn-warning" value="Remettre à zéro" /> <br />
            </div>
                </form>
          
        </div>
    </body>
</html>
