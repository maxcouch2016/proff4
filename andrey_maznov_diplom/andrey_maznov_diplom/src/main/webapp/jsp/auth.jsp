<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>Authentification</title>
    
	<link rel="stylesheet" href="content/css/style.css">

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <script type="text/javascript" src="content/js/auth.js"></script>
</head>

<body>
	<p class="lang"><spring:message code="auth_label_language" text="Text not found" /> : <a href="?locale=en">English</a>|<a href="?locale=ru">Russian</a><p>
	<div id="login">  
        <form>
            <fieldset class="clearfix">
                <p>
                <span class="fontawesome-user"></span>
                <input id="login_input" type="text" placeholder=<spring:message code="auth_input_username_placeholder" text="Text not found" />>
                </p>
                
                <p>
                <span class="fontawesome-lock"></span>
                <input type="password" id="login_pass" placeholder=<spring:message code="auth_input_password_placeholder" text="Text not found" />>
                </p>
                
                <p><input type="button" id="login_btn" value=<spring:message code="auth_button_value" text="Text not found" />></p>
            </fieldset>
        </form>
    </div>
</body>
</html>