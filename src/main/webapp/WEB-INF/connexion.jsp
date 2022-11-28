<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="/crud3/css/style.css">
<title>Insert title here</title>
</head>
<body>
	<h1>Page d'authentification</h1>
	<form method="post" class="row" style="margin-left: 10px">
		<fieldset class="col-9">
		<legend>Connexion</legend>
		<label class="form-label" for="login">Login</label>
		<input type="text" name="login" class="form-control">
		<label class="form-label" for="motDePasse">Mot de passe</label>
		<input type="password" name="motDePasse" class="form-control">
		<input type="submit" value="Se connecter" class="btn btn-success" style="margin-top: 10px">
		</fieldset>
	</form>
</body>
</html>