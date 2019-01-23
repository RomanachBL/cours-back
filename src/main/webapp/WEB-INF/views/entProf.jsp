<%@ include file="_include/header.jsp" %>

<body>
	
	<!--  Div à gauche -->
	<div style="width:40%;float:left">
		<h2> Espace enseignant </h2><br>
		
		<!--  Infos de l'enseignant en récupérant la variable du professeur en question selon l'id (getProfById() dans le controlleur)  -->
		<ul>
			<li><span style="font-weight:bold;text-decoration:underline;">ID :</span> ${entProf.idp}</li><br>
			<li><span style="font-weight:bold;text-decoration:underline;">Nom :</span> ${entProf.nomp}</li><br>
			<li><span style="font-weight:bold;text-decoration:underline;">Prenom :</span> ${entProf.prenomp}</li><br>
		
			<li>
				<!--  Affichage de ses cours enseignés -->
				<div style="display:flex">
					<span style="font-weight:bold;text-decoration:underline;"> Cours enseignés :</span>
					<c:if test="${!empty entProf.getSpeCours()}">
						<ul style="margin-top:0">
						<c:forEach items="${entProf.getSpeCours()}" var="spe">
							<li> ${spe.titre}</li><br>
						</c:forEach>
						</ul>
					</c:if>
				</div>
			</li>
		</ul>
		
		
		
		<br><br><br>
		
		<h3> Ajouter une spécialité :</h3>
		
		<c:url var="submit" value="/speAdd/${entProf.idp}" ></c:url>
		<form action="${submit}">
		<table>
			<tr>
				<td>
					<label>
						<spring:message text="Choisissez un cours : "/>
					</label>
				</td>
				<td>
					<select name="idcours">
						<c:forEach items="${listCours}" var="cours">
							<!--  Variable de test -->
							<!--  Si un cours est déjà dans sa liste de cours Spé, alors test = 1 (et donc la case de ce cours sera "disabled", sinon test = 0 -->
							<c:set var="test" value="0" />
							<c:forEach items="${entProf.getSpeCours()}" var="spe">
								<c:if test="${spe.titre == cours.titre}">
									<c:set var="test" value="1" />
								</c:if>
							</c:forEach>
							<c:if test="${test == 0}">
								<option value="${cours.idc}"> ${cours.titre} </option><br>
							</c:if>
							<c:if test="${test == 1}">
								<option value="${cours.idc}" disabled> ${cours.titre} </option><br>
							</c:if>
						</c:forEach>
					</select>
				</td>

				<td colspan="2">
					<input type="submit" value="<spring:message text="Valider"/>" />
				</td>
			</tr>
		
		</table>
		
		</form>
		
		
		
		<br><br><br>
		
		<h3> Ajouter une session :</h3>
		
	<c:url var="submit" value="/sessadd/${entProf.idp}" ></c:url>
	<form action="${submit}">
	<table>
		<tr>
			<td>
				<label>
					<spring:message text="ID enseignant : "/>
				</label>
			</td>
			<td>
				<input name="idprof" value="${entProf.idp}" readonly="true" />
			</td>
		</tr>
	
		<tr>
			<td>
				<label>
					<spring:message text="Cours : "/>
				</label>
			</td>
			<td>
				<select name="idcours">
					
					<c:if test="${!empty entProf.getSpeCours()}">
						<c:forEach items="${entProf.getSpeCours()}" var="spe">
							<!-- Compteur qui va compter le nombre de fois où on retrouve un même titre -->
							<c:set var="cpt" value="0" />
							<c:forEach items="${entProf.getSessions()}" var="spetest">
								<c:if test="${spe.titre == spetest.getUnCours().titre}">
									<c:set var="cpt" value="${cpt+1}" />
								</c:if>
							</c:forEach>
							
							<!-- Si le cours n'apparait pas plus de 1 fois (2 fois max) alors on pourra l'ajouter, sinon il n'apparaitra même pas dans les choix -->
							<c:if test="${cpt < 2}">
								<option value="${spe.idc}"> ${spe.titre} </option><br>
							</c:if>

						</c:forEach>
					</c:if>
					
				</select>
			</td>
		</tr>
		
		<tr>
			<td>
				<label>
					<spring:message text="Date de début : "/>
				</label>
			</td>
			<td>
				<input name="datedeb" type="date" />
			</td> 
		</tr>
		
		<tr>
			<td>
				<label>
					<spring:message text="Nombre de Semaines : "/>
				</label>
			</td>
			<td>
				<input name="semaines" type="number" min="1" />
			</td> 
		</tr>
		
		<tr>
			<td colspan="2">
				<input type="submit" value="<spring:message text="Ajouter"/>" />
			</td>
		</tr>
	</table>	
	</form>
		
	</div>
	
	<!-- #################################################################################### -->
	
	<!--  div à droite  -->
	<div style="width:57%;float:right">
		
		<h3> Liste de mes sessions :</h3>
		
		<!--  Affichage liste des sessions que ce professeur a créées -->
		<c:if test="${!empty entProf.getSessions()}">
			<table class="tg">
			<tr>
				<th width="80">ID</th>
				<th width="120">Cours</th>
				<th width="170">Date de début</th>
				<th width="170">Nombre de Semaines</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${entProf.getSessions()}" var="sess">
				<tr>
					<td>${sess.idsess}</td>
					<td>${sess.getUnCours().titre}</td>
					<td>${sess.datedeb}</td>
					<td>${sess.semaines}</td>
					<td><a href="<c:url value='/removeSess/${entProf.idp}/${sess.idsess}' />" >Delete</a></td>
				</tr>
			</c:forEach>
			</table>
		</c:if>
		
		<!--  Si le prof n'a aucune session -->
		<c:if test="${empty entProf.getSessions()}">
			<h4 style="color:red">Vous n'avez créé aucune session.</h4>
		</c:if>
	

	
	</div>	
	
</body>
</html>