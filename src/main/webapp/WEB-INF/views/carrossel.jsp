<%@ page language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

 <section id="carousel">
		<div id="carouseldinamico" class="carousel slide fadeing" data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<c:forEach items="${pessoasd}" var="painel" varStatus="status">
						<li data-target="#carouseldinamico" data-slide-to="${status.index}"></li>
					</c:forEach>
				</ol>
				<!-- Wrapper for slides -->
				<div class="carousel-inner" role="listbox">
					<c:forEach items="${pessoasd}" var="painel2" varStatus="status2">			 				 		
				 		<c:if test="${status2.index == 1}">
				 		<!-- 
					      		LOCALHOST
					      		<img src="<c:url value="/diretorio_imagens/${painel2.localFotoDestaque}"/>">
					      		
					      		AMAZON
					      		<img src="${painel2.localFotoDestaque}"/>
					      	 -->
					      	 
					      	<figure class="item active">
								<img src="<c:url value="/diretorio_imagens/${painel2.localFotoDestaque}"/>">						
								<figcaption class="carousel-caption">									
									<a href="/catalogo/pessoas/prepararPerfil?idPessoa=${painel2.id}" style="text-decoration:none">
										<label class="branca">${painel2.nomeFantasia} (2)</label>
									</a>
								</figcaption>
							</figure>
					     </c:if>				     
					     <c:if test="${status2.index != 1}">
					      	<figure class="item">					 
								<img src="<c:url value="/diretorio_imagens/${painel2.localFotoDestaque}"/>">
								<figcaption class="carousel-caption">
									<a href="/catalogo/pessoas/prepararPerfil?idPessoa=${painel2.id}" style="text-decoration:none">
										<label class="branca">${painel2.nomeFantasia}</label>
									</a>
								</figcaption>
							</figure>
					     </c:if>	 				     																 		
				 	</c:forEach>
				</div>
				<a class="left carousel-control" href="#carouseldinamico" role="button" data-slide="prev">
					<i class="fa fa-chevron-left"></i>
				</a>
				<a class="right carousel-control" href="#carouseldinamico" role="button" data-slide="next">
					<i class="fa fa-chevron-right"></i>
				</a>
			</div>							
	</section>