<%-- 
    Document   : prix-produit
    Created on : 26 janv. 2023, 15:32:37
    Author     : Mialisoa
--%>
<%-- 
    Document   : prix-produit
    Created on : 26 janv. 2023, 15:32:37
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
    <title>Prix conseillé produit</title>
</head>
<%@page import="model.Produit, java.util.Vector"%>
<%
    Produit produit = (Produit)request.getAttribute("produit");
    Double prixConseille = (Double)request.getAttribute("prix");
    Double benefice = (Double)request.getAttribute("benefice");
    Double marge = (Double)request.getAttribute("marge");
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
            <th  style="width: 150px; background-color: rgb(157, 202, 202);">Produit</th>
            <th style="background-color: rgb(157, 202, 202);">Prix d'achat</th>
        </tr>
        <tr>
            <td><% out.print(produit.getNomproduit()); %></td>
            <td><% out.print(produit.getPrix()); %></td>
        </tr>
    </table>

    <table border="1">
        <tr>
            <th  style="width: 150px; background-color: rgb(157, 202, 202);">Produit</th>
            <th style="background-color: rgb(157, 202, 202);">Prix conseillé</th>
        </tr>
        <tr>
            <td><% out.print(produit.getNomproduit()); %></td>
            <td><% out.print(prixConseille.doubleValue()); %></td>
        </tr>
    </table>

    <table border="1">
        <tr>
            <th  style="width: 150px; background-color: rgb(157, 202, 202);">Produit</th>
            <th style="background-color: rgb(157, 202, 202);">Bénéfice</th>
            <th style="background-color: rgb(157, 202, 202);">Marge bénéficiaire</th>
        </tr>
        <tr>
            <td><% out.print(produit.getNomproduit()); %></td>
            <td><% out.print(benefice.doubleValue()); %></td>
            <td><% out.print(marge.doubleValue()); %>%</td>
        </tr>
    </table>

    <div id="footer">

    </div>
</body>
</html>

