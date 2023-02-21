<%-- 
    Document   : form-produit
    Created on : 26 janv. 2023, 15:18:11
    Author     : Mialisoa
--%>

<%-- 
    Document   : form-produit
    Created on : 26 janv. 2023, 15:18:11
    Author     : Mialisoa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Produit, java.util.Vector"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css/insertEmp.css">
    <title>Voir le prix conseillé d'un produit</title>
</head>
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
    <%
        Vector<Produit> produits = (Vector<Produit>)request.getAttribute("produits");
    %>
    <div id="body">
    <div id="sary">
        <!-- <div id="title">
            <h1>
                Inserer un employe
            </h1>
        </div> -->
    </div>
    <div id="content">
        <div id="title">
            <h1>
                Prix conseillé d'un produit
            </h1>
        </div>
        <div id="formulaire">
            <form action="PrixProduit" method="post">
                <div>
                    <label for="produit">Produit </label>
                    <select name="produit">
                        <% for(Produit p : produits) { %>
                            <option value="<% out.print(p.getIdProduit()); %>"><% out.print(p.getNomproduit()); %></option>
                        <% } %>
                    </select>
                </div>

                <div id="submit">
                        <input type="submit" value="Valider">
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>

