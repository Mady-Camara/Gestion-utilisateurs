<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@include file="header.jsp"%>
<h1>Ajouter un utilisateur :</h1>
<form method="post" class="row">
	<div class="col-9">
	<label for="prenom" class="form-label">Prenom de l'utilisateur : </label>
	<input type="text" name="prenom" class="form-control">
	<label for="nom" class="form-label">Nom de l'utilisateur : </label>
	<input type="text" name="nom" class="form-control">
	<label for="login" class="form-label">Login de l'utilisateur : </label>
	<input type="text" name="login" class="form-control">
	<label for="password" class="form-label">Mot de passe de l'utilisateur : </label>
	<input type="password" name="password" class="form-control">
	<input class="btn btn-success" type="submit" value="Valider">
	</div>
</form>
	<c:forEach var="message" items="${messages}">
		<p style="color: red">${message}</p>
	</c:forEach>
</body>
</html>