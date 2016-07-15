<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script type="text/javascript" src="js/my.js"></script>
</head>
<body>
	<% String nameUserForProfil = (String)request.getAttribute("nameUser"); %>

	<% if(nameUserForProfil!=null && nameUserForProfil!=""){%>
		<div id="profil"><% out.print(nameUserForProfil);%></div>
		
		<form method="get"><input type="submit" name="logout" value="logout"></form>
	<% } else { %>
		<% String cookPass = (String)request.getAttribute("cookPass");  %>
		<% String cookLogin = (String)request.getAttribute("cookLogin");  %>
		<% if(cookPass == null) cookPass = "";%>
		<% if(cookLogin == null) cookLogin = "";%>
		<form method="get">
			<input type="text" placeholder="Ввести логин" name="login" value="<% out.print(cookLogin); %>" >
			<input type="pass" name="pass" value="<% out.print(cookPass); %>" >
			<input type="submit">
		</form>
	<%} %>
	<hr>
    <div id="block1">контент 1</div>
    <div id="block2">контент 2</div>
    <div id="block3">контент 3</div>
    <div id="block4">контент 4</div>
</body>
</html>
