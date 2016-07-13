<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="domain.Content"%>

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
	<% List<Content> contents = (List<Content>)request.getAttribute("contents"); %>
	<div class="wrap">
		
		<div class="messagePage">
			<% for(Content cont: contents){%>
			<div class="messageBlock">
				<% out.println(cont.toPage());%>
			</div>
			<%}%>
		</div>
		<% String text = (String) request.getAttribute("formText");
		if (text != null) out.println(text); %>
		
	</div>
</body>
</html>