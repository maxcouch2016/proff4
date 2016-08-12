<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>	
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script type="text/javascript" src="js/myjs.js"></script>
</head>
<body>
	Home page
	<table id="myTable"></table>
	<% Integer countPage = (Integer)request.getAttribute("countPage");%>
	<% if(countPage!=null && countPage>1) { %>
		<div class="StyleNavigationPage">
			<% for(int i=0;i<countPage;i++){ %>
				<% String name = (10*i+1)+" - " + (10*(i+1)); %>
				<p onlclick="ajaxFunctionPage(<% out.print(i); %>)"><% out.print(name); %></p>
			<%} %>
		</div>
	<% } %>		
</body>
</html>