<%-- 
    Document   : insert-service
    Created on : 31 janv. 2023, 15:13:11
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
    <title>Nouveaux services</title>
</head>
<body>
    <%@page import="model.Service, java.util.Vector"%>
    
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
        <%
            if(request.getAttribute("typeServices") != null && request.getAttribute("idclient") != null) {
                Vector<Service> typeServices = (Vector<Service>)request.getAttribute("typeServices");
                int idclient = ((Integer)request.getAttribute("idclient")).intValue();
            %> 
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
                            Demander des services
                        </h1>
                    </div>
                    <div id="formulaire">
                        <form action="BackInsertService" method="post">
                            <div id="client">
                                <input type="hidden" name="idclient" value="<% out.print(idclient); %>" >  
                            </div>
                            <% for(Service s : typeServices) { %>
                                <div id="service">
                                    <label for="service"><% out.print(s.getType_service()); %></label> 
                                    <input type="hidden" name="service" value="<% out.print(s.getIdtypeservice()); %>">
                                    <input type="number" name="quantite" value="0">
                                    <input type="hidden" name="prix" value="<% out.print(s.getPrixDeVente()); %>">
                                    <%-- <label for="remise">Remise</label> 
                                    <input type="text" name="remise" value="0"> --%>
                                </div>
                                <%-- <div id="quantite">
                                </div> --%>
                            <% } %>
                            <div id="submit">
                                <input type="submit" value="Valider">
                            </div>
                        </form>
                    </div>
                </div>
            <% } else {
                // erreur 
                if(request.getAttribute("sqlError") != null) { %>
                    <p>Erreur liée au serveur. Impossible de charger les donnees.</p>     
                <% }
                else if (request.getAttribute("error") != null) { %>
                    <p>Erreur interne au serveur</p>     
                <% }
            } %>
    </div>
</body>
</html>
