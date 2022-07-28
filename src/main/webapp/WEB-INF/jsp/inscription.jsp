<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Inscription</title>
        <link type="text/css" rel="stylesheet" href="css/form.css" />
    </head>
	    <header>
		<jsp:include page="/WEB-INF/views/header2.jsp"></jsp:include>
		</header>
    <body>
    <br>
        <form method="post" action="${pageContext.servletContext.contextPath}ServletInscription">
            <fieldset>
                <legend>Inscription</legend>
                <p>Vous pouvez vous inscrire via ce formulaire.</p>
				
				<label for="id_pseudo"> Pseudo : <span class="requis">*</span></label>
                <input type="text" id="id_pseudo" name="pseudo" size="30" maxlength="30" required="required" pattern="^[a-z0-9_-]{3,30}$"/>
<br> 
				<label for="id_nom"> Nom : <span class="requis">*</span></label>
                <input type="text" id="id_nom" name="nom" size="30" maxlength="30" required="required"/>
<br>
                <label for="prenom"> Prénom : <span class="requis">*</span></label>
                <input type="text" id="prenom" name="prenom" size="30" maxlength="30" required="required"/>
                
<br>
                <label for="email"> Adresse email : <span class="requis">*</span></label>
                <input type="email" id="email" name="email" size="30" maxlength="50" required="required" pattern="[^@ \t\r\n]+@[^@ \t\r\n]+\.[^@ \t\r\n]+"/>
<br>                
                <label for="telephone"> Téléphone : </label>
                <input type="text" id="telephone" name="telephone" size="30" maxlength="10" pattern="^[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[0-9]{3}[-\s\.]?[0-9]{4,6}$"/>
<br>
                <label for="rue"> Rue : <span class="requis">*</span></label>
                <input type="text" id="rue" name="rue" size="30" maxlength="30" />
<br>                
                <label for="code_postal"> Code Postal : <span class="requis">*</span></label>
                <input type="text" id="code_postal" name="code_postal" size="30" maxlength="10" required="required"/>
<br>
                <label for="ville"> Ville : <span class="requis">*</span></label>
                <input type="text" id="ville" name="ville" size="30" maxlength="30" required="required"/>
<br>
                <label for="mot_de_passe"> Mot de passe : <span class="requis">*</span></label>
                <input type="password" id="mot_de_passe" name="mot_de_passe" value="" size="30" maxlength="30" required="required" pattern="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,30}$"/>
<br>
                <label for="confirmation"> Confirmation du mot de passe : <span class="requis">*</span></label>
                <input type="password" id="confirmation" name="confirmation" value="" size="30" maxlength="30" required="required"/>
<br>
                <input type="submit" value="Inscription" class="sansLabel" />
                <a href="ServletAccueil"> <input type="button" name="btAnnuler" value="Annuler" class="boutonForm" title="Annuler" /> </a>
                <br />

                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
                
                <%-- Vérification de la présence d'un objet utilisateur en session --%>
                <c:if test="${!empty sessionScope.utilisateur}">
                <%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>
                <p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.utilsateur.email}</p>
                </c:if>
            </fieldset>
        </form>
    </body>
	    <footer>
		<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
		</footer>
</html>