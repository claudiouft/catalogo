<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pesquisar Pessoa</title>
<link href="<c:url value="../resources/css/bootstrap.min.css"/>" rel="stylesheet"/>
<link href="<c:url value="../resources/css/bootstrap-theme.min.css"/>" rel="stylesheet"/>
<link href="<c:url value="../resources/css/estilo.css"/>" rel="stylesheet"/>
</head>
<body>
	<div class="container">
	<jsp:include page="../menu.jsp" />	
	<h3>Filtro da pesquisa:</h3>
		<br>	
		<form action="adicionar_fotos" method="post" enctype="multipart/form-data" >
			<div>	
		        <label>Nome:</label>
		        <label>${pessoa.nome}</label>	        
		        <input type="hidden" name="id" id="id" value="${pessoa.id}" />	        
		    </div>
		    <div>	
		        <label>Fotos:</label>
		        <input type="file" name="file" id="file" multiple="multiple"/>
		    </div>
		    <button type="submit">Adicionar Fotos</button>
		</form>
		<h2>Fotos Adicionadas:</h2>
		<table class="table table-bordered table-striped table-hover">
			<c:forEach items="${pessoa.listaFotos}" var="foto">
				<tr>
					<td> 
						<!-- 
						LOCALHOST
						<img height="180" width="240" src="<c:url value="/diretorio_imagens/${foto.localFoto}"/>"/>						
						REMOTO
						<img class="img-responsive" src="${foto.localFoto}">
						 -->
						<img height="15%" width="15%" src="${foto.localFoto}">		
						<label>${foto.localFoto}</label>		
					</td>
					<td align="center" valign="middle">
						<a href="desativarFoto?idFoto=${foto.id}"
							title="Remover Fotos">
							<span class="glyphicon glyphicon-minus-sign"></span>
						</a>					
					</td>								
				</tr>
			</c:forEach>		
		</table>
		<jsp:include page="../rodape.jsp" />  
	</div>
</body>
</html>