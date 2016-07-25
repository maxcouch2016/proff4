<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="domain.Content"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Ads</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script type="text/javascript">

	function sendData(){
		$.ajax({
        	dataType: 'json',
    		type: "POST",
    		data: "catalogNewMessage=" + $("#adType option:selected").val() + "&textNewMessage=" + $("#content").val(),
    		url:'/firstApp/content',
        	success: function(data){
            	if (data.adverToAdd != ''){
            		$("#messages").append(data.adverToAdd);
            		$("#content").val("");
            	}
        	},
        	error: function() {
            	alert("Some error occured!");
        	}
    	});
	}
	
	$(document).ready(function() {
		$("#buttonAddAdv").click(function(){
			sendData();
		});	
	});	

</script>

</head>
<body>
	
	<% List<Content> contents = (List<Content>)request.getAttribute("contents"); %>
	<div class="wrap">

		<div class="messagePage" id="messages">
			<% for(Content cont: contents){
				out.println(cont.toPage());
			}%>
		</div>
		<% String text = (String) request.getAttribute("formText");
		if (text != null) out.println(text); %>

	</div>
</body>
</html>