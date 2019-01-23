<%@ include file="WEB-INF/views/_include/header.jsp" %>
<body>
	<header>
		<h1 class="titreHeader"> Cours-Back </h1>
	</header>	
	<div id="divIndex">
	<br><br>
	<h2>
		Cliquez sur un lien :
	</h2>
	
	<a href="<c:url value='/student' />" >Afficher les étudiants</a><br>
	<a href="<c:url value='/prof' />" >Afficher les professeurs</a><br>
	<a href="<c:url value='/cours' />" >Afficher les cours et les sessions</a>
		
	<br><br><br>
	
	<h3>
		Etudiant ? Accédez à votre ENT :
	</h3>
	
	<c:url var="EntStu" value="/entStu/${ids}" ></c:url>

	<form action="${EntStu}">
		<table>
			<tr>
				<td>
					<label>
						<spring:message text="Ecrivez votre id étudiant :"/>
					</label>
				</td>
				<td>
					<input type="number" min="0" name="ids"/>
				</td>
				<td>
					<input type="submit" value="<spring:message text="Valider"/>" />
				</td>
			</tr>
		</table>
	</form>
		
	<br><br>
		
	<h3>
		Enseignant ? Accédez à votre ENT :
	</h3>
		
	<c:url var="EntProf" value="/entProf/${idp}" ></c:url>

	<form action="${EntProf}">
		<table>
			<tr>
				<td>
					<label>
						<spring:message text="Ecrivez votre id enseignant :"/>
					</label>					
				</td>
				<td>
					<input type="number" min="0" name="idp"/>
				</td>
				<td>
					<input type="submit" value="<spring:message text="Valider"/>" />
				</td>
			</tr>
		</table>
	</form>
	</div>
	
</body>
	
<%@ include file="WEB-INF/views/_include/footer.jsp" %>
