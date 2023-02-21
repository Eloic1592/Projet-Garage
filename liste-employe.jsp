<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css/devis.css">
    <title>Liste des employés</title>
</head>
<%@page import="model.Liste_employe, java.util.Vector"%>
<%
    Vector<Liste_employe> employes = (Vector<Liste_employe>)request.getAttribute("employes");
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
    <div id="body" style="margin-left: 200px;">
    <table border="1"">
        <tr>
            <th  style="width: 150px;">NOM</th>
            <th>PRENOM</th>
            <th>GENRE</th>
            <th>SPECIALITE</th>
        </tr>
        <% for(Liste_employe employe : employes) { %>
            <tr>
                <td><% out.print(employe.getNom()); %></td>
                <td><% out.print(employe.getPrenom()); %></td>
                <td><% out.print(employe.getGenre()); %></td>
                <td><% out.print(employe.getNomspecialite()); %></td> 
            <tr>
        <% } %>
   </table>
    <div class="tools">
        <a href="ServeInsertEmploye">Nouvel employé</a>
    </div>
<div id="footer">

</div>
</div>
</body>
</html>