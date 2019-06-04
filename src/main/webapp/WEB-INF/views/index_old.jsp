<%@ page language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<title>Belas</title>

<link href="<c:url value="resources/css/bootstrap.min.css"/>" rel="stylesheet"/>
<link href="<c:url value="resources/css/bootstrap-theme.min.css"/>" rel="stylesheet"/>
<link href="<c:url value="resources/css/estilo.css"/>" rel="stylesheet"/>
<link rel="shortcut icon" href="img/icon_verde.ico" type="image/x-icon" />

<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
	<div class="container">
		
		<section id="depoimentos">
		<h2 class="container titulo-depoimentos">Destaque do mês</h2>
		
		<div id="carouseldinamico" class="carousel slide" data-ride="carousel">
			<ol class="carousel-indicators">
				<c:forEach items="${pessoasd}" var="painel" varStatus="status">
					<li data-target="#carouseldinamico" data-slide-to="${status.index}"></li>
				</c:forEach>
			</ol>
			 <div class="carousel-inner"  role="listbox">			 	
			 	<c:forEach items="${pessoasd}" var="painel2" varStatus="status2">			 				 		
			 		<c:if test="${status2.index == 1}">
				      	<figure class="item active">
							<img src="<c:url value="/diretorio_imagens/${painel2.localFotoDestaque}"/>">
							<figcaption class="carousel-caption">							
							<a href="/catalogo/pessoas/prepararPerfil?idPessoa=${painel2.id}" style="text-decoration:none">
								<h4>${painel2.nomeFantasia}</h4>
							</a>	
							</figcaption>
						</figure>
				     </c:if>				     
				     <c:if test="${status2.index != 1}">
				      	<figure class="item">
							<img src="<c:url value="/diretorio_imagens/${painel2.localFotoDestaque}"/>">
							<figcaption class="carousel-caption">
								<a href="/catalogo/pessoas/prepararPerfil?idPessoa=${painel2.id}" style="text-decoration:none">
									<h4>${painel2.nomeFantasia}</h4>
								</a>
							</figcaption>
						</figure>
				     </c:if>	 
				     																 		
			 	</c:forEach>
			 	
			 </div>
			 <!-- class="thumbnail" -->
			  <!-- Controls -->
			  <a class="left carousel-control" href="#carouseldinamico" role="button" data-slide="prev">
			    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			    <span class="sr-only">Previous</span>
			  </a>
			  <a class="right carousel-control" href="#carouseldinamico" role="button" data-slide="next">
			    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			    <span class="sr-only">Next</span>
			  </a>
		</div>		
		
		</section>

		<div class="page-header">
			<h3>Catálogo</h3>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4>Escolhas do Catálogo:</h4>
			</div>
			<div class="panel-body" style="padding: 1%;">
				<c:forEach items="${pessoas}" var="painel" varStatus="status">
					<div class="rown">
						<div class="col-xs-12 col=sm-3 col-md-4" style="padding: 1%;">					
							<a href="/catalogo/pessoas/prepararPerfil?idPessoa=${painel.id}" style="text-decoration:none" class="thumbnail">
								<img src="<c:url value="/diretorio_imagens/${painel.localFotoPrincipal}"/>">
								<div class="caption">
									<p>			    	 	
						    	 		<h3><img src="img/icon_cel.png"> ${painel.nomeFantasia} </h3>
						    	 	</p>
								</div>
								<!-- 
								
								class="col-xs-6 col=sm-3 col-md-4"
								
								Diretorio remoto
								<img src="<c:url value="${painel.localFotoPrincipal}"/>">
								
								Diretorio localhost
								<img src="<c:url value="/diretorio_imagens/${painel.localFotoPrincipal}"/>">
								<div class="caption">
									<p>			    	 	
						    	 		<h3><img src="img/icon_call_verde2.png"> ${painel.nomeFantasia} </h3>
						    	 	</p>
								</div>
								
								 -->
							</a>
						</div>
					</div>
				
				</c:forEach>
			</div>
		</div>		
	</div>
	<jsp:include page="rodape.jsp" /> 
</body>

<script src="resources/js/jquery-3.3.1.min.js"></script>
<script src="resources/js/bootstrap.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="http://platform.twitter.com/widgets.js"></script>
</html>