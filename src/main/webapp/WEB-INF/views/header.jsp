<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div style="background: #0568CD; height: 100px; padding: 5px; border-radius: 5px">
  <div style="float: left">
  <a href="${pageContext.request.contextPath}/ServletAccueil">
  <img src="https://i.postimg.cc/k5vPsnCG/logo.png" height=100 alt="Cliquer ici pour revenir à la page d'accueil" />
  </a>
  </div>

  <div style="float: right; padding: 10px; text-align: right;">

   <br/>
     <nav>
     	<a href="${pageContext.request.contextPath}/ServletConnexion"> Se connecter - Inscription</a>
     	<%-- Vérification de la présence d'un objet utilisateur en session --%>
	            <c:if test="${!empty sessionScope.sessionUtilisateur}">
	            <%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>
	            <p class="succes"> Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionUtilisateur.email}</p>
	            </c:if>
     </nav>

  </div>

</div>
