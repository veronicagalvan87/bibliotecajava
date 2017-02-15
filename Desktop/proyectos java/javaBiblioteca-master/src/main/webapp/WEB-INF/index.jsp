<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Biblioteca - Login</title>
<link href="<c:url value="/static/css/style.css" />" rel="stylesheet">
<c:set var="path" value="${pageContext.request.contextPath}"
	scope="request" />
<style type="text/css">
#login {
	width: 400px;
	margin-left: auto;
	margin-right: auto;
	margin-top: 100px;
}
#btn-login {
	width: 100%;
}
#btn-registro {
	width: 100%;
}
</style>
</head>
<body>
	<section id="login" class="panel panel-primary">

		<c:if test='${not empty param["sinacceso"]}'>
			<div class="alert alert-warning">Usuario y/o contraseña
				incorrectos!</div>
		</c:if>

		<c:if test='${not empty param["salir"]}'>
			<div class="alert alert-info">Ha salido del sistema!</div>
		</c:if>

		<form action='<c:url value="/autenticar"/>' method="post">
			<div class="panel-heading">Biblioteca - Login</div>

			<div class="panel-body">
				<label for="usuario"></label> <input id="usuario" name="username"
					class="form-control" required> <label for="password"></label>
				<input type="password" id="password" name="password"
					class="form-control" required>
			</div>

			<div class="panel-footer">
				<p>
					<button id="btn-login" class="btn btn-primary">Entrar</button>
				</p>
				<p>
					<a id="btn-registro" data-toggle="modal" class="btn btn-info"
						href="#modal-registro">¿No tiene cuenta? Registrese</a>
				</p>
			</div>

			<input type="hidden" id="_csrf" name="_csrf" value="${_csrf.token}">
		</form>


	</section>

	<div class="modal fade" id="modal-registro">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title text-center">
						<spring:message code="views.menu.register" />
					</h4>
				</div>
				<form action="<c:url value="/login" />" method="POST" role="form">
					<div class="modal-body">
						<div class="form-group">
							<label for=""><spring:message code="views.index.mail" /></label>
							<input name="email" type="email" class="form-control" id=""
								placeholder="Email">
						</div>
						<div class="form-group">
							<label for=""><spring:message code="views.index.pass" /></label>
							<input name="contrasena" type="password" class="form-control" id=""
								placeholder="Contraseña">
						</div>
						<div class="form-group">
							<label for=""><spring:message code="views.index.name" /></label>
							<input name="nombre" type="text" class="form-control" id=""
								placeholder="Nombre">
						</div>
						<div class="form-group">
							<label for=""><spring:message code="views.index.lastname" /></label>
							<input name="apellido" type="text" class="form-control" id=""
								placeholder="Apellido">
						</div>

						<div class="form-group">
							<label for=""><spring:message code="views.index.dir" /></label>
							<input name="direccion" type="text" class="form-control" id=""
								placeholder="Direccion">
						</div>

						<div class="form-group">
							<label for=""><spring:message code="views.index.tel" /></label>
							<input name="telefono" type="text" class="form-control" id=""
								placeholder="Telefono">
						</div>


						<input type="hidden" id="input" name="id" class="form-control"
							value="">
						<sec:authorize access="isAnonymous()">
							<input type="hidden" id="input" name="roles"
								class="form-control" value="2">
						</sec:authorize>
						<sec:authorize access="hasRole('ADMIN')">
							<input type="hidden" id="input" name="roles"
								class="form-control" value="1">
						</sec:authorize>
						<input type="hidden" name="_csrf" id="_csrf" class="form-control"
							value="${_csrf.token}">
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">
							<spring:message code="views.menu.close" />
						</button>
						<button type="submit" class="btn btn-primary">
							<spring:message code="views.menu.register" />
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>