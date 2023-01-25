<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="style.css">

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fiche Produit</title>
</head>
<body>



<div id="content">

  <h3>Modifier Produit ${produit.id}</h3>
  <form action="produit" method="post">
  <input type="hidden" name="id" value="${produit.id}">
  Prix :<input value="${produit.prix}" name="prix" type="number" min="0" step="0.01" placeholder="Saisir prix"><br>
  Stock :<input value="${produit.stock}" name="stock" type="number" min="0" step="1" placeholder="Saisir stock"><br>
  Libelle :<input value="${produit.libelle}" name="libelle" type="text" placeholder="Saisir libellé"><br>
   
    <input class ="btn btn-warning" type="submit" value="Modifier">
    <a href="produit"><input type="button" class ="btn btn-info" value="Retour"></a>
  </form>
</div>

</body>
</html>