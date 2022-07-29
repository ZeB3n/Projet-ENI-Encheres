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
	
<!-- 												ACCUEIL NON-CONNECTE -->
<!-- 	------------------------------------------------------------------------------------------------------------------------ -->

		<%-- Si l'utilisateur existe en session, alors on affiche une page d'accueil en mode "non-connecté". --%>
    		<c:if test="${empty sessionScope.utilisateur}">
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
		
	<!-- affichage de 2 encheres -->
	
	<article class="obj">
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


  
   
<article class="obj">
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
    
    </c:if>
    
<!-- 												ACCUEIL CONNECTE -->
<!-- 	------------------------------------------------------------------------------------------------------------------------ -->
	 

    <%-- Vérification de la présence d'un objet utilisateur en session --%>
	    <c:if test="${!empty sessionScope.utilisateur}">
	     <fieldset>
	     <%-- Si l'utilisateur existe en session, alors on affiche une page d'accueil en mode "connecté". --%>
	     <!-- slogan -->
        <div id="titre">
            <h2>Liste des enchères</h2>
        </div>

        

   
    <nav> <!-- navigation = filtres -->

        <h2>Filtres : </h2>

         <!-- Barre de recherche -->
        <label for="site-search"></label>
        <input type="search" id="site-search" name="q" placeholder="Le nom de l'article contient" title="Barre de recherche" >
        
        <br><br>

         <!--Liste de catégories-->
        <label for="categorie">Catégorie : </label>
        <select name="categorie" id="categorie">
            <option>Toutes</option>
            <option>Informatique</option>
            <option>Ameublement</option>
            <option>Vêtement</option>
            <option>Sport et Loisirs</option>
        </select>

        <br><br>

        <!-- Option ACHAT-->
        <div id="left">
            <ul>
                <input type="radio" id="achat" value="Achats" name="choix" checked> 
                <label for="achat">Achats</label>
                    <li><input type="checkbox">enchères ouvertes</li>
                    <li><input type="checkbox">mes enchères en cours</li>
                    <li><input type="checkbox">mes enchères remportées</li>
            </ul>
        </div>

        <!-- Option MES VENTES-->
        <div id="right">
            <ul>
                <input type="radio" id="vente" value="mes ventes" name="choix"> 
                <label for="vente">Mes ventes</label>
                    <li><input type="checkbox">mes ventes en cours</li>
                    <li><input type="checkbox">ventes non débutées</li>
                    <li><input type="checkbox">mes enchères remportées</li>
            </ul>
        </div>

        <!-- Bouton rechercher , affichera les listes d'articles-->
        <button id="btRechercher" type="submit" value="Rechercher">Rechercher</button>
    
    </nav><!-- fin navigation = filtres -->
    <br>
    
				
				
				
	 <section> <!-- AFFICHER LES ACHATS OU LES VENTES  -->
            <article class="obj">
                <main class="frame"> <!-- Image -->
                    <img class="image" src="#"> <!--Afficher photo article -->
                </main>
                
                
              
            </article>

            
			
    </section>

    <br><br>
    <section>
        <!-- aperçue de la liste des enchères A COMPLETER -->
    </section>

    <br><br>
     </fieldset>
	</c:if>
	
</body>
<footer>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</footer>
</html>