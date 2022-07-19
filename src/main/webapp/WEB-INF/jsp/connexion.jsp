<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
</head>
<body>
	<h1>CONNEXION</h1>
	<form action="">
	Identifiant : 
	<input type="text" id="pseudo" id="email" name="pseudo" name="email">
	<br>
	Mot de passe : 
	<input type="password" id="mot_de_passe" name="mot_de_passe">
	<br>
		<a href="<%=request.getContextPath()%>/ServletGestionConnexion"><button type="submit" formmethod="post">Connexion</button></a>
		<br>
		<a href="<%=request.getContextPath()%>/ServletInscription"><button type="submit" formmethod="get">Créer un compte</button></a>
	</form>
	
	<h2> ---- TEST ---- </h2>
</body>
</html>
