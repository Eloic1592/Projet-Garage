<%-- 
    Document   : facture.jsp
    Created on : 31 janv. 2023, 15:49:08
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
    <title>Facture</title>
</head>
<body>
<%
    Float entree = (Float)request.getAttribute("entree");
    Float sortie = (Float)request.getAttribute("sortie");
    Float reste = (Float)request.getAttribute("reste");
    Double report = (Double)request.getAttribute("report");


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
        <th  style="width: 150px; background-color: rgb(157, 202, 202);">Gains</th>
        <th style="background-color: rgb(157, 202, 202);">Dépense</th>
        <th style="background-color: rgb(157, 202, 202);">Reste Aujourd'hui</th>
        <th style="background-color: rgb(157, 202, 202);">Report hier</th>
    </tr>
    <tr>
        <td><% out.print(entree); %></td>
        <td><% out.print(sortie); %></td>
        <td><% out.print(reste); %></td>
        <td><% out.print(report); %></td>

    </tr>
    
    

    </table>
    <a href="insert-report.jsp">Report</a>
    
    <div>
        Reste en caisse 
        <% out.print(report + reste); %>
    </div>

<div id="footer">

</div>    
</body>
</html>
