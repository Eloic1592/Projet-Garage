<%-- 
    Document   : insert-report
    Created on : 9 févr. 2023, 15:06:39
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
                Enregistrer un report
            </h1>
        </div>
        <div id="formulaire">
            <form action="InsertReport" method="post">
                <div>
                    <label for="date">Date</label>
                    <input type="date" name="date" required>     
                </div>
                <div>
                    <label for="prix">Montant </label>
                    <input type="text" name="prix" required>     
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
