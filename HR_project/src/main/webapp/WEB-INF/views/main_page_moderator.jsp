<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Main page moderator</title>

    <!-- Bootstrap -->
    <link href="content/css/bootstrap.min.css" rel="stylesheet">
    <link href="content/css/style.css" rel="stylesheet">
   
   	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script type="text/javascript" src="content/js/mainpage.js"></script>
    <script type="text/javascript" src="content/js/mainpagemoderator.js"></script>
   
     <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  
	    <style>
	   a  {cursor: pointer}
	  	</style>
  	
	  	<script>
	  	 setTable(0);
	  	</script>

  
  </head>
  
  <body>
    
               
      
          
              
           
            
            <div align="center">
             <h1> Workers search menu </h1>
             <img src="content/pictures/tomahawk.jpg" alt="..." class="img-rounded">
            </div>
              
	            
	            <div class="btn-group btn-group-justified" role="group" aria-label="...">
	              <div class="btn-group" role="group">
	                <button type="button" class="btn btn-default" onclick="redirectToCreateWorker();"> New worker </button>
	            </div>
	              
	            <div class="btn-group" role="group">
	                <button type="button" class="btn btn-default" onclick="redirectToUpdateWorker();"> Update worker info </button>
	            </div>
            
              </div>
                
 		<form name="searchForm">
		  <div class="form-group">
		    <label for="exampleInputEmail1">Search by name</label>
		    <input name="names" type="text" class="form-control" id="exampleInputEmail1" placeholder="name or lastname">
		  </div>
		  <button type="button" class="btn btn-default" onclick="getFoundWorkers();" >Search</button>
		</form>
		    
    
   <div class="table-responsive">   
 	<table id="myTable" class="table"></table>
   </div>
   
	<% Integer countPage = (Integer)request.getAttribute("pageCount");%>
	<% if(countPage!=null && countPage>1) { %>
		<div class="StyleNavigationPage">
			<ul class="pagination">
			<% for(int i=0;i<countPage;i++){ %>
				<% String name = (40*i+1)+" - " + (40*(i+1)); %>
				<li><a onclick="setTable(<% out.print(i); %>)"><% out.print(name); %></a></li>
			<%} %>
			</ul>
		</div>
	<% } %>		
    

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="content/js/bootstrap.min.js"></script>
  </body>
</html>