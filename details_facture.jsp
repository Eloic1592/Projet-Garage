<%-- 
    Document   : details_facture
    Created on : 1 févr. 2023, 22:53:52
    Author     : Mialisoa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="assets/css/devis.css">
        <title>Détails facture</title>
    </head>
    <body>
        <%@page import="java.util.Vector, model.Details_facture_client" %>
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
        <h1>Détails de la Facture</h1>
        <% 
            if(request.getAttribute("factures") != null && request.getAttribute("reste") != null) {
            Vector<Details_facture_client> factures = (Vector<Details_facture_client>)request.getAttribute("factures");    
        %>
                <table border="1">
                    <tr>
                        <th  style="width: 150px; background-color: rgb(157, 202, 202);">Client</th>
                        <th style="background-color: rgb(157, 202, 202);">Service</th>
                        <th style="background-color: rgb(157, 202, 202);">Quantité</th>
                        <th style="background-color: rgb(157, 202, 202);">Prix unitaire</th>
                        <%-- <th style="background-color: rgb(157, 202, 202);">Remise</th> --%>
                        <th style="background-color: rgb(157, 202, 202);">Prix avec remise</th>
                        <th style="background-color: rgb(157, 202, 202);">Montant</th>
                    </tr>
                    <% for(Details_facture_client f : factures) {%>
                        <tr>
                            <td><% out.print(f.getNom() + " " + f.getPrenom()); %></td>
                            <td><% out.print(f.getType_service()); %></td>
                            <td><% out.print(f.getQuantite()); %></td>
                            <td><% out.print(f.getPrixunitaire()); %></td>
                            <td><% out.print(f.getPrixremise()); %></td>
                            <td><% out.print(f.getMontant()); %></td>
                        </tr>
                    <% } %>
                </table>
            <p>
                <% if(request.getAttribute("remise") != null) { %>
                    <h3>Remise sur le total : <% out.print(request.getAttribute("remise")); %> </h3>
                <% } %>
                <h3>Total : <% out.print(Details_facture_client.getTotal(factures)); %></h3>
                <h3>Reste : <% out.print( (Double)request.getAttribute("reste") ); %></h3>
            </p>
            <form action="Paiement" method="post">
                <input type="text" name="montant" value="0" min="0" max=10000 >
                <input type="hidden" name="idclient" value="<% out.print(request.getParameter("idclient")); %>">
                <input type="hidden" name="idfacture" value="<% out.print(request.getParameter("idfacture")); %>">
                <input type="date" name="date" >
                <input type="submit" value="Payer">
            </form>
            <div class="message">
                <% 
                    if(request.getParameter("error") != null) {
                        int error = Integer.parseInt(request.getParameter("error"));
                        if(error == 1) {
                            out.print("Erreur lié à la base de donnée du serveur");
                        } else if (error == 5) {
                            out.print("Montant invalide ou totalité de la facture déjà payée");
                        } else if(error == 10){
                            out.print("Erreur interne du serveur");
                        }
                    }
                %>
            </div>
        <% } %>
    </body>
</html>
