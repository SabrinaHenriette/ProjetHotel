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

<!-- Formulaire pour ajouter une réservation -->
<br/>
<div style="background-color: white; padding-left: 6px; margin-left: 6px; padding-right: 6px; margin-right: 6px;">
	<form method="post" action="ajouterReservation" class="form">
			<div class="form-group">
				<label>Ajouter une Réservation : </label>
			</div>
			<div class="form-group">
				<label for="idEmploye">ID Employé :</label> <input type="text"
					class="form-control" placeholder="ID Employé" name="idEmploye" id="idEmploye">
				<label for="idClient">ID Client</label> <input type="text"
					class="form-control" placeholder="ID Client" name="idClient" id="idClient">
				<label for="dateDebut">Date Début :</label> <input type="date"
					class="form-control" placeholder="AAAA/MM/JJ" name="dateDebut" id="dateDebut">
				<label for="dateFin">Date Fin :</label> <input type="date"
					class="form-control" placeholder="AAAA/MM/JJ" name="dateFin" id="dateFin">
				<label id="etatReservation">Etat de la réservation :</label> <textarea class="form-control" 
				placeholder="Etat de la réservation" row="2" name="etatReservation" id="etatReservation"></textarea>
			</div>
			<button type="submit" class="btn btn-primary">Ajouter</button>
			<br/>
	</form>
	<br>
</div>
<!-- Fin Formulaire pour ajouter une réservation -->
<br>
<!-- Début des formulaire d'affichage des réservations : -->
<div  style="background-color: white; padding-left: 6px; margin-left: 6px; padding-right: 6px; margin-right: 6px;">

<!-- Formulaire pour afficher toutes les réservations -->
<br/>
		<div>
			<form method="post" action="afficherToutesReservations" class="form-inline">
				<p>
					<label for="idReservation">Afficher toutes les réservations : </label>  		
					<input type="submit" value="Afficher" class="btn btn-primary">
				</p>
			</form>
		</div>
<!-- FIN Formulaire pour afficher toutes les réservations -->

<!-- Formulaire pour afficher une réservations par son ID -->
<br/>
		<div>
			<form method="post" action="afficherReservationParIdReservation" class="form-inline">
				<p>		
					<label for="idReservation">Afficher une réservation par son ID : </label>  
					<input type="text" name="idReservation" id="idReservation" placeholder="ID de la réservation" class="form-control"/>					
					<input type="submit" value="Afficher" class="btn btn-primary">
				</p>
			</form>
		</div>
<!-- FIN Formulaire pour afficher une réservations par son ID -->

<!-- Formulaire pour afficher une réservations par son idClient -->
<br/>
		<div>
			<form method="post" action="afficherReservationParIdClient" class="form-inline">
				<p>		
					<label for="idClient">Afficher une réservation par l'ID du Client : </label>  
					<input type="text" name="idClient" id="idClient" placeholder="ID du client" class="form-control"/>					
					<input type="submit" value="Afficher" class="btn btn-primary">
				</p>
			</form>
		</div>
<!-- FIN Formulaire pour afficher une réservations par son idClient -->

<!-- Formulaire pour afficher une réservations par son idEmploye -->
<br/>
		<div>
			<form method="post" action="afficherReservationParIdEmploye" class="form-inline">
				<p>		
					<label for="idEmploye">Afficher une réservation par l'ID de l'Employé : </label>  
					<input type="text" name="idEmploye" id="idEmploye" placeholder="ID de l'employé" class="form-control"/>					
					<input type="submit" value="Afficher" class="btn btn-primary">
				</p>
			</form>
		</div>
<!-- FIN Formulaire pour afficher une réservations par son idEmploye -->

