<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	#btnEx1{
		cursor: pointer;
		background: green;
	}
	#btnEx1:hover{
		background: red;
		color: white;
	}
	.Example2 p{
		margin-left: 20px;
		margin-top: 10px;
		cursor: pointer;
	}
	.Example2 textarea{
		margin-left: 40px;
		display: none;
		
	}
	#changeImage{
		max-width: 100px;		
	}
</style>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script type="text/javascript">
	function clickMe(){
		alert("сообщение от clickMe()");
		console.log("message from clickMe()");
	}
	var picSelector = 1;
	function sendData(){
		var text = $("#addText").val();
	    $.ajax({
	        dataType: 'json',
	    	type: "POST",
	    	data: "text=" + text,
	    	url:'/proff4_notification_web/ajax',
	        success: function(data){
	            if(data.pic!=''){
	            	$(".blockImages").append(data.pic);
	            }
	        },
	        error: function() {
	            alert("Alarm!");
	        }
	    });

	}
	
	$(document).ready(function() {
		$("#btnEx").click(function(){
			clickMe();
		});
		$(".btn1").click(function(){
			alert("click = "+this.id);
		});
		$(".Example2 p").click(function(){
			var el = "#text"+this.id;
			if($(el).css('display') == 'inline-block'){
				$(el).css('display', 'none');
			} else {
				$(el).css('display', 'inline-block');
			}
		});
		$("#btnEx2").hover(function(){
			$("#btnEx2").css('background', 'red');
		});
		$("#changeImage").click(function(){
			picSelector++;
			if(picSelector>3) picSelector = 1;
			
			var img1 = "img/main_banner1.jpg";
			var img2 = "img/main_banner2.jpg";
			var img3 = "img/main_banner2.png";
			var newPic = img3;
			
			if(picSelector == 1) newPic = img2; 
			if(picSelector == 2) newPic = img3;
			if(picSelector == 3) newPic = img1;
			$("#changeImage").prop('src', newPic);
		});
		$("#addImg").click(function(){
			sendData();
		});
	});
	
</script>
</head>
<body>
	<hr>
		<input type="button" value="click me" onclick="clickMe()">
	<hr>
		<input type="button" id="btnEx1"  class="btn1" value="click me">
	<hr>
		<input type="button" id="btnEx2" class="btn1" value="click me">	
	<hr>
		<% for(int i=0; i< 5; i++){%>
			<div class="Example2"  >
				<p id="Example2_<% out.print(i); %>">Термин</p>
				<textarea id="textExample2_<% out.print(i); %>">Тут содерждится определение</textarea>
			</div>
		<%} %>
	<hr>
		<img src="img/main_banner1.jpg" id="changeImage">
	<hr>
		<input type="button" id="addImg">
		<input type="text" id="addText">
		<div class="blockImages">
			<img src="img/main_banner1.jpg">
		</div>
</body>
</html>