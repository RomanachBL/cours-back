<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Gestion de cours</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
		footer{position: absolute; bottom:0; right:0; left:0; padding-left: 5px; border-top: 1px solid black;}
		.titreHeader{text-align:center}
		.accueil{position: absolute; right:0; padding-right: 30px; font: normal bold 25px serif}
		.accueil > a{text-decoration:none}
		.accueil > a:hover{opacity:0.5}
	</style>
</head>
<span class="accueil"><a href="<c:url value='/' />"> Accueil </a></span>

<html>
