<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="../includes2.jsp"/>	
</head>
<body>
	<div class="container"> 
		<jsp:include page="../menu.jsp" />
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4><strong>${pessoa.nome}</strong></h4>
				<h4><a href="tel:${pessoa.telefone}" class="sem_link">
					<img src="../img/icon_cel.png">&nbsp&nbsp&nbsp${pessoa.telefoneFormatado}</a>
				</h4>
				<h4><a href="https://api.whatsapp.com/send?phone=55${pessoa.telefone}&text=Oi%20peguei%20seu%20numero%20no%20catalogo%20goiania%20100" class="sem_link">
				<img src="../img/whatsapp1.png">&nbsp&nbsp&nbsp WhatsApp</a></h4>
			</div>
		<div class="panel-body" style="padding: 1%">
		<!--
		<div class="col-md-6">
				<div class="panel panel-default" align="center">
					<div class="panel-body">
						<img class="img-responsive" src="<c:url value="${pessoa.localFotoPrincipal}"/>">
					</div>			    		
			  	</div>				
			</div>
		  -->
			<div class="col-md-6" style="padding: 1%">
				<div class="panel panel-default" align="center" style="padding: 1%">
					<img class="img-responsive" src="${pessoa.localFotoPrincipal}">
					
					<!-- 
					//remoto
					<img class="img-responsive" src="<c:url value="${pessoa.localFotoPrincipal}"/>">
					//localhost
					<img src="<c:url value="/diretorio_imagens/${painel.localFotoPrincipal}"/>">
					 -->			    		
			  	</div>				
			</div>
			<div class="col-md-6" style="padding: 1%">				
				<div class="panel panel-default">			    	
			    	<div class="panel-body">
			    		<h4><strong>Detalhes:</strong></h4>
			    	 	<div class="rown">
		    	 			<div style="padding: 1%" class="col-xs-6 text-left"><h4 style="margin-top: 1%; margin-bottom: 1%">Preço:</h4></div>
							<div style="padding: 1%" class="col-xs-6 text-right"><h4 style="margin-top: 1%; margin-bottom: 1%">${pessoa.precoFormatado}</h4></div>	    	 						    	 			
		    	 		</div>		    	 		
		    	 		<div class="rown">
		    	 			<div style="padding: 1%" class="col-xs-6 text-left"><h4 style="margin-top: 1%; margin-bottom: 1%">Altura:</h4></div>
							<div style="padding: 1%" class="col-xs-6 text-right"><h4 style="margin-top: 1%; margin-bottom: 1%">${pessoa.alturaFormatado}</h4></div>
		    	 		</div>
		    	 		<div class="rown">
		    	 			<div style="padding: 1%" class="col-xs-6 text-left"><h4 style="margin-top: 1%; margin-bottom: 1%">Peso:</h4></div>
							<div style="padding: 1%" class="col-xs-6 text-right"><h4 style="margin-top: 1%; margin-bottom: 1%">${pessoa.pesoFormatado}</h4></div>
		    	 		</div>
		    	 		<div class="rown">
		    	 			<div style="padding: 1%" class="col-xs-6 text-left"><h4 style="margin-top: 1%; margin-bottom: 1%">Manequim:</h4></div>
							<div style="padding: 1%" class="col-xs-6 text-right"><h4 style="margin-top: 1%; margin-bottom: 1%">${pessoa.manequim}</h4></div>
		    	 		</div>
		    	 		<div class="rown">
		    	 			<div style="padding: 1%" class="col-xs-6 text-left"><h4 style="margin-top: 1%; margin-bottom: 1%">Cidade:</h4></div>
							<div style="padding: 1%" class="col-xs-6 text-right"><h4 style="margin-top: 1%; margin-bottom: 1%">${pessoa.cidade}</h4></div>
		    	 		</div>
		    	 		<div class="rown">
		    	 			<div style="padding: 1%" class="col-xs-3 text-left"><h4 style="margin-top: 1%; margin-bottom: 1%">Estado:</h4></div>
							<div style="padding: 1%" class="col-xs-9 text-right"><h4 style="margin-top: 1%; margin-bottom: 1%">${pessoa.uf}</h4></div>
		    	 		</div>
		    	 		<div class="rown">		    	 			
		    	 			<div style="padding: 1%" class="col-xs-12 text-left"><h4 style="margin-top: 1%; margin-bottom: 1%">Descrição:</h4></div>
		    	 		</div>
		    	 		<div class="rown">
							<div style="padding: 1%" class="col-xs-12 text-left"><h5 style="margin-top: 1%; margin-bottom: 1%">${pessoa.descricao}</h5></div>
		    	 		</div>	
			    	</div>
			    		
			  	</div>
				
			</div>
		</div>
	</div>
	</div>
	<div class="container">
		<div class="rown col-xs-12 col=sm-12 col-md-12" style="padding: 1%;">
			<h3>Fotos:</h3>
		</div>
		<c:forEach items="${pessoa.listaFotos}" var="foto">			
			<div class="rown" class="col-xs-12 col=sm-12 col-md-12" style="padding: 1%;">
				<div class="col-xs-12 col=sm-12 col-md-12" style="padding: 1%;">
					<div class="panel panel-default" align="center" style="padding: 1%;">
						<div class="panel-body" style="padding: 1%;">
							
							<!-- 
							<img  class="img-responsive" src="<c:url value="${foto.localFoto}"/>"/> 
							<a data-fancybox="gallery" href="/diretorio_imagens/${foto.localFoto}">							
							<img  class="img-responsive" src="${foto.localFoto}"/>	
							
							<a data-fancybox="gallery" href="/catalogo/diretorio_imagens/${foto.localFoto}">														
								<img  src="<c:url value="plapla plapla"/>"/>
							</a>
							-->	
							<a data-fancybox="gallery" href="${foto.localFoto}">													
								<img  class="img-responsive" src="${foto.localFoto}"/>	
							</a>
						</div>
					</div>
				</div>
			</div>					
		</c:forEach>
	</div>
	<jsp:include page="../rodape2.jsp" />  
</body>

</html> 
