<%@ include file="_include/header.jsp" %>

<body>

	<!-- Simple jsp qui permet de voir les d�tails d'une Session de Cours -->

	<div style="width:50%;float:left">
		<h3> Session n�${sessDet.idsess} </h3><br>
		<ul>
			<li><span style="font-weight:bold;text-decoration:underline;"> ID :</span> ${sessDet.idsess} </li><br>
			<li><span style="font-weight:bold;text-decoration:underline;"> Cours :</span> ${sessDet.getUnCours().getTitre()} </li><br>
			<li><span style="font-weight:bold;text-decoration:underline;"> Professeur :</span> Mr/Mme ${sessDet.getUnProf().getPrenomp()} ${sessDet.getUnProf().getNomp()} </li><br>
			<li><span style="font-weight:bold;text-decoration:underline;"> Date de d�but :</span> ${sessDet.datedeb} </li><br>
			<li><span style="font-weight:bold;text-decoration:underline;"> Nombre de semaines :</span> ${sessDet.semaines} </li><br>
		</ul>
	
		<br><h4><a href="<c:url value='/cours' />" > Revenir en arri�re </a></h4><br>
		
		<span style="font-style:italic"> Vous voulez vous y inscrire ? Rendez-vous sur votre ENT �tudiant (� l'accueil).</span><br><br>
	</div>
	
	
	<div style="width:50%;float:right;margin-top:20px">
		<c:if test="${!empty sessDet.getLesEtudiants()}">
			<h3> Liste des �tudiants inscrits :</h3>
			<table  class="tg" style="margin-top:50px">
				<tr>
					<th width="120"> Nom </th>
					<th width="120"> Pr�noms </th>
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
			<h3 style="color:red">Aucun �tudiant inscrit pour cette session</h3>
		</c:if>
	</div>

</body>
</html>