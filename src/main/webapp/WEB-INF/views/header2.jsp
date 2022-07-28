<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X_UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Navbar</title>
<link rel="stylesheet" href="css/header.css">
</head>
<body>

	<nav class="navbar">
	<a href="${pageContext.request.contextPath}/ServletAccueil" class="logo">
	<img src="https://i.postimg.cc/k5vPsnCG/logo.png" height=100 alt="Cliquer ici pour revenir à la page d'accueil" />
    </a>
    <div class="nav-links">
    
    			<%-- Vérification de la présence d'un objet utilisateur en session --%>
	            <c:if test="${!empty sessionScope.utilisateur}">
	            <%-- Si l'utilisateur existe en session, alors on affiche la navbar connectée --%>
	            	<ul>
			    		<li><a href="#"> Enchères </a></li>
			    		<li><a href="#"> Vendre un article </a></li>
			    		<li><a href="#"> Mon profil </a></li>
			    		<li><a href="${pageContext.request.contextPath}/ServletDeconnexion"> Déconnexion </a></li>
    				</ul>
	            </c:if>
	            
    		<%-- Si l'utilisateur n'existe pas en session, alors on affiche la navbar non-connectée --%>
    		<c:if test="${empty sessionScope.utilisateur}">
    			<ul>
			    	<li><a href="${pageContext.request.contextPath}/ServletConnexion"> S'inscrire - Se connecter </a></li>
    			</ul>
    		</c:if>
    	
    </div>
    <img alt="menu hamburger" src="https://fr.freepik.com/icones-gratuites/bouton-menu-circulaire_754773.htm" class="menu-hamburger">
	</nav>
	<header></header>

</body>
	<script> 
		const menuHamburger = document.querySelector(".menu-hamburger")
		const navLinks = document.querySelector(".nav-links")
		
		menuHamburger.addEventListener('click',()=>{
			nacLinks.classList.toggle('mobile-menu')
		})
	</script>
</html>