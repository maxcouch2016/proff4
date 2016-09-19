<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Login page</title>

    <!-- Bootstrap -->
    <link href="content/css/bootstrap.min.css" rel="stylesheet">
    <link href="content/css/style.css" rel="stylesheet">
   
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
   <script type="text/javascript" src="content/js/loginpage.js"></script>
   
     <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  
  <body>
    		
    		
    		
        <div class="container">
            
              <img src="content/pictures/apache.jpg" alt="..." class="img-rounded">
              
          
               <form name ="loginForm">
                  <div class="form-group">
                    <label for="exampleInputEmail1">Login</label>
                        <input name ="email" type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
                  </div>
                  
                  <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>
                    <input name="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                  </div>
                  
                  <button type="submit" class="btn btn-default" onclick="loginValidation();" >login</button>
             
                </form>
             
             
        </div>
    
    

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>