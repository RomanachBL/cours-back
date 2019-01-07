<%@ include file="_include/header.jsp" %>

<body>
	
	<h2>
		Liste des professeurs
	</h2>
	
	<c:if test="${!empty listProf}">
		<table class="tg">
		<tr>
			<th width="80">ID</th>
			<th width="120">Nom</th>
			<th width="120">Prenom</th>
			<th width="60">Edit</th>
			<th width="60">Delete</th>
		</tr>
		<c:forEach items="${listProf}" var="prof">
			<tr>
				<td>${prof.idp}</td>
				<td>${prof.nomp}</td>
				<td>${prof.prenomp}</td>
				<td><a href="<c:url value='/editProf/${prof.idp}' />" >Edit</a></td>
				<td><a href="<c:url value='/removeProf/${prof.idp}' />" >Delete</a></td>
			</tr>
		</c:forEach>
		</table>
	</c:if>
	<br>
	
	<!--  ################################################################### -->
	
	<h3>
		Ajouter / modifier un professeur
	</h3>
	
	<c:url var="addAction" value="/prof/add" ></c:url>
	<form:form action="${addAction}" commandName="prof">
	<table>
		<c:if test="${!empty prof.nomp}">
		<tr>
			<td>
				<form:label path="idp">
					<spring:message text="IDp"/>
				</form:label>
			</td>
			<td>
				<form:input path="idp" readonly="true" size="8"  disabled="true" />
				<form:hidden path="idp" />
			</td> 
		</tr>
		</c:if>
		<tr>
			<td>
				<form:label path="nomp">
					<spring:message text="Nom : "/>
				</form:label>
			</td>
			<td>
				<form:input path="nomp" />
			</td> 
		</tr>
		<tr>
			<td>
				<form:label path="prenomp">
					<spring:message text="Prenom : "/>
				</form:label>
			</td>
			<td>
				<form:input path="prenomp" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<c:if test="${!empty prof.nomp}">
					<input type="submit"
						value="<spring:message text="Modifier"/>" />
				</c:if>
				<c:if test="${empty prof.nomp}">
					<input type="submit"
						value="<spring:message text="Ajouter"/>" />
				</c:if>
			</td>
		</tr>
	</table>	
	</form:form>

</body>

