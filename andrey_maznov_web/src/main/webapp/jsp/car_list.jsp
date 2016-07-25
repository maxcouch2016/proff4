<%@ page import="java.util.List"%>
<%@ page import="domain.Car"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cars list</title>
</head>
<body>
	<form method="post">
		<input type="text" name="number" placeholder="Enter number">
		<input type="text" name="model" placeholder="Enter model"> 
		<input type="submit" value="Add">
	</form>
	<hr>
	<% List<Car> listContent = (List<Car>) request.getAttribute("cars");
	if (listContent.size() > 0) {
		out.println("Cars list");
		out.println("<table border=\"2\"><tr><td>Model</td><td>Number</td></tr>");
		for (Car car : listContent) {
			out.println("<tr><td> " + car.getModel() + "</td><td>" + car.getNumber() + "</td></tr>");
		};
	} %>
	
</body>
</html>