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
	<br>
	Identifiant : 
	<br>
	Mot de passe : 
		<a href="<%=request.getContextPath()%>/ServletGestionConnexion"><button type="submit" formmethod="post">Connexion</button></a>
		<a href="<%=request.getContextPath()%>/ServletInscription"><button type="submit" formmethod="get">Créer un compte</button></a>
</body>
</html>