<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="style.css">

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modification Filieres</title>
</head>
<body>



<div id="content">

  <h3>Modifier Filiere ${filiere.id}</h3>
  <form action="filiere" method="post">
  <input type="hidden" name="id" value="${filiere.id}">
    Libelle :<input value="${filiere.libelle}" name="libelle" type="text" placeholder="Saisir le libelle"><br>
    Debut :<input value="${filiere.debut}" name="debut" type="date" placeholder="Saisir la date de debut"><br>
    Fin :<input value="${filiere.fin}" name="fin" type="date" placeholder="Saisir la date de fin"><br>

    <input class ="btn btn-warning" type="submit" value="Modifier">
    <a href="filieres"><input type="button" class ="btn btn-info" value="Retour"></a>
  </form>
</div>

</body>
</html>