<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="WEB-INF/header.jsp" %>
        
        <script type="text/javascript">
		google.load("visualization", "1", {packages: ["corechart"]});
                
		// Après le chargement de la page, on fait l'appel AJAX
		google.setOnLoadCallback(doAjax);
		
		function drawChart(dataArray) {
			var data = google.visualization.arrayToDataTable(dataArray);
			var options = {
				title: 'Ventes par client',
				//is3D: true,
                                pieHole: 0.5

			};
			var chart = new google.visualization.PieChart(document.getElementById('piechart2'));
			chart.draw(data, options);
		}
                 

		// Afficher les ventes par client
		function doAjax() {
			$.ajax({
				url: "productsByCustomer",
				dataType: "json",
				success: // La fonction qui traite les résultats
					function (result) {
						// On reformate le résultat comme un tableau
						var chartData = [];
						// On met le descriptif des données
						chartData.push(["Client", "Ventes"]);
						for(var client in result) {
							chartData.push([client, result[client]]);
						}
						// On dessine le graphique
						drawChart(chartData);
					}
				
			});
		}	

	
	</script>
    </head>
    <body>
        <%@ include file="WEB-INF/menu.jsp" %>
        <div class="row">
            <div class="col-md-8 col-md-offset-2">
                <h1>Nombre de ventes pour chaque client</h1>
               <!-- <a href='productsByCustomer' target="_blank">Voir les données brutes</a><br> -->
                <!-- Le graphique apparaît ici -->
                <div id="piechart2" style="width: 900px; height: 500px;"></div>
            </div>
            <div class="row">

                </body>
                </html>