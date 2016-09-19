<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="domain.Message"%>

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
<% List<Message> messes = (List<Message>)request.getAttribute("mess"); %>
    <div class="wrap">
        <div class="messagePage">
        	<% for(Message m: messes){%>
            <div class="messageBlock">
				<% out.println(m.toPage());%>                
            </div>
            <%}%>
        </div>
        <form method="post">
	        <input type="text" name="dateNewMessage">
	        <select name="catalogNewMessage">
	            <option value="1">Авто</option>
	            <option value="2">Недвижимость</option>
	            <option value="3">Работа</option>
	        </select>
	        <textarea name="textNewMessage"></textarea>
	        <input type="submit" value="добавить">
        </form>
    </div>
</body>
</html>