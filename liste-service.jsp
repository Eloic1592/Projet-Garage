<%-- 
    Document   : liste-service
    Created on : 19 janv. 2023, 19:02:46
    Author     : Mialisoa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css/devis.css">
    <title>Charge des services</title>
</head>
<body>
<%@page import="model.Service, java.util.Vector"%>
<%
    Vector<Service> services = (Vector<Service>)request.getAttribute("services");
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
        <th  style="width: 150px; background-color: rgb(157, 202, 202);">Service</th>
        <th style="background-color: rgb(157, 202, 202);">Charge salariale</th>
        <th style="background-color: rgb(157, 202, 202);">Charge matérielle</th>
        <th style="background-color: rgb(157, 202, 202);">Marge bénéficiaire</th>
        <th style="background-color: rgb(157, 202, 202);">Bénéfice</th>
    </tr>
    <% for(Service s : services) { %>
        <tr>
            <td><% out.print(s.getType_service()); %></td>  
            <td><% out.print(s.getMontant_service()); %></td>
            <td><% out.print(s.getMontant_produit()); %></td>  
            <td><% out.print(s.getMarge_beneficiaire()); %></td>  
            <td><% out.print(s.getBenefice()); %></td> 
            <td><a href="SingleServiceDevis?idService=<% out.print(s.getIdtypeservice()); %>">Détails</a></td>
        <tr>
    <% } %>
    </table>
<div id="footer">

</div>    
</body>
</html>
