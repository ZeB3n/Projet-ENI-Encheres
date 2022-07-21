<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
</head>
<header>
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
</header>
<body>
	<h1>INSCRIPTION</h1>
	<form method="post" action="inscription">
            <fieldset>
                <legend>Inscription</legend>
                <p>Vous pouvez vous inscrire via ce formulaire.</p>
                
                <label for="pseudo"> Pseudo : <span class="requis">*</span></label>
                <input type="text" id="pseudo" name="pseudo" value="<c:out value="${param.pseudo}"/>" size="20" maxlength="30" />
                <span class="erreur">${erreurs['pseudo']}</span>
                
                <label for="nom"> Nom : <span class="requis">*</span></label>
                <input type="text" id="nom" name="nom" value="<c:out value="${param.nom}"/>" size="20" maxlength="30" />
                <span class="erreur">${erreurs['nom']}</span>
                <br />
                
                <label for="prenom"> Prénom : <span class="requis">*</span></label>
                <input type="text" id="prenom" name="prenom" value="<c:out value="${param.prenom}"/>" size="20" maxlength="30" />
                <span class="erreur">${erreurs['prenom']}</span>

                <label for="email"> Email : <span class="requis">*</span></label>
                <input type="email" id="email" name="email" value="<c:out value="${param.email}"/>" size="20" maxlength="50" />
                <span class="erreur">${erreurs['email']}</span>
                <br />
                
                <label for="telephone"> Téléphone : </label>
                <input type="text" id="telephone" name="telephone" value="<c:out value="${param.telephone}"/>" size="20" maxlength="10" />
                <span class="erreur">${erreurs['telephone']}</span>

                <label for="rue"> Rue <span class="requis">*</span></label>
                <input type="text" id="rue" name="rue" value="<c:out value="${param.rue}"/>" size="20" maxlength="30" />
                <span class="erreur">${erreurs['rue']}</span>
                <br />
                
                <label for="code_postal"> Code Postal : <span class="requis">*</span></label>
                <input type="text" id="code_postal" name="code_postal" value="<c:out value="${param.code_postal}"/>" size="20" maxlength="30" />
                <span class="erreur">${erreurs['code_postal']}</span>

                <label for="ville"> Ville : <span class="requis">*</span></label>
                <input type="text" id="ville" name="ville" value="<c:out value="${param.ville}"/>" size="20" maxlength="30" />
                <span class="erreur">${erreurs['ville']}</span>
                <br />

                <label for="motdepasse"> Mot de passe : <span class="requis">*</span></label>
                <input type="password" id="mot_de_passe" name="mot_de_passe" value="" size="20" maxlength="20" />
                <span class="erreur">${erreurs['mot_de_passe']}</span>

                <label for="confirmation"> Confirmation : <span class="requis">*</span></label>
                <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
                <span class="erreur">${erreurs['confirmation']}</span>
                <br />

                <input type="submit" value="Créer" class="sansLabel" />
                <br />
                
                <p class="${empty erreurs ? 'succes' : 'erreur'}">${resultat}</p>
            </fieldset>
        </form>
		<a href="<%=request.getContextPath()%>/ServletGestionConnexion"><button type="submit" formmethod="post">Créer un compte</button></a>
		<a href="<%=request.getContextPath()%>/ServletAccueil"><button type="submit">Annuler</button></a>
</body>
<footer>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</footer>
</html>
 