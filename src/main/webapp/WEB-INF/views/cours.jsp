<%@ include file="_include/header.jsp" %>

<body>
	
	<h2>
		Liste des cours
	</h2>
	
	<c:if test="${!empty listCours}">
		<table class="tg">
		<tr>
			<th width="80">ID</th>
			<th width="120">Titre</th>
			<th width="200">Résumé</th>
			<th width="200">Compétences</th>
			<th width="60">Edit</th>
			<th width="60">Delete</th>
		</tr>
		<c:forEach items="${listCours}" var="cours">
			<tr>
				<td>${cours.idc}</td>
				<td>${cours.titre}</td>
				<td>${cours.resume}</td>
				<td>${cours.competences}</td>
				<td><a href="<c:url value='/editCours/${cours.idc}' />" >Edit</a></td>
				<td><a href="<c:url value='/removeCours/${cours.idc}' />" >Delete</a></td>
			</tr>
		</c:forEach>
		</table>
	</c:if>
	<br><br>
	
	<!--  ################################################################### -->
	
	<h3>
		Ajouter / modifier un cours
	</h3>
	<h5>
		(pour add/edit/delete une session, se rendre sur un "Espace Enseignant")	
	</h5>
	<br>
	<c:url var="addAction" value="/cours/add" ></c:url>
	<form:form action="${addAction}" commandName="cours">
	<table>
		<c:if test="${!empty cours.titre}">
		<tr>
			<td>
				<form:label path="idc">
					<spring:message text="ID :"/>
				</form:label>
			</td>
			<td>
				<form:input path="idc" readonly="true" size="8"  disabled="true" />
				<form:hidden path="idc" />
			</td> 
		</tr>
		</c:if>
		<tr>
			<td>
				<form:label path="titre">
					<spring:message text="Titre : "/>
				</form:label>
			</td>
			<td>
				<form:input path="titre" />
			</td> 
		</tr>
		<tr>
			<td>
				<form:label path="resume">
					<spring:message text="Résumé : "/>
				</form:label>
			</td>
			<td>
				<form:input path="resume" />
			</td>
		</tr>
		<tr>
			<td>
				<form:label path="competences">
					<spring:message text="Compétences : "/>
				</form:label>
			</td>
			<td>
				<form:input path="competences" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<c:if test="${!empty cours.titre}">
					<input type="submit"
						value="<spring:message text="Modifier"/>" />
				</c:if>
				<c:if test="${empty cours.titre}">
					<input type="submit"
						value="<spring:message text="Ajouter"/>" />
				</c:if>
			</td>
		</tr>
	</table>	
	</form:form>

</body>

