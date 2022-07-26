<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Inscription</title>
        <link type="text/css" rel="stylesheet" href="form.css" />
    </head>
    <body>
        <form method="post" action="ServletInscription">
            <fieldset>
                <legend>Inscription</legend>
                <p>Vous pouvez vous inscrire via ce formulaire.</p>
				
				<label for="pseudo"> Pseudo : <span class="requis">*</span></label>
                <input type="text" id="pseudo" name="pseudo" value="<c:out value="${utilisateur.pseudo}"/>" size="20" maxlength="30"/>
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
                <label for="email"> Adresse email : <span class="requis">*</span></label>
                <input type="email" id="email" name="email" value="<c:out value="${utilisateur.email}"/>" size="20" maxlength="60" />
                <span class="erreur">${form.erreurs['email']}</span>
<br>                
                <label for="telephone"> Téléphone : </label>
                <input type="text" id="telephone" name="telephone" value="<c:out value="${utilisateur.telephone}"/>" size="20" maxlength="10" />
                <span class="erreur">${form.erreurs['telephone']}</span>
<br>
                <label for="rue"> Rue : <span class="requis">*</span></label>
                <input type="text" id="rue" name="rue" value="<c:out value="${utilisateur.rue}"/>" size="20" maxlength="30" />
                <span class="erreur">${form.erreurs['rue']}</span>
<br>                
                <label for="codePostal"> Code Postal : <span class="requis">*</span></label>
                <input type="text" id="codePostal" name="codePostal" value="<c:out value="${utilisateur.codePostal}"/>" size="20" maxlength="30" />
                <span class="erreur">${form.erreurs['codePostal']}</span>
<br>
                <label for="ville"> Ville : <span class="requis">*</span></label>
                <input type="text" id="ville" name="ville" value="<c:out value="${utilisateur.ville}"/>" size="20" maxlength="30" />
                <span class="erreur">${form.erreurs['ville']}</span>
<br>
                <label for="motDePasse"> Mot de passe : <span class="requis">*</span></label>
                <input type="password" id="motDePasse" name="motDePasse" value="" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['motDePasse']}</span>
<br>
                <label for="confirmation"> Confirmation du mot de passe : <span class="requis">*</span></label>
                <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
                <span class="erreur">${form.erreurs['confirmation']}</span>
<br>
                <input type="submit" value="Inscription" class="sansLabel" />
                <br />

                <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>
                
                <%-- Vérification de la présence d'un objet utilisateur en session --%>
                <c:if test="${!empty sessionScope.sessionUtilisateur}">
                <%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>
                <p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionUtilisateur.email}</p>
                </c:if>
            </fieldset>
        </form>
    </body>
</html>