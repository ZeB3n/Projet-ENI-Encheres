<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                <input type="text" id="pseudo" name="pseudo" value="" size="20" maxlength="30" />
                
                <label for="nom"> Nom : <span class="requis">*</span></label>
                <input type="text" id="nom" name="nom" value="" size="20" maxlength="30" />
                <br />
                
                <label for="prenom"> Prénom : <span class="requis">*</span></label>
                <input type="text" id="prenom" name="prenom" value="" size="20" maxlength="30" />

                <label for="email"> Email <span class="requis">*</span></label>
                <input type="text" id="email" name="email" value="" size="20" maxlength="50" />
                <br />
                
                <label for="telephone"> Téléphone : </label>
                <input type="text" id="telephone" name="telephone" value="" size="20" maxlength="10" />

                <label for="rue"> Rue <span class="requis">*</span></label>
                <input type="text" id="rue" name="rue" value="" size="20" maxlength="30" />
                <br />
                
                <label for="code_postal"> Code Postal : <span class="requis">*</span></label>
                <input type="text" id="code_postal" name="code_postal" value="" size="20" maxlength="30" />

                <label for="ville"> Ville : <span class="requis">*</span></label>
                <input type="text" id="ville" name="ville" value="" size="20" maxlength="30" />
                <br />

                <label for="motdepasse"> Mot de passe : <span class="requis">*</span></label>
                <input type="password" id="mot_de_passe" name="mot_de_passe" value="" size="20" maxlength="20" />

                <label for="confirmation"> Confirmation : <span class="requis">*</span></label>
                <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
                <br />

                <input type="submit" value="Créer" class="sansLabel" />
                <br />
            </fieldset>
        </form>
		<a href="<%=request.getContextPath()%>/ServletGestionConnexion"><button type="submit" formmethod="post">Créer un compte</button></a>
		<a href="<%=request.getContextPath()%>/ServletAccueil"><button type="submit">Annuler</button></a>
</body>
<footer>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</footer>
</html>
 