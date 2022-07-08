<jsp:directive.page contentType="text/html; charset=UTF-8" />
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<%@include file="base-head.jsp"%>
	</head>
	<body>
		<%@include file="nav-menu.jsp"%>
			
		<div id="container" class="container-fluid">
			<h3 class="page-header">Adicionar Cargo</h3>

			<form action="${pageContext.request.contextPath}/cargo/${action}" method="POST">
				<input type="hidden" value="${cargo.getIdCargo()}" name="idCargo">
				<div class="row">
					<div class="form-group col-md-4">
					<label for="nomeCargo">Nome do Cargo</label>
						<input type="text" class="form-control" id="nomeCargo" name="nomeCargo" 
							   autofocus="autofocus" placeholder="nome do cargo" 
							   required oninvalid="this.setCustomValidity('Por favor, informe o nome do cargo')"
							   oninput="setCustomValidity('')"
							   value="${cargo.getNomeCargo()}">
					</div>
					
					<div class="form-group col-md-4">
					<label for="descricaoCargo">Descrição do Cargo</label>
						<input type="text" class="form-control" id="descricaoCargo" name="descricaoCargo" 
							   autofocus="autofocus" placeholder="descrição do cargo" 
							   required oninvalid="this.setCustomValidity('Por favor, informe a descrição do cargo.')"
							   oninput="setCustomValidity('')"
							   value="${cargo.getDescricaoCargo()}">
					</div>
					
					<div class="form-group col-md-2">
					<label for="salarioCargo">Salário</label>
						<input type="text" class="form-control" id="salarioCargo" name="salarioCargo" 
							   autofocus="autofocus" placeholder="salário do cargo" 
							   required oninvalid="this.setCustomValidity('Por favor, informe o salário do cargo.')"
							   oninput="setCustomValidity('')"
							   value="${cargo.getSalarioCargo()}">
					</div>
					
					<div class="form-group col-md-2">
					<label for="cargaHorariaSemanalCargo">Carga Horária Semanal</label>
						<input type="text" class="form-control" id="cargaHorariaSemanalCargo" name="cargaHorariaSemanalCargo" 
							   autofocus="autofocus" placeholder="cargo horária do cargo" 
							   required oninvalid="this.setCustomValidity('Por favor, informe a carga horária do cargo.')"
							   oninput="setCustomValidity('')"
							   value="${cargo.getCargaHorariaSemanalCargo()}">
					</div>

					</div>
				</div>
				<hr />
				<div id="actions" class="row pull-right">
					<div class="col-md-12">
						<a href="${pageContext.request.contextPath}/cargo" class="btn btn-default">Cancelar</a>
						<button type="submit" class="btn btn-primary">${not empty cargo ? "Alterar Cargo" : "Criar Cargo"}</button>
					</div>
				</div>
			</form>
		</div>

		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</body>
</html>
