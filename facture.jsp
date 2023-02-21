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
<%@page import="model.Facture, java.util.Vector"%>
<%
    Vector<Facture> factures = (Vector<Facture>)request.getAttribute("factures");
    Double total = (Double)request.getAttribute("total");
    int idfacture = ((Integer)request.getAttribute("idfacture")).intValue(); 
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
        <th style="background-color: rgb(157, 202, 202);">Quantité</th>
        <th style="background-color: rgb(157, 202, 202);">Prix unitaire</th>
        <th style="background-color: rgb(157, 202, 202);">Total</th>
    </tr>
    <% for(Facture f : factures) { %>
        <tr>
            <td><% out.print(f.getNom()); %></td>
            <td><% out.print(f.getQuantite()); %></td>
            <td><% out.print(f.getPrix()); %></td>
            <td><% out.print(f.getTotal()); %></td>
        </tr>
    <%  } %>
    
    </table>
    <h3> Montant à payer: <% out.print(total.doubleValue()); %> </h3>
    <div>
        <h4>Montant payé: </h4>
        <h4>Reste à payer: </h4>
    </div>

    <div>
        <form action="" method="post">
            <input type="hidden" name="idfacture" value="<% out.print(idfacture); %>">
            <div class="input">
                <label for="montant">Montant</label>
                <input type="number" name="montant" value="0">
            </div>
            <div class="input">
                <input type="submit" value="Payer">
            </div>
        </form>
    </div>

<div id="footer">

</div>    
</body>
</html>
