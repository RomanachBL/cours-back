<%@ include file="_include/header.jsp" %>

<body>

	<h2>
		Liste des étudiants
	</h2>
	
	<c:if test="${!empty listStudent}">
		<table class="tg">
		<tr>
			<th width="80">ID</th>
			<th width="120">Nom</th>
			<th width="120">Prenom</th>
			<th width="60">Edit</th>
			<th width="60">Delete</th>
		</tr>
		<c:forEach items="${listStudent}" var="student">
			<tr>
				<td>${student.ids}</td>
				<td>${student.noms}</td>
				<td>${student.prenoms}</td>
				<td><a href="<c:url value='/editStu/${student.ids}' />" >Edit</a></td>
				<td><a href="<c:url value='/removeStu/${student.ids}' />" >Delete</a></td>
			</tr>
		</c:forEach>
		</table>
	</c:if>
	<br> 
	
	<!--  ################################################################### -->
	
	<h3>
		Ajouter / modifier un étudiant
	</h3>
	
	<c:url var="addAction" value="/student/add" ></c:url>
	<form:form action="${addAction}" commandName="student">
	<table>
		<c:if test="${!empty student.noms}">
		<tr>
			<td>
				<form:label path="ids">
					<spring:message text="IDs"/>
				</form:label>
			</td>
			<td>
				<form:input path="ids" readonly="true" size="8"  disabled="true" />
				<form:hidden path="ids" />
			</td> 
		</tr>
		</c:if>
		<tr>
			<td>
				<form:label path="noms">
					<spring:message text="Nom : "/>
				</form:label>
			</td>
			<td>
				<form:input path="noms" />
			</td> 
		</tr>
		<tr>
			<td>
				<form:label path="prenoms">
					<spring:message text="Prenom : "/>
				</form:label>
			</td>
			<td>
				<form:input path="prenoms" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<c:if test="${!empty student.noms}">
					<input type="submit"
						value="<spring:message text="Modifier"/>" />
				</c:if>
				<c:if test="${empty student.noms}">
					<input type="submit"
						value="<spring:message text="Ajouter"/>" />
				</c:if>
			</td>
		</tr>
	</table>	
	</form:form>
	
</body>

