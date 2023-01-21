<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="style.css">

    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion Matière</title>
</head>
<body>



<div id="content">
<h1>Liste des Matières</h1>
		<input id="btnAddMatiere" type="button" class ="btn btn-success" value="Ajouter">
     <a href="index.html"><input type="button" class ="btn btn-info" value="Retour"></a>

     <table class="table table-striped">
       <thead>
         <tr>
           <th>Id</th>
           <th>Libelle</th>
           <th>Quest</th>
           <th>Actions</th>
           </tr>
       </thead>
       <tbody>
       <c:forEach items="${matieres}" var="matiere">
       	<tr>
           <td>${matiere.id}</td>
           <td>${matiere.libelle}</td>
           <td>${matiere.quest}</td>
           <td>
             <a href="matiere?id=${matiere.id}"><input type="button" class ="btn btn-warning" value="Modifier"></a>
             <a href="matiere?id=${matiere.id}&delete"><input type="button" class ="btn btn-danger" value="Supprimer"></a>
           </td>
         </tr>
       </c:forEach>
         
       </tbody>
     </table>





     <div id="addFormMatiere" class="formAjout">
            <h3>Ajouter Matiere</h3>
            <form action="matiere" method="post">
            Libelle :<input name="libelle" type="text" placeholder="Saisir le libelle"><br>
            Code Quest :<input name="quest" type="number" placeholder="Saisir le code Quest"><br>
            <input class ="btn btn-success" type="submit" value="Ajouter">
            </form>
        </div>

</div>


</body>
</html>


<script>

btnAddMatiere.onclick=function()
{
  addFormMatiere.style.display="block";
}

</script>