<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css/insertEmp.css">
    <title>Demander service</title>
</head>
<body>
    <%@page import="java.util.Vector, model.Type_service, model.Vehicule_client" %>
    <%
        int error = 1;
        Vector<Vehicule_client> vehicules = null;
        Vector<Type_service> services = null;
        int client = 0;
        if(request.getAttribute("vehicules") != null && request.getAttribute("services") != null && request.getAttribute("client") != null) {
            vehicules = (Vector<Vehicule_client>)request.getAttribute("vehicules");
            services = (Vector<Type_service>)request.getAttribute("services");
            client = ((Integer)request.getAttribute("client")).intValue();
            error = 0;
        }
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
        <% if(error == 0) { %>
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
                        Service
                    </h1>
                </div>
                <div id="formulaire">
                    <form action="InsertService" method="post">
                        <div>
                            <input type="hidden" name="client" value="<% out.print(client); %>" required>
                        </div>
                        <div>
                            <label for="vehicule">Vehicule: </label>
                            <select name="vehicule">
                                <% for(Vehicule_client vehicule : vehicules) { %>
                                    <option value="<% out.print(vehicule.getIdvehiculeclient()); %>"><% out.print(vehicule.getImmatriculation()); %></option>
                                <% } %>
                            </select>      
                        
                        </div>
                        <div>
                            <label for="service">Service: </label>
                            <select name="service">
                                <% for(Type_service service : services) { %>
                                    <option value="<% out.print(service.getIdtypeservice()); %>"><% out.print(service.getType_service()); %></option>
                                <% } %> 
                            </select>     
                        </div>
                        <div>
                            <label for="">Libelle: </label>
                            <input type="text" name="libelle" >     
                        </div> 
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