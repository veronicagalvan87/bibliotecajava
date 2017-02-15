<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta name="_csrf" content="${_csrf.token}" />
<!-- default header name is X-CSRF-TOKEN -->
<meta name="_csrf_header" content="${_csrf.headerName}" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript"
	src="<c:url value="/static/js/autor.js" />"></script>
</head>

<body>

	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<h2>Buscar Autores por nombre</h2>
				<div id="custom-search-input">
					<div class="input-group col-md-12">
						<input type="text" id="AJAXnombreAutor"
							class="form-control input-lg" placeholder="Buscar" /> <span
							class="input-group-btn">
							<button class="btn btn-info btn-lg" id="AJAXautores"
								type="button">
								<i class="glyphicon glyphicon-search"></i>
							</button>
						</span>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div id="ajaxOutput">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nombre</th>
					<th>Editar</th>
					<th>Borrar</th>
				</tr>
			</thead>
			<tbody>


				<c:forEach items="${autores}" var="autor">
					<tr data-id="${autor.id}">
						<td>${autor.id}</td>
						<td><a href="<c:url value="/autores/autor/${autor.id}" />">${autor.nombre}</a></td>
						<td><a class="editar-autor btn btn-warning">Editar</a></td>
						<td><a class="btn btn-danger open-Modal"
							data-nombre="${autor.nombre}" data-id="${autor.id}"
							data-toggle="modal" href='#modal-borrar'>Borrar</a></td>
					</tr>
				</c:forEach>

				<tr>
					<td colspan="5"><a class="btn btn-primary" data-toggle="modal"
						href='#modal-autor'>Añadir autor</a></td>
				</tr>
			</tbody>
		</table>

	</div>

	<!-- empiezan la diversion -->

	<div class="modal fade" id="modal-autor">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">Añadir Autor</h4>
				</div>
				<form method="POST" action="<c:url value="/autores"/>" role="form">
					<div class="modal-body">
						<div class="form-group">
							<label for="Nombre">Nombre</label> <input type="text"
								class="form-control" id="nombre-autor" name="nombre"
								placeholder="Input field">
						</div>
						<input type="hidden" name="id" id="inputId" class="form-control"
							value="">
					</div>

					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
						<button type="submit" class="btn btn-primary">Guardar</button>
					</div>
					<input type="hidden" id="_csrf" name="_csrf" value="${_csrf.token}">
				</form>
			</div>
		</div>
	</div>


	<!-- Empieza diversion 2 -->

	<div class="modal fade" id="modal-borrar">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">Estas Seguro??</h4>
				</div>
				<div class="modal-body">
					¿Estas seguro de borrar este autor? <input type="hidden" name=""
						id="autor" class="form-control" value=""> <strong><span
						id="autorNombre"></span></strong>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">No</button>
					<button type="button" class="btn btn-primary btn-borrar"
						data-dismiss="modal">Si</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>