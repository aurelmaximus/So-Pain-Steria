<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="style.css">

    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des produits</title>
</head>
<body>



<div id="content">
<h1>Liste des Produits</h1>
     <input id="btnAddStagiaire" type="button" class ="btn btn-success" value="Ajouter">
     <a href="index.html"><input type="button" class ="btn btn-info" value="Retour"></a>

     <table class="table table-striped">
       <thead>
         <tr>
           <th>Id</th>
           <th>Prix</th>
           <th>Stock</th>
           <th>Libelle</th>
           <th>Actions</th>
           </tr>
       </thead>
       <tbody>
       <c:forEach items="${stagiaires}" var="stagiaire">
       	<tr>
           <td>${stagiaire.id}</td>
           <td>${stagiaire.nom}</td>
           <td>${stagiaire.prenom}</td>
           <td>${stagiaire.email}</td>
           <td>
             <a href="produit?id=${produit.id}"><input type="button" class ="btn btn-warning" value="Modifier"></a>
             <a href="produit?id=${produit.id}&delete"><input type="button" class ="btn btn-danger" value="Supprimer"></a>
           </td>
         </tr>
       </c:forEach>
         
       </tbody>
     </table>





     <div id="addFormProduit" class="formAjout">
            <h3>Ajouter Produit</h3>
            <form action="produit" method="post">
            Prix :<input name="prix" type="number" min="0" step="0.01" placeholder="Saisir prix"><br>
            Stock initial :<input name="stock" type="number" min="0" step="1" placeholder="Saisir stock"><br>
            Libelle :<input name="libelle" type="text" placeholder="Saisir libellé"><br>
 
              <input class ="btn btn-success" type="submit" value="Ajouter">
            </form>
        </div>

</div>


</body>
</html>


<script>

btnAddProduit.onclick=function()
{
  addFormProduit.style.display="block";
}

</script>