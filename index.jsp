<%-- 
    Document   : index
    Created on : 10 janv. 2023, 13:21:05
    Author     : itu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- <!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Garage</title>
    </head>
    <body>
        <a href="ServeInsertEmploye">Insérer employe</a>
        <a href="insert-client.jsp">Nouveau Client</a>
        <br>
        <a href="ListeClient">Liste clients</a>
        <a href="ListeVehicule">Liste vehicule</a>
        <a href="ListeEmploye">Liste employes</a>
        <br>
        <a href="ListeService">Devis des services</a>
        <a href="ServeProduit">PRODUITS</a>
    </body>
</html> --%>

<%
    response.sendRedirect("ListeService");
%>
