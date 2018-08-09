<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<c:url value="../resources/css/bootstrap.min.css"/>" rel="stylesheet"/>
<link href="<c:url value="../resources/css/bootstrap-theme.min.css"/>" rel="stylesheet"/>
<link href="<c:url value="../resources/css/estilo.css"/>" rel="stylesheet"/>
</head>
<body>
	<div class="container">
	<jsp:include page="../menu.jsp"/>
	<h3>Cadastro realizado com sucesso!</h3>
		<br>
		<a href="/catalogo/">Clique</a>	
	<jsp:include page="../rodape.jsp" />  	
	</div>
</body>
</html>