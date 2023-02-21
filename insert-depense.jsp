<%-- 
    Document   : insert-depense
    Created on : 9 févr. 2023, 12:30:27
    Author     : Mialisoa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css/insertEmp.css">
    <title>Garage</title>
</head>
    <%@page import="model.Type_depense, java.util.Vector"%>
    <%
        Vector<Type_depense> types = (Vector<Type_depense>)request.getAttribute("types");
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
            <li><a href="ServeInsertDepense">DEPENSES</a></li>
            <li><a href="insert-report.jsp">Report</a></li>
        </ul>
    </div>
</header>
<body>
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
                Enregistrer une depense
            </h1>
        </div>
        <div id="formulaire">
            <form action="InsertDepense" method="post">
                <div>
                    <label for="type">Type de dépense</label>
                    <select name="type" >
                        <% for(Type_depense type : types) { %>
                            <option value="<% out.print(type.getIdtypedepense()); %>"><% out.print(type.getType_depense()); %></option>
                        <% } %>
                    </select>
                </div>
                <div>
                    <label for="designation">Designation </label>
                    <input type="text" name="designation" required>
                </div>
                <div>
                    <label for="prix">Montant </label>
                    <input type="text" name="prix" required>     
                </div>
                <div>
                    <label for="date">Date </label>
                    <input type="date" name="date" required>     
                </div>
                <div id="submit">
                    <input type="submit" value="Valider">
                </div>
            </form>
        </div>
        <a href="ServeCaisse">Etat de la caisse</a>
    </div>
</div>
</body>
</html>