<%@ page language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html class="no-js" lang="en">
<head>
  	<jsp:include page="includes.jsp" />
</head>
<body>
	<!-- SESSÃO DO MENU !-->
	<jsp:include page="menu.jsp"/>
	
	<!-- SESSÃO DO CARROSEL !-->
	<jsp:include page="carrossel.jsp" />
	
	
</body>
   <div id="preloader"> 
    	<div id="loader"></div>
   </div> 

	<!-- INCLUDE RODAPE !-->
	<jsp:include page="includesRodape.jsp"/>
</html>

