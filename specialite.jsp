<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css/insertEmp.css">
    <title>Spécialité d'un employé</title>
</head>
<body>

    <%@ page import="java.util.Vector, model.Specialite" %>
    <% 
        Integer id = (Integer)request.getSession().getAttribute("id");
        Vector<Specialite> specialites = new Specialite().getAll(null);
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
                <h3>Employer garage</h3>
            </div>
            <div id="formulaire">
                <form action="InsertSpecialite" method="post">
                    <div>
                        <input type="hidden" name="id"  value="<% out.print(id.intValue()); %>">
                    </div>
                    <div>
                        <label for="specialite">Specialite: </label>
                        <select  name="specialite">
                            <% for(Specialite s : specialites) {  %>
                                <option value="<% out.print(s.getIdspecialite()); %>"><% out.print(s.getNomSpecialite()); %></option>
                            <% } %>  
                        </select>
                    </div>
                    <div id="submit">
                        <input type="submit" value="Valider">
                        <a href="insert-employe.jsp">
                            <button><a href="index.jsp">Accueil</a></button>
                        </a>
                    </div>
                </form>
            </div>            
        </div>
    </div>
</body>
</html>