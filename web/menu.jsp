<%-- 
    Document   : menu
    Created on : 27 nov. 2020, 12:35:05
    Author     : sio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Interface</title>
        <link rel="stylesheet" type="text/css" href="styles.css"/>
    </head>
    
    <body>
        <h1>Bienvenue sur l'interface de l'application</h1>
        <a href="Controleur?action=listedepartements">
            <button name="menu" value="listedepartement">Liste des medecins par departement</button>
        </a>
        <a href="Controleur?action=listespecialite"><button name="menu" value="listespecialite">Recherche par specialite</button></a>
        <a href="Controleur?action=listenom"><button name="menu" value="listenom">Recherche par nom</button></a>
    </body>
</html>
