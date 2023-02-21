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
            <li style="margin-right: 350px;">GARAGE</li>
            <li><a href="ListeClient">CLIENTS</a></li>
            <li><a href="ListeEmploye">EMPLOYE</a></li>
            <li><a href="ListeService">SERVICE</a></li>
            <li><a href="ServeInsertDepense">DEPENSES</a></li>
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
                Insertion Nouveau client
            </h1>
        </div>
        <div id="formulaire">
            <form action="InsertClient" method="post">
                <div>
                    <label for="">Nom: </label>
                    <input type="text" name="nom" id="" required>
                </div>
                <div>
                    <label for="">Prenom: </label>
                    <input type="text" name="prenom" id="" required>     
                </div>
                <div>
                    <label for="">Contact: </label>
                    <input type="text" name="contact" id="" required>     
                </div>
                <div>
                    <label for="">Email: </label>
                    <input style="width: 200px;" type="email" name="email" id="" required>     
                </div>

                <div>
                    <label for="">Adresse: </label>
                    <input type="text" name="adresse" id="">  
                </div>

                <div>
                    <label for="">Date de naissance: </label>
                    <input type="date" name="dtn" id="">  
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