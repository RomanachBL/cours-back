<%@ include file="_include/header.jsp" %>

<body>

	<!-- Simple jsp qui permet de voir les détails d'une Session de Cours -->

	<div style="width:50%;float:left">
		<h3> Session n°${sessDet.idsess} </h3><br>
		<ul>
			<li><span style="font-weight:bold;text-decoration:underline;"> ID :</span> ${sessDet.idsess} </li><br>
			<li><span style="font-weight:bold;text-decoration:underline;"> Cours :</span> ${sessDet.getUnCours().getTitre()} </li><br>
			<li><span style="font-weight:bold;text-decoration:underline;"> Professeur :</span> Mr/Mme ${sessDet.getUnProf().getPrenomp()} ${sessDet.getUnProf().getNomp()} </li><br>
			<li><span style="font-weight:bold;text-decoration:underline;"> Date de début :</span> ${sessDet.datedeb} </li><br>
			<li><span style="font-weight:bold;text-decoration:underline;"> Nombre de semaines :</span> ${sessDet.semaines} </li><br>
		</ul>
	
		<br><h4><a href="<c:url value='/cours' />" > Revenir en arrière </a></h4><br>
		
		<span style="font-style:italic"> Vous voulez vous y inscrire ? Rendez-vous sur votre ENT étudiant (à l'accueil).</span><br><br>
	</div>
	
	
	<div style="width:50%;float:right;margin-top:20px">
		<c:if test="${!empty sessDet.getLesEtudiants()}">
			<h3> Liste des étudiants inscrits :</h3>
			<table  class="tg" style="margin-top:50px">
				<tr>
					<th width="120"> Nom </th>
					<th width="120"> Prénoms </th>
				</tr>
				<c:forEach items="${sessDet.getLesEtudiants()}" var="stu">
					<tr>
						<td> ${stu.noms}</td>
						<td> ${stu.prenoms}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<c:if test="${empty sessDet.getLesEtudiants()}">
			<h3 style="color:red">Aucun étudiant inscrit pour cette session</h3>
		</c:if>
	</div>

</body>
</html>