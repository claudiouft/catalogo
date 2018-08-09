<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista Pessoas</title>
<link href="<c:url value="../resources/css/bootstrap.min.css"/>" rel="stylesheet"/>
<link href="<c:url value="../resources/css/bootstrap-theme.min.css"/>" rel="stylesheet"/>
<link href="<c:url value="../resources/css/estilo.css"/>" rel="stylesheet"/>
</head>
<body>
	<div class="container">
	<jsp:include page="../menu.jsp"/>
	<h3>Listagem Geral</h3>
	<table class="table table-bordered table-striped table-hover">
		<tr>
			<th>Nome</th>
			<th>Nome Fantasia</th>
			<th>Telefone</th>
			<th>Foto</th>		
		</tr>
		<c:forEach items="${pessoas}" var="p3">
			<tr>
				<td>${p3.nome}</td>
				<td>${p3.nomeFantasia}</td>
				<td>${p3.telefone}</td>				
				<td> 
				</td>
			</tr>
		</c:forEach>		
	</table>
	<jsp:include page="../rodape.jsp" />  
	</div>
</body>
</html>

<!-- 
<c:forEach items="${pessoas}" var="p3">
			<tr>
				<td>${p3.nome}</td>
				<td>${p3.nomeFantasia}</td>
				<td>${p3.telefone}</td>				
				<td> 
					<img class="img-responsive" height="180" width="240" src="<c:url value="/diretorio_imagens/${p3.localFotoPrincipal}"/>"/>						
				</td>
			</tr>
		</c:forEach>	
 -->