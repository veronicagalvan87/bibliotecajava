<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<link rel="shortcut icon"
	href="<c:url value="static/img/favicon.ico" />" type="image/x-icon">
<link rel="icon" href='<c:url value="static/img/favicon.ico" />'
	type="image/x-icon">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title><sitemesh:write property='title' /></title>

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

<sitemesh:write property='head' />

</head>

<body>
	<div class="navbar">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">CSD</a>
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="<c:url value="/" />">Inicio</a></li>
				<li><a href="<c:url value="/autores" />">Autores</a>
				</li>
				<li><a href="<c:url value="/libros" />">Libros</a></li>
				<li><a href="<c:url value="/" />">Login</a></li>
			</ul>
		</div>
	</div>
	<sitemesh:write property='body' />
</body>
</html>