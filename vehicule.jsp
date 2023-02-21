<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css/insertEmp.css">
    <title>Ajouter véhicule</title>
</head>
<body>
    <%@page import ="model.*, java.util.Vector" %>    
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
            //out.print("Hehe");
            if(request.getAttribute("marques") != null && request.getAttribute("modeles") != null && request.getAttribute("types") != null && request.getAttribute("client") != null) { 
                Vector<Marque> marques = (Vector<Marque>) request.getAttribute("marques");
                Vector<Modele> modeles = (Vector<Modele>) request.getAttribute("modeles");
                Vector<Vehicule> types = (Vector<Vehicule>) request.getAttribute("types");
                int client = ((Integer)request.getAttribute("client")).intValue();    
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
                            Insertion Nouveau véhicule
                        </h1>
                    </div>
                    <div id="formulaire">
                        <form action="InsertVehicule" method="post">

                            <label for="marque">Marque: </label> 
                            <select name="marque">
                                <% for(Marque marque : marques) { %>
                                    <option value="<% out.print(marque.getId()); %>"><% out.print(marque.getMarque()); %></option>
                                <% } %>
                            </select>
                        
                            <p><label for="modele">Modele: </label> 
                            <select name="modele">
                                <% for(Modele modele : modeles) { %>
                                    <option value="<% out.print(modele.getId()); %>"><% out.print(modele.getMarque()); %></option>
                                <% } %> 
                            </select></p>

                            <div>
                                <label for="immatriculation">Immatriculation: </label>
                                <input type="text" name="immatriculation" required>     
                            </div>
                            <div>
                                <label for="vehicule">Vehicule: </label>
                                <select name="vehicule">
                                    <% for(Vehicule type : types) { %>
                                        <option value="<% out.print(type.getIdvehicule()); %>"><% out.print(type.getTypevehicule()); %></option>
                                    <% } %> 
                                </select>   
                            </div>

                            <div>
                                <input type="hidden" name="client" value="<% out.print(client); %>" >  
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
                else {
                    out.print("erreur tsy haiko");
                }
            } %>
    </div>
</body>
</html>