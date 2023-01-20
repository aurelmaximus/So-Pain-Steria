<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="style.css">

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fiche Ordinateur</title>
</head>
<body>



<div id="content">

  <h3>Modifier Ordinateur ${ordinateur.id} </h3>
            <form action="ordinateur" method="post">
            <input type="hidden" name="id" value="${ordinateur.id}">
            Marque :<input value="${ordinateur.marque}" name="marque" type="text" placeholder="Saisir la marque"><br>
            Ram :<input value="${ordinateur.ram}" min="2" step="2" name="ram" type="number" placeholder="Saisir la RAM"><br>
            Stagiaire :
            	<select name="stagiaire">
                  <c:forEach items="${stagiaires}" var="stagiaire">
                    	
              	<c:choose>
              	<c:when test="${stagiaire.id==ordinateur.stagiaire.id}">
              		<option selected value="${stagiaire.id}" >${stagiaire.id} - ${stagiaire.nom} ${stagiaire.prenom}</option>
              	</c:when>
              	
              	<c:otherwise>
              		<option value="${stagiaire.id}" >${stagiaire.id} - ${stagiaire.nom} ${stagiaire.prenom}</option>
              	
              	</c:otherwise>
              	</c:choose>
              
              </c:forEach>
            	  </select><br>
   


    <input class ="btn btn-warning" type="submit" value="Modifier">
    <a href="ordinateur"><input type="button" class ="btn btn-info" value="Retour"></a>
  </form>
</div>

</body>
</html>