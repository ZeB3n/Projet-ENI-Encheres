<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
<link type="text/css" rel="stylesheet" href="css/form.css" />
</head>
<header>
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
</header>
<body>
	<h1>ACCUEIL DE ENI-ENCHERES</h1>
		<a href="${pageContext.request.contextPath}/ServletConnexion"><button type="submit" formmethod="get">Connexion</button></a>
		<%-- Vérification de la présence d'un objet utilisateur en session --%>
	            <c:if test="${!empty sessionScope.sessionUtilisateur}">
	            <%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>
	            <p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionUtilisateur.email}</p>
	            </c:if>
</body>
<footer>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</footer>
</html>