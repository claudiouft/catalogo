<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pesquisar Pessoa</title>
<link href="<c:url value="../resources/css/bootstrap.min.css"/>" rel="stylesheet"/>
<link href="<c:url value="../resources/css/bootstrap-theme.min.css"/>" rel="stylesheet"/>
<link href="<c:url value="../resources/css/estilo.css"/>" rel="stylesheet"/>
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>	
	<div class="container">
	<jsp:include page="../menu.jsp"/>
	<div class="page-header">
		<h3>Pesquisa</h3>
	</div>
	<div class="panel panel-default">
		<div class="panel-body">
			<form action="pesquisa" class="form-horizontal" method="post">
				<div class="form-group">	
			        <label class="control-label col-sm-2" for="nome">Nome:</label>
			        <div class="col-sm-10">
			        	<input type="text" name="nome" id="nome"  class="form-control"/>
			        </div>			        
			    </div>
			    <div class="form-group">	
			        <label class="control-label col-sm-2" for="nomeFantasia">Nome Fantasia:</label>
			        <div class="col-sm-10">
			        	<input type="text" name="nomeFantasia" id="nomeFantasia" class="form-control" />
			        </div>			        
			    </div>	    
			    <div class="form-group">
			        <div class="col-sm-offset-2 col-sm-10">
			        	<button type="submit" class="btn btn-primary">Pesquisar</button>
			        </div>			        
			    </div>
			</form>	
		</div>
	</div>
	<div class="page-header">
		<h3>Resultado da Pesquisa:</h3>
	</div>
	<div class="panel panel-default">
		<div class="panel-body">			
			<table class="table table-bordered table-striped table-hover">
				<tr>
					<th>Nome</th>
					<th>Nome Fantasia</th>
					<th>Telefone</th>
					<th>Ativo/Desativado</th>
					<th>Imagem</th>
					<th>Ações</th>
				</tr>
				<c:forEach items="${pessoas}" var="p1">
					<tr>
						<td>${p1.nome}</td>	
						<td>${p1.nomeFantasia}</td>
						<td>${p1.telefone}</td>
						<td>
							<c:if test="${p1.ativo=='S'}"> <label style="color: green;">(ATIVA)</label> </c:if>
							<c:if test="${p1.ativo=='N'}"> <label style="color: red;">(DESATIVADA)</label></c:if>
						</td>
						<td> 
							<img height="80" width="120" src="<c:url value="${p1.localFotoPrincipal}"/>"/>						
						</td>
						<td align="center" valign="middle">
							<a href="prepararAlterar?idPessoa=${p1.id}" 
								title="Editar Pessoa"> 
								<span class="glyphicon glyphicon-edit"></span> 
							</a>
							<a href="prepararAdicionarFoto?idPessoa=${p1.id}"" 
								title="Adicionar ou Remover Fotos">
								<span class="glyphicon glyphicon-plus-sign"></span>
							</a>
						</td>				
					</tr>
				</c:forEach>		
			</table>
		</div>
	</div>
	<jsp:include page="../rodape.jsp" />  
	</div>
</body>
</html>