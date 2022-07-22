<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
<link type="text/css" rel="stylesheet" href="css/form.css" />
</head>
<header>
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
</header>
<body>
	<h1>CONNEXION</h1>
	
	<form method="post" action="<%=request.getContextPath()%>/ServletGestionConnexion">
            <fieldset>
                <legend>Connexion</legend>
	                <p>Vous pouvez vous connecter via ce formulaire.</p>
	
	                <label for="nom">Identifiant : <span class="requis">*</span></label>
	                <input type="email" id="email" name="email" value="<c:out value="${utilisateur.email}"/>" size="20" maxlength="60" />
	                <span class="erreur">${form.erreurs['email']}</span>
					<br />
	
	                <label for="motdepasse">Mot de passe : <span class="requis">*</span></label>
	                <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
	                <span class="erreur">${form.erreurs['motdepasse']}</span>
					<br />
	
	                <input type="submit" value="Connexion" class="sansLabel" />
					<br />
	
	                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
	
	                <%-- Vérification de la présence d'un objet utilisateur en session --%>
	                <c:if test="${!empty sessionScope.sessionUtilisateur}">
	                <%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>
	                <p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionUtilisateur.email}</p>
                	</c:if>
            </fieldset>
        </form>
        <a href="<%=request.getContextPath()%>/ServletInscription"><button type="submit" formmethod="get">Créer un compte</button></a>
</body>
<footer>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</footer>
</html>
