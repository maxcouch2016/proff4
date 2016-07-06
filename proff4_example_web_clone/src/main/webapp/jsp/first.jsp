<%@ page import="java.util.List"%>
<%@ page import="domain.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% List<Product> listContent = (List<Product>)request.getAttribute("products"); %>
	First Page-добавили
<hr>
<% for(Product pr: listContent) out.println("<p>"+pr.getName()+"</p>"); %>
<hr>
<form method="post">
	<input type="text" name="polk" placeholder="Введите что-то">
	<input type="submit" value="отпр.">	
</form>
	
</body>
</html>