<%@page import="beans.Utilisateur"%>
<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

	<%@include file="header.jsp"%>
	<h1>Liste des utilisateurs :</h1>
	<c:choose>
		<c:when test="${empty utilisateurs }">
			<h2>La liste des utilisateurs est vide</h2>
		</c:when>
		<c:otherwise>
			<table class="table">
				<tr>
					<th>Id</th><th>Prenom</th><th>Nom</th><th>Login</th><th>Password</th><th>Actions</th>
				</tr>
				<c:forEach var="utilisateur" items="${utilisateurs }">
						<tr>
							<td><c:out value="${utilisateur.id}"/></td>
							<td><c:out value="${utilisateur.prenom}"/></td>
							<td><c:out value="${utilisateur.nom}"/></td>
							<td><c:out value="${utilisateur.login}"/></td>
							<td><c:out value="${utilisateur.password}"/></td>
							<td><a href="update?id=${utilisateur.id}"><button class="btn btn-warning">Modifier</button></a><a href="delete?id=${utilisateur.id}"><button class="btn btn-danger" style="margin-left: 10px" onclick="return confirm('Vous etes sur de vouloir supprimer?')">Supprimer</button></a></td>
						</tr>	
				</c:forEach>
				</table>
				<a href="add"><button class="btn btn-success add-button">Ajouter un utilisateur</button></a>
		</c:otherwise>
	</c:choose>
				
</body>
</html>