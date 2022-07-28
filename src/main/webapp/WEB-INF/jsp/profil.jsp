<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Mon profil</title>
        <link type="text/css" rel="stylesheet" href="css/form.css" />
</head>

	<header>
		<jsp:include page="/WEB-INF/views/header2.jsp"></jsp:include>
	</header>

<body>

	<fieldset>
	<%-- Vérification de la présence d'un objet utilisateur en session --%>
		<c:if test="${!empty sessionScope.utilisateur}">
                
                <legend>Mon profil</legend>
                <%-- Si l'utilisateur existe en session, alors on affiche ses informations personnelles. --%>
                
                <p>Affichage de vos données personelles.</p>
<br>
				
				<p>Pseudo : ${sessionScope.utilisateur.pseudo} </p>         
<br> 
				<p>Nom : ${sessionScope.utilisateur.nom} </p>
<br>
                <p>Prénom : ${sessionScope.utilisateur.prenom} </p>                
<br>
				<p>Email : ${sessionScope.utilisateur.email} </p>                
<br>    
				<p>Téléphone : ${sessionScope.utilisateur.telephone} </p>         
<br> 
				<p>Rue : ${sessionScope.utilisateur.rue} </p>            
<br>
				<p>Ville : ${sessionScope.utilisateur.ville} </p>                
<br> 
				<p>Mot de passe : *********** </p>                
<br>            
		</c:if>
	</fieldset>
	
</body>

	<footer>
		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
	</footer>
		
</html>