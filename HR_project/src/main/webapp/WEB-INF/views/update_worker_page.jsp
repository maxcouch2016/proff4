<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Update worker</title>

    <!-- Bootstrap -->
    <link href="content/css/bootstrap.min.css" rel="stylesheet">
    <link href="content/css/style.css" rel="stylesheet">
   
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script type="text/javascript" src="content/js/updateworker.js"></script>
     <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
      <style>
          .search-id-form{
              margin-bottom: 1%;
          }</style>
  </head>
  
  <body>
    
       
           
            <div align="center"> 
             <img src="content/pictures/tomahawk.jpg" alt="..." class="img-rounded">
             <h1>Update worker's information menu</h1> 
            </div>
            
            <div class="search-id-form">
            <form name="search-id-form" class="form-inline">
              <div class="form-group">
                <p class="form-control-static">&ensp;Worker's ID</p>
              </div>
              <div class="form-group">
                <input name="id" type="text" class="form-control" id="inputPassword2" placeholder="ID">
              </div>
              <button type="button" class="btn btn-default" onclick="findWorkerById();">Search</button>
               <Strong><span class="form-group" id="current-id-text"></span> </Strong>
               <span class="form-group" id="current-id"></span>
            </form>   
            </div>
 
 	    <form name="updateWorkerForm">
                 
            <div class="input-group">
              <span class="input-group-addon" id="basic-addon1">First name</span>
              <input name="firstname" type="text" class="form-control" placeholder="first name" aria-describedby="basic-addon1">
            </div>
             
             <div class="input-group">
              <span class="input-group-addon" id="basic-addon1">Last name</span>
              <input name="lastname" type="text" class="form-control" placeholder="last name" aria-describedby="basic-addon1">
            </div>
            
            <div class="input-group">
              <span class="input-group-addon">Salary 	&ensp;  $.  </span>
              <input name="salary" type="text" class="form-control" aria-label="Amount (to the nearest dollar)">
              <span class="input-group-addon">.00</span>
            </div>
             
            <div class="input-group">
              <span class="input-group-addon" id="basic-addon1">	 Birth &ensp;date </span>
              <input name="birthdate" type="text" class="form-control" placeholder="DD.MM.YYYY" aria-describedby="basic-addon1">
            </div>
        
        	 <div class="form-group">
			  <label for="department">Status</label>
			  <select class="form-control" name="status" id="status">
			    <option>Active</option>
			    <option>Inactive</option>
			  </select>
			</div>
     
			 <div class="form-group">
			  <label for="department">Department</label>
			  <select class="form-control" name="department" id="department">
			    <option>HR department</option>
			    <option>Testing department</option>
			    <option>Programmers department</option>
			  </select>
			</div>
        
            <div class="btn-group btn-group-justified" role="group" aria-label="...">
				  <div class="btn-group" role="group">
				    <button type="submit" class="btn btn-default" onclick="updateWorker();">Update information</button>
				  </div>
			</div>
        
        
        
  		</form>
    
    
    

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="content/js/bootstrap.min.js"></script>
  </body>
</html>