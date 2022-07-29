<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
<link type="text/css" rel="stylesheet" href="css/accueil.css" />
</head>
<header>
<jsp:include page="/WEB-INF/views/header2.jsp"></jsp:include>
</header>
<body>
<br>
	<h1>ACCUEIL DE ENI-ENCHERES</h1>

    		 <fieldset>
	 	<div id="titre">
            <h2>LISTE DES ENCHERES</h2>
        </div>
		
    <nav> <!-- navigation = filtres -->		
	<!-- sous menu filtres -->	
<h2>Filtres :</h2>		
		
<!-- menu -->	 

 <label for="site-search"></label>
        <input type="search" id="site-search" name="q" placeholder="Le nom de l'article contient" title="Barre de recherche" >
        
        <br><br>	
        
  <!-- categories liste deroulante -->      
      
 <label for="categorie">Catégorie : </label>
        <select name="categorie" id="categorie">
            <option>Toutes</option>
            <option>Informatique</option>
            <option>Ameublement</option>
            <option>Vêtement</option>
            <option>Sport & Loisirs</option>
        </select>     
      
 <!-- bouton rechercher -->   
 
 	 <button id="btRechercher">Rechercher</button>
		</nav>
		
		<br>   
		<br>
		<br>
		<br>
		
				<%-- Vérification de la présence d'un objet utilisateur en session --%>
	    <c:if test="${!empty sessionScope.utilisateur}">
	     <%-- Si l'utilisateur existe en session, alors on affiche une section masquée en mode "connecté". --%>
        <!-- Option ACHAT-->
        <nav>
        <div>
        <div>
            <ul>
                <input type="radio" id="achat" value="Achats" name="choix" checked> 
                <label for="achat">Achats</label>
                    <li><input type="checkbox">enchères ouvertes</li>
                    <li><input type="checkbox">mes enchères en cours</li>
                    <li><input type="checkbox">mes enchères remportées</li>
            </ul>
        </div>

        <!-- Option MES VENTES-->
        <div>
            <ul>
                <input type="radio" id="vente" value="mes ventes" name="choix"> 
                <label for="vente">Mes ventes</label>
                    <li><input type="checkbox">mes ventes en cours</li>
                    <li><input type="checkbox">ventes non débutées</li>
                    <li><input type="checkbox">mes enchères remportées</li>
            </ul>
        </div>
        </div>
    
    </nav><!-- fin navigation = filtres -->
    </c:if>
    <br>
		
	<!-- affichage de 2 encheres -->
	
	<article id="rightart" class="obj">
            <main class="frame"> <!-- Image de l'article (objet) -->
                <img class="image" src="#"> <!--Afficher la photo de l'article mis en vente-->
            </main>
            <form>
                <div class="infos">
                    <label for="article" class="nomArticle"><b>----- Le nom de l'article ----</b></label>
                    <br>
                    <label for="prix">Prix : </label> <!--afficher le prix -->
                    <br>
                    <label for="finEnch">Fin de l'enchère : </label> <!--afficher la date de fin d'enchère-->
                    <br>
                    <label for="vendeur">Vendeur : </label> <!--afficher le nom du vendeur-->
                    <br>
                </div>
            </form>
        </article>


  
   
<article id="leftart" class="obj">
            <main class="frame"> <!-- Image de l'article (objet) -->
                <img class="image" src="#"> <!--Afficher la photo de l'article mis en vente-->
            </main>
            <form>
                <div class="infos">
                    <label for="article" class="nomArticle"><b>----- Le nom de l'article ----</b></label>
                    <br>
                    <label for="prix">Prix : </label> <!--Faire apparaitre le prix -->
                    <br>
                    <label for="finEnch">Fin de l'enchère : </label> <!--faire apparaitre la date de fin d'enchère-->
                    <br>
                    <label for="vendeur">Vendeur : </label> <!--Faire apparaitre le nom du vendeur-->
                    <br>
                </div>
            </form>
        </article>
         </fieldset>
	
</body>
<footer>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</footer>
</html>