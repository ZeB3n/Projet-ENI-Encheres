<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div style="background: #0568CD; height: 100px; padding: 5px; border-radius: 5px">
  <div style="float: left">
  <a href="${pageContext.request.contextPath}/ServletAccueil"><img alt="Logo test de ENI-Enchères" height="100" src="../../img/enchereslogotest.png"></a>
     <h1>ENI-Enchères</h1>
  </div>

  <div style="float: right; padding: 10px; text-align: right;">

   <br/>
     <nav>
     	<a href="<%=request.getContextPath()%>/ServletConnexion">Se connecter - Inscription</a>
     	<%-- Vérification de la présence d'un objet utilisateur en session --%>
	            <c:if test="${!empty sessionScope.sessionUtilisateur}">
	            <%-- Si l'utilisateur existe en session, alors on affiche son adresse email. --%>
	            <p class="succes">Vous êtes connecté(e) avec l'adresse : ${sessionScope.sessionUtilisateur.email}</p>
	            </c:if>
     </nav>

  </div>

</div>
