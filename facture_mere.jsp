<%-- 
    Document   : facture_mere
    Created on : 1 févr. 2023, 22:19:29
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
    <%@page import="java.util.Vector, model.Facture_mere_client" %>
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
            <th  style="width: 150px; background-color: rgb(157, 202, 202);">Client</th>
            <th style="background-color: rgb(157, 202, 202);">Date</th>
            <th style="background-color: rgb(157, 202, 202);">Détails</th>
        </tr>
        <% 
                if(request.getAttribute("factures") != null) {
                    Vector<Facture_mere_client> factures = (Vector<Facture_mere_client>)request.getAttribute("factures");
                    
                %>
                        <% for(Facture_mere_client f : factures) {%>
                                <tr>
                            
                                    <td><% out.print(f.getNom() + " " + f.getPrenom()); %></td>
                                    <td><% out.print(f.getDates()); %></td>
                                    <td>
                                        <a href="ServeDetailsFacture?idfacture=<% out.print(f.getIdfacturemere()); %>&&idclient=<% out.print( f.getIdclient() ); %>">Détails</a>
                                    </td>
                                
                               </tr>
                        <% } %>
            <% } %>
    
    </table>

<div id="footer">

</div>    
</body>
</html>

