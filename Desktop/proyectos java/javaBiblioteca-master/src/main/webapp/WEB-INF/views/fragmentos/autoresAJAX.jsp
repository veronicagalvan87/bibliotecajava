<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
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
