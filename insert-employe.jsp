<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assets/css/insertEmp.css">
    <title>Nouveau employé</title>
</head>
<body>
    <%@page import="model.Genre, model.NiveauEtude, java.util.Vector"%>
    
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
            if(request.getAttribute("genres") != null && request.getAttribute("niveaux") != null) {
                Vector<Genre> genres = (Vector<Genre>)request.getAttribute("genres");
                Vector<NiveauEtude> niveaux = (Vector<NiveauEtude>)request.getAttribute("niveaux");
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
                            Insertion Nouveau Employe
                        </h1>
                    </div>
                    <div id="formulaire">
                        <form action="InsertServlet" method="post">
                            <div>
                                <label for="nom">Nom: </label>
                                <input type="text" name="nom" id="" required>
                            </div>
                            <div>
                                <label for="prenom">Prenom: </label>
                                <input type="text" name="prenom" id="" required>     
                            </div>
                            <div id="genre">
                                <label for="genre">Genre: </label> 
                                <select name="genre">
                                    <% for(Genre g : genres) {  %>
                                        <option value="<% out.print(g.getIdgenre()); %>"><% out.print(g.getNom()); %></option>
                                    <% } %>   
                                </select>
                            </div>
                            <div>
                                <label for="date_naissance">Date de naissance: </label>
                                <input type="date" name="date_naissance" id="">  
                            </div>
                            <div> 
                                <label for="niveau">Niveau d'�tude</label>
                                <select id="niveau" name="niveau">
                                    <% for(NiveauEtude n : niveaux) {  %>
                                        <option value="<% out.print(n.getIdniveauetude()); %>"><% out.print(n.getNiveauEtude()); %></option>
                                    <% } %>     
                                </select>    
                            </div>    
                            <div id="submit">
                                <input type="submit" value="Valider">
                                <% if(request.getAttribute("error") != null) { 
                                    if((Integer)request.getAttribute("error") == 3) { %>
                                        <p color="red">Vous êtes trop jeune</p>
                                    <% } %>
                                <% } %>
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