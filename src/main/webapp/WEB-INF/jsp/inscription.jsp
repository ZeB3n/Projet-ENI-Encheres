<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
</head>
<body>
	<h1>INSCRIPTION</h1>
		<a href="<%=request.getContextPath()%>/ServletGestionConnexion"><button type="submit" formmethod="post">Créer un compte</button></a>
		<a href="<%=request.getContextPath()%>/Accueil"><button type="submit">Annuler</button></a>
</body>
</html>