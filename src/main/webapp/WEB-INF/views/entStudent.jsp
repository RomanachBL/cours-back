<%@ include file="_include/header.jsp" %>

<body>

	<!--  Div � gauche -->
	<div style="width:45%;float:left">
		<h2> Espace �tudiant </h2><br>
		
		<!--  Infos de l'�tudiant en r�cup�rant la variable de cet �tudiant en question selon l'id (getStudentById() dans le controlleur)  -->
		<ul>
			<li><span style="font-weight:bold;text-decoration:underline;">ID :</span> ${entStudent.ids}</li><br>
			<li><span style="font-weight:bold;text-decoration:underline;">Nom :</span> ${entStudent.noms}</li><br>
			<li><span style="font-weight:bold;text-decoration:underline;">Prenom :</span> ${entStudent.prenoms}</li><br>
		</ul>
		
		<!--  #################### Liste des sessions o� il n'est pas inscrit #################### -->
		<!--  ############################ (et o� il peut s'inscrire) ############################ -->
		<br><br>
		<h3> M'inscrire � une session ? </h3>
		
		<!--  Affichage liste de toutes les sessions -->
			<c:if test="${!empty listSessions}">
				<table class="tg">
				<tr>
					<th width="80">ID</th>
					<th width="120">Cours</th>
					<th width="170">Professeur</th>
					<th width="170">Date de d�but</th>
					<th width="170">Nombre de semaines</th>
					<th width="120"></th>
	
				</tr>
				<c:forEach items="${listSessions}" var="session">
						<tr>
							<td>${session.idsess}</td>
							<td>${session.getUnCours().titre}</td>
							<td>${session.getUnProf().prenomp.charAt(0)}. ${session.getUnProf().nomp}</td>
							<td>${session.datedeb}</td>
							<td>${session.semaines}</td>
							<!--  Variable de test -->
							<!--  Si l'�tudiant est d�j� inscrit dans cette session, alors test = 1, sinon 0. -->
							<c:set var="test" value="0" />
							<c:forEach items="${session.getLesEtudiants()}" var="insc">
								<c:if test="${insc.ids == entStudent.ids}">
									<c:set var="test" value="1" />
								</c:if>
							</c:forEach>
							<c:if test="${test == 0}">													<!-- Petit script JS pour faire une alert de confirmation -->
								<td><a href="<c:url value='/inscr/${session.idsess}/${entStudent.ids}' />" onClick="return conf()" >S'inscrire</a></td>
							</c:if>
							<c:if test="${test == 1}">
								<td>D�j� inscrit</td>
							</c:if>
						</tr>
				</c:forEach>
				</table>
			</c:if>
		
		<!--  S'il n'y a aucune session .. peu probable ! -->
		<c:if test="${empty listSessions}">
			<h4 style="color:red">Il n'y a aucune session.</h4>
		</c:if>	
	</div>
	
	<!--  div � droite  -->
	<div style="width:50%;float:right">
		
		<h3> Liste des sessions o� je suis inscrit :</h3>
		
		<!--  Affichage liste des sessions de l'�tudiant -->
		<c:if test="${!empty entStudent.getInscSessions()}">
			<table class="tg">
			<tr>
				<th width="50">ID</th>
				<th width="120">Cours</th>
				<th width="120">Professeur</th>
				<th width="120">Date de d�but</th>
				<th width="150">Nombre de semaines</th>
			</tr>
			<c:forEach items="${entStudent.getInscSessions()}" var="insc">
				<tr>
					<td>${insc.idsess}</td>
					<td>${insc.getUnCours().titre}</td>
					<td>${insc.getUnProf().prenomp.charAt(0)}. ${insc.getUnProf().nomp}</td>
					<td>${insc.datedeb}</td>
					<td>${insc.semaines}</td>
				</tr>
			</c:forEach>
			</table>
		</c:if>
		
		<!--  Si l'�tudiant n'est inscrit � aucune des sessions -->
		<c:if test="${empty entStudent.getInscSessions()}">
			<h4 style="color:red">Vous n'�tes inscrit � aucune session.</h4>
		</c:if>	
		
	</div>
	
</body>
</html>

<script>
	function conf(){
		var r=confirm("Toute inscription est d�finitive ! Voulez-vous confirmer ?");
		if (r==true)
		{
			return true;
		}
		else
		{
			return false;
		}
 	}
</script>