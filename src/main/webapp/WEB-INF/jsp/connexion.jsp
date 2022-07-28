<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Connexion</title>
        <link type="text/css" rel="stylesheet" href="css/form.css" />        
    </head>
<header>
<jsp:include page="/WEB-INF/views/header2.jsp"></jsp:include>
</header>
    <body>
    <br>
        <form method="post" action="${pageContext.servletContext.contextPath}/ServletConnexion">
            <fieldset>
                <legend>Connexion</legend>
                <p>Vous pouvez vous connecter via ce formulaire.</p>

                <label for="id_pseudo">Pseudo <span class="requis">*</span></label>
                <input type="text" id="id_pseudo" name="pseudo" size="30" maxlength="50" required="required"/>
                
				<br />

                <label for="id_mot_de_passe">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="id_mot_de_passe" name="mot_de_passe" value="" size="30" maxlength="30" required="required" />
                
				<br />
				<div>
                <input type="submit" value="Connexion" class="sansLabel" />
            	<a href="${pageContext.servletContext.contextPath}/ServletInscription"> <input type="button" class="boutonForm" value="Créer un compte"> </a>
            	</div>
       			


                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>

                <%-- Vérification de la présence d'un objet id en session --%>
                <c:if test="${!empty sessionScope.utilisateur}">
                    <%-- Si l'utilisateur existe en session, alors on affiche son pseudo. --%>
                    <p class="succes">Hello ${sessionScope.utilisateur.pseudo}, tu aimes toujours les cookies?</p>
                </c:if>
            </fieldset>
        </form>
    </body>
<footer>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</footer>
</html>