<!-- Formulaire pour afficher une réservations par son idChambre -->
<br/>
		<div>
			<form method="post" action="afficherReservationParIdChambre" class="form-inline">
				<p>		
					<label for="idChambre">Afficher une réservation par le numéro de Chambre : </label>  
					<input type="text" name="idChambre" id="idChambre" placeholder="N=° de chambre" class="form-control"/>					
					<input type="submit" value="Afficher" class="btn btn-primary">
				</p>
			</form>
		</div>
<!-- FIN Formulaire pour afficher une réservations par son idChambre -->
<br>
</div>

<!-- Fin des formulaire d'affichage des réservations -->

<!-- Liste des réservations -->
<br/>
<div style="background-color: white; padding-left: 6px; margin-left: 6px; padding-right: 6px; margin-right: 6px;">
		<div>
			<h2>Liste des réservations</h2>
			<table class="table">
				<th>ID Réservation</th>
				<th>Date début</th>
				<th>Date fin</th>
				<th>Etat/Statut</th>
				<th>id Client</th>
				<th>id Employé</th>
				<th></th>
<!-- 				<th></th> -->
				<c:forEach items="${listeReservation}" var="r">
					<tr>
						<td>${r.idReservation}</td>
						<td>${r.dateDebut}</td>
						<td>${r.dateFin}</td>
						<td>${r.etatReservation}</td>
						<td>${r.client.idPersonne}</td>
						<td>${r.employe.idPersonne}</td>
						<td><a class="btn btn-primary" href="/detailReservation/{r.idReservation}" role="button"></a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
</div>
<!-- FIN Liste des réservations -->

<br>

<!-- Disponibilité des chambres : -->
<br/>
<div style="background-color: white; padding-left: 6px; margin-left: 6px; padding-right: 6px; margin-right: 6px;">
	<form method="post" action="rechercherDisponibilite" class="form">
			<div class="form-group">
				<label>Disponibilité des chambres : </label>
			</div>
			<div class="form-group">
				<label for="dateDebut">Date Début :</label> <input type="date"
					class="form-control" placeholder="AAAA/MM/JJ" name="dateDebut" id="dateDebut">
				<label for="dateFin">Date Fin :</label> <input type="date"
					class="form-control" placeholder="AAAA/MM/JJ" name="dateFin" id="dateFin">
			</div>
			<button type="submit" class="btn btn-primary">Rechercher</button>
			<br/>
	</form>
	<br>
</div>
<!-- Fin de Disponibilité des chambres -->

<!-- Liste des chambres disponibles -->
<br/>
<div style="background-color: white; padding-left: 6px; margin-left: 6px; padding-right: 6px; margin-right: 6px;">
		<div>
			<h2>Liste des chambres disponibles</h2>
			<table class="table">
				<th>Numéro</th>
				<th>Description</th>
				<th>Capacité</th>
				<th>Prix</th>
				<c:forEach items="${listeChambres}" var="c">
					<tr>
						<td>${c.idChambre}</td>
						<td>${c.description}</td>
						<td>${c.capacite}</td>
						<td>${c.prix}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
</div>
<!-- FIN Liste chambres disponibles -->

<!-- Formulaire pour ajouter une Chambre à une réservation -->
<br/>
<div style="background-color: white; padding-left: 6px; margin-left: 6px; padding-right: 6px; margin-right: 6px;">
	<form method="post" action="ajouterUneChambreAReservation" class="form">
			<div class="form-group">
				<label>Ajouter une Chambre à une réservation: </label>
			</div>
			<div class="form-group">
				<label for="idReservation">ID Réservation :</label> <input type="text"
					class="form-control" placeholder="ID Réservation" name="idReservation" id="idReservation">
				<label for="IdChambre">N° de Chambre</label> <input type="text"
					class="form-control" placeholder="N=° de Chambre" name="IdChambre" id="IdChambre">
			<button type="submit" class="btn btn-primary">Ajouter</button>
			<br/>
	</form>
	<br>
</div>
<!-- Fin Formulaire pour ajouter une Chambre à une réservation -->



</body>
</html>