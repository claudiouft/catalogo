<%@ page language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- LISTA DE MENINAS -->

<section id="carrosel">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h4>Todas elas:</h4>
			</div>
			<div class="panel-body" style="padding: 1%;">
				<c:forEach items="${pessoas}" var="painel" varStatus="status">
					<div class="rown">
						<div class="col-xs-12 col=sm-3 col-md-4" style="padding: 1%;">					
							<a href="/catalogo/pessoas/prepararPerfil?idPessoa=${painel.id}" style="text-decoration:none" class="thumbnail">
								<img class="img-responsive" src="${painel.localFotoPrincipal}">
								<span>
									<h4 class="alinha_centro">
										<img src="img/smartphone32.png"> ${painel.nomeFantasia} 
									</h4>
								</span>
								<!-- 
								
								class="col-xs-6 col=sm-3 col-md-4"
								
								col-xs-12 col=sm-3 col-md-4
								
								Diretorio remoto
								<img class="img-responsive" src="${painel.localFotoPrincipal}">
								
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
</section>