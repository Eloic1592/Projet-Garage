<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css/devis.css">
    <title>Liste des clients</title>
</head>
<%@page import="model.*, java.util.Vector"%>
<%
    Vector<Client> clients = (Vector<Client>)request.getAttribute("clients");
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
        <th  style="width: 150px; background-color: rgb(157, 202, 202);">NOM</th>
        <th style="background-color: rgb(157, 202, 202);">PRENOM</th>
        <th style="background-color: rgb(157, 202, 202);">Email</th>
        <th style="background-color: rgb(157, 202, 202);">Contact</th>
        <th style="background-color: rgb(157, 202, 202);">Date de naissance</th>
    </tr>
    <% for(Client client : clients) { %>
        <tr>
            <td><% out.print(client.getNom()); %></td>
            <td><% out.print(client.getPrenom()); %></td>
            <td><% out.print(client.getEmail()); %></td>
            <td><% out.print(client.getContact()); %></td>
            <td><% out.print(client.getDatenaissance()); %></td>
            <td style="background-color: rgb(67, 72, 85); text-align: center;"><a href="ServeInsertService?idclient=<% out.print(client.getIdclient()); %>" style="color: white;">BOUTON SERVICE</a></td>
            <td style="background-color: rgb(67, 72, 85); text-align: center;"><a href="ServeInsertVehicule?client=<% out.print(client.getIdclient()); %>" style="color: white;">nouveau vehicule</a></td>    
            <td style="background-color: rgb(67, 72, 85); text-align: center;"><a href="ListeVehicule?client=<% out.print(client.getIdclient()); %>" style="color: white;">Liste vehicules</a>  </td>
            <td style="background-color: rgb(67, 72, 85); text-align: center;"><a href="ServeListeFacture?idclient=<% out.print(client.getIdclient()); %>" style="color: white;">Facture</a> </td>  
        <tr>
    <% } %>
    </table>
    <div class="tools">
        <a href="insert-client.jsp" style="color: black;">Nouveau client</a>
    </div>
<div id="footer">

</div>
</body>
</html>