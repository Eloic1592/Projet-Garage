<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css/devis.css">
    <title>Liste des véhicules</title>
</head>
<%@page import="model.Liste_vehicule, java.util.Vector"%>
<%
    Vector<Liste_vehicule> vehicules = (Vector<Liste_vehicule>)request.getAttribute("vehicules");
%>
<header>
    <div id="nav">
        <ul>
            <li style="margin-right: 300px;">
                <a href="ServeCaisse">GARAGE</a>
            </li>
            <li><a href="ListeClient">CLIENTS</a></li>
            <li><a href="ListeEmploye">EMPLOYE</a></li>
            <li><a href="ListeService">SERVICE</a></li>
            <li><a href="ServeProduit">PRODUITS</a></li>
            <li><a href="ServeInsertDepense">DEPENSES</a></li>
            <li><a href="insert-report.jsp">Report</a></li>
        </ul>
    </div>
</header>
<body>
    <div id="ambony">
        <div class="logo"></div>
            <img src="assets/img/logo2.jpeg" alt="img" width="100px" height="90px">
        </div>
        <div class="titre">
            <h1>Auto Repair Invoice</h1>
        </div>
    </div>
    <table border="1">
    <tr>
        <th>NOM ET PRENOM</th>
        <th>IMMATRICULATION</th>
        <th>MARQUE</th>
        <th>MODELE</th>
    </tr>
    <% for(Liste_vehicule vehicule : vehicules) { %>
        <tr>
            <td><% out.print(vehicule.getNom()); %> <% out.print(vehicule.getPrenom()); %></td>
            <td><% out.print(vehicule.getImmatriculation()); %></td>
            <td><% out.print(vehicule.getMarque()); %></td>
            <td><% out.print(vehicule.getModele()); %></td>
        <tr>
    <% } %>
    </table>
<div id="footer">

</div>
</body>
</html>
