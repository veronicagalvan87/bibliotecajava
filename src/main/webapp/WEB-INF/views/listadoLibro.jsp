<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<script type="text/javascript"
	src="<c:url value="/static/js/autor.js" />"></script>
<body>



	<table class="table table-hover">
		<thead>
			<tr>
				<th>Id</th>
				<th>Título</th>
				<th>Autor</th>
				<th>Categoría</th>
				<th>Editar</th>
				<th>Borrar</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${libros}" var="libro">
				<tr data-id="${libro.id}">
					<td>${libro.id}</td>
					<td><a href="<c:url value="/libros/libro/${libro.id}" />">${libro.titulo}</a></td>
					<td><a
						href="<c:url value="/autores/autor/${libro.autor.id}" />">${libro.autor.nombre}</a></td>
					<td>${libro.categoria }</td>
					<td><a class="editar-autor btn btn-warning">Editar</a></td>
					<td><a class="btn btn-danger open-Modal"
						data-nombre="${autor.nombre}" data-id="${autor.id}"
						data-toggle="modal" href='#modal-borrar'>Borrar</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5"><a class="btn btn-primary" data-toggle="modal"
					href='#modal-autor'>Añadir libro</a></td>
			</tr>
		</tbody>
	</table>



	<!-- empiezan la diversion -->

	<div class="modal fade" id="modal-libro">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title">Añadir Libro</h4>
				</div>
				<form method="POST" action="<c:url value="/libros"/>" role="form">
					<div class="modal-body">
						<div class="form-group">
							<label for="Nombre">Título</label> <input type="text"
								class="form-control" id="titulo-libro" name="libro"
								placeholder="Título del libro"> 
							<label for="Nombre">Autor</label> <input type="text" 
								class="form-control" id="titulo-libro"
								name="libro" placeholder="Título del libro"> 
							<label for="Nombre">Categoría</label> <input type="text"
								class="form-control" id="titulo-libro" name="libro"
								placeholder="Título del libro">
						</div>
						<input type="hidden" name="id" id="inputId" class="form-control"
							value="">
					</div>

					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
						<button type="submit" class="btn btn-primary">Guardar</button>
					</div>
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