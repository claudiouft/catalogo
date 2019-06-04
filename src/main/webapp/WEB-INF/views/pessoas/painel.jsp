<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Painel</title>
<link href="<c:url value="../resources/css/bootstrap.min.css"/>" rel="stylesheet"/>
<link href="<c:url value="../resources/css/bootstrap-theme.min.css"/>" rel="stylesheet"/>
<link href="<c:url value="../resources/css/estilo.css"/>" rel="stylesheet"/>
</head>
<body>
	<div class="container">
	<jsp:include page="../menu.jsp" />
	<div class="page-header">
		<h3>Catálogo</h3>
	</div>
	<div class="panel panel-default">
		<div class="panel-heading">
			<h4>Escolhas do Catálogo:</h4>
		</div>
		<div class="panel-body">
			<c:forEach items="${pessoas}" var="painel" varStatus="status">
				<div class="rown">
					<div class="col-xs-6 col=sm-3 col-md-4">
						<a href="prepararAlterar?idPessoa=${painel.id}" class="thumbnail">
						
							<img class="img-responsive" src="${painel.localFotoPrincipal}">
							<div class="caption">
								<h4>${painel.nomeFantasia}</h4>
								<h4>${painel.telefone}</h4>
							</div>
						</a>
					</div>
				</div>
			
			</c:forEach>
		</div>
	</div>
	<jsp:include page="../rodape.jsp" />  
	</div>
</body>
</html>



<!-- 
				<table class="table table-bordered table-striped table-hover">
				<tr>
					<th>Nome Fantasia</th>
					<th>Telefone</th>
				</tr>
				<c:forEach items="${pessoas}" var="p3">
					<tr>
						<td><h2>${p3.nomeFantasia}</h2></td>
						<td><h2>${p3.telefone}</h2></td>
					</tr>
					<c:forEach items="${p3.listaFotos}" var="foto">
						<tr>
							<td colspan="2"><img height="180" width="240" src="<c:url value="/diretorio_imagens/${foto.localFoto}"/>" /></td>
						</tr>
					</c:forEach>
				</c:forEach>
			 -->
			 
			 <!-- 
			 
			 <c:forEach items="${pessoas}" var="p3" varStatus="status">
			 		<c:if test="${status.count == 0}"> <tr> </c:if>
				 		<c:if test="${status.count % 2 == 0}"> <tr> </c:if>		 		
						<td colspan="2"> ${status.count} <img height="180" width="240" src="<c:url value="/diretorio_imagens/${p3.localFotoPrincipal}"/>" /></td>
						<c:if test="${status.count % 2 == 0}"> </tr> </c:if>
					<c:if test="${status.count == 0}"> </tr> </c:if>				
			</c:forEach>
			
			<label>Count:${status.count}</label><br>
			<label>Index:${status.index}</label><br>
			
			  -->
			  <!-- 
			 <c:if test="${status.count % 3 == 1}">
		      	<tr>
		     </c:if>	
					<td align="center"> 
						<a href="prepararAlterar?idPessoa=${p3.id}">
							<img class="img-responsive" height="30%" width="30%"  src="<c:url value="/diretorio_imagens/${p3.localFotoPrincipal}"/>" /><br>
						</a>
						<a href="prepararAlterar?idPessoa=${p3.id}">
							<label>${p3.nomeFantasia}</label><br>
							<label>${p3.telefone}</label>
						</a>														
					</td>
			<c:if test="${status.count % 3 == 0||status.count == fn:length(values)}">
		      </tr>
		    </c:if>	
			-->		  