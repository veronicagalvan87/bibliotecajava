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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
	integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
	crossorigin="anonymous"></script>
<link href="<c:url value="/static/css/style.css" />" rel="stylesheet">
<c:set var="path" value="${pageContext.request.contextPath}"
	scope="request" />
</head>
<body>



	<table class="table table-hover">
		<thead>
			<tr>
				<th>Id</th>
				<th>Título</th>
				<th>Autor</th>
				<th>Editar</th>
				<th>Borrar</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${libros}" var="libro">
				<tr data-id="${libro.id}">
					<td>${libro.id}</td>
					<td><a href="<c:url value="/libross/libro/${libro.id}" />">${libro.titulo}</a></td>
					<td>${libro.autor.id}</td>
					<td><a class="editar-libro btn btn-warning">Editar</a></td>
					<td><a class="btn btn-danger open-Modal"
						data-nombre="${libro.titulo}" data-id="${libro.id}"
						data-toggle="modal" href='#modal-borrar'>Borrar</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5"><a class="btn btn-primary" data-toggle="modal"
					href='#modal-libro'>Añadir Libro</a></td>
			</tr>
		</tbody>
	</table>


</body>
</html>