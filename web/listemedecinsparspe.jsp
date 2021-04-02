<%-- 
    Document   : listemedecinspardep
    Created on : 18 mars 2021, 12:55:04
    Author     : sio
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="styles.css"/>
    </head>
    <body>
    <center>
        <div class="logo"><img src="logo.jpg"></div>
        <h1>Liste des médecins par specialite</h1>
        <table>
            <tr>
                <td>Nom</td>
                <td>Prenom</td>
                <td>Adresse</td>
                <td>Telephone</td>
                <td>Specialite</td>
            </tr>
            
        <c:forEach var="medecin" items="${medecins}">
             <tr>   
            <td>${medecin.nom}</td>
           <td>${medecin.prenom}</td>
           <td>${medecin.adresse}</td>
           <td>${medecin.tel}</td>
           <td>${medecin.spe}</td>
            </tr>
            
        </c:forEach>
           
    </table>
    </center>
        
        
    </body>
</html>
