<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/bootstrap.css">
<title>Reservation</title>
</head>
<body style="background-color: rgb(34,34,34);">

<!-- Entête -->
<div style="background-image: url(<%=request.getContextPath()%>/resources/ban.jpg);">
		<h1 style="text-align: right; color: white;">Atlantis<br/>
			<small>Gestion hotel</small>
		</h1>
</div>
<div>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="home">Navigation</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="home">Accueil</a></li>
				<li><a href="produit">Produit</a></li>
				<li><a href="devis">Devis</a></li> 
				<li><a href="facture">Facture</a></li> 
				<li class="active"><a href="reservation">Reservation</a></li> 
				<li><a href="personne">Personne</a></li>
				<li><a href="chambre">Chambre</a></li>
			</ul>
		</div>
	</nav>
</div>
<!-- FIN Entête -->

<div style="background-color: white; padding-left: 6px; margin-left: 6px; padding-right: 6px; margin-right: 6px;">
			<div class="form-group">
				<label>Reservation effectué</label>
			</div>
</div>



</body>
</html>