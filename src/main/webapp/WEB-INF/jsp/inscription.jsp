<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inscription</title>
<link type="text/css" rel="stylesheet" href="css/form.css" />
</head>
<header>
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
</header>
<body>
	<h1>INSCRIPTION</h1>
	<form method="post" action="${pageContext.request.contextPath}/ServletGestionConnexion">
            <fieldset>
                <legend>Inscription</legend>
                <p>Vous pouvez vous inscrire via ce formulaire.</p>
                
                <label for="pseudo"> Pseudo : <span class="requis">*</span></label>
                <input type="text" id="pseudo" name="pseudo" value="<c:out value="${utilisateur.pseudo}"/>" size="20" maxlength="30"
                 />
                <span class="erreur">${form.erreurs['pseudo']}</span>
<br>                
                <label for="nom"> Nom : <span class="requis">*</span></label>
                <input type="text" id="nom" name="nom" value="<c:out value="${utilisateur.nom}"/>" size="20" maxlength="30" />
                <span class="erreur">${form.erreurs['nom']}</span>
<br>
                
                <label for="prenom"> Prénom : <span class="requis">*</span></label>
                <input type="text" id="prenom" name="prenom" value="<c:out value="${utilisateur.prenom}"/>" size="20" maxlength="30" />
                <span class="erreur">${form.erreurs['prenom']}</span>
<br>
                <label for="email"> Email : <span class="requis">*</span></label>
                <input type="email" id="email" name="email" value="<c:out value="${utilisateur.email}"/>" size="20" maxlength="50" 
                pattern="[^@ \t\r\n]+@[^@ \t\r\n]+\.[^@ \t\r\n]+" />
                <span class="erreur">${form.erreurs['email']}</span>
                
<br>                
                <label for="telephone"> Téléphone : </label>
                <input type="text" id="telephone" name="telephone" value="<c:out value="${utilisateur.telephone}"/>" size="20" maxlength="10"
                pattern="^[\+]?[(]?[0-9]{3}[)]?[-\s\.]?[0-9]{3}[-\s\.]?[0-9]{4,6}$"  />
                <span class="erreur">${form.erreurs['telephone']}</span>
<br>
                <label for="rue"> Rue : <span class="requis">*</span></label>
                <input type="text" id="rue" name="rue" value="<c:out value="${utilisateur.rue}"/>" size="20" maxlength="30" />
                <span class="erreur">${form.erreurs['rue']}</span>
                
<br>                
                <label for="code_postal"> Code Postal : <span class="requis">*</span></label>
                <input type="text" id="code_postal" name="code_postal" value="<c:out value="${utilisateur.code_postal}"/>" size="20" maxlength="30" />
                <span class="erreur">${form.erreurs['code_postal']}</span>
<br>
                <label for="ville"> Ville : <span class="requis">*</span></label>
                <input type="text" id="ville" name="ville" value="<c:out value="${utilisateur.ville}"/>" size="20" maxlength="30" />
                <span class="erreur">${form.erreurs['ville']}</span>
                
<br>
                <label for="motdepasse"> Mot de passe : <span class="requis">*</span></label>
                <input type="password" id="mot_de_passe" name="mot_de_passe" value="" size="20" maxlength="20"
                pattern="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$"  />
                <span class="erreur">${form.erreurs['mot_de_passe']}</span>
<br>
                <label for="confirmation"> Confirmation : <span class="requis">*</span></label>
                <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" 
                pattern="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$"  />
                <span class="erreur">${form.erreurs['confirmation']}</span>
<br>                

                <input type="submit" value="Créer un compte" class="sansLabel" />
                <br />
                
                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
            </fieldset>
        </form>
		<a href="${pageContext.request.contextPath}/ServletAccueil"><button type="submit">Annuler</button></a>
		
</body>
<footer>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</footer>
</html>
 