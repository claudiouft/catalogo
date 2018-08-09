<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Pessoa</title>
<link href="<c:url value="../resources/css/bootstrap.min.css"/>" rel="stylesheet"/>
<link href="<c:url value="../resources/css/bootstrap-theme.min.css"/>" rel="stylesheet"/>
<link href="<c:url value="../resources/css/estilo.css"/>" rel="stylesheet"/>
<link href="<c:url value="../resources/datetimepicker/css/bootstrap-datetimepicker.min.css"/>" rel="stylesheet"/>

<script src="../resources/js/jquery-3.3.1.min.js"></script>
<script src="../resources/datetimepicker/js/bootstrap-datetimepicker.min.js"></script>
<script src="../resources/datetimepicker/js/locales/bootstrap-datetimepicker.pt-BR.js"></script>
<script src="../resources/jquery-mask/src/jquery.mask.js"></script>
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>
<body>
	<div class="container">
	<jsp:include page="../menu.jsp" />
	<div class="page-header">
		<h3>
			Editar Pessoa: 
			<c:if test="${pessoa.ativo=='S'}"> <label style="color: green;">(ATIVA)</label> </c:if>
			<c:if test="${pessoa.ativo=='N'}"> <label style="color: red;">(DESATIVADA)</label></c:if>
		</h3>	
	</div>
	<div class="panel panel-default">
		<div class="panel-body">
			<form action="editar" method="post" enctype="multipart/form-data" >
				
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">	
					        <label for="nome">Nome:</label>
					        <input type="text" name="nome" id="nome" value="${pessoa.nome}" class="form-control" />
					        <input type="hidden" name="id" id="id" value="${pessoa.id}" />
					    </div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">	
					        <label for="nomeFantasia">Nome Fantasia:</label>
					        <input type="text" name="nomeFantasia" id="nomeFantasia" value="${pessoa.nomeFantasia}" class="form-control" />
					    </div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">	
					        <label for="telefone">Telefone:</label>
					        <input type="text" name="telefoneFormatado" id="telefoneFormatado" data-mask="(00)00000-0000" placeholder="(00)00000-0000" maxlength="14" autocomplete="off" value="${pessoa.telefone}" class="form-control"/>
					    </div>
					    <script type="text/javascript">
						$(document).ready(function(){
						
						        $("#telefoneFormatado").mask("(99) 99999-9999");
						});
						</script>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">	
					        <label for="ativo">Ativar/Desativar:</label>
					        <input type="radio" name="ativo" id="ativo" value="S" <c:if test="${pessoa.ativo=='S'}">checked="checked"</c:if> /> Ativado
					        <input type="radio" name="ativo" id="ativo" value="N" <c:if test="${pessoa.ativo=='N'}">checked="checked"</c:if> /> Desligado
					    </div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">	
					        <label for="ativo">Destaque:</label>
					        <input type="radio" name="destaque" id="destaque" value="S" <c:if test="${pessoa.destaque=='S'}">checked="checked"</c:if> /> Sim
					        <input type="radio" name="destaque" id="destaque" value="N" <c:if test="${pessoa.destaque=='N'}">checked="checked"</c:if> /> Não
					    </div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">	
					        <label for="preco">Categoria:</label>
					        <input type="text" name="categoria" id="categoria" value="${pessoa.categoria}" maxlength="1" class="form-control"/>
					    </div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">	
					        <label for="preco">Preço:</label>
					        <input type="text" name="preco" id="preco" value="${pessoa.preco}" class="form-control"/>
					    </div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">				    		
			    			<label>Data de Nascimento:</label>				    			 
					        <div class="input-group date" id="datetimepicker">				                 
				                 <input type="text"  data-format="dd/MM/yyyy" name="dataNascimento" id="dataNascimento" value="<fmt:formatDate value="${pessoa.dataNascimento.time}" pattern="dd/MM/yyyy" />" class="form-control" />
				                 
				                 <span class="input-group-addon">
				                     <span class="glyphicon glyphicon-calendar"></span>
				                 </span>
				             </div>
				            <script type="text/javascript">
				             	$(document).ready(function() {
				            	  $(function() {
				            	    $('#datetimepicker').datetimepicker({					                 
					                    autoclose: true,
					                    todayBtn: true,
					                    pickTime: true ,
					                    pickerPosition: "bottom-left",
					                    language: 'pt-BR'
					                });
				            	  });
				            	});
							</script>			    		
					    </div>
					</div>
				</div>
				
				
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">	
					        <label for="altura">Altura:</label>
					        <input type="text" name="altura" id="altura" value="${pessoa.altura}" class="form-control"/>
					    </div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">	
					        <label for="peso">Peso:</label>
					        <input type="text" name="peso" id="peso" value="${pessoa.peso}" class="form-control"/>
					    </div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">	
					        <label for="manequim">Manequim:</label>
					        <input type="text" name="manequim" id="manequim" value="${pessoa.manequim}" class="form-control"/>
					    </div>
					</div>
				</div>
				
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">	
					        <label for="cidade">Cidade:</label>
					        <input type="text" name="cidade" id="cidade" value="${pessoa.cidade}" class="form-control"/>
					    </div>
					</div>
				</div>
				
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">	
					        <label for="uf">Estado:</label>
					        <input type="text" name="uf" id="uf" value="${pessoa.uf}" class="form-control"/>
					    </div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">	
					        <label for="descricao">Descrição:</label>
					        <textarea rows="5" cols="100" name="descricao" id="descricao" class="form-control">${pessoa.descricao}</textarea>			     
					    </div>		
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">	
					        <label for="filep">Foto Principal:</label>
					        <input type="file" name="filep" id="filep" class="form-control" value="${pessoa.localFotoPrincipal}" />
					    </div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">	
					        <label for="filed">Foto Destaque:</label>
					        <input type="file" name="filed" id="filed" class="form-control" value="${pessoa.localFotoDestaque}" />
					    </div>
					</div>
				</div>	
			    <button type="submit" class="btn btn-primary">Alterar</button>
			</form>
		</div>
	</div>
	<jsp:include page="../rodape.jsp" />  
	</div>
</body>
</html>