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
        <form method="post" action="ServletConnexion">
            <fieldset>
                <legend>Connexion</legend>
                <p>Vous pouvez vous connecter via ce formulaire.</p>

                <label for="email">Adresse email <span class="requis">*</span></label>
                <input type="email" id="email" name="email" value="<c:out value="${utilisateur.email}"/>" size="30" maxlength="50" />
                <span class="erreur">${form.erreurs['email']}</span>
				<br />

                <label for="mot_de_passe">Mot de passe <span class="requis">*</span></label>
                <input type="password" id="mot_de_passe" name="mot_de_passe" value="" size="30" maxlength="30" />
                <span class="erreur">${form.erreurs['mot_de_passe']}</span>
				<br />
				<div>
                <input type="submit" value="Connexion" class="sansLabel" />
            	<a href="ServletInscription"> <input type="button" class="boutonForm" value="Créer un compte"> </a>
            	</div>
       			


                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>

                <%-- Vérification de la présence d'un objet utilisateur en session --%>
                <c:if test="${!empty sessionScope.sessionUtilisateur}">
                    <%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>
                    <p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionUtilisateur.email}</p>
                </c:if>
            </fieldset>
        </form>
    </body>
<footer>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</footer>
</html>