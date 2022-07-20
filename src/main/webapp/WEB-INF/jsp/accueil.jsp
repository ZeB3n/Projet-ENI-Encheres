<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
</head>
<header>
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
</header>
<body>
	<h1>ACCUEIL</h1>
		<a href="<%=request.getContextPath()%>/ServletConnexion"><button type="submit" formmethod="get">Connexion</button></a>
</body>
<footer>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</footer>
</html>