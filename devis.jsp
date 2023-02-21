<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css/devis.css">
    <title>Document</title>
</head>
<body>
<%@page import="model.Devis_service, model.Devis_produit, java.util.Vector"%>
<%
    Vector<Devis_service> services = (Vector<Devis_service>)request.getAttribute("service");
    Vector<Devis_produit> produits = (Vector<Devis_produit>)request.getAttribute("produit");
%>
<header>
    <div id="nav">
        <ul>
            <li style="margin-right: 350px;">GARAGE</li>
            <li><a href="ListeClient">CLIENTS</a></li>
            <li><a href="ListeEmploye">EMPLOYE</a></li>
            <li>DEPENSES</li>
            <li>DEPENSES</li>
            <li>DECONNEXION</li>
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
    <h2>Charge salariale</h2>
    <table border="1">
    <tr>
        <th  style="width: 150px; background-color: rgb(157, 202, 202);">Service</th>
        <th style="background-color: rgb(157, 202, 202);">Specialite</th>
        <th style="background-color: rgb(157, 202, 202);">Duree</th>
        <th style="background-color: rgb(157, 202, 202);">Salaire par heure</th>
        <th style="background-color: rgb(157, 202, 202);">Montant salaire</th>
    </tr>
    <% for(Devis_service s : services) { %>
        <tr>
            <td><% out.print(s.getType_service()); %></td>  
            <td><% out.print(s.getNomspecialite()); %></td>
            <td><% out.print(s.getDureetravail()); %></td>  
            <td><% out.print(s.getSalaire_par_heure()); %></td>  
            <td><% out.print(s.getPrix_salariale()); %></td> 
        <tr>
    <% } %>
    </table>

    <h3>Total : </h3>
    <%
        Double totalService = (Double)request.getAttribute("montantService");
        if(totalService != null) {
            out.print(totalService);
        }
        else {
            out.print("Erreur du serveur : impossible de collecter les données");
        }
    %>

    <h2>Charge materielle</h2>

    <table border="1">
    <tr>
        <th style="background-color: rgb(157, 202, 202);">Nom produit</th>
        <th style="background-color: rgb(157, 202, 202);">Prix unitaire</th>
        <th style="background-color: rgb(157, 202, 202);">Quantite</th>
        <th style="background-color: rgb(157, 202, 202);">Montant total</th>
    </tr>
    <% for(Devis_produit p : produits) { %>
        <tr>
            <td><% out.print(p.getNomproduit()); %></td>  
            <td><% out.print(p.getPrix()); %></td>
            <td><% out.print(p.getQuantite()); %></td>  
            <td><% out.print(p.getPrix_total_produit()); %></td>  
        <tr>
    <% } %>
    </table>

    <h3>Total : </h3>
    <%
        Double totalProduit = (Double)request.getAttribute("montantProduit");
        if(totalProduit != null) {
            out.print(totalProduit);
        }
        else {
            out.print("Erreur du serveur : impossible de collecter les données");
        }
    %>

    <h3>Prix du service</h3>
    <%
        Double total = (Double)request.getAttribute("total");
        if(total != null) {
            out.print(total);
        }
        else {
            out.print("Erreur du serveur : impossible de collecter les données");
        }
    %>
<div id="footer">

</div>    
</body>
</html>