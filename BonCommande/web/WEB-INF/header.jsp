<%-- 
    Document   : header
    Created on : 1 nov. 2016, 08:24:49
    Author     : Anaïs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>

<!-- header de chaque fichier, a appelé dans chaque fichier !!!! -->
<title>Bon de commande</title>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- insertion de la feuille de style --> 
<link rel="stylesheet" href="../Style/style.css">

<!-- Insertion de bootstrap, pour le css -->
<script src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	
        <!-- On charge l'API Google -->
	<script type="text/javascript" src="https://www.google.com/jsapi"></script>
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
			var chart = new google.visualization.PieChart(document.getElementById('piechart'));
			chart.draw(data, options);
		}
                

		// Afficher les ventes par client
		function doAjax() {
			$.ajax({
				url: "salesByCustomer",
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